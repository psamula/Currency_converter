package validators;

import exceptions.CurrencyNotFoundException;
import exceptions.NegativeAmountException;
import domain.ICustomCurrency;

import java.math.BigDecimal;

public class CustomValidator {
    public static void isPositiveAmount(BigDecimal amount) throws NegativeAmountException {
        if (amount.compareTo(BigDecimal.valueOf(0)) <= 0) {
            throw new NegativeAmountException("Negative amount input");
        }
    }
    public static void isFoundCurrency(ICustomCurrency currency) throws CurrencyNotFoundException {
        if (currency == null) {
            throw new CurrencyNotFoundException("No currency could be found with such code");
        }
    }
    public static boolean isEmptyInput(String choice) {
        return choice.equals("");
    }
}
