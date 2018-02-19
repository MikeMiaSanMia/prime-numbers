package com.recruitment.controller;

import com.recruitment.model.ConnectDB;
import com.recruitment.model.DataDB;
import com.recruitment.model.PrimeNumbers;
import com.recruitment.model.ProcessingJSON;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class AppLogicService {
    public List<Integer> resolve() {
        ConnectDB connectDB = new ConnectDB();
        String serverContent = connectDB.getServerContent();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(serverContent);
            ProcessingJSON processingJSON = new ProcessingJSON();
            DataDB dataDB = processingJSON.retrieveDataFromJSON(json);
            PrimeNumbersService primeNumbersService = new PrimeNumbersService();
            PrimeNumbers primeNumbers = primeNumbersService.findPrimeNumbers(dataDB);
            primeNumbersService.printCollection(primeNumbers.getPrimeNumbersList(),
                    "All prime numbers from server");
            List<Integer> solution = primeNumbersService.makeSortedUnique(primeNumbers);
            primeNumbersService.printCollection(solution,
                    "Sorted and unique prime numbers from server");
            return solution;
        } catch (ParseException pe) {
            pe.printStackTrace();
            System.out.println("Empty list returned");
            return new ArrayList<>();
        }

    }
}
