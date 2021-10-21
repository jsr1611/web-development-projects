package variables.Day1_OOP;

/*
Author: Jumanazar Saidov
Problem no: 2-topshiriq
Definition:
To’g’ri burchakli uchburchak klassini yarating.
Uning barcha atributlari va methodlariga mos nom va toifa tanlang.
(Eni va bo’yi attributlari, Perimetrini va Yuzasini hisoblaydigan 2 ta methodi bo’lsin).
 */

public class RightTriangle {
    private double legA;
    private double legB;
    private double hypotenuseC;

    private int alpha_AC;
    private int beta_BC;
    public RightTriangle(double legA, double legB){
        this.legA = legA;
        this.legB = legB;
        this.hypotenuseC = Math.sqrt((Math.pow(this.legA,2) + Math.pow(this.legB,2)));
    }

    public double perimeter(){
        double result = this.legA + this.legB + this.hypotenuseC;
        System.out.printf("The perimeter of the right triangle is equal to: %.2f\n", result );
        return result;
    }

    public double area(){
        double result = (this.legA * this.legB)/2;
        System.out.printf("The area of the triangle is equal to: %.2f\n", result);
        return result;
    }


    public static void main(String[] args) {
        RightTriangle rt = new RightTriangle(3.0,4.0);
        rt.area();
        rt.perimeter();


    }
}
