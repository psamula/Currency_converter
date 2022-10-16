package domain;

import java.util.Currency;

public interface ICustomCurrency {
    String getName();
    void setExchangeRate(String exchangeRate);
    void setName(String name);
    int getConversionRate();
    void setConversionRate(int conversionRate);
    String getCode();
    void setCode(String code);
    String getExchangeRate();
    Currency getCurrency();
}
