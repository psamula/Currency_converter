package service;

import Exceptions.CurrencyNotFoundException;
import Exceptions.InvalidInputException;
import Exceptions.NegativeAmountException;
import dao.ICurrencyDao;
import service.converter_tools.CurrencyExchange;
import service.converter_tools.CurrencyFormatter;
import validators.CustomValidator;
import java.math.BigDecimal;

public class CurrencyService implements ICurrencyService {
    private final ICurrencyDao currencyDao;

    public CurrencyService(ICurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }

    public String exchange(String currFromCode, String amount, String currToCode)
            throws InvalidInputException {

        try {

            var currencyFrom = currencyDao.getCurrencyByCode(currFromCode);
            var currencyTo = currencyDao.getCurrencyByCode(currToCode);

            var BigDecimalAmount = new BigDecimal(amount);
            CustomValidator.isPositiveAmount(BigDecimalAmount);
            CustomValidator.isFoundCurrency(currencyFrom);
            CustomValidator.isFoundCurrency(currencyTo);

            var value = CurrencyExchange.convertCurrencies(currencyFrom, currencyTo, BigDecimalAmount);
            return CurrencyFormatter.formatCurrency(value, currencyTo.getCurrency());
        }
        catch (CurrencyNotFoundException | NegativeAmountException nt) {
            throw new InvalidInputException(nt.getMessage(), nt);
        }
        catch (NumberFormatException nfe) {
            throw new InvalidInputException("Input amount is invalid", nfe);
        }
    }

}
