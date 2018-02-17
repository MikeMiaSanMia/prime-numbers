package com.recruitment.model;

public final class DataDB {
    private final String id;
    private final Integer arrayLength;
    private final Integer[] dataArray;

    public DataDB(String id, Integer arrayLength, Integer[] dataArray) {
        this.id = id;
        this.arrayLength = arrayLength;
        this.dataArray = dataArray;
    }

    public String getId() {
        return id;
    }

    public Integer getArrayLength() {
        return arrayLength;
    }

    public Integer[] getDataArray() {
        return dataArray;
    }
}
