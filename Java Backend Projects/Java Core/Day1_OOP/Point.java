package variables.Day1_OOP;

/*
Author: Jumanazar Saidov
Problem no: 1-topshiriq
Definition:
X va Y koordinatalarni ifodalovchi atributlari bor bo’lgan Point classini yozing.
Koordinatalarni “(45, 56)” shaklda chop etuvchi printXY() methodini yozing.
 */

public class Point {
    private int X;
    private int Y;
    public Point(int x, int y){
        this.X = x;
        this.Y = y;
    }
    public void printXY(){
        System.out.printf("(%d, %d)\n", this.X, this.Y);
    }

    public static void main(String[] args) {
        Point p = new Point(45, 56);
        p.printXY();
    }

}
