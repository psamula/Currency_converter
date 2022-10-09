package ui;

import handlers.CurrencyHandler;

import java.util.Scanner;

public class UserInterface {
    private Scanner sc;
    private CurrencyHandler currencyHandler;

    public UserInterface(Scanner sc, CurrencyHandler currencyHandler) {
        this.sc = sc;
        this.currencyHandler = currencyHandler;
    }

    public void run() {
        int i = 1;
        while(i-- != 0) {
            System.out.println("Which currency do you want to exchange? [code]");
            String choice = sc.nextLine();
            System.out.println("How much of it?");
            float chosenAmount = -1;
            try {
                chosenAmount = Float.parseFloat(sc.nextLine());
            } catch (IllegalArgumentException ill) {
                System.out.println("Input is invalid!");
                return;
            }
            System.out.println("Which currency do you want to exchange to? [code]");
            String destCurrChoice = sc.nextLine();
            var finalAmount = currencyHandler.sell(choice, chosenAmount, destCurrChoice);/*
            if (finalAmount == -1) {
                System.out.println("Wrong amount!");
                return;
            }
            if (finalAmount == -2) {
                System.out.println("Wrong currency!");
                return;
            }*/
            System.out.println(finalAmount);
        }
    }
}
