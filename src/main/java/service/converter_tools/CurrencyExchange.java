package service.converter_tools;

import domain.CustomCurrency;
import domain.ICustomCurrency;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class CurrencyExchange {
    public static BigDecimal convertCurrencies(ICustomCurrency c1, ICustomCurrency c2, BigDecimal amount) {
        var c1e =  new BigDecimal(c1.getExchangeRate().replace(",", "."));
        var c2e =  new BigDecimal(c2.getExchangeRate().replace(",", "."));
        var c1c =  BigDecimal.valueOf(c1.getConversionRate());
        var c2c =  BigDecimal.valueOf(c2.getConversionRate());

        var result = amount
                .multiply(c1e)
                .divide(c1c, RoundingMode.HALF_EVEN)
                .multiply(c2c)
                .divide(c2e, RoundingMode.HALF_EVEN)
                .setScale(2, RoundingMode.HALF_EVEN);

        return result;
    }
}
