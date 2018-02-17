package com.recruitment.model;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
    private List<Integer> primeNumbersList = new ArrayList<>();

    public List<Integer> getPrimeNumbersList() {
        return primeNumbersList;
    }

    public void addPrimeNumber(Integer primeNumber) {
        primeNumbersList.add(primeNumber);
    }

    public Integer getPrimeNumbersListSize() {
        return primeNumbersList.size();
    }


}
