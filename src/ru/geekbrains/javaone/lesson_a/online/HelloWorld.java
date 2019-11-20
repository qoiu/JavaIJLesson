package ru.geekbrains.javaone.lesson_a.online;

import java.util.Scanner;

/*
1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
+
2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
+
3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
+
4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
+
5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
+
6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
++
7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
+
8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.


 */
public class HelloWorld {
    public static void main(String[] args) {
        allTypes();
        System.out.println(calculation(2.0,3.0,7.0,5.0));
        System.out.println(inRange(7, 1));
        System.out.println(inputRange());
        System.out.println(isPositive(2));
        System.out.println(isNegative(2));
        hiName("Никита");
        leap();
    }

    private static void allTypes() {
        boolean b = true;
        byte byt = 1;
        short sh = 34;
        int i = 10;
        long ln = 25;
        char c = 77;
        char ch = 'a';
        double db = 32.7;
        float fl = 36f;
        String s="Hello world!";
        /*System.out.println(c);
        System.out.println(ch);
        System.out.println(i);
        ++i;
        System.out.println(i);
        i++;
        System.out.println(i);
*/
    }

    private static int calculation(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    private static double calculation(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    private static boolean inRange(int a, int b) {
        int c = a + b;
        if (c >= 10 && c <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean inputRange(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите a");
       int a= sc.nextInt();
        System.out.println("Введите b");
       int b=sc.nextInt();
       int c=a+b;
        if (c >= 10 && c <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPositive(int a){
        if(a<0){
            return false;
        }else {
            return true;
        }

    }

    public static boolean isNegative(int a){
        return !isPositive(a);
    }

    public static void hiName(String s){
        System.out.println("Привет, " + s + "!");
    }
    public static void leap(){
        int year=2019;
//проверить дополнительные условия в одну строчку не смог. Не хватило времени. Разберусь чуть позже.
        if (year % 4==0){
            if (year % 100==0){
                if (year % 400==0){
                    System.out.println("Високосный");
                } else {
                    System.out.println("Не високосный");
                }

            }else{
                System.out.println("Високосный");
            }
        }else{
            System.out.println("Не високосный");
        }
    }
}
