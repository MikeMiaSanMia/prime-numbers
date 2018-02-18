package com.recruitment.controller;

import com.recruitment.model.DataDB;
import com.recruitment.model.PrimeNumbers;

import java.util.List;
import java.util.stream.Collectors;

public class PrimeNumbersService {
    public PrimeNumbers findPrimeNumbers(DataDB dataDB) {
        PrimeNumbers primeNumbers = new PrimeNumbers();
        final Integer[] data = dataDB.getDataArray();
        for (Integer number : data) {
            if (isPrime(number)) {
                primeNumbers.addPrimeNumber(number);
            }
        }
        return primeNumbers;
    }

    private boolean isPrime(Integer number) {
        if ( number > 2 && number % 2 == 0 ) {
            return false;
        }
        int top = (int)Math.sqrt(number) + 1;
        for(int i = 3; i < top; i+=2){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    public List<Integer> makeSortedUnique(PrimeNumbers primeNumbers) {
        return primeNumbers.getPrimeNumbersList().stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    public void printCollection(List<Integer> list) {
        System.out.println(list.size());
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
