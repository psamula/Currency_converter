import dao.CurrencyDao;
import service.CurrencyHandler;
import ui.IUserInterface;
import ui.UserInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //handlers.XMLmanager.XMLhandler xmlhandler = new handlers.XMLmanager.XMLhandler();
        String test = "EUR\n" + "2.5\n" + "USD\n";
        IUserInterface ui = new UserInterface(new Scanner(test), new CurrencyHandler(CurrencyDao.getInstance()));
        ui.run();

    }
}