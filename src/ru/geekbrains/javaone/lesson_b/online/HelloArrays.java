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
    public static void multiplyArray(int[] arr){
        for(int i=0;i<arr.length;i++) {
            arr[i] = (arr[i]<6)? arr[i]*2:arr[i];
        }
    }
    public static int returnMin(int[] arr){
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
                min=(min>arr[i])?arr[i]:min;
        }
        return min;
    }
    public static int returnMax(int[] arr){
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            max=(max<arr[i])?arr[i]:max;
        }
        return max;
    }
    public static void diagonal(int[][] arr){
        for(int i=0;i<arr.length;i++){
            arr[i][i]=1;
            arr[i][arr.length-i-1]=1;
            System.out.println(Arrays.toString(arr[i]));
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
        int[] arr3={ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("--Задание 3---\nВ массиве      :  " + Arrays.toString(arr3));
        multiplyArray(arr3);
        System.out.println("Умножаем всех <6 на 2:  " + Arrays.toString(arr3)+"\n");
        int[] arr4={ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("--Задание 4---\nМинимальное значение массива:  " + returnMin(arr4)+"\nМаксимальное значение массива:"+ returnMax(arr4));
        int[][] arr5=new int[11][11];
        diagonal(arr5);
    }

}
