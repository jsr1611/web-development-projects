package OOP.Day4.Overriding;

public class AnimalDemo {
    public static void main(String[] args) {

        // Object initialization as a general animal
        Animal animal = new Animal();
        animal.sound();

        // now it is a dog
        animal = new Dog();
        animal.sound();

        // now it is a cat
        animal = new Cat();
        animal.sound();

        // now it is a duck
        animal = new Duck();
        animal.sound();




    }
}
