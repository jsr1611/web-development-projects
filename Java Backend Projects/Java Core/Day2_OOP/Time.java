/*
Author: Jumanazar Saidov
Date: 2021-10-27

 */
package variables.Day2_OOP;

public class Time {
    private int hour;
    private int minute;
    private int second;
    Time(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }
    public String getCurrentTime(){
        return String.format("%02d:%02d:%02d", hour,minute,second);
    }

    public static void main(String[] args) {
        Time time = new Time(1, 25, 8);
        System.out.println(time.getCurrentTime());
    }
}
