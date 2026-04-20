package khayah.rest_with_spring_boot_and_java.controllers;

import khayah.rest_with_spring_boot_and_java.exception.UnsupportedMathOperationException;
import khayah.rest_with_spring_boot_and_java.math.SimpleMath;
import khayah.rest_with_spring_boot_and_java.request.convert.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private SimpleMath math = new SimpleMath();

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value");
        return math.sum(NumberConverter.converToDouble(numberOne), NumberConverter.converToDouble(numberTwo));
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value");
        return  math.subtraction(NumberConverter.converToDouble(numberOne), NumberConverter.converToDouble(numberTwo));
    }

    @RequestMapping("multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        if(!NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value");
        return math.multiplication(NumberConverter.converToDouble(numberOne), NumberConverter.converToDouble(numberTwo));
    }

    @RequestMapping("division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        if(!NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value");
        return math.division(NumberConverter.converToDouble(numberOne),NumberConverter.converToDouble(numberTwo));
    }

    @RequestMapping("mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        if(!NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value");
        return math.mean(NumberConverter.converToDouble(numberOne),NumberConverter.converToDouble(numberTwo));
    }

    @RequestMapping("squareRote/{number}")
    public Double squareRote(
            @PathVariable("numberOne") String number
    ) throws Exception{
        if(!NumberConverter.isNumeric(number))
            throw new UnsupportedMathOperationException("Please set a numeric value");
        return math.squareRote(NumberConverter.converToDouble(number));
    }

}
