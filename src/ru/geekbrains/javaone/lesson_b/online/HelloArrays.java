package ru.geekbrains.javaone.lesson_b.online;

import java.util.Arrays;



public class HelloArrays {
//-----------1.Превращаем 0 в 1 и наоборот
    public static void invertArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                arr[i]=1;
                }else{
                arr[i]=0;
            }
        }
    }
    public static void fillArray( int[] arr){
        for(int i=0;i<arr.length;i++) {
            arr[i] = 1 + i *3;
        }
    }

    public static void main(String[] args){
        int[] arr={1,1,0,0,1,0,1,1,0,0};
        System.out.println("--Задание 1---\nСоздали массив:  " + Arrays.toString(arr));
        invertArray(arr);
        System.out.println("Поменяли массив: "+Arrays.toString(arr)+"\n");
        int[] arr2=new int[8];
        fillArray(arr2);
        System.out.println("--Задание 2---\nАвтозаполнение пустого массива:  " + Arrays.toString(arr)+"\n");
         
    }

}
