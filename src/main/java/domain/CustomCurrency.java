package domain;

import javax.xml.bind.annotation.*;
import java.util.Currency;

//@Builder
@XmlRootElement(name = "pozycja")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomCurrency {

    @XmlElement(name = "nazwa_waluty")
    private String name;
    @XmlElement(name = "przelicznik")
    private int conversionRate;
    @XmlElement(name = "kod_waluty")
    private String code;
    @XmlElement(name = "kurs_sredni")
    private double exchangeRate;

    public String getName() {
        return name;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Currency getCurrency() {
        return Currency.getInstance(this.code);
    }

   // public Locale getLocale() { return getCurrency()}

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

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(float exchangeRate) {
        this.exchangeRate = exchangeRate;
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
