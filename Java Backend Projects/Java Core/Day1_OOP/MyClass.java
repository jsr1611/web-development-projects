package variables.Day1_OOP;

/*
Author: Jumanazar Saidov
Problem no: 3-topshiriq
Definition:
Ikkita atribut: firstAtribut va secondAttribut larga ega MyClass nomli klass yarating.
Ushbu atributlar qiymatini aboutAttributes, yig’indisini sumAttributes,
kattasini maxAttribute ekranga chiqazadigan methodlarini yarating.
 */

public class MyClass {
    private int firstAttribute;
    private int secondAttribute;
    public MyClass(int firstAttribute, int secondAttribute){
        this.firstAttribute = firstAttribute;
        this.secondAttribute = secondAttribute;
    }

    public void aboutAttributes(){
        System.out.printf("First attribute = %d\nSecond attribute = %d\n", this.firstAttribute, this.secondAttribute);
    }

    public void sumAttributes(){
        System.out.printf("Sum of attributes:\n%d + %d = %d\n", this.firstAttribute, this.secondAttribute, this.firstAttribute+this.secondAttribute);
    }

    public void maxAttribute(){
        int max = Math.max(this.firstAttribute, this.secondAttribute);
        System.out.printf("Max attribute = %d\n", max);
    }


    public static void main(String[] args) {
        MyClass myClass = new MyClass(23, 43);
        myClass.aboutAttributes();
        myClass.sumAttributes();
        myClass.maxAttribute();
    }
}
