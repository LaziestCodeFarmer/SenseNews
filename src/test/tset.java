import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.math.BigInteger;
import java.security.MessageDigest;

public class tset {

    @Test
    public void m1() throws Exception{
        //将密码进行MD5加密
        //获取MD5加密器
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //将密码进行加密，同时返回的是二进制密文
        //byte[] digest = md5.digest("zxzxz".getBytes("utf-8"));
        byte[] digest = md5.digest("dddss".getBytes());
        //转换成16进制
        String s = new BigInteger(digest).toString(16);
        System.out.println(s);
    }



}
