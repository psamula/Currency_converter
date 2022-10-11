package service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencyFormatter {
    public static String formatCurrency(BigDecimal value, Currency currency) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        numberFormat.setCurrency(currency);

        return numberFormat.format(value);
    }
}
