package com.jeff.data_manage_system.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jeff.data_manage_system.dto.ListParams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ListUtil {

    public static Map<String, Object> getInfo(long totalCount, int page, int pageSize, int count){
        Map<String, Object> info = new LinkedHashMap<>();
        info.put("totalCount", totalCount);
        info.put("current", page);
        info.put("pageSize", pageSize);
        info.put("count", count);
        return info;
    }


    public static Map<String, Object> getInfo(PageInfo pageInfo){
        return getInfo(pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getSize());
    }

    public static Map<String, Object> getInfo(Page page){
        return getInfo(new PageInfo(page));
    }


    public static Map<String, Object> getList(List results, Map<String, Object> info){
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("results", results);
        data.put("info", info);
        return data;
    }

    public static Map<String, Object> getList(Page results){
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("results", results);
        data.put("info", getInfo(new PageInfo(results)));
        return data;
    }

    public static void startPage(ListParams listParams, String columns[]){
        if(listParams == null){
            listParams = new ListParams(10, 1, null, null);
        }else {
            if(listParams.getPageSize() == null)
                listParams.setPageSize(10);
            if(listParams.getCurrPage() == null)
                listParams.setCurrPage(1);
        }
        if(Arrays.asList(columns).indexOf(listParams.getSortField()) == -1){
            PageHelper.startPage(listParams.getCurrPage(), listParams.getPageSize());
        }else {
            String orderBy = listParams.getSortField() + " " + (listParams.getSortOrder().toLowerCase().equals("descend")? "desc" : "asc");
            PageHelper.startPage(listParams.getCurrPage(), listParams.getPageSize(), orderBy);
        }
    }

}
