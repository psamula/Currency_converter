package service;

import dao.ICurrencyDao;
import service.converter_tools.CurrencyExchange;
import service.converter_tools.CurrencyFormatter;

import java.math.BigDecimal;

public class CurrencyHandler implements ICurrencyHandler {
    private final ICurrencyDao currencies;

    public CurrencyHandler(ICurrencyDao currencies) {
        this.currencies = currencies;
    }

    public String exchange(String currFromCode, BigDecimal amount, String currToCode) {
        var currencyFrom = currencies.getCurrencyByCode(currFromCode);
        var currencyTo = currencies.getCurrencyByCode(currToCode);

        if (currencyFrom == null || currencyTo == null) {
            throw new RuntimeException("Currency not found");
        }

        var value = CurrencyExchange.convertCurrencies(currencyFrom, currencyTo, amount);

        return CurrencyFormatter.formatCurrency(value, currencyTo.getCurrency());


    }
    public void viewCurrentCourses() {
        throw new RuntimeException(("Not implemented yet!"));
    }

}
