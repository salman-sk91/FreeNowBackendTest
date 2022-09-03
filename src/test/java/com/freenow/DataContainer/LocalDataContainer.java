package com.freenow.DataContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LocalDataContainer {

    public HashMap<String, Object> dataMap;
    public List<Object> dataList;

    public LocalDataContainer(){
        dataMap = new HashMap<>();
        dataList = new ArrayList<>();
    }

    public Object getDataMap(final String key) {
        return dataMap.get(key);
    }

    public void addDataMap(final String key, final Object object) {
        dataMap.put(key,object);
    }

    public Object getDataList(final Object key) {
       return dataList.get((Integer) key);
    }

    public void addDataList(Object object) {
        dataList.add(object);
    }




}
