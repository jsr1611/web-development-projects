package variables;

import java.util.Scanner;

// Author: Jumanazar Saidov
/*
Swapping two integers without using a 3rd variable
 */
public class SwapWithoutThirdOne {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int A, B;
        System.out.print("Enter the first number:");
        A = scanner.nextInt();
        System.out.print("Enter the second number:");
        B = scanner.nextInt();

        A += B;
        B = A - B;
        A = A - B;
        System.out.println(String.format("A = %d, B= %d", A, B));

    }
}
