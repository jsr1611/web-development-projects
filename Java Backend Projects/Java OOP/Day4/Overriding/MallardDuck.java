/*
Author: Jumanazar Saidov
Date: 2021.11.01
Definition: Overriding in OOP.
 */

package OOP.Day4.Overriding;

/**
 * Mallard Child of Duck
 */
public class MallardDuck extends Duck{
    @Override
    public void display() {
        System.out.println("I am a mallard duck!");
    }

}
