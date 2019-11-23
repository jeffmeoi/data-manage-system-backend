package com.jeff.datamanagesystem.service.impl;

import com.jeff.datamanagesystem.entity.Type;
import com.jeff.datamanagesystem.exception.NullException;
import com.jeff.datamanagesystem.mapper.ImageInfoMapper;
import com.jeff.datamanagesystem.mapper.TypeMapper;
import com.jeff.datamanagesystem.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private ImageInfoMapper imageInfoMapper;

    @Override
    public List<Map> getCount() {
        List<Map> list = new LinkedList<>();
        List<Type> typeList = typeMapper.getTypeList();
        Long total = 0L;
        for(Type type : typeList){
            Map<String, Object> map = new HashMap<>();
            Long count = imageInfoMapper.getCountByTypeID(type.getId());
            map.put("name", type.getName());
            map.put("count", count);
            list.add(map);
            total += count;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Total");
        map.put("count", total);
        list.add(map);
        return list;
    }

    @Override
    public int addType(Type type) {
        type.setId(null);
        type.setCreateTime(new Date());
        type.setUpdateTime(type.getCreateTime());
        return typeMapper.addType(type);
    }

    @Override
    public int updateType(Type type) {
        if(type.getId() == null)
            throw new NullException();
        type.setUpdateTime(new Date());
        return typeMapper.updateType(type);
    }

    @Override
    public int editType(Type type) {
        if(type.getId() == null)
            return addType(type);
        else
            return updateType(type);
    }

    @Override
    public int deleteType(Integer id) {
        return typeMapper.deleteType(id);
    }

    @Override
    public Type getType(Integer id) {
        return typeMapper.getTypeByID(id);
    }

    @Override
    public List<Type> getTypeList() {
        return typeMapper.getTypeList();
    }
}
