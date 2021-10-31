package OOP.Day4.Overloading;

public class Figure {
    private Integer sideA;
    private Integer sideB;
    private Integer radius;

    public Figure(){}

    public Figure(Integer sideA, Integer sideB, Integer radius){
        this.sideA = sideA;
        this.sideB = sideB;
        this.radius = radius;
    }
    public Integer area(Integer sideA, Integer sideB){
        return sideA * sideB;
    }
    public Double area(Integer radius){
        return Math.PI * Math.pow(radius, 2);
    }

    public Integer perimeter(Integer sideA, Integer sideB){
        return 2 * (sideA + sideB);
    }
    public Double perimeter(Integer radius){
        return 2.0 * Math.PI * radius;
    }

    public void print(Integer sideA, Integer sideB){
        System.out.printf("Rectangle sides A and B equal: %d and %d, respectively\n", sideA, sideB);
    }

    public void print(Integer radius){
        System.out.println("Radius of the circle equals: " + radius);
    }

}
