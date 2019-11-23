package com.jeff.datamanagesystem;

import com.jeff.datamanagesystem.enums.Role;
import com.jeff.datamanagesystem.util.ImageUtil;
import com.jeff.datamanagesystem.util.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataManageSystemApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void MD5Test(){
        System.out.println(MD5Util.getMD5("123456"));
        System.out.println(MD5Util.getMD5("154651"));
        System.out.println(MD5Util.getMD5("13234"));
    }


}
