package khayah.rest_with_spring_boot_and_java.math;

import khayah.rest_with_spring_boot_and_java.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class SimpleMath {

    public Double sum(Double numberOne, Double numberTwo){
        return numberOne + numberTwo;
    }

    public Double subtraction(Double numberOne, Double numberTwo){
        return  numberOne - numberTwo;
    }

    public Double multiplication(Double numberOne, Double numberTwo){
        return numberOne * numberTwo;
    }

    public Double division(Double numberOne, Double numberTwo){
        return numberOne / numberTwo;
    }

    public Double mean(Double numberOne, Double numberTwo){
        return (numberOne + numberTwo) / 2;
    }

    public Double squareRote(Double number){
        return Math.sqrt(number);
    }

}
