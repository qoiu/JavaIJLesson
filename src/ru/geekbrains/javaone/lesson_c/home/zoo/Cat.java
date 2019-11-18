package ru.geekbrains.javaone.lesson_c.home.zoo;

import ru.geekbrains.javaone.lesson_c.home.Animal;

public class Cat extends Animal {
    public Cat(String name){
        super(name,200,2f,0);
    }
    public Cat(String name,int speedLimit,float jumpLimit,int swimLimit){
        super(name,speedLimit,jumpLimit,swimLimit);
    }

    public void swimm(int distance){
        System.out.println(name+": I'm proud animal!!! I'll never swim!m!!");

    }


}
