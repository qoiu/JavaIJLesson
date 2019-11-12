package ru.geekbrains.javaone.lesson_c.home;

import ru.geekbrains.javaone.lesson_c.home.zoo.Bird;
import ru.geekbrains.javaone.lesson_c.home.zoo.Cat;
import ru.geekbrains.javaone.lesson_c.home.zoo.Dog;

public class DZ05 {
    public static void main(String[] args){
        Animal[] zoo={
                new Cat("barsic"),
                new Dog("Reks"),
                new Bird("sss",200,0.3f,0)
        };
        for(int i=0;i<zoo.length;i++){
            zoo[i].jump();
        }
    }
}
