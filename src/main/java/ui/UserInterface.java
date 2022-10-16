package ui;

import exceptions.InvalidInputException;
import service.ICurrencyService;
import validators.CustomValidator;

import java.util.Scanner;

public class UserInterface implements IUserInterface {
    private final Scanner sc;
    private final ICurrencyService currencyService;

    public UserInterface(Scanner sc, ICurrencyService currencyService) {
        this.sc = sc;
        this.currencyService = currencyService;
    }

    public void run() {
        while(true) {
            try {
                System.out.println("\n(Insert empty string to exit)");
                System.out.println("Which currency do you want to exchange? [code]\n");
                String choice = prepUserInput(sc.nextLine());
                if (CustomValidator.isEmptyInput(choice)) {
                    break;
                }

                System.out.println("How much of it?");
                String chosenAmount = prepUserInput(sc.nextLine());

                System.out.println("Which currency do you want to exchange to? [code]");
                String destCurrChoice = prepUserInput(sc.nextLine());
                var finalAmount = currencyService.exchange(choice, chosenAmount, destCurrChoice);
                System.out.println("You'll receive: " + finalAmount);
            }
            catch (InvalidInputException iie) {
                System.out.println(iie.getMessage() + "\n\nTry again\n");
            }
        }
    }
    private String prepUserInput(String input) {
        return input.trim().toUpperCase();
    }
}
