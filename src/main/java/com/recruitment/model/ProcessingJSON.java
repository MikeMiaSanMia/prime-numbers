package com.recruitment.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProcessingJSON {
    public DataDB retrieveDataFromJSON(JSONObject json) {
        String id = (String) json.get("id");
        long arrayDataLength = (long) json.get("size");
        int arrayLength = (int) arrayDataLength;
        JSONArray jsonArray = (JSONArray) json.get("data");
        Integer[] dataArray = convertJSONArrayToIntegerArray(jsonArray, arrayLength);
        return new DataDB(id, arrayLength, dataArray);
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
