package dao;

import XMLmanager.XMLhandler;
import domain.CourseTable;
import domain.CustomCurrency;
import XMLmanager.XMLhandler;
import java.util.*;

public class CurrencyDao implements ICurrencyDao {
    private HashMap<String, CustomCurrency> currencyMap;
    private List<CustomCurrency> sourceList;
    private static CurrencyDao instance;

    private void createCurrencyCollection() {
        if (this.sourceList.isEmpty()) {
            throw new RuntimeException("The data source is empty");
        }
        this.sourceList.forEach(c -> currencyMap.put(c.getCode(), c));
    }
    public Map<String, CustomCurrency> getCurrencyMap() {
        return currencyMap;
    }
    public List<CustomCurrency> getCurrencyList() {
        return new ArrayList<>(this.currencyMap.values());
    }

    public static CurrencyDao getInstance() {
        synchronized (CurrencyDao.class) {
            if (instance == null) {
                String filename = "lasta.xml";
                List<CustomCurrency> sourceList = XMLhandler
                        .convert(CourseTable.class, filename);
                instance = new CurrencyDao(sourceList);
            }
        }
        return instance;
    }
    public CustomCurrency getCurrencyByCode(String code) {
        return this.currencyMap.getOrDefault(code, null);
    }

    public double getExchangeRateByCode(String code) {
        var currencyExchange = this.currencyMap
                .getOrDefault(code, null);
        if (currencyExchange == null) {
            throw new RuntimeException("Invalid code!");
        }
        return currencyExchange.getExchangeRate();
    }



    private CurrencyDao(List<CustomCurrency> sourceList) {
        currencyMap = new HashMap<>();
        this.sourceList = sourceList;
        createCurrencyCollection();
    }

}
