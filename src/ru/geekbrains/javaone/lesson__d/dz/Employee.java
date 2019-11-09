package ru.geekbrains.javaone.lesson__d.dz;

public class Employee {
    String last_name;
    String first_name;
    String second_name;
    String position;
    int phone;
    int salary;
    int age;

    Employee(String name,String position,int phone,int salary, int age){
        this.position=position;
        this.phone=phone;
        this.salary=salary;
        this.age=age;
    }
}
