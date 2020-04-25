package calculator.datatypes.real;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

public class RealValueParser implements AbstractValueParser {

    @Override
    public AbstractValue parse(String value) throws ParseValueException {
        String[] subStr = value.split("/");
        String iNumerator = subStr[0];
        String iDenominator;
        double number;

        try {
            if (value.contains(".")) {
                number = Double.parseDouble(subStr[0]);
                return new RealValue(number);
            } else {
                if (subStr[1].equals("0")) {
                    throw new ParseValueException("Denominator is zero!");
                } else {
                    iDenominator = subStr[1];
                    return new RealValue(Integer.parseInt(iNumerator), Integer.parseInt(iDenominator));

                }
            }
        } catch (Exception e) {
            throw new ParseValueException();
        }
    }

    @Override
    public String getDatatypeName() {
        return "Real numbers";
    }
}
