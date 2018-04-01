package util;

import java.security.MessageDigest;

import br.com.augustoleal.starwarsplanets.entity.Planet;

public class PlanetHelper {

	public static void generateHashId(Planet planet) {
		
		try{
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			byte messageDigest[] = algorithm.digest(planet.getNome().toLowerCase().getBytes("UTF-8"));
			
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}			
			
			planet.setId(hexString.toString());
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
}
