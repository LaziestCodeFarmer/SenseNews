package com.xtl.utils;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class MD5 {

    public static String md5(String password) throws Exception {
        //将密码进行MD5加密
        //获取MD5加密器
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //将密码进行加密，同时返回的是二进制密文
        byte[] digest = md5.digest(password.getBytes("utf-8"));
        //根据构造函数转换成10进制，再转换成16进制
        password = new BigInteger(digest).toString(16);
        return password;
    }

}
