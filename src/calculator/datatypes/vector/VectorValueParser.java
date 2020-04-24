package calculator.datatypes.vector;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

public class VectorValueParser implements AbstractValueParser {
    @Override
    public AbstractValue parse(String value) throws ParseValueException {
        value = value.trim();
//(1,0,0) + (2,5,8)
        StringBuffer sb = new StringBuffer(value);

        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        value = sb.toString();

        String[] subStr = value.split(",");
        int len = subStr.length;
        double[] vec = new double[len];
        try {
            //System.out.println(1);
            if (subStr.length == 0) {
                throw new ParseValueException();
            } else {
               // System.out.println(2);
                for (int i = 0; i <= subStr.length - 1; i++) {
                    vec[i] = Double.parseDouble(subStr[i]);
                }
            }
            return new VectorValue(vec);
        }catch (Exception e){
            throw  new ParseValueException();
        }

    }

    @Override
    public String getDatatypeName() {
        return "Vectors";
    }
}
