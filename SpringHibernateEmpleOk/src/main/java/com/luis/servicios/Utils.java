package com.luis.servicios;

import java.security.MessageDigest;

public class Utils {

	public static String getHash(String origen) throws Exception{
		
		byte[] buffer=origen.getBytes();
		MessageDigest md=MessageDigest.getInstance("sha1");
		md.update(buffer);
		byte[] digest=md.digest();
		String hash="";
		for (byte aux : digest) {
			int b= aux & 0xff;
			
			if(Integer.toHexString(b).length()==1)
				hash+="0";
			hash+=Integer.toHexString(b);
			
		}
		
		return hash;
		
	}
	
	
}
