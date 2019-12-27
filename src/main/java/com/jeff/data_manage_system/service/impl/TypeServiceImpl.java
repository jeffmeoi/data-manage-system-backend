package com.jeff.data_manage_system.service.impl;

import com.jeff.data_manage_system.entity.Type;
import com.jeff.data_manage_system.exception.NullException;
import com.jeff.data_manage_system.mapper.ImageInfoMapper;
import com.jeff.data_manage_system.mapper.TypeMapper;
import com.jeff.data_manage_system.service.TypeService;
import com.jeff.data_manage_system.util.ExcelUtil;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
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
    public int addType(Type type, Integer userID) {
        type.setUserID(userID);
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
    public int editType(Type type, Integer userID) {
        if(type.getId() == null)
            return addType(type, userID);
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

    @Override
    public void addTypes(File file, Integer userID) throws IOException {
        Iterator rows = ExcelUtil.getRowIterator(file);
        rows.next();
        while(rows.hasNext()) {
            List<String> cellValues = ExcelUtil.getCellValues((Row) rows.next());
            String name = cellValues.get(0);
            String description = cellValues.get(1);
            typeMapper.addType(new Type(null, name, description, userID, new Date(), new Date()));
        }
        file.delete();
    }
}
