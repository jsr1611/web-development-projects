package OOP.Day4.Overriding;

public class Rectangle extends Figure{
    private Integer sideA;
    private Integer sideB;
    public Rectangle(Integer sideA, Integer sideB){
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public Double area() {
        return sideA * sideB * 1.0;
    }

    @Override
    public Double perimeter() {
        return 2.0 * (sideA + sideB);
    }
}
