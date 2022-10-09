package handlers;

public class CurrencyHandler {

    public String sell(String currFromCode, double amount, String currToCode) {
        TransactionHandler transactionHandler = new TransactionHandler(currFromCode, currToCode, amount);
        return transactionHandler.getExchangeResult();
    }
}
