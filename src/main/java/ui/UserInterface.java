package ui;

import service.ICurrencyHandler;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class UserInterface implements IUserInterface {
    private Scanner sc;
    private ICurrencyHandler currencyHandler;

    public UserInterface(Scanner sc, ICurrencyHandler currencyHandler) {
        this.sc = sc;
        this.currencyHandler = currencyHandler;
    }

    public void run() {
        int i = 1;
        while(i-- > 0) {
            System.out.println("Which currency do you want to exchange? [code]");
            String choice = sc.nextLine();
            System.out.println("How much of it?");
            BigDecimal chosenAmount = new BigDecimal(sc.nextLine()).setScale(2, RoundingMode.HALF_EVEN);

            System.out.println("Which currency do you want to exchange to? [code]");

            String destCurrChoice = sc.nextLine();

            if (chosenAmount.compareTo(BigDecimal.valueOf(0)) <= 0) {
                System.out.println("Invalid amount!");
                continue;
            }

            var finalAmount = currencyHandler.exchange(choice, chosenAmount, destCurrChoice);
            System.out.println(finalAmount);/*
            if (finalAmount == -1) {
                System.out.println("Wrong amount!");
                return;
            }
            if (finalAmount == -2) {
                System.out.println("Wrong currency!");
                return;
            }*/

        }
    }
}
