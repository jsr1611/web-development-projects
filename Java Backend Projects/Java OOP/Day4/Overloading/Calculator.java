package OOP.Day4.Overloading;

public class Calculator {

    // add method
    public static Integer add(int a, int b){
        return a + b;
    }
    public static Double add(double a, double b){
        return a + b;
    }
    public static Double add(int a, double b){
        return a + b;
    }
    public static Double add(double a, int b){
        return a + b;
    }
    public static String add(String a, String b){
        if (isDigitNotValid(a)) return null;
        if (isDigitNotValid(b)) return null;

        if(!a.contains(".") && !b.contains(".")){
            return Integer.parseInt(a) + Integer.parseInt(b) + "";
        }
        else {
            return String.format("%.1f", (Double.parseDouble(a) + Double.parseDouble(b)));
        }
    }
    public static String add(int a, String b){
        if(isDigitNotValid(b)) return null;

        if(!b.contains(".")){
            return a + Integer.parseInt(b) + "";
        }
        else {
            return a + Double.parseDouble(b) + "";
        }
    }

    public static String add(String a, int b){
        if(isDigitNotValid(a)) return null;

        if(!a.contains(".")){
            return b + Integer.parseInt(a) + "";
        }
        else {
            return b + Double.parseDouble(a) + "";
        }
    }



    //sub method
    public static Integer sub(int a, int b){
        return a-b;
    }

    public static Double sub (double a, double b){
        return a - b;
    }
    public static Double sub(int a, double b){
        return a - b;
    }

    public static Double sub(double a, int b){
        return a - b;
    }

    public static String sub(String a, String b){
        if (isDigitNotValid(a)) return null;
        if (isDigitNotValid(b)) return null;

        if(!a.contains(".") && !b.contains(".")){
            return Integer.parseInt(a) - Integer.parseInt(b) + "";
        }
        else {
            return String.format("%.1f", (Double.parseDouble(a) - Double.parseDouble(b)));
        }
    }

    public static String sub(int a, String b){
        if(isDigitNotValid(b)) return null;

        if(!b.contains(".")){
            return a - Integer.parseInt(b) + "";
        }
        else {
            return a - Double.parseDouble(b) + "";
        }
    }

    public static String sub(String a, int b){
        if(isDigitNotValid(a)) return null;

        if(!a.contains(".")){
            return b - Integer.parseInt(a) + "";
        }
        else {
            return b - Double.parseDouble(a) + "";
        }
    }

    // multiply method

    //sub method
    public static Integer mul(int a, int b){
        return a * b;
    }

    public static Double mul (double a, double b){
        return a * b;
    }
    public static Double mul(int a, double b){
        return a * b;
    }

    public static Double mul(double a, int b){
        return a * b;
    }

    public static String mul(String a, String b){
        if (isDigitNotValid(a)) return null;
        if (isDigitNotValid(b)) return null;

        if(!a.contains(".") && !b.contains(".")){
            return Integer.parseInt(a) * Integer.parseInt(b) + "";
        }
        else {
            return String.format("%.1f", (Double.parseDouble(a) * Double.parseDouble(b)));
        }
    }

    public static String mul(int a, String b){
        if(isDigitNotValid(b)) return null;

        if(!b.contains(".")){
            return a * Integer.parseInt(b) + "";
        }
        else {
            return a * Double.parseDouble(b) + "";
        }
    }

    public static String mul(String a, int b){
        if(isDigitNotValid(a)) return null;

        if(!a.contains(".")){
            return b * Integer.parseInt(a) + "";
        }
        else {
            return b * Double.parseDouble(a) + "";
        }
    }

    // div method
    public static Double div(int a, int b){
        if(b == 0){
            System.out.println("ArithmeticException: Division by 0");
            return null; // ArithmeticException("Division by 0");
        }
        return a/(double)b;
    }

    public static Double div (double a, double b){
        if(b==0){
            System.out.println("ArithmeticException: Division by 0");
            return null; // ArithmeticException("Division by 0");
        }
        return a / b;
    }
    public static Double div(int a, double b){
        if(b==0){
            System.out.println("ArithmeticException: Division by 0");
            return null; // ArithmeticException("Division by 0");
        }
        return a / b;
    }

    public static Double div(double a, int b){
        if(b==0){
            System.out.println("ArithmeticException: Division by 0");
            return null; // ArithmeticException("Division by 0");
        }
        return a / b;
    }

    public static String div(String a, String b){
        if (isDigitNotValid(a)) return null;
        if (isDigitNotValid(b)) return null;
        if(b.equals("0")){
            System.out.println("ArithmeticException: Division by 0");
            return null; // ArithmeticException("Division by 0");
        }

        if(!a.contains(".") && !b.contains(".")){
            return Integer.parseInt(a) / Integer.parseInt(b) + "";
        }
        else {
            return String.format("%.1f", (Double.parseDouble(a) / Double.parseDouble(b)));
        }
    }

    public static String div(int a, String b){
        if(isDigitNotValid(b)) return null;
        if(b.equals("0")){
            System.out.println("ArithmeticException: Division by 0");
            return null; // ArithmeticException("Division by 0");
        }

        if(!b.contains(".")){
            return a / Integer.parseInt(b) + "";
        }
        else {
            return a / Double.parseDouble(b) + "";
        }
    }

    public static String div(String a, int b){
        if(isDigitNotValid(a)) return null;
        if(b == 0){
            System.out.println("ArithmeticException: Division by 0");
            return null; // ArithmeticException("Division by 0");
        }

        if(!a.contains(".")){
            return  (Integer.parseInt(a) / b) + "";
        }
        else {
            return (Double.parseDouble(a)/b) + "";
        }
    }

    public static Integer abs(Integer a){
        return Math.abs(a);
    }




    // supporting methods
    private static boolean isDigitNotValid(String a) {
        for (int i = 0; i < a.length(); i++) {
            if (!Character.isDigit(a.charAt(i))) {
                System.out.println("Given String parameter is not a number: " + a);
                return true;
            }
        }
        return false;
    }


}
