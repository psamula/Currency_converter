package handlers;

import dao.CurrencyDao;
import domain.CurrencyExchange;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;


public class TransactionHandler {
    CurrencyExchange c1;
    CurrencyExchange c2;
    BigDecimal amount;

    public TransactionHandler(String currCode1, String currCode2, double amount) {
        this.c1 = CurrencyDao.getInstance()
                .getCurrencyMap()
                .getOrDefault(currCode1, null);

        this.c2 = CurrencyDao.getInstance()
                .getCurrencyMap()
                .getOrDefault(currCode2, null);

        if (c1 == null || c2 == null) {
            System.out.println("Currency not found!");
            return;
        }
        this.amount = BigDecimalHandler.convertToBD(amount);

        if ((this.amount.compareTo(BigDecimalHandler.convertToBD(0)) <= 0)) {
            System.out.println("Wrong amount! ");
        }
    }


    private BigDecimal convertCurrency() {
        var c1_exchange = BigDecimalHandler.convertToBD(c1.getExchangeRate());
        var c1_conversion = BigDecimalHandler.convertToBD(c1.getConversionRate());
        var c2_exchange = BigDecimalHandler.convertToBD(c2.getExchangeRate());
        var c2_conversion = BigDecimalHandler.convertToBD(c2.getConversionRate());

        return this.amount
                .multiply(c1_exchange)
                .divide(c1_conversion, RoundingMode.HALF_EVEN)
                .multiply(c2_conversion)
                .divide(c2_exchange, RoundingMode.HALF_EVEN);
    }
    public String getExchangeResult() {

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        numberFormat.setCurrency(c2.getCurrency());

        var result = convertCurrency();

        return numberFormat.format(result);
    }
}
