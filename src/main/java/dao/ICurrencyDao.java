package dao;


import domain.ICustomCurrency;
import java.util.List;
import java.util.Map;

public interface ICurrencyDao {
     ICustomCurrency getCurrencyByCode(String code);
     String getExchangeRateByCode(String code);
     Map<String, ICustomCurrency> getCurrencyMap();
     List<ICustomCurrency> getCurrencyList();

}
