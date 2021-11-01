/*
Author: Jumanazar Saidov
Date: 2021.11.01
Committed to clean code!
Definition: Usage of Overriding in OOP.
 */

package OOP.Day4.Overriding;

/**
 * Parent class Duck
 */
public class Duck extends Animal{

    public void quack(){
        System.out.println("I can quack quack quack!");
    }

    public void display(){
        System.out.println("I am a duck!");
    }

    // other duck-like methods, if any


    /**
     * Animal sound method inherited from parent class
     */
    @Override
    public void sound() {
        System.out.println("I sound like quack quack quack!");
    }
}
