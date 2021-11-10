package OOP.Nov7;

public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius, String color){

        this.radius = radius;
    }

    @Override
    public Double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getColor() {
        return null;
    }
}
