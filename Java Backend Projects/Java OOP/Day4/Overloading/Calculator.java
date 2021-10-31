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
        for(int i=0; i < a.length(); i++){
            if(!Character.isDigit(a.charAt(i))){
                System.out.println("Given String parameter is not a number: " + a);
                return null;
            }
        }
        for(int i=0; i < b.length(); i++){
            if(!Character.isDigit(b.charAt(i))){
                System.out.println("Given String parameter is not a number: " + b);
                return null;
            }
        }

        if(!a.contains(".") && !b.contains(".")){
            return Integer.parseInt(a) + Integer.parseInt(b) + "";
        }
        else {
            return String.format("%.1f", (Double.parseDouble(a) + Double.parseDouble(b)));
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
        for(int i=0; i < a.length(); i++){
            if(!Character.isDigit(a.charAt(i))){
                System.out.println("Given String parameter is not a number: " + a);
                return null;
            }
        }
        for(int i=0; i < b.length(); i++){
            if(!Character.isDigit(b.charAt(i))){
                System.out.println("Given String parameter is not a number: " + b);
                return null;
            }
        }

        if(!a.contains(".") && !b.contains(".")){
            return Integer.parseInt(a) - Integer.parseInt(b) + "";
        }
        else {
            return String.format("%.1f", (Double.parseDouble(a) - Double.parseDouble(b)));
        }
    }




}
