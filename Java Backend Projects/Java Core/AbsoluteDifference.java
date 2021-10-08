package variables;



import java.util.Scanner;

/*
 * Author: Jumanazar Saidov
 * Perform all major operations available such as addition, subtraction, multiplication, division, and modulo division for two numbers received from user input
 */

public class AbsoluteDifference {
    public static void main(String[] args){
        int A, B;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter two integers.");
        System.out.print("A = ");
        A = scanner.nextInt();
        System.out.print("B = ");
        B = scanner.nextInt();
        System.out.printf("Absolute difference of %d and %d equals %d %n", A, B, getAbsoluteDiff(A,B));
    }

    /*
    * Get absolute difference of two integers
    */
    private static int getAbsoluteDiff(int a, int b) {
        return Math.abs(a-b);
    }
}
