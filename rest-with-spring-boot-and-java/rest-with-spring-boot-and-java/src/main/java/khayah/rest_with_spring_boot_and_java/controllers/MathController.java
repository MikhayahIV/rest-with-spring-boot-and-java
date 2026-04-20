package khayah.rest_with_spring_boot_and_java.controllers;

import khayah.rest_with_spring_boot_and_java.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value");
        return converToDouble(numberOne) + converToDouble(numberTwo);
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        if(!isNumeric(numberOne) || isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value");
        return  converToDouble(numberOne) - converToDouble(numberTwo);
    }

    @RequestMapping("multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        if(!isNumeric(numberOne)||!isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value");
        return converToDouble(numberOne) * converToDouble(numberTwo);
    }

    @RequestMapping("divison/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        if(!isNumeric(numberOne)||!isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value");
        return converToDouble(numberOne) / converToDouble(numberTwo);
    }

    @RequestMapping("mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        if(!isNumeric(numberOne)||!isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value");
        return (converToDouble(numberOne) + converToDouble(numberTwo)) / 2;
    }

    @RequestMapping("squareRote/{number}")
    public Double squareRote(
            @PathVariable("numberOne") String number
    ) throws Exception{
        if(!isNumeric(number))
            throw new UnsupportedMathOperationException("Please set a numeric value");
        return Math.sqrt(converToDouble(number));
    }


    private Double converToDouble(String strNumber) throws IllegalArgumentException  {
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value");
        String number = strNumber.replace(",",".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",",".");
       return (number.matches("\"[-+]?[0-9]*\\\\.?[0-9]+\""));
    }
}
