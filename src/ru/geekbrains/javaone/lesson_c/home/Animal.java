package ru.geekbrains.javaone.lesson_c.home;

public abstract class Animal {
    private String name;
    private int speedLimit;
    private float jumpLimit;
    private int swimLimit;


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


    public void run(int distance){
       if(distance<speedLimit) {
           System.out.println(name + " run");
       }else{
           System.out.println(name + " don't run");
       }
       }
    public void swim(int distance){
       if(swimLimit==0){
           System.out.println(name+" can't swim");
       } else if(distance<swimLimit){
           System.out.println(name+" swim");
       }

    }
    public void jump(){
        System.out.println(name+" jump");
    }
    public void setName(String name){
        this.name=name;
    }
    public void train(int speedLLim,float jumpLimit,int swimLimit){
       System.out.println(name+" finish train");
       this.speedLimit+=speedLLim;
       this.jumpLimit+=jumpLimit;
       this.swimLimit+=swimLimit;
    }
}
