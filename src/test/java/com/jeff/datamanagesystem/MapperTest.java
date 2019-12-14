package com.jeff.datamanagesystem;

import com.jeff.datamanagesystem.entity.ImageInfo;
import com.jeff.datamanagesystem.entity.User;
import com.jeff.datamanagesystem.mapper.ImageInfoMapper;
import com.jeff.datamanagesystem.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class MapperTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ImageInfoMapper imageInfoMapper;

    @Test
    public void UserMapperTest(){
        Assert.assertEquals(userMapper.addUser(new User(null, "username", "password", "E-mail" , "name",0, null, new Date(), new Date())), 1);
        System.out.println(userMapper.getUserByUsername("admin"));
    }

    @Test
    public void ImageMapperTest(){
        Assert.assertEquals(imageInfoMapper.addImageInfo(new ImageInfo(null, "country", "position", 1, 21d, 21d, 231d, new Date(), 12, 2d, "123", "123", 1, new Date(), new Date())), 1);
        Assert.assertNotEquals(imageInfoMapper.getImageInfo(1), null);
    }
}
