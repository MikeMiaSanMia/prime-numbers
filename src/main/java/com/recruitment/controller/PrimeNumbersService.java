package com.recruitment.controller;

import com.recruitment.model.DataDB;
import com.recruitment.model.PrimeNumbers;

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
            System.out.println(number + " is not prime");
            return false;
        }
        int top = (int)Math.sqrt(number) + 1;
        for(int i = 3; i < top; i+=2){
            if(number % i == 0){
                System.out.println(number + " is not prime");
                return false;
            }
        }
        System.out.println(number + " is prime");
        return true;
    }
}
