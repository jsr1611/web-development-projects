package OOP.Day4.Overriding;

public class Circle extends Figure{
    private Integer radius;
    public Circle(Integer radius){
        this.radius = radius;
    }

    @Override
    public Double area() {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public Double perimeter() {
        return 2.0 * Math.PI * radius;
    }
}
