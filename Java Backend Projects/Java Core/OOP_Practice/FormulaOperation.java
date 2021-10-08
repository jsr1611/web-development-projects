package variables.OOP_Practice;

import java.util.Scanner;

public class FormulaOperation {
    static int number;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter an integer number");
        number = scanner.nextInt();
        String txt = String.valueOf(number);
        int count = 0, total = 0;
        System.out.printf("%s + %s + %s + %s = %d",
                txt,
                txt+txt,
                txt+txt+txt,
                txt+txt+txt+txt,
                times(txt));
    }

    private static int times(String count) {
        return Integer.parseInt(count) + Integer.parseInt(count + count) +Integer.parseInt(count + count + count) + Integer.parseInt(count + count + count + count);
    }
}
