package pro.sky.java.course2.calculator;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.calculator.exception.DivideByZeroException;

@Service
public class ServiceImpl implements pro.sky.java.course2.calculator.Service {
    public String greeting() {
        return "Добро пожаловать в калькулятор";
    }

    public String plus(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
           return "Не введен один из параметров или оба параметра";
        } else {
            Integer sum = num1 + num2;
            return num1 + " + " + num2 + " = " + sum;
        }
    }

    public String minus(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            return "Не введен один из параметров или оба параметра";
        } else {
            Integer result = num1 - num2;
            return num1 + " - " + num2 + " = " + result;
        }
    }

    public String multiply(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            return "Не введен один из параметров или оба параметра";
        } else {
            Integer result = num1 * num2;
            return num1 + " * " + num2 + " = " + result;
        }
    }

    public String divide(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            return "Не введен один из параметров или оба параметра";
        } else if (num2 == 0) {
            throw new DivideByZeroException("Делить на 0 нельзя");
        } else {
            Double result = (double) num1 / (double) num2;
            return num1 + " / " + num2 + " = " + result;
        }
    }
}




