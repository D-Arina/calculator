package calculator.datatypes.vector;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;
import calculator.ParseValueException;

public class VectorValue extends AbstractValue {

    @Override
    public AbstractValue add(AbstractValue operand) throws OperationNotSupportedException, ParseValueException {
        return null;
    }

    @Override
    public AbstractValue sub(AbstractValue operand) throws OperationNotSupportedException, ParseValueException {
        return null;
    }

    @Override
    public AbstractValue mul(AbstractValue operand) throws OperationNotSupportedException {
        return null;
    }

    @Override
    public AbstractValue div(AbstractValue operand) throws DivisionByZeroException, OperationNotSupportedException {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}
