package ru.geekbrains.javaone.lesson_c.home.zoo;

import ru.geekbrains.javaone.lesson_c.home.Animal;

public class Horse extends Animal {
    public Horse(String name){
        super(name,1500,3f,100);
    }
    public Horse(String name,int speedLimit,float jumpLimit,int swimLimit){
        super(name,speedLimit,jumpLimit,swimLimit);
    }
}
