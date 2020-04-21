package calculator.datatypes.rational;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.datatypes.rational.RationalValue;

public class RationalValue extends AbstractValue
{
    private int iNumerator;
    private int iDenominator;
    
    public RationalValue(int iNumerator, int iDenominator)
    {
    		super();
    		this.iNumerator = iNumerator;
    		this.iDenominator = iDenominator;
    		normalize();
    }
    
    
    public String toString()
    {
    	if (iDenominator == 1)
    		return new String(iNumerator + " ");
    	else
        return new String(iNumerator + "/" + iDenominator);
    }
    

    public AbstractValue add(AbstractValue operand)
    {
        return new RationalValue(iNumerator*((RationalValue) operand).iDenominator + ((RationalValue) operand).iNumerator*iDenominator,
        		this.iDenominator = iDenominator*((RationalValue) operand).iDenominator);
    }
    

    public AbstractValue sub(AbstractValue operand)
    {
        return new RationalValue (iNumerator*((RationalValue) operand).iDenominator - ((RationalValue) operand).iNumerator*iDenominator,
        		this.iDenominator = iDenominator*((RationalValue) operand).iDenominator);
    }
    
    
    public AbstractValue mul(AbstractValue operand)
    {
        return new RationalValue (iNumerator*((RationalValue) operand).iNumerator,
        		iDenominator*((RationalValue) operand).iDenominator);
    }
    
    
    public AbstractValue div(AbstractValue operand)
    		throws DivisionByZeroException {
    	if (((RationalValue) operand).iNumerator == 0)
    		throw new DivisionByZeroException(); 
        return new RationalValue (iNumerator*((RationalValue) operand).iDenominator, iDenominator*((RationalValue) operand).iNumerator);
    }
    
    
    
    
    private int NOD(int val1, int val2)
    {
        if (val1 < val2)
        {
            int iTemp = val2; val2 = val1; val1 = iTemp;
        }
        int iRemainder = val1 % val2;
        while (iRemainder != 0)
        {
            val1 = val2;
            val2 = iRemainder;
            iRemainder = val1 % val2;
        }
        return val2;
    }
    
    private int sign(int val)
    {
        return (val > 0) ? 1 : (val < 0) ? -1 : 0;
    }

    private int abs(int val)
    {
        return (val > 0) ? val : -val;
    }
    
    private void normalize()
    {
        if (iNumerator == 0)
        {
            iDenominator = 1;
            return;
        }
        int iSign = sign(iNumerator) * sign(iDenominator);
        int Numerator = abs(iNumerator);
        int Denominator = abs(iDenominator);
        int iNOD = NOD(Numerator, Denominator);
        iNumerator = (Numerator / iNOD) * iSign;
        iDenominator = Denominator / iNOD;
    }
    
    public static void main(String [] args)
    {
    	RationalValue num = new RationalValue(1,3);
        System.out.println(num);
        num.add(new RationalValue(1,2));
        System.out.println(num);
        
        num = new RationalValue(1,3);
        System.out.println(num);
        num.mul(new RationalValue(3,2));
        System.out.println(num);        
    }
}
