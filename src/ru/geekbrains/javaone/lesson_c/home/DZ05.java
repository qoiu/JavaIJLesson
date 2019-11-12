package ru.geekbrains.javaone.lesson_c.home;

import ru.geekbrains.javaone.lesson_c.home.zoo.Bird;
import ru.geekbrains.javaone.lesson_c.home.zoo.Cat;
import ru.geekbrains.javaone.lesson_c.home.zoo.Dog;

public class DZ05 {
    public static void main(String[] args){
        Dog champ=new Dog("Scooby");
        Animal[] zoo={
                new Cat("Barsic"),
                new Dog("Reks"),
                new Bird("Kesha",20,0.3f,0)
        };
        for(int i=0;i<zoo.length;i++){
           //zoo[i].jump();
            zoo[i].run(150);
        }
        zoo[2].train(140,0,0);
        zoo[1].train(-400,0,0);
        for(int i=0;i<zoo.length;i++){
            //zoo[i].jump();
            zoo[i].run(150);

        }
        champ.run(230);
        zoo[0].swimm(100);
        zoo[1].swimm(100);
    }
}
