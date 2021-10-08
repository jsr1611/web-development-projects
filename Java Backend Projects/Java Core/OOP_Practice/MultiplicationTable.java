package variables.OOP_Practice;

// Author: Jumanazar Saidov
/*
Perform multiplication table operation through 1 to 10 for the given number
 */

import java.util.Scanner;

public class MultiplicationTable {

    static int number;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please, enter an integer number: ");
        number = scanner.nextInt();
        int count = 1;
        while (count <= 10){
            System.out.printf("%d x %d = %d\n",number, count, multiply(number, count));
            count += 1;
        }

    }

    private static int multiply(int number, int count) {
        return number * count;
    }

}
