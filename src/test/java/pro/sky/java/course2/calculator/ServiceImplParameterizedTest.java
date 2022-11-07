package pro.sky.java.course2.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.java.course2.calculator.exception.DivideByZeroException;

import java.util.stream.Stream;

public class ServiceImplParameterizedTest {

    private final ServiceImpl serviceImpl = new ServiceImpl();

    @ParameterizedTest
    @MethodSource("paramsForTestAddiction")
    public void shouldDoCorrectAddiction (Integer num1, Integer num2, Integer expected) {
        String actual = serviceImpl.plus(num1, num2);

        Assertions.assertEquals (actual, num1 + " + " + num2 + " = " + expected);

    }

    @ParameterizedTest
    @MethodSource("paramsForTestSubtraction")
    public void shouldDoCorrectSubtraction (Integer num1, Integer num2, Integer expected) {
        String actual = serviceImpl.minus(num1, num2);
        Assertions.assertEquals (actual, num1 + " - " + num2 + " = " + expected);

    }
    @ParameterizedTest
    @MethodSource("paramsForTestMultiplication")
    public void shouldDoCorrectMultiplication (Integer num1, Integer num2, Integer expected) {
        String actual = serviceImpl.multiply(num1, num2);
        Assertions.assertEquals (actual, num1 + " * " + num2 + " = " + expected);

    }

    @ParameterizedTest
    @MethodSource("paramsForTestDivision")
    public void shouldDoCorrectDivision (Integer num1, Integer num2, Double expected) {
        if (num2 == 0) {
            DivideByZeroException e = Assertions.assertThrows (DivideByZeroException.class, () -> {
                serviceImpl.divide(num1, 0);
            });
            Assertions.assertEquals("Делить на 0 нельзя", e.getMessage());
        } else {
            String actual = serviceImpl.divide(num1, num2);
            Assertions.assertEquals(actual, num1 + " / " + num2 + " = " + expected);
        }
    }
    public static Stream<Arguments> paramsForTestAddiction() {
        return Stream.of (
        Arguments.of (20, -10, 10),
        Arguments.of (-16, 4, -12)
        );
    }

    public static Stream<Arguments> paramsForTestSubtraction() {
        return Stream.of (
                Arguments.of (22, -8, 30),
                Arguments.of (-16, 4, -20)
        );
    }

    public static Stream<Arguments> paramsForTestMultiplication() {
        return Stream.of (
                Arguments.of (5, 5, 25),
                Arguments.of (-7, 3, -21),
                Arguments.of (-2, -3, 6)
        );
    }

    public static Stream<Arguments> paramsForTestDivision() {
        return Stream.of (
                Arguments.of (24, -4, -6.0),
                Arguments.of (-16, -8, 2.0),
                Arguments.of (1, 0, null)
        );
    }

}
