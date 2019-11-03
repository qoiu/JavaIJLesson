package ru.geekbrains.javaone.lesson_b.online;

import java.util.Arrays;



public class HelloArrays {
//-----------1.Превращаем 0 в 1 и наоборот
    public static int[] invertArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                arr[i]=1;
                }else{
                arr[i]=0;
            }
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr={1,1,0,0,1,0,1,1,0,0};
        System.out.println("--Задание 1---");
        System.out.println("Создали массив:  " + Arrays.toString(arr));
        System.out.println("Поменяли массив: "+Arrays.toString(invertArray(arr)));
    }

}
