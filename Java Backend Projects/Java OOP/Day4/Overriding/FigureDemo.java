package OOP.Day4.Overriding;

class FigureDemo{
    public static void main(String[] args) {
        Circle c = new Circle(3);
        System.out.printf("Doira yuzasi: %.1f\n",c.area());
        System.out.printf("Aylana uzunligi: %.1f\n", c.perimeter());

        Triangle t = new Triangle(6, 7, 9);
        System.out.println("Uchburchak yuzasi: " + t.area());
        System.out.println("Uchburchak perimetri: " + t.perimeter());

        Rectangle r = new Rectangle(5, 8);
        System.out.println("To'rtburchak yuzasi: " + r.area());
        System.out.println("To'rtburchak perimetri: " + r.perimeter());
    }

}