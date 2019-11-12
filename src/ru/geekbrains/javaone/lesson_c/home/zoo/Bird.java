package ru.geekbrains.javaone.lesson_c.home.zoo;

import ru.geekbrains.javaone.lesson_c.home.Animal;

public class Bird extends Animal {
    public Bird(String name){
        super(name,5,0.2f,0);
    }
    public Bird(String name,int speedLimit,float jumpLimit,int swimLimit){
        super(name,speedLimit,jumpLimit,swimLimit);
    }
    public void swim(int distance){
        System.out.println(name+": I can fly, but swimm...NEVER!!!!");

    }

}
