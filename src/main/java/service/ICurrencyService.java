package service;


public interface ICurrencyService {
    String exchange(String currFromCode, String amount, String currToCode);
}
