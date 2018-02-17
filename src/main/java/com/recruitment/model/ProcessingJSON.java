package com.recruitment.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProcessingJSON {
    public DataDB retrieveDataFromJSON(JSONObject json) {
        System.out.println(json.get("id"));
        String id = (String) json.get("id");
        System.out.println(json.get("size"));
        long arrayDataLength = (long) json.get("size");
        int arrayLength = (int) arrayDataLength;
        System.out.println(json.get("data"));
        JSONArray jsonArray = (JSONArray) json.get("data");
        Integer[] dataArray = convertJSONArrayToIntegerArray(jsonArray, arrayLength);
        DataDB dataDB = new DataDB(id, arrayLength, dataArray);
        System.out.println(dataDB.getId());
        System.out.println(dataDB.getArrayLength());
        System.out.println(dataDB.getDataArray()[0]);
        return dataDB;
    }

    private Integer[] convertJSONArrayToIntegerArray(JSONArray jsonArray, int arrayLength) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < arrayLength; i++) {
            long element = (long) jsonArray.get(i);
            integerList.add((int) element);
        }
        Integer[] dataArray = new Integer[integerList.size()];
        return integerList.toArray(dataArray);
    }
}
