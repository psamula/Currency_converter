package service.converter_tools;

import domain.CustomCurrency;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class CurrencyExchange {
    public static BigDecimal convertCurrencies(CustomCurrency c1, CustomCurrency c2, BigDecimal amount) {
        var c1e =  BigDecimal.valueOf(c1.getExchangeRate());
        var c2e =  BigDecimal.valueOf(c2.getExchangeRate());
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
