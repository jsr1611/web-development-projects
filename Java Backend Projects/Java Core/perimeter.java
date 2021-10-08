package variables;
import java.util.Scanner;

/*
 * Author: Jumanazar Saidov
 * Perimeter calculator
 */

class Perimeter {
    public Perimeter() {}

    static int side_a, side_b;
        public static void main(String[] args){
            System.out.println("Please, input two integers for size of square rectangle sides:");
            Scanner scanner = new Scanner(System.in);
            System.out.print("A = ");
            side_a = scanner.nextInt();
            System.out.print("B = ");
            side_b = scanner.nextInt();

            System.out.println("Perimeter of a square rectangle is  2 * (A + B) = " + 2 * (side_a + side_b));
        }

}