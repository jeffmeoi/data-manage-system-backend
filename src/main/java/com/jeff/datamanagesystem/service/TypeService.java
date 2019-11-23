package com.jeff.datamanagesystem.service;

import com.jeff.datamanagesystem.entity.Type;

import java.util.List;
import java.util.Map;

public interface TypeService {
    List<Map> getCount();
    int addType(Type type);
    int updateType(Type type);
    int editType(Type type);
    int deleteType(Integer id);
    Type getType(Integer id);
    List<Type> getTypeList();
}
