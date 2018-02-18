package com.recruitment;

import com.recruitment.controller.PrimeNumbersService;
import com.recruitment.model.ConnectDB;
import com.recruitment.model.DataDB;
import com.recruitment.model.PrimeNumbers;
import com.recruitment.model.ProcessingJSON;
import com.recruitment.view.PresentationService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.List;

/**
 * @author Michał Bodzek
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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
            PresentationService presentationService = new PresentationService();
            presentationService.showResults(solution);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }
}
