package main.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Tony on 2017/6/29.
 */
public class PasswordEncode {
    public static String encode(String username,String oriPassword) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//        MessageDigest digest=MessageDigest.getInstance("MD5");
//        BASE64Encoder encoder=new BASE64Encoder();
//        return encoder.encode(digest.digest(oriPassword.getBytes("utf-8")));
        String hashAlgorithmName="MD5";
        Object salt= ByteSource.Util.bytes(username);
        int hashIterations=1024;
        Object result=new SimpleHash(hashAlgorithmName,oriPassword,salt,hashIterations);
        return String.valueOf(result);
    }
}
