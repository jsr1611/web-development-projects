/*
Author: Jumanazar Saidov
Date: 2021.11.01
Committed to clean code!
Definition: Calculator overloaded! can do basic operations (add, sub, mul, div, abs, pow) on any kind of user input
 */
package OOP.Day4.Overloading;

public class Calculator {

    // add method
    public static Integer add(int num1, int num2){
        return num1 + num2;
    }
    public static Double add(double num1, double num2){
        return num1 + num2;
    }
    public static Double add(int num1, double num2){
        return num1 + num2;
    }
    public static Double add(double num1, int num2){
        return num1 + num2;
    }
    public static String add(String num1Str, String num2Str){
        if (isDigitNotValid(num1Str)) return null;
        if (isDigitNotValid(num2Str)) return null;

        if(!num1Str.contains(".") && !num2Str.contains(".")){
            return Integer.parseInt(num1Str) + Integer.parseInt(num2Str) + "";
        }
        else {
            return String.format("%.2f", (Double.parseDouble(num1Str) + Double.parseDouble(num2Str)));
        }
    }
    public static String add(int num1, String num2Str){
        if(isDigitNotValid(num2Str)) return null;

        if(!num2Str.contains(".")){
            return num1 + Integer.parseInt(num2Str) + "";
        }
        else {
            return String.format("%.2f", num1 + Double.parseDouble(num2Str));
        }
    }

    public static String add(String num1Str, int num2){
        if(isDigitNotValid(num1Str)) return null;

        if(!num1Str.contains(".")){
            return num2 + Integer.parseInt(num1Str) + "";
        }
        else {
            return String.format("%.2f", num2 + Double.parseDouble(num1Str));
        }
    }

    public static String add(Double num1, String num2Str){
        if(isDigitNotValid(num2Str)) return null;
        if(!num2Str.contains(".")){
            return num1 + Integer.parseInt(num2Str) + "";
        }
        else {
            return String.format("%.2f", num1 + Double.parseDouble(num2Str));
        }
    }

    public static String add(String num1Str, Double num2){
        if(isDigitNotValid(num1Str)) return null;
        if(!num1Str.contains(".")){
            return num2 + Integer.parseInt(num1Str) + "";
        }
        else {
            return String.format("%.2f", num2 + Double.parseDouble(num1Str));
        }
    }




    //sub method
    public static Integer sub(int num1, int num2){
        return num1-num2;
    }

    public static Double sub (double num1, double num2){
        return num1 - num2;
    }
    public static Double sub(int num1, double num2){
        return num1 - num2;
    }

    public static Double sub(double num1, int num2){
        return num1 - num2;
    }

    public static String sub(String num1Str, String num2Str){
        if (isDigitNotValid(num1Str)) return null;
        if (isDigitNotValid(num2Str)) return null;

        if(!num1Str.contains(".") && !num2Str.contains(".")){
            return Integer.parseInt(num1Str) - Integer.parseInt(num2Str) + "";
        }
        else {
            return String.format("%.2f", (Double.parseDouble(num1Str) - Double.parseDouble(num2Str)));
        }
    }

    public static String sub(int num1, String num2Str){
        if(isDigitNotValid(num2Str)) return null;

        if(!num2Str.contains(".")){
            return num1 - Integer.parseInt(num2Str) + "";
        }
        else {
            return num1 - Double.parseDouble(num2Str) + "";
        }
    }

    public static String sub(String num1Str, int num2){
        if(isDigitNotValid(num1Str)) return null;

        if(!num1Str.contains(".")){
            return num2 - Integer.parseInt(num1Str) + "";
        }
        else {
            return String.format("%.2f", num2 - Double.parseDouble(num1Str));
        }
    }

    // multiply method

    //sub method
    public static Integer mul(int num1, int num2){
        return num1 * num2;
    }

    public static Double mul (double num1, double num2){
        return num1 * num2;
    }
    public static Double mul(int num1, double num2){
        return num1 * num2;
    }

    public static Double mul(double num1, int num2){
        return num1 * num2;
    }

    public static String mul(String num1Str, String num2Str){
        if (isDigitNotValid(num1Str)) return null;
        if (isDigitNotValid(num2Str)) return null;

        if(!num1Str.contains(".") && !num2Str.contains(".")){
            return Integer.parseInt(num1Str) * Integer.parseInt(num2Str) + "";
        }
        else {
            return String.format("%.2f", (Double.parseDouble(num1Str) * Double.parseDouble(num2Str)));
        }
    }

    public static String mul(int num1, String num2){
        if(isDigitNotValid(num2)) return null;

        if(!num2.contains(".")){
            return num1 * Integer.parseInt(num2) + "";
        }
        else {
            return num1 * Double.parseDouble(num2) + "";
        }
    }

    public static String mul(String num1, int num2){
        if(isDigitNotValid(num1)) return null;

        if(!num1.contains(".")){
            return num2 * Integer.parseInt(num1) + "";
        }
        else {
            return String.format("%.2f", num2 * Double.parseDouble(num1));
        }
    }

    // div method
    public static Double div(int dividend, int divisor){
        if(divisor == 0){
            System.out.println("ArithmeticException: Division by 0");
            return null; // ArithmeticException("Division by 0");
        }
        return dividend/(double)divisor;
    }

    public static Double div (double dividend, double divisor){
        if(divisor == 0){
            System.out.println("ArithmeticException: Division by 0");
            return null; // ArithmeticException("Division by 0");
        }
        return dividend / divisor;
    }
    public static Double div(int dividend, double divisor){
        if(divisor == 0){
            System.out.println("ArithmeticException: Division by 0");
            return null; // ArithmeticException("Division by 0");
        }
        return dividend / divisor;
    }

    public static Double div(double dividend, int divisor){
        if(divisor == 0){
            System.out.println("ArithmeticException: Division by 0");
            return null; // ArithmeticException("Division by 0");
        }
        return dividend / divisor;
    }

    public static String div(String dividendStr, String divisorStr){
        if (isDigitNotValid(dividendStr)) return null;
        if (isDigitNotValid(divisorStr)) return null;
        if(divisorStr.equals("0")){
            System.out.println("ArithmeticException: Division by 0");
            return null; // ArithmeticException("Division by 0");
        }

        if(!dividendStr.contains(".") && !divisorStr.contains(".")){
            return Integer.parseInt(dividendStr) / Integer.parseInt(divisorStr) + "";
        }
        else {
            return String.format("%.2f", (Double.parseDouble(dividendStr) / Double.parseDouble(divisorStr)));
        }
    }

    public static String div(int dividend, String divisorStr){
        if(isDigitNotValid(divisorStr)) return null;
        if(divisorStr.equals("0")){
            System.out.println("ArithmeticException: Division by 0");
            return null; // ArithmeticException("Division by 0");
        }

        if(!divisorStr.contains(".")){
            return dividend / Integer.parseInt(divisorStr) + "";
        }
        else {
            return String.format("%.2f", dividend / Double.parseDouble(divisorStr));
        }
    }

    public static String div(String dividendStr, int divisor){
        if(isDigitNotValid(dividendStr)) return null;
        if(divisor == 0){
            System.out.println("ArithmeticException: Division by 0");
            return null; // ArithmeticException("Division by 0");
        }

        if(!dividendStr.contains(".")){
            return  (Integer.parseInt(dividendStr) / divisor) + "";
        }
        else {
            return String.format("%.2f", (Double.parseDouble(dividendStr)/ divisor));
        }
    }

    // absolute value method
    public static Integer abs(Integer number){
        return Math.abs(number);
    }

    public static Double abs(Double number){
        return Math.abs(number);
    }
    public static String abs(String number){
        if(isDigitNotValid(number))return null;
        if(number.contains(".")){
            return Math.abs(Double.parseDouble(number)) + "";
        }
        else {
            return Math.abs(Integer.parseInt(number)) + "";
        }
    }

    // shifting to power of 2 (square)
    public static Integer power(Integer number){
        return number * number;
    }

    public static Double power(Double number){
        return number * number;
    }

    public static String power(String numberStr){
        if(isDigitNotValid(numberStr)) return null;
        if(numberStr.contains(".")){
            return Math.pow(Double.parseDouble(numberStr), 2) + "";
        }
        else {
            return Math.pow(Integer.parseInt(numberStr),2) + "";
        }
    }



    // supporting methods
    private static boolean isDigitNotValid(String numberString) {
        for (int index = 0; index < numberString.length(); index++) {

            if (!Character.isDigit(numberString.charAt(index)) && numberString.charAt(index) != '.') {
                if(index == 0 && numberString.charAt(0) == '-'){ // edge case for negative numbers
                    continue;
                }
                System.out.println("Given String parameter is not a number: " + numberString);
                return true;
            }
        }
        return false;
    }


}
