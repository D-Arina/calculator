package calculator.datatypes.vector;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;
import calculator.ParseValueException;
import calculator.datatypes.complex.ComplexValue;

public class VectorValue extends AbstractValue {
    private double[] v;
    private int len;

    VectorValue(double[] v){
        this.v = v;
        this.len = v.length;
    }
    VectorValue(int len){
        this.len = len;
        this.v = new double[len];
    }



    @Override
    public AbstractValue add(AbstractValue operand) throws OperationNotSupportedException, ParseValueException {
        VectorValue w = (VectorValue)operand;
        VectorValue q = new VectorValue(len);
        //System.out.println("add - " + v.toString() + w.toString() );
        if (w.len != this.v.length){
            throw new ParseValueException("Different lengths.");
        }
        for (int i=0; i < len; i++){
            q.v[i] = this.v[i] + w.v[i];
        }
        return q;
    }

    @Override
    public AbstractValue sub(AbstractValue operand) throws OperationNotSupportedException, ParseValueException {
        VectorValue w = (VectorValue)operand;
        VectorValue q = new VectorValue(len);
        if (w.len != this.v.length){
            throw new ParseValueException("Different lengths.");
        }
        for (int i=0; i < len; i++){
            q.v[i] = this.v[i] - w.v[i];
        }
        return q;
    }

    @Override
    public AbstractValue mul(AbstractValue operand) throws OperationNotSupportedException {
        VectorValue w = (VectorValue)operand;
        VectorValue vec = new VectorValue(3);
        if (w.len != this.v.length){
            throw new OperationNotSupportedException("*");
        }
        if(!(w.len == 3)){
            throw new OperationNotSupportedException("*");
        }else {
            double x = this.v[1]*w.v[2] - this.v[2]*w.v[1];
            double y = this.v[2]*w.v[0] - this.v[0]*w.v[2];
            double z = this.v[0]*w.v[1] - this.v[1]*w.v[0];
            vec.v[0] = x;
            vec.v[1] = y;
            vec.v[2] = z;
            return vec;
        }
    }

    @Override
    public AbstractValue div(AbstractValue operand) throws DivisionByZeroException, OperationNotSupportedException {
        throw new OperationNotSupportedException("/");
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append('(');
        for (int i = 0; i < len; i++) {
            s.append(v[i]);
            if (i < len-1) s.append(", ");
        }
        s.append(')');
        return s.toString();
    }
}
