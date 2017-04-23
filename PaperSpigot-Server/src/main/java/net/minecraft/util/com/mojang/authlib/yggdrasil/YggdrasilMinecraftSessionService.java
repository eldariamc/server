//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.util.com.mojang.authlib.yggdrasil;

import net.minecraft.util.com.google.common.collect.Iterables;
import net.minecraft.util.com.google.gson.Gson;
import net.minecraft.util.com.google.gson.GsonBuilder;
import net.minecraft.util.com.google.gson.JsonParseException;
import net.minecraft.util.com.mojang.authlib.GameProfile;
import net.minecraft.util.com.mojang.authlib.HttpAuthenticationService;
import net.minecraft.util.com.mojang.authlib.exceptions.AuthenticationException;
import net.minecraft.util.com.mojang.authlib.exceptions.AuthenticationUnavailableException;
import net.minecraft.util.com.mojang.authlib.minecraft.HttpMinecraftSessionService;
import net.minecraft.util.com.mojang.authlib.minecraft.InsecureTextureException;
import net.minecraft.util.com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.util.com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import net.minecraft.util.com.mojang.authlib.properties.Property;
import net.minecraft.util.com.mojang.authlib.yggdrasil.response.MinecraftProfilePropertiesResponse;
import net.minecraft.util.com.mojang.authlib.yggdrasil.response.MinecraftTexturesPayload;
import net.minecraft.util.com.mojang.util.UUIDTypeAdapter;
import net.minecraft.util.org.apache.commons.codec.Charsets;
import net.minecraft.util.org.apache.commons.codec.binary.Base64;
import net.minecraft.util.org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class YggdrasilMinecraftSessionService extends HttpMinecraftSessionService {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String BASE_URL = "https://sessionserver.mojang.com/session/minecraft/";
	private static final URL JOIN_URL = HttpAuthenticationService.constantURL("https://sessionserver.mojang.com/session/minecraft/join");
	private static final URL CHECK_URL = HttpAuthenticationService.constantURL("https://sessionserver.mojang.com/session/minecraft/hasJoined");
	private final PublicKey publicKey;
	private final Gson gson = (new GsonBuilder()).registerTypeAdapter(UUID.class, new UUIDTypeAdapter()).create();

	protected YggdrasilMinecraftSessionService(YggdrasilAuthenticationService authenticationService) {
		super(authenticationService);

		try {
			X509EncodedKeySpec e = new X509EncodedKeySpec(IOUtils.toByteArray(YggdrasilMinecraftSessionService.class.getResourceAsStream("/yggdrasil_session_pubkey.der")));
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			this.publicKey = keyFactory.generatePublic(e);
		} catch (Exception var4) {
			throw new Error("Missing/invalid yggdrasil public key!");
		}
	}

	public void joinServer(GameProfile profile, String authenticationToken, String serverId) throws AuthenticationException {
		/*JoinMinecraftServerRequest request = new JoinMinecraftServerRequest();
		request.accessToken = authenticationToken;
		request.selectedProfile = profile.getId();
		request.serverId = serverId;
		this.getAuthenticationService().makeRequest(JOIN_URL, request, Response.class);*/
	}

	public GameProfile hasJoinedServer(GameProfile user, String serverId) throws AuthenticationUnavailableException {
		/*HashMap arguments = new HashMap();
		arguments.put("username", user.getName());
		arguments.put("serverId", serverId);
		URL url = HttpAuthenticationService.concatenateURL(CHECK_URL, HttpAuthenticationService.buildQuery(arguments));

		try {
			HasJoinedMinecraftServerResponse e = (HasJoinedMinecraftServerResponse)this.getAuthenticationService().makeRequest(url, (Object)null, HasJoinedMinecraftServerResponse.class);
			if(e != null && e.getId() != null) {
				GameProfile result = new GameProfile(e.getId(), user.getName());
				if(e.getProperties() != null) {
					result.getProperties().putAll(e.getProperties());
				}

				return result;
			} else {
				return null;
			}
		} catch (AuthenticationUnavailableException var7) {
			throw var7;
		} catch (AuthenticationException var8) {
			return null;
		}*/
		return user;
	}

	public Map<Type, MinecraftProfileTexture> getTextures(GameProfile profile, boolean requireSecure) {
		Property textureProperty = (Property)Iterables.getFirst(profile.getProperties().get("textures"), (Object)null);
		if(textureProperty == null) {
			String s = profile.getName() + ".png";
			HashMap<MinecraftProfileTexture.Type, MinecraftProfileTexture> map = new HashMap();
			map.put(MinecraftProfileTexture.Type.SKIN, new MinecraftProfileTexture("https://eldaria.fr/skins/" + s));
			map.put(MinecraftProfileTexture.Type.CAPE, new MinecraftProfileTexture("https://eldaria.fr/capes/" + s));
			return map;
		} else {
			if(requireSecure) {
				if(!textureProperty.hasSignature()) {
					LOGGER.error("Signature is missing from textures payload");
					throw new InsecureTextureException("Signature is missing from textures payload");
				}

				if(!textureProperty.isSignatureValid(this.publicKey)) {
					LOGGER.error("Textures payload has been tampered with (signature invalid)");
					throw new InsecureTextureException("Textures payload has been tampered with (signature invalid)");
				}
			}

			MinecraftTexturesPayload result;
			try {
				String e = new String(Base64.decodeBase64(textureProperty.getValue()), Charsets.UTF_8);
				result = (MinecraftTexturesPayload)this.gson.fromJson(e, MinecraftTexturesPayload.class);
			} catch (JsonParseException var6) {
				LOGGER.error("Could not decode textures payload", var6);
				return new HashMap();
			}

			return (Map)(result.getTextures() == null?new HashMap():result.getTextures());
		}
	}

	public GameProfile fillProfileProperties(GameProfile profile, boolean requireSecure) {
		if(/*profile.getId() == null*/ true) {
			return profile;
		} else {
			try {
				URL e = HttpAuthenticationService.constantURL("https://sessionserver.mojang.com/session/minecraft/profile/" + UUIDTypeAdapter.fromUUID(profile.getId()));
				e = HttpAuthenticationService.concatenateURL(e, "unsigned=" + !requireSecure);
				MinecraftProfilePropertiesResponse response = (MinecraftProfilePropertiesResponse)this.getAuthenticationService().makeRequest(e, (Object)null, MinecraftProfilePropertiesResponse.class);
				if(response == null) {
					LOGGER.debug("Couldn\'t fetch profile properties for " + profile + " as the profile does not exist");
					return profile;
				} else {
					GameProfile result = new GameProfile(response.getId(), response.getName());
					result.getProperties().putAll(response.getProperties());
					profile.getProperties().putAll(response.getProperties());
					LOGGER.debug("Successfully fetched profile properties for " + profile);
					return result;
				}
			} catch (AuthenticationException var6) {
				LOGGER.warn("Couldn\'t look up profile properties for " + profile, var6);
				return profile;
			}
		}
	}

	public YggdrasilAuthenticationService getAuthenticationService() {
		return (YggdrasilAuthenticationService)super.getAuthenticationService();
	}
}
