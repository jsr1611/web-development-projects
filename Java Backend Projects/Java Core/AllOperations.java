package variables;

/*
* Author: Jumanazar Saidov
* Perform all major operations available such as addition, subtraction, multiplication, division, and modulo division for two numbers received from user input
 */

import java.util.Scanner;

public class AllOperations {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter two integer variables:");
        System.out.print("A = ");
        int a,b;

        a = scanner.nextInt();
        System.out.print("B = ");
        b = scanner.nextInt();
        System.out.println("All operations");
        System.out.printf("A + B = %d%n", add(a,b));
        System.out.printf("A - B = %d%n", subtract(a,b));
        System.out.printf("A * B = %d%n", multiply(a,b));
        System.out.printf("A / B = %d%n", divide(a,b));
        System.out.printf("A %% B = %d%n", modulo(a,b));

    }



    static int add(int a, int b){
        return a+b;
    }
    static int subtract(int a, int b){
        return a - b;
    }
    static int multiply(int a, int b){
        return a * b;
    }
    static int divide(int a, int b){
        if(b==0){
            return 0;
        }
        return a/b;
    }

    static int modulo(int a, int b) {
        if(b==0){
            return 0;
        }
        return a % b;
    }
}
