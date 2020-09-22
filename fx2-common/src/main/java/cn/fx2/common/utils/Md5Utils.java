package cn.fx2.common.utils;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Md5Utils {

    private Md5Utils() {
    }

    private static final char[] hexDigits =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String toHexString(byte[] bytes) {
        if (bytes == null) return "";
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(hexDigits[(b >> 4) & 0x0F]);
            hex.append(hexDigits[b & 0x0F]);
        }
        return hex.toString();
    }

    public static String getMD51(String string) {
        byte[] encodeBytes = null;
        try {
            encodeBytes = MessageDigest.getInstance("MD5").digest(string.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException neverHappened) {
            throw new RuntimeException(neverHappened);
        }

        return toHexString(encodeBytes);
    }

    public static String getMD5GBK(String string) {
        byte[] encodeBytes = null;
        try {
            encodeBytes = MessageDigest.getInstance("MD5").digest(string.getBytes("GBK"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException neverHappened) {
            throw new RuntimeException(neverHappened);
        }

        return toHexString(encodeBytes);
    }
    
    public static String getMD5(String string) {
    	//对字符串先做加盐，然后做两次md5操作。
    	string+="salt_user_center";
    	MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			byte[]bs=md5.digest(string.getBytes());
	    	string=new String(new Hex().encode(bs));
	    	bs=md5.digest(string.getBytes());
	    	string=new String(new Hex().encode(bs));
	    	return string;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public static String getMD5(String string,String salt) {
    	//对字符串先做加盐，然后做两次md5操作。
    	string+=salt;
    	MessageDigest md5;
    	try {
    		md5 = MessageDigest.getInstance("MD5");
    		byte[]bs=md5.digest(string.getBytes());
    		string=new String(new Hex().encode(bs));
    		bs=md5.digest(string.getBytes());
    		string=new String(new Hex().encode(bs));
    		return string;
    	} catch (NoSuchAlgorithmException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
}
