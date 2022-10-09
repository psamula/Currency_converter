import handlers.CurrencyHandler;
import ui.UserInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //handlers.XMLhandler xmlhandler = new handlers.XMLhandler();
        String test = "PLN\n" + "2.5\n" + "CNY\n";
        UserInterface ui = new UserInterface(new Scanner(test), new CurrencyHandler());
        ui.run();

    }
}