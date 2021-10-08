package operators;

import java.util.Scanner;

/*
* Author: Jumanazar Saidov
* Calculates speed (in meters per second) using distance in km and time in minutes.
*/

public class speedCalculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int L; // km
        int T; // minutes
        double V ;
        System.out.print("Enter distance in kilometers (km): ");
        L = scanner.nextInt();
        System.out.print("Enter time in minutes (m): ");
        T = scanner.nextInt();
        V = (L * 1000) / (double) T * 60;
        System.out.println("Speed is equal to " + V  + " m/s");
    }
}
