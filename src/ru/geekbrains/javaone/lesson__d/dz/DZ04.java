package ru.geekbrains.javaone.lesson__d.dz;

import java.lang.reflect.Array;

public class DZ04 {


    public static void main(String[] args) {
        Employee emp1 = new Employee("Клещёнок Ирина Владимировна", "бухгалтер", "+79219799092", 25000, 32);
        System.out.println(emp1.getName() + " - " + emp1.getPosition());
        Employee[] emp = new Employee[5];
        emp[0] = new Employee("Черных Иван Сергеевич", "администратор", "+79113522245", 25000, 42);
        emp[1] = new Employee("Цаплин Игорь Владимирович", "директор", "+79813556689", 75000, 46);
        emp[2] = new Employee("Наконечная Ольга Ивановна", "секретарь", "+79113522245", 30000, 26);
        emp[3] = new Employee("Петросов Кирилл Николаевич", "программист", "+79657219541", 60000, 34);
        emp[4] = new Employee("Хайми Мария Александровна", "менеджер", "+79217802061", 50000, 49);
        raiseForOld(emp,45,5000);
        for (int i = 0; i < emp.length; i++) {
            if (emp[i].getAge() > 40) {
                showEmployee(emp[i]);
            }
        }
    }

    private static void showEmployee(Employee emp){
        System.out.println("("+emp.getId()+")"+emp.getName() + " \nВозраст:" + emp.getAge() + "\nДолжность:" + emp.getPosition()+"\nЗарплата: " +emp.getSalary()+"\n-------------------");
    }
    private static void raiseForOld(Employee[] emp,int after, int amount) {
        for (int i = 0; i < emp.length; i++) {
            if (emp[i].getAge() > after) {
                emp[i].setSalary(emp[i].getSalary()+amount);
            }
        }
    }
}
