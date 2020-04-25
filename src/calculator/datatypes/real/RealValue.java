package calculator.datatypes.real;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;
import calculator.ParseValueException;
import calculator.datatypes.complex.ComplexValue;

public class RealValue extends AbstractValue {
    private double value;

    public RealValue(double value){
        this.value = value;
    }
    public RealValue(int iNumerator, int iDenominator){
        this.value = (double)iNumerator/(double)iDenominator;
    }

    @Override
    public AbstractValue add(AbstractValue operand) throws OperationNotSupportedException, ParseValueException {
        RealValue o = (RealValue) operand;
        return new RealValue(this.value + o.value);

    }

    @Override
    public AbstractValue sub(AbstractValue operand) throws OperationNotSupportedException, ParseValueException {
        RealValue o = (RealValue) operand;
        return new RealValue(this.value - o.value);
    }

    @Override
    public AbstractValue mul(AbstractValue operand) throws OperationNotSupportedException {
        RealValue o = (RealValue) operand;
        return new RealValue(this.value * o.value);
    }

    @Override
    public AbstractValue div(AbstractValue operand) throws DivisionByZeroException, OperationNotSupportedException {
        RealValue o = (RealValue) operand;
        double op =  ((RealValue) operand).value;
        if (op == 0.0){
            throw new DivisionByZeroException();
        }else {
            return new RealValue(this.value / op);
        }
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
