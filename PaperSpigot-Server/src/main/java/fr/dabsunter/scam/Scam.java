package fr.dabsunter.scam;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by David on 23/07/2016.
 */
public class Scam {

	private static final char[] DIGITS =
			{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	public static void check(String productId) {
		if (!isValid(productId)) {
			System.err.println("Le produit n'a pas été validé.");
			System.exit(0);
		}
	}

	public static void check(JavaPlugin plugin) {
		if (!isValid(plugin.getDescription().getMain())) {
			plugin.getLogger().warning("Le produit n'a pas été validé.");
			plugin.getServer().getPluginManager().disablePlugin(plugin);
		}
	}

	public static boolean isValid(String productId) {
		final Gson gson = new Gson();
		final String id = digestMD5(productId);
		Product[] products = new Product[0];
		try {
			InputStream in = new URL("http://dabsunter.github.io/products.json").openStream();
			products = gson.fromJson(new InputStreamReader(in), Product[].class);
			in.close();
		} catch (JsonSyntaxException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			System.err.println(ex);
		}

		for (Product p : products)
			if (p.id.equals(id) && p.active)
				return true;

		return false;
	}

	public static String digestMD5(String input) {
		try {
			return digestMD5(input.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static String digestMD5(byte[] input) {
		try {
			final MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(input);
			final byte[] data = md5.digest();
			final int l = data.length;
			final char[] out = new char[l << 1];
			// two characters form the hex value.
			for (int i = 0, j = 0; i < l; i++) {
				out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
				out[j++] = DIGITS[0x0F & data[i]];
			}
			return new String(out);
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	private class Product {

		String id;
		boolean active;

	}

}

