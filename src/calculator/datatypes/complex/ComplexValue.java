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


    @Override
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
        ComplexValue temp = new ComplexValue(o.re, -1 * o.im);
        temp = ComplexValue.this.mul(temp);
        double denominator = (o.re * o.re) + (o.im * o.im);
        return new ComplexValue(temp.re / denominator, temp.im / denominator);
    }

    @Override
    public String toString() {
        return  re + " + " +im + "i";
    }

    public double mod(){
        return Math.sqrt (re * re+ im * im);
    }


}
