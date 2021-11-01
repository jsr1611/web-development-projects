package OOP.Day4.Overriding;

public class Triangle extends Figure{
    private Integer sideA;
    private Integer sideB;
    private Integer hipotenuse;
    public Triangle(Integer sideA, Integer sideB, Integer hipotenuse){
        this.sideA = sideA;
        this.sideB = sideB;
        this.hipotenuse = hipotenuse;
    }

    @Override
    public Double area() {
        return sideA * sideB / 2.0;
    }

    @Override
    public Double perimeter() {
        return 1.0 * (sideA + sideB + hipotenuse);
    }
}












// for not-right trianle Area = 1/2 * HeightB * SideB;
//or Area = SQRT(S * (S-sideA)*(S-sideB)*(S-sideC);
// S = 1/2 * (sideA + sideB + sideC);
//for right triangle Area = 1/2 * sideA * sideB;