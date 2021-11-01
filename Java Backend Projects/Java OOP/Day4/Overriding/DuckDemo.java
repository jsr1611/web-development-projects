/*
Author: Jumanazar Saidov
Date: 2021.11.01
Definition: Testing features of overriding in OOP.
 */
package OOP.Day4.Overriding;

public class DuckDemo {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.quack();
        duck.display();

        duck = new MallardDuck();
        duck.quack();
        duck.display();

        duck = new RedheadDuck();
        duck.quack();
        duck.display();

    }
}
