package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;
import calculator.ParseValueException;

public class ComplexValue extends AbstractValue {
    private double re, im;

    ComplexValue(double re, double im){
        this.re = re;
        this.im = im;
    }



    public ComplexValue add(AbstractValue operand) throws OperationNotSupportedException, ParseValueException {
        ComplexValue o = (ComplexValue)operand;
        ComplexValue n = new ComplexValue(re + o.re, im + o.im);
        return n;
    }

    @Override
    public AbstractValue sub(AbstractValue operand) throws OperationNotSupportedException, ParseValueException {
        ComplexValue comp = (ComplexValue) operand;
        return new ComplexValue(re - comp.re, im - comp.im);
    }

    @Override
    public ComplexValue mul(AbstractValue operand) throws OperationNotSupportedException {
        ComplexValue o = (ComplexValue)operand;
        return new ComplexValue(re * o.re - im * o.im, re * o.im + im * o.re);
    }

    @Override
    public AbstractValue div(AbstractValue operand) throws DivisionByZeroException, OperationNotSupportedException {
        ComplexValue o = (ComplexValue)operand;
        double m = Math.sqrt (re * re+ im * im);
        return new ComplexValue ((re * o.re - im * o.im) /m, (im * o.re - re * o.im) /m);
    }

    @Override
    public String toString() {
        return  + re + " + " +im;
    }


}
