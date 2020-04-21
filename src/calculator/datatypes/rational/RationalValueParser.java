package calculator.datatypes.rational;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;
import calculator.datatypes.rational.RationalValue;

public class RationalValueParser implements AbstractValueParser {

public AbstractValue parse(String value) throws ParseValueException {
	String[] subStr = value.split("/");
	String iNumerator = subStr[0];
	String iDenominator;
	
    	   if (value.indexOf("/") < 0)
    	   {
    		   iDenominator = "1";
    	   }
    	   else
    	   {
    		   if (subStr[1] == "0")
    		    {
    		       throw new ParseValueException("Denominator is zero!");
    		    }
    		       else
    		       {
    		    	   iDenominator = subStr[1];
    		       }
       }
	try {
		return new RationalValue(Integer.parseInt(iNumerator), Integer.parseInt(iDenominator));
		} 
	catch (NumberFormatException exception) 
	{
		throw new ParseValueException();
		}
}

public String getDatatypeName() {
	return "рациональные числа";
	}



public static void main (String[] args)
{
	String value = "-17/5";
	String[] subStr = value.split("/");
	String iNumerator = subStr[0];
	String iDenominator = subStr[1];
	System.out.println(iNumerator);
	System.out.println(iDenominator);
}
}