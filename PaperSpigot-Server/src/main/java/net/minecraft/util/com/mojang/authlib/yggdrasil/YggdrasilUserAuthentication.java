//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.util.com.mojang.authlib.yggdrasil;

import net.minecraft.util.com.mojang.authlib.*;
import net.minecraft.util.com.mojang.authlib.exceptions.AuthenticationException;
import net.minecraft.util.com.mojang.authlib.exceptions.InvalidCredentialsException;
import net.minecraft.util.com.mojang.authlib.yggdrasil.request.AuthenticationRequest;
import net.minecraft.util.com.mojang.authlib.yggdrasil.request.RefreshRequest;
import net.minecraft.util.com.mojang.authlib.yggdrasil.response.AuthenticationResponse;
import net.minecraft.util.com.mojang.authlib.yggdrasil.response.RefreshResponse;
import net.minecraft.util.com.mojang.authlib.yggdrasil.response.User;
import net.minecraft.util.org.apache.commons.lang3.ArrayUtils;
import net.minecraft.util.org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.Arrays;
import java.util.Map;

public class YggdrasilUserAuthentication extends HttpUserAuthentication {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String BASE_URL = "https://api.eldaria.fr/auth/";
	private static final URL ROUTE_AUTHENTICATE = HttpAuthenticationService.constantURL("https://api.eldaria.fr/api/authenticate");
	private static final URL ROUTE_REFRESH = HttpAuthenticationService.constantURL("https://api.eldaria.fr/api/refresh");
	private static final URL ROUTE_VALIDATE = HttpAuthenticationService.constantURL("https://api.eldaria.fr/api/validate");
	private static final URL ROUTE_INVALIDATE = HttpAuthenticationService.constantURL("https://api.eldaria.fr/api/invalidate");
	private static final URL ROUTE_SIGNOUT = HttpAuthenticationService.constantURL("https://api.eldaria.fr/api/signout");
	private static final String STORAGE_KEY_ACCESS_TOKEN = "accessToken";
	private final Agent agent;
	private GameProfile[] profiles;
	private String accessToken;
	private boolean isOnline;

	public YggdrasilUserAuthentication(YggdrasilAuthenticationService authenticationService, Agent agent) {
		super(authenticationService);
		this.agent = agent;
	}

	public boolean canLogIn() {
		return !this.canPlayOnline() && StringUtils.isNotBlank(this.getUsername()) && (StringUtils.isNotBlank(this.getPassword()) || StringUtils.isNotBlank(this.getAuthenticatedToken()));
	}

	public void logIn() throws AuthenticationException {
		if(StringUtils.isBlank(this.getUsername())) {
			throw new InvalidCredentialsException("Invalid username");
		} else {
			if(StringUtils.isNotBlank(this.getAuthenticatedToken())) {
				this.logInWithToken();
			} else {
				if(!StringUtils.isNotBlank(this.getPassword())) {
					throw new InvalidCredentialsException("Invalid password");
				}

				this.logInWithPassword();
			}

		}
	}

	protected void logInWithPassword() throws AuthenticationException {
		if(StringUtils.isBlank(this.getUsername())) {
			throw new InvalidCredentialsException("Invalid username");
		} else if(StringUtils.isBlank(this.getPassword())) {
			throw new InvalidCredentialsException("Invalid password");
		} else {
			LOGGER.info("Logging in with username & password");
			AuthenticationRequest request = new AuthenticationRequest(this, this.getUsername(), this.getPassword());
			AuthenticationResponse response = (AuthenticationResponse)this.getAuthenticationService().makeRequest(ROUTE_AUTHENTICATE, request, AuthenticationResponse.class);
			if(!response.getClientToken().equals(this.getAuthenticationService().getClientToken())) {
				throw new AuthenticationException("Server requested we change our client token. Don\'t know how to handle this!");
			} else {
				if(response.getSelectedProfile() != null) {
					this.setUserType(response.getSelectedProfile().isLegacy()?UserType.LEGACY:UserType.MOJANG);
				} else if(ArrayUtils.isNotEmpty(response.getAvailableProfiles())) {
					this.setUserType(response.getAvailableProfiles()[0].isLegacy()?UserType.LEGACY:UserType.MOJANG);
				}

				User user = response.getUser();
				if(user != null && user.getId() != null) {
					this.setUserid(user.getId());
				} else {
					this.setUserid(this.getUsername());
				}

				this.isOnline = true;
				this.accessToken = response.getAccessToken();
				this.profiles = response.getAvailableProfiles();
				this.setSelectedProfile(response.getSelectedProfile());
				this.getModifiableUserProperties().clear();
				this.updateUserProperties(user);
			}
		}
	}

	protected void updateUserProperties(User user) {
		if(user != null) {
			if(user.getProperties() != null) {
				this.getModifiableUserProperties().putAll(user.getProperties());
			}

		}
	}

	protected void logInWithToken() throws AuthenticationException {
		if(StringUtils.isBlank(this.getUserID())) {
			if(!StringUtils.isBlank(this.getUsername())) {
				throw new InvalidCredentialsException("Invalid uuid & username");
			}

			this.setUserid(this.getUsername());
		}

		if(StringUtils.isBlank(this.getAuthenticatedToken())) {
			throw new InvalidCredentialsException("Invalid access token");
		} else {
			LOGGER.info("Logging in with access token");
			RefreshRequest request = new RefreshRequest(this);
			RefreshResponse response = (RefreshResponse)this.getAuthenticationService().makeRequest(ROUTE_REFRESH, request, RefreshResponse.class);
			if(!response.getClientToken().equals(this.getAuthenticationService().getClientToken())) {
				throw new AuthenticationException("Server requested we change our client token. Don\'t know how to handle this!");
			} else {
				if(response.getSelectedProfile() != null) {
					this.setUserType(response.getSelectedProfile().isLegacy()?UserType.LEGACY:UserType.MOJANG);
				} else if(ArrayUtils.isNotEmpty(response.getAvailableProfiles())) {
					this.setUserType(response.getAvailableProfiles()[0].isLegacy()?UserType.LEGACY:UserType.MOJANG);
				}

				if(response.getUser() != null && response.getUser().getId() != null) {
					this.setUserid(response.getUser().getId());
				} else {
					this.setUserid(this.getUsername());
				}

				this.isOnline = true;
				this.accessToken = response.getAccessToken();
				this.profiles = response.getAvailableProfiles();
				this.setSelectedProfile(response.getSelectedProfile());
				this.getModifiableUserProperties().clear();
				this.updateUserProperties(response.getUser());
			}
		}
	}

	public void logOut() {
		super.logOut();
		this.accessToken = null;
		this.profiles = null;
		this.isOnline = false;
	}

	public GameProfile[] getAvailableProfiles() {
		return this.profiles;
	}

	public boolean isLoggedIn() {
		return StringUtils.isNotBlank(this.accessToken);
	}

	public boolean canPlayOnline() {
		return this.isLoggedIn() && this.getSelectedProfile() != null && this.isOnline;
	}

	public void selectGameProfile(GameProfile profile) throws AuthenticationException {
		if(!this.isLoggedIn()) {
			throw new AuthenticationException("Cannot change game profile whilst not logged in");
		} else if(this.getSelectedProfile() != null) {
			throw new AuthenticationException("Cannot change game profile. You must log out and back in.");
		} else if(profile != null && ArrayUtils.contains(this.profiles, profile)) {
			RefreshRequest request = new RefreshRequest(this, profile);
			RefreshResponse response = (RefreshResponse)this.getAuthenticationService().makeRequest(ROUTE_REFRESH, request, RefreshResponse.class);
			if(!response.getClientToken().equals(this.getAuthenticationService().getClientToken())) {
				throw new AuthenticationException("Server requested we change our client token. Don\'t know how to handle this!");
			} else {
				this.isOnline = true;
				this.accessToken = response.getAccessToken();
				this.setSelectedProfile(response.getSelectedProfile());
			}
		} else {
			throw new IllegalArgumentException("Invalid profile \'" + profile + "\'");
		}
	}

	public void loadFromStorage(Map<String, Object> credentials) {
		super.loadFromStorage(credentials);
		this.accessToken = String.valueOf(credentials.get("accessToken"));
	}

	public Map<String, Object> saveForStorage() {
		Map result = super.saveForStorage();
		if(StringUtils.isNotBlank(this.getAuthenticatedToken())) {
			result.put("accessToken", this.getAuthenticatedToken());
		}

		return result;
	}

	/** @deprecated */
	@Deprecated
	public String getSessionToken() {
		return this.isLoggedIn() && this.getSelectedProfile() != null && this.canPlayOnline()?String.format("token:%s:%s", new Object[]{this.getAuthenticatedToken(), this.getSelectedProfile().getId()}):null;
	}

	public String getAuthenticatedToken() {
		return this.accessToken;
	}

	public Agent getAgent() {
		return this.agent;
	}

	public String toString() {
		return "YggdrasilAuthenticationService{agent=" + this.agent + ", profiles=" + Arrays.toString(this.profiles) + ", selectedProfile=" + this.getSelectedProfile() + ", username=\'" + this.getUsername() + '\'' + ", isLoggedIn=" + this.isLoggedIn() + ", userType=" + this.getUserType() + ", canPlayOnline=" + this.canPlayOnline() + ", accessToken=\'" + this.accessToken + '\'' + ", clientToken=\'" + this.getAuthenticationService().getClientToken() + '\'' + '}';
	}

	public YggdrasilAuthenticationService getAuthenticationService() {
		return (YggdrasilAuthenticationService)super.getAuthenticationService();
	}
}
