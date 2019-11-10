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
        this.birthYear=DZ04.curYear-age;
        id+=1;
    }
    public int getId(){
        return empId;
    }
    public static void raiseForOld(Employee[] emp,int after, int amount) {
        for (int i = 0; i < emp.length; i++) {
            if (emp[i].getAge() > after) {
                emp[i].setSalary(emp[i].getSalary()+amount);
            }
        }
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
        return DZ04.curYear-birthYear;
    }
    public void setSalary(int salary){
        this.salary=salary;
    }

}
