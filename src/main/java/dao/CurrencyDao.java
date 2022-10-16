package dao;

import domain.CustomCurrency;
import domain.ICustomCurrency;
import xml_manager.XmlToListConverter;
import domain.CourseTable;


import java.util.*;

import static java.lang.System.exit;

public class CurrencyDao implements ICurrencyDao {
    private final HashMap<String, ICustomCurrency> currencyMap;
    private final List<ICustomCurrency> sourceList;
    private static CurrencyDao instance;

    private void createCurrencyCollection() {
        if (this.sourceList.isEmpty()) {
            System.out.println("The data source is empty");
            exit(-3);
        }
        this.sourceList.forEach(c -> currencyMap.put(c.getCode(), c));
        addZloty();
    }
    public Map<String, ICustomCurrency> getCurrencyMap() {
        return currencyMap;
    }
    public List<ICustomCurrency> getCurrencyList() {
        return new ArrayList<>(this.currencyMap.values());
    }

    public static CurrencyDao getInstance() {
        synchronized (CurrencyDao.class) {
            if (instance == null) {
                String url = "https://www.nbp.pl/kursy/xml/lasta.xml";
                var listToImportFrom = XmlToListConverter
                        .convert(CourseTable.class, url);

                if (listToImportFrom == null) {
                    System.out.println("DAO xml list loading error");
                    exit(-1);
                }
                List<ICustomCurrency> sourceList = new ArrayList<>(listToImportFrom);

                instance = new CurrencyDao(sourceList);
            }
        }
        return instance;
    }
    public ICustomCurrency getCurrencyByCode(String code) {
        return this.currencyMap.getOrDefault(code, null);
    }

    public String getExchangeRateByCode(String code) {
        var currencyExchange = this.currencyMap
                .getOrDefault(code, null);
        return currencyExchange.getExchangeRate();
    }



    private CurrencyDao(List<ICustomCurrency> sourceList) {
        currencyMap = new HashMap<>();
        this.sourceList = sourceList;
        createCurrencyCollection();
    }
    private void addZloty() {

        var pln = new CustomCurrency();
        pln.setName("polski zloty");
        pln.setConversionRate(1);
        pln.setCode("PLN");
        pln.setExchangeRate("1.00");

        this.currencyMap.put("PLN", pln);
    }

}
