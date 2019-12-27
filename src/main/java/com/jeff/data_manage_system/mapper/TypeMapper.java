package com.jeff.data_manage_system.mapper;

import com.jeff.data_manage_system.entity.Type;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeMapper {

    @Insert("insert into type (name, description, user_id, create_time, update_time) values(#{name}, #{description}, #{userID}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys = true)
    int addType(Type type);

    @Delete("delete from type where id=#{id}")
    int deleteType(Integer id);

    @Update("update type set name=#{name}, description=#{description}, update_time=#{updateTime} where id=#{id}")
    int updateType(Type type);

    @Results(id = "type", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "description", property = "description"),
            @Result(column = "user_id", property = "userID"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
    })
    @Select("select id, name, description, user_id, create_time, update_time from type where id=#{id} limit 1")
    Type getTypeByID(Integer id);

    @Select("select name from type where id=#{id} limit 1")
    String getTypeNameByID(Integer id);

    @Select("select id from type where name=#{name} limit 1")
    Integer getTypeIDbyName(String name);

    @ResultMap("type")
    @Select("select id, name, description, user_id, create_time, update_time from type")
    List<Type> getTypeList();
}
