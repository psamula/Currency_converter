package domain;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Currency;

//@Builder
@XmlRootElement(name = "pozycja")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomCurrency implements ICustomCurrency {

    @XmlElement(name = "nazwa_waluty")
    private String name;
    @XmlElement(name = "przelicznik")
    private int conversionRate;
    @XmlElement(name = "kod_waluty")
    private String code;
    @XmlElement(name = "kurs_sredni")
    private String exchangeRate;

    public String getName() {
        return name;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
    public Currency getCurrency() {
        return Currency.getInstance(this.code);
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getConversionRate() {
        return conversionRate;
    }
    public void setConversionRate(int conversionRate) {
        this.conversionRate = conversionRate;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getExchangeRate() {
        return exchangeRate;
    }

    @Override
    public String toString() {
        return "handlers.CurrencyExchange{" +
                "name='" + name + '\'' +
                ", conversionRate=" + conversionRate +
                ", code='" + code + '\'' +
                ", exchangeRate=" + exchangeRate;
    }
}
