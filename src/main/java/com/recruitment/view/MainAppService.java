package com.recruitment.view;

import com.recruitment.controller.AppLogicService;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainAppService {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (menuChoice(scanner) != 0) {
            System.out.println("------------------------------- RESULTS ----------------------------------");
            appRun();
        }
        System.exit(0);
    }

    private void appRun() {
        AppLogicService mainApplication = new AppLogicService();
        List<Integer> solution = mainApplication.resolve();
        PresentationService presentationService = new PresentationService();
        presentationService.showResults(solution);
    }

    private int menuChoice(Scanner scanner) {
        String choiceString;
        do {
            System.out.println("-------------------------------- MENU ------------------------------------");
            System.out.println("Choose: ");
            System.out.println("Displaying next session results - type: 1");
            System.out.println("Close application - type: 0");
            System.out.print("Enter a valid integer number [0 or 1]: ");
            choiceString = scanner.nextLine();
            System.out.println();
        } while (!isNumberValid(choiceString));
        return Integer.parseInt(choiceString);
    }

    private boolean isNumberValid(String number) {
        String patternString = "[01]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
