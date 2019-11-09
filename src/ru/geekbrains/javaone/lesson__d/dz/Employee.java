package ru.geekbrains.javaone.lesson__d.dz;

public class Employee {
    private String name;
    private String position;
    private String phone;
    private int salary;
    private int birthYear;
    private int empId;
    private static int id;

    Employee(String name,String position,String phone,int salary, int age){
        empId=id;
        this.name=name;
        this.position=position;
        this.phone=phone;
        this.salary=salary;
        this.birthYear=2019-age;
        id+=1;
    }
    public int getId(){
        return empId;
    }
    public String getName(){
        return name;
    }
    public String getPosition(){
        return position;
    }
    public String getPhone(){
        return phone;
    }
    public int getSalary(){
        return salary;
    }
    public int getAge(){
        return 2019-birthYear;
    }
    public void setSalary(int salary){
        this.salary=salary;
    }

}
