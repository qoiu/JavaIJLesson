package ru.geekbrains.javaone.lesson_c.home;

public abstract class Animal {
    protected String name;
    protected int speedLimit;
    protected float jumpLimit;
    protected int swimmLimit;


   protected Animal(String name,int speedLimit, float jumpLimit,int swimmLimit){
        this.name=name;
        this.speedLimit=speedLimit;
        this.jumpLimit=jumpLimit;
        this.swimmLimit=swimmLimit;
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
    public void swimm(int distance){
       if(swimmLimit==0){
           System.out.println(name+" can't swim");
       } else if(distance<swimmLimit){
           System.out.println(name+" swim");
       }

    }
    public void jump(){
        System.out.println(name+" jump");
    }
    public void setName(String name){
        this.name=name;
    }
    public void train(int speedLLim,float jumpLimit,int swimmLimit){
       System.out.println(name+" finish train");
       this.speedLimit+=speedLLim;
       this.jumpLimit+=jumpLimit;
       this.swimmLimit+=swimmLimit;
    }
}
