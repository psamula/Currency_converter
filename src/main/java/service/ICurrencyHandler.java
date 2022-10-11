package service;


import java.math.BigDecimal;

public interface ICurrencyHandler {
    String exchange(String currFromCode, BigDecimal amount, String currToCode);

}
