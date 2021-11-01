/*
Author: Jumanazar Saidov
Date: 2021.11.01
Committed to clean code!
Definition:
Testing functionalities of the Calculator methods.
 */
package OOP.Day4.Overloading;

public class CalcDemo {
    public static void main(String[] args) {
        System.out.println("add(int,int) method: 1001 + 1010 = " +         Calculator.add(1001, 1010));
        System.out.printf("add(int,double) method: 1001 + 1010.15 = %.2f\n",         Calculator.add(1001, 1010.15));
        System.out.printf("add(String,double) method: '1001.45' + 1010.10 = %s\n", Calculator.add("1001.45", 1010.10));

        System.out.println("sub(int,int) method: 1010 - 1001 = " +         Calculator.sub(1010, 1001));
        System.out.printf("sub(double,int) method: 1051.45 - 1010 = %.2f\n", Calculator.sub(1051.45, 1010));
        System.out.println("sub(String,String) method: '1999.45' - '909' = " +         Calculator.sub("1999.45", "909"));

        System.out.println("mul(int,int) method: 10 * 35 = " +         Calculator.mul(10, 35));
        System.out.printf("mul(double,int) method: 3.14 * 555 = %.2f\n", Calculator.mul(3.14, 555));
        System.out.println("sub(String,String) method: '-2000' * '-0.2' = " +         Calculator.mul("-2000", "-0.2"));

        System.out.printf("div(int,int) method: 2021 / 3 = %.2f\n", Calculator.div(2021, 3));
        System.out.printf("mul(double,int) method: 3.14 / 555 = %.2f\n", Calculator.div(3.14, 555));
        System.out.println("sub(String,String) method: '-2000' / '0.2' = " +         Calculator.div("-2000", "0.2"));

        System.out.printf("abs(int) method: 2021 = %d\n", Calculator.abs(2021));
        System.out.printf("abs(double) method: 3.14  = %.2f\n", Calculator.abs(3.14));
        System.out.println("abs(String) method: '-2000.25' = " +         Calculator.abs("-2000.25"));

        System.out.printf("power(int) method: 16 = %d\n", Calculator.power(16));
        System.out.printf("power(double) method: 3.14= %.2f\n", Calculator.power(3.14));
        System.out.println("power(String) method: '-5.5' = " +         Calculator.power("-5.5"));



    }
}
