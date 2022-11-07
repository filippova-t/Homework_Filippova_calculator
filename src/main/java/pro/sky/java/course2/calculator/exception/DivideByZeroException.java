package pro.sky.java.course2.calculator.exception;

public class DivideByZeroException extends IllegalArgumentException{
    public DivideByZeroException(String s) {
        super(s);
    }
}
