package operators;

import java.util.Scanner;

/*
* Author: Jumanazar Saidov
* Displays time in HH:mm:ss for a given time in seconds
*/

public class TimeCalculator {
    static int time; // time in seconds
    static int hours = 0, minutes = 0, seconds = 0;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter time in seconds: ");
        boolean inputSuccess = false;
        while (!inputSuccess) {
            try {
                time = Integer.parseInt(scanner.next());
                inputSuccess = true;
            } catch (NumberFormatException e) {
                System.out.println("Please, enter only numbers");
            }
        }

        if(time >= 60){
            if(time >= 60 * 60){
                hours = calcHours();
            }
            minutes = calcMinutes();
            seconds = time;
        }
        else {
            seconds = time;
        }
        System.out.println(String.format("Time: %02d:%02d:%02d", hours,minutes,seconds));

    }

    private static int calcHours() {
        while (time >= 60 * 60){
            time -= 60 * 60;
            hours += 1;
        }
        return hours;
    }

    private static int calcMinutes() {
        while(time >= 60){
            time -= 60;
            minutes += 1;
        }
        return minutes;
    }
}
