import dao.CurrencyDao;
import service.CurrencyService;
import ui.IUserInterface;
import ui.UserInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IUserInterface ui = new UserInterface(new Scanner(System.in), new CurrencyService(CurrencyDao.getInstance()));
        ui.run();
        String test = "ttt";


    }
}