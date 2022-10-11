package dao;

import domain.CustomCurrency;

import java.util.List;
import java.util.Map;

public interface ICurrencyDao {
     CustomCurrency getCurrencyByCode(String code);
     double getExchangeRateByCode(String code);
     Map<String, CustomCurrency> getCurrencyMap();
     List<CustomCurrency> getCurrencyList();

}
