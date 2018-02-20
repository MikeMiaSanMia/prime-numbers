package com.recruitment.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.recruitment.model.DataDB;
import com.recruitment.model.PrimeNumbers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PrimeNumbersServiceTest {
    @Test
    void findPrimeNumbersShouldReturnProperValue() {
        PrimeNumbersService primeNumbersService = new PrimeNumbersService();
        String id = "a2a77bc3-f6fb-469b-ab02-b9833e7a550f";
        Integer arrayLength = 10;
        Integer[] dataArray = {8, 90, 130, 109, 13, 38, 60, 677, 13, 999};
        DataDB dataDB = new DataDB(id, arrayLength, dataArray);

        PrimeNumbers primeNumbers = primeNumbersService.findPrimeNumbers(dataDB);
        List<Integer> integerList = primeNumbers.getPrimeNumbersList();
        int[] actualArray = integerList.stream().mapToInt(i->i).toArray();
        int[] expectedArray = {109, 13, 677, 13};
        assertTrue(Arrays.equals(expectedArray, actualArray));
    }

    @Test
    void makeSortedUniqueShouldReturnProperValue() {
        PrimeNumbersService primeNumbersService = new PrimeNumbersService();
        String id = "a2a77bc3-f6fb-469b-ab02-b9833e7a550f";
        Integer arrayLength = 10;
        Integer[] dataArray = {8, 90, 130, 109, 13, 38, 60, 677, 13, 999};
        DataDB dataDB = new DataDB(id, arrayLength, dataArray);

        PrimeNumbers primeNumbers = primeNumbersService.findPrimeNumbers(dataDB);
        List<Integer> integerList = primeNumbersService.makeSortedUnique(primeNumbers);
        int[] actualArray = integerList.stream().mapToInt(i->i).toArray();
        int[] expectedArray = {13, 109, 677};
        assertTrue(Arrays.equals(expectedArray, actualArray));
    }
}
