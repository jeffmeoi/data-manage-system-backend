package com.jeff.datamanagesystem.util;

import org.springframework.util.DigestUtils;

public class MD5Util {

    private static final String slat = "Jeff";

    public static String getMD5(String str) {
        String base = str +"/" + slat;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
}
