package OOP.Day4.Overloading;

/**
 * Calculate area and perimeter for different figures using polymorphism
 */
public class Figure {
    /**
     * Rectangle's area
     * @param sideA value
     * @param sideB value
     * @return area
     */
    public Integer area(Integer sideA, Integer sideB){
        return sideA * sideB;
    }

    /**
     * Circle's area
     * @param radius value
     * @return area
     */
    public Double area(Integer radius){
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * Rectangle's perimeter
     * @param sideA value
     * @param sideB value
     * @return perimeter
     */
    public Integer perimeter(Integer sideA, Integer sideB){
        return 2 * (sideA + sideB);
    }

    /**
     * Circle's perimeter
     * @param radius value
     * @return perimeter
     */
    public Double perimeter(Integer radius){
        return 2.0 * Math.PI * radius;
    }

    /**Print rectangle's sides
     * @param sideA value
     * @param sideB value
     */
    public void print(Integer sideA, Integer sideB){
        System.out.printf("Rectangle sides A and B equal: %d and %d, respectively\n", sideA, sideB);
    }

    /**Print circle's radius
     * @param radius value
     */
    public void print(Integer radius){
        System.out.println("Radius of the circle equals: " + radius);
    }

}
