/*
Author: Jumanazar Saidov
Date: 2021-10-27
Definition:
Aqlli kalkulyator yasang, bunda foydalanuvchi kiritgan stringdagi misolda qavs, kasr va boshqa murakkab
amallarni ham aniqlab natija chiqasin.
Masalan: 3*8+4*(5+6/7) ....
 */
package variables.Day2_OOP;

public class SmartCalculator {
    private double result;
    private String input;
    private String output;

    public String calc(String inputStr) throws Exception {
        System.out.println("Initial input: " + inputStr);
        while(inputStr.contains("(") || inputStr.contains("*") || inputStr.contains("/") || inputStr.contains("%") || inputStr.contains("+") || inputStr.contains("-")){
            String smallStr = "";
            String operator = "";
            int start = 0, end = 0;
            if(inputStr.contains("(")){
                start = inputStr.indexOf("(");
                end = inputStr.indexOf(")") +1;
                smallStr = inputStr.substring(start, end);
                System.out.println("smallStr: " + smallStr);
                double a = Double.parseDouble(smallStr.substring(1, smallStr.indexOf(" ")).trim());
                operator = smallStr.substring(smallStr.indexOf(" ")+1, smallStr.indexOf(" ") + 2);
                double b = Double.parseDouble(smallStr.substring(smallStr.indexOf(operator)+1, smallStr.length()-1));
                smallStr = proc(a, b, operator);
                inputStr = inputStr.substring(0, start) + smallStr + inputStr.substring(end+1);
                System.out.println("current result: " + inputStr);
            }
        }
        return "";
    }
    public String proc(double a, double b, String op) throws Exception {
        switch (op){
            case "*":
                return String.valueOf(a * b);
            case "/":
                return String.valueOf(a / b);
            case "%":
                return String.valueOf(a % b);
            case "+":
                return String.valueOf(a + b);
            case "-":
                return String.valueOf(a - b);
            default:
                throw new Exception("Wrong operation was given. Please, check the arithmetic operation provided in the string input : " + op);
        }
    }


    public static void main(String[] args) throws Exception {
        SmartCalculator s = new SmartCalculator();
        s.calc("3 * 8 + 4 * (5 + 6) + 22");
    }
}
