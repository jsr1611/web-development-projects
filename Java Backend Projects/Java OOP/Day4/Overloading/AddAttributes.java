package OOP.Day4.Overloading;

public class AddAttributes {
    public Integer add(int a, int b){
        return a+b;
    }
    public Double add(int a, double b){
        return a + b;
    }
    public Double add(double a, double b, double c){
        return a+b+c;
    }

    public String add(String firstStr, String secondStr){
        return firstStr + " " + secondStr;
    }

    public String add(int a, String str){
        return  a + str;
    }
}
