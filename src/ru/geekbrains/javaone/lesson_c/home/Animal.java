package ru.geekbrains.javaone.lesson_c.home;

public abstract class Animal {
    protected String name;
    protected int speedLimit;
    protected float jumpLimit;
    protected int swimLimit;


   protected Animal(String name,int speedLimit, float jumpLimit,int swimLimit){
        this.name=name;
        this.speedLimit=speedLimit;
        this.jumpLimit=jumpLimit;
        this.swimLimit=swimLimit;
    }
    protected Animal(String name){
        this.name=name;
    }
    protected Animal(){}


    public void run(){
        System.out.println(name+" run");
    }
    public void swim(){
        System.out.println(name+" swim");
    }
    public void jump(){
        System.out.println(name+" jump");
    }
    public void setName(String name){
        this.name=name;
    }

}
