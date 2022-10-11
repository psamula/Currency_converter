package delete_unused;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalHandler {
    public static BigDecimal convertToBD(double amount) {
        return new BigDecimal("" + amount)
                .setScale(2, RoundingMode.HALF_EVEN);
    }
    public static String nothing(String nn) {
        return nn + " ";
    }
}
