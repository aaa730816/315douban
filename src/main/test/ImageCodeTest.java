package main.test;

import main.util.CreateImageCode;
import main.util.PasswordEncode;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Tony on 2017/6/28.
 */
public class ImageCodeTest {
    @Test
    public void test(){
        CreateImageCode code=new CreateImageCode();
        System.out.println(code.getBuffImg().getWidth());
    }
    @Test
    public void passwordEncode() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println(PasswordEncode.encode("aaa730816","950831"));
    }
}
