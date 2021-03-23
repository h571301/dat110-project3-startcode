package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity) throws NoSuchAlgorithmException {		
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		// we use MD5 with 128 bits digest
		MessageDigest md = MessageDigest.getInstance("MD5");
		// compute the hash of the input 'entity'
		 byte[] messageDigest = md.digest(entity.getBytes());
		// convert the hash into hex format
		String hashtext = toHex(messageDigest);
		// convert the hex into BigInteger
		hashint = new BigInteger(hashtext, 16);
		// return the BigInteger
		return hashint;
	}
	
	public static BigInteger addressSize() throws NoSuchAlgorithmException {
		
		// Task: compute the address size of MD5
		// get the digest length
		// compute the number of bits = digest length * 8
		int dl = bitSize();
		// compute the address size = 2 ^ number of bits
		BigInteger adressSize = (new BigInteger("2").pow(dl));
		// return the address size
		return adressSize;
	}
	
	public static int bitSize() throws NoSuchAlgorithmException {
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		// find the digest length
		int digestlen = md.getDigestLength();
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
