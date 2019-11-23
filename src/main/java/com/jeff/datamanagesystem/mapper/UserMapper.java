package com.jeff.datamanagesystem.mapper;

import com.jeff.datamanagesystem.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Select("select count(id) from user")
    Long getTotalCount();


    @Insert("insert into user (username, name, password, email, status, creator_id, create_time, update_time) values(#{username}, #{name}, #{password}, #{email}, #{status}, #{creatorID}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys = true)
    int addUser(User user);

    @Update("update user set username=#{username}, name=#{name}, password=#{password}, email=#{email}, status=#{status}, creator_id=#{creatorID}, create_time=#{createTime}, update_time=#{updateTime} where id = #{id}")
    int updateUser(User user);

    @Update("update user set username=#{username}, name=#{name}, email=#{email}, status=#{status}, update_time=#{updateTime} where id = #{id}")
    int updateUserWithoutPassword(User user);

    @Delete("delete from user where id=#{id}")
    int deleteUser(int id);

    @Results(id = "user", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "name", property = "name"),
            @Result(column = "password", property = "password"),
            @Result(column = "email", property = "email"),
            @Result(column = "status", property = "status"),
            @Result(column = "creator_id", property = "creatorID"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
    })
    @Select("select id, username, name, password, email, status, creator_id, create_time, update_time from user where id=#{id} limit 1")
    User getUserByID(Integer id);

    @ResultMap("user")
    @Select("select id, username, name, password, email, status, creator_id, create_time, update_time from user where username=#{username} limit 1")
    User getUserByUsername(String username);

    @ResultMap("user")
    @SelectProvider(type = UserMapperProvider.class, method = "getUserList")
    List<User> getUserList(User user);

    class UserMapperProvider{
        public String getUserList(final User user){
            return new SQL(){{
                SELECT("id, username, name, password, email, status, creator_id, create_time, update_time");
                FROM("user");
                if(user != null){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    if(user.getId() != null)
                        WHERE("id like concat('%', #{id}, '%')");
                    if(user.getUsername() != null)
                        WHERE("username like concat('%', #{username}, '%')");
                    if(user.getName() != null)
                        WHERE("name like concat('%', #{name}, '%')");
                    if(user.getEmail() != null)
                        WHERE("email like concat('%', #{email}, '%')");
                    if(user.getStatus() != null)
                        WHERE("status like concat('%', #{status}, '%')");
                    if(user.getCreatorID() != null)
                        WHERE("creator_id like concat('%', #{creator_id}, '%')");
                    if(user.getCreateTime() != null)
                        WHERE("create_time like concat('%" + simpleDateFormat.format(user.getCreateTime()) + "%')");
                    if(user.getUpdateTime() != null)
                        WHERE("update_time like concat('%" + simpleDateFormat.format(user.getUpdateTime()) + "%')");
                }
            }}.toString();
        }
    }

}
