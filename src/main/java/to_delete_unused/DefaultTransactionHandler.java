package to_delete_unused;


public class DefaultTransactionHandler/* implements TransactionHandler*/ {
//    private CustomCurrency c1;
//    private CustomCurrency c2;
//    private BigDecimal amount;
//
//    public DefaultTransactionHandler(String currCode1, String currCode2, double amount) {
//        this.c1 = CurrencyDao.getInstance()
//                .getCurrencyMap()
//                .getOrDefault(currCode1, null);
//
//        this.c2 = CurrencyDao.getInstance()
//                .getCurrencyMap()
//                .getOrDefault(currCode2, new Exception("wrong"));
//
//        if (c1 == null || c2 == null) {
//            System.out.println("Currency not found!");
//            return;
//        }
//        this.amount = BigDecimal.valueOf(amount);
//
//        if (this.amount.compareTo(BigDecimal.valueOf(0)) <= 0) {
//            System.out.println("Wrong amount! ");
//        }
//    }
//
//
//    private BigDecimal convertCurrency() {
//
//        var c1_exchange = BigDecimal.valueOf(c1.getExchangeRate());
//        var c2_exchange = BigDecimal.valueOf(c2.getExchangeRate());
//        var c2_conversion = BigDecimal.valueOf(c2.getConversionRate());
//        var c1_conversion = BigDecimal.valueOf(c1.getConversionRate());
//
//        return this.amount
//                .multiply(c1_exchange)
//                .divide(c1_conversion, RoundingMode.HALF_EVEN)
//                .multiply(c2_conversion)
//                .divide(c2_exchange, RoundingMode.HALF_EVEN).setScale(2, RoundingMode.HALF_EVEN);
//    }
//    public String getExchangeResult() {
//
////        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
////        numberFormat.setCurrency(c2.getCurrency());
////
////        var result = convertCurrency();
////
////        return numberFormat.format(result);
//    }

}
