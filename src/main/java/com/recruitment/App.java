package com.recruitment;

import com.recruitment.controller.AppLogicService;
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
    public static void main( String[] args ) {
        AppLogicService mainApplication = new AppLogicService();
        List<Integer> solution = mainApplication.resolve();
        PresentationService presentationService = new PresentationService();
        presentationService.showResults(solution);
    }
}
