package variables.Day1_OOP;

/*
Author: Jumanazar Saidov
Problem no: 4-topshiriq
Definition:
Quyidagi 3ta attribute bor bo’lgan Date klassini yarating: yil, oy va kun.
15.05.2020 formatdagi sanani chop etuvchi mehod yarating.
 */

public class Date {
    private int year;
    private int month;
    private int day;
    public Date(int year, int month, int day){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void printDate(){
        System.out.printf("%02d.%02d.%04d\n", this.day, this.month, this.year);
    }

    public static void main(String[] args) {
        Date d = new Date(2021, 5, 2);
        d.printDate();
    }
}
