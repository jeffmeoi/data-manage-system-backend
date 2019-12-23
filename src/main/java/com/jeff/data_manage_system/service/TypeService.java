package com.jeff.data_manage_system.service;

import com.jeff.data_manage_system.entity.Type;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface TypeService {
    List<Map> getCount();
    int addType(Type type, Integer userID);
    void addTypes(File file, Integer userID) throws IOException;
    int updateType(Type type);
    int editType(Type type, Integer userID);
    int deleteType(Integer id);
    Type getType(Integer id);
    List<Type> getTypeList();
}
