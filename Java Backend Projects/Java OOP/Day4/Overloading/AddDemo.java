package OOP.Day4.Overloading;

public class AddDemo {
    public static void main(String[] args) {
        AddAttributes adder = new AddAttributes();
        System.out.println("Ikkita int sonlar yig`indisi: 1010 + 222 = " + adder.add(1010, 222));
        System.out.printf("Int va double sonlar yig`indisi: 1010 + 222.6 = %.1f\n", adder.add(1010, 222.6));
        System.out.printf("Uchta double sonlar yig`indisi: 3.4 + 4.5 + 101.4 = %.1f\n", adder.add(3.4, 4.5, 101.4));
        System.out.printf("Ikkita matnni qo`shish: 'I love ' + 'programming in Java' = '%s'\n", adder.add("I love", "programming in Java" ));
        System.out.printf("Son va matnni qo`shish: 404 + 'NOT FOUND' = '%s' \n", adder.add(404, "NOT FOUND"));
    }



}
