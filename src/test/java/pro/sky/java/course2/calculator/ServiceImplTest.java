package pro.sky.java.course2.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.calculator.exception.DivideByZeroException;

public class ServiceImplTest {

    private final ServiceImpl serviceImpl = new ServiceImpl();

    private final Integer num1first = 10;
    private final Integer num2first = 2;
    private final Integer num1second = -8;
    private final Integer num2second = -4;


    @Test
    public void shouldDoCorrectAddiction () {
        String actual = serviceImpl.plus(num1first, num2first);
        Integer result = num1first + num2first;
        Assertions.assertEquals (actual, num1first + " + " + num2first + " = " + result);
        actual= serviceImpl.plus(num1second, num2second);
        result = num1second + num2second;
        Assertions.assertEquals(actual, num1second + " + " + num2second + " = " + result);

    }

    @Test
    public void shouldDoCorrectSubtraction () {
        String actual = serviceImpl.minus(num1first, num2first);
        Integer result = num1first - num2first;
        Assertions.assertEquals (actual, num1first + " - " + num2first + " = " + result);
        actual= serviceImpl.minus(num1second, num2second);
        result = num1second - num2second;
        Assertions.assertEquals(actual, num1second + " - " + num2second + " = " + result);

    }

    @Test
    public void shouldDoCorrectMultiplication () {
        String actual = serviceImpl.multiply(num1first, num2first);
        Integer result = num1first * num2first;
        Assertions.assertEquals (actual, num1first + " * " + num2first + " = " + result);
        actual= serviceImpl.multiply(num1second, num2second);
        result = num1second * num2second;
        Assertions.assertEquals(actual, num1second + " * " + num2second + " = " + result);

    }

    @Test
    public void shouldDoCorrectDivision () {
        String actual = serviceImpl.divide(num1first, num2first);
        Double result = (double) num1first / num2first;
        Assertions.assertEquals (actual, num1first + " / " + num2first + " = " + result);
        actual= serviceImpl.divide(num1second, num2second);
        result = (double) num1second / num2second;
        Assertions.assertEquals(actual, num1second + " / " + num2second + " = " + result);

    }

    @Test
    public void shouldDoCorrectDivisionByZero () {
            DivideByZeroException e = Assertions.assertThrows (DivideByZeroException.class, () -> {
            serviceImpl.divide(num1first, 0);
        });
        Assertions.assertEquals("Делить на 0 нельзя", e.getMessage());
    }



}
