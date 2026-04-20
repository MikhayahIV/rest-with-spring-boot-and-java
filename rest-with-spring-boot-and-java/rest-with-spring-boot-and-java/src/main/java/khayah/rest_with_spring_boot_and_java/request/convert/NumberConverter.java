package khayah.rest_with_spring_boot_and_java.request.convert;

import khayah.rest_with_spring_boot_and_java.exception.UnsupportedMathOperationException;

public class NumberConverter {
    public static Double converToDouble(String strNumber) throws IllegalArgumentException  {
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value");
        String number = strNumber.replace(",",".");
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",",".");
        return (number.matches("\"[-+]?[0-9]*\\\\.?[0-9]+\""));
    }
}
