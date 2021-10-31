package OOP.Day4.Overloading;


public class FigureDemo {
    public static void main(String[] args) {
        Figure figure = new Figure();
        figure.print(4,5);
        figure.print(5);

        System.out.println("Rectangle's area: " + figure.area(4,5));
        System.out.printf("Circle's area: %.1f\n", figure.area(5));

        System.out.println("Rectangle's perimeter: " + figure.perimeter(4,5));
        System.out.printf("Circle's length: %.1f\n", figure.perimeter(5));




    }
}
