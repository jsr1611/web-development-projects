package variables.Day2_OOP;

public class PenDemo {
    public static void main(String[] args) {

        Pen pen = new Pen(false, 100, 10);
        pen.pushButton();
        System.out.println(pen.getInkAmount());
        pen.write("As Salomu aleykum");
        System.out.println(pen.getInkAmount());

        pen.refill(-150);

    }
}
