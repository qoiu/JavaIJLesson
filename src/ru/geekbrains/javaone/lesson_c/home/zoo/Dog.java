package ru.geekbrains.javaone.lesson_c.home.zoo;

import ru.geekbrains.javaone.lesson_c.home.Animal;

public class Dog extends Animal {
    public Dog(String name){
        super(name,500,0.5f,10);
    }
    public Dog(String name,int speedLimit,float jumpLimit,int swimLimit){
        super(name,speedLimit,jumpLimit,swimLimit);
    }
}
