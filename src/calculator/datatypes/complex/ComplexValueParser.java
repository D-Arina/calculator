package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

public class ComplexValueParser implements AbstractValueParser {


    @Override
    public AbstractValue parse(String value) throws ParseValueException {

        Double im = 0.0;
        Double re = 0.0;
        String value2 = value.toString();

        value = value.trim();
         //-3+2i + 5-6i
        StringBuffer sb = new StringBuffer(value);
        if(value.contains("i")) {
            sb.deleteCharAt(value.length() - 1);
        }
        char[] str = value.toCharArray();

        try {
            if (str[0] == '-') {
                //System.out.println("1");
                sb.deleteCharAt(0);
                value = sb.toString();
                if (value.contains("-")) {
                    //System.out.println("2");
                    String[] subSrt = value.split("\\-");
                    re = Double.parseDouble(subSrt[0]);
                    re = re * -1;
                    if (subSrt.length == 2) {
                        //System.out.println("3");
                        im = Double.parseDouble(subSrt[1]);
                        im = im * -1;
                    } else {
                        //System.out.println("4");
                        im = -1.0;
                    }
                } else if (value.contains("+")) {
                    //System.out.println("5");
                    String[] subSrt = value.split("\\+");
                    re = Double.parseDouble(subSrt[0]);
                    re = re * -1;
                    if (subSrt.length == 2) {
                        //System.out.println("13");
                        im = Double.parseDouble(subSrt[1]);
                    } else {
                        //System.out.println("14");
                        im = 1.0;
                    }
                }else {
                    if(value2.contains("i")){
                        String[] subSrt = value.split("");
                        im = Double.parseDouble(subSrt[0]);
                        im = im * -1;
                    }else{
                        String[] subSrt = value.split("");
                        re = Double.parseDouble(subSrt[0]);
                        re = re * -1;
                    }
                }
            } else {
               // System.out.println(6);
                value = sb.toString();
                if (value.contains("-")) {
                    //System.out.println("7");
                    String[] subStr = value.split("\\-");
                    re = Double.parseDouble(subStr[0]);
                    if (subStr.length == 2) {
                        //System.out.println("8");
                        im = Double.parseDouble(subStr[1]);
                        im = im * -1;
                    } else {
                        im = -1.0;
                    }
                } else {
                    if (value.contains("+")) {
                        //System.out.println("9");
                        String[] subSrt = value.split("\\+");
                        re = Double.parseDouble(subSrt[0]);
                        if (subSrt.length == 2) {
                            //System.out.println("3");
                            im = Double.parseDouble(subSrt[1]);
                        } else {
                            //System.out.println("4");
                            im = 1.0;
                        }
                    }else {
                        if(value2.contains("i")){
                            String[] subSrt = value.split("");
                            im = Double.parseDouble(subSrt[0]);

                        }else{
                            String[] subSrt = value.split("");
                            re = Double.parseDouble(subSrt[0]);

                        }
                    }
                }
            }

            return new ComplexValue(re, im);
        }catch (Exception e){
            throw  new ParseValueException();
        }
    }

    @Override
    public String getDatatypeName() {
        return "Complex number";
    }
}

