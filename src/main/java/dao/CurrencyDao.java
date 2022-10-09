package dao;

import domain.CourseTable;
import domain.CurrencyExchange;
import handlers.XMLhandler;

import java.util.*;

public class CurrencyDao {
    private HashMap<String, CurrencyExchange> currencyMap = new HashMap<>();
    private List<CurrencyExchange> sourceList;
    private static CurrencyDao instance;

    public void createCurrencyExchanges() {
        this.sourceList.forEach(c -> currencyMap.put(c.getCode(), c));
    }

    public List<CurrencyExchange> getCurrencyExchanges() {
        return new ArrayList<>(this.currencyMap.values());
    }
    
    public static CurrencyDao getInstance() {
        synchronized (CurrencyDao.class) {
            if (instance == null) {
                String filename = "lasta.xml";
                List<CurrencyExchange> sourceList = XMLhandler
                        .convert(CourseTable.class, filename);
                instance = new CurrencyDao(sourceList);
            }
        }
        return instance;
    }

    public HashMap<String, CurrencyExchange> getCurrencyMap() {
        return currencyMap;
    }

    private CurrencyDao(List<CurrencyExchange> sourceList) {
        currencyMap = new HashMap<>();
        this.sourceList = sourceList;
        createCurrencyExchanges();
    }

}
