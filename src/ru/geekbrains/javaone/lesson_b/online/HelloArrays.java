package ru.geekbrains.javaone.lesson_b.online;

import java.util.Arrays;
public class HelloArrays {
//-----------1.Превращаем 0 в 1 и наоборот
    private static void invertArray(int[] arr){
        for(int i=0;i<arr.length;i++){
                arr[i]=(arr[i]==0)?1:0;
        }
    }
    //------2.Заполняем 1*3
    private static void fillArray(int[] arr){
        for(int i=0;i<arr.length;i++) {
            arr[i] = 1 + i *3;
        }
    }
    //------3.<6 меньше 6 умножаем на 2
    private static void multiplyArray(int[] arr){
        for(int i=0;i<arr.length;i++) {
            arr[i] = (arr[i]<6)? arr[i]*2:arr[i];
        }
    }
    //------4.находим минимум и максимум
    private static int returnMin(int[] arr){
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
                min=(min>arr[i])?arr[i]:min;
        }
        return min;
    }
    private static int returnMax(int[] arr){
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            max=(max<arr[i])?arr[i]:max;
        }
        return max;
    }
    //------5.заполняем диагональ
    private static void diagonal(int[][] arr){
        for(int i=0;i<arr.length;i++){
            arr[i][i]=1;
            arr[i][arr.length-i-1]=1;
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    //-----6.Счастливый билет
    private static boolean balance(int[] arr){
        int left;
        int right;
        for(int i=1;i<arr.length-1;i++){
            left=0;
            right=0;
            for(int l=0;l<i;l++){
                left+=arr[l];
            }
            for(int r=i;r<arr.length;r++){
                right+=arr[r];
            }
            if(left==right) {
                return true;
            }
        }
        return false;
    }
    //-----7.Сдвигаем элементы массива
    private static void rollArray(int[] arr,int roll){
        int[] Tarray=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            Tarray[i]=arr[i];
        }
        for(int i=0;i<arr.length;i++){
            if(i+roll>=arr.length){
                arr[i]=Tarray[i+roll-arr.length];
            }
            else if(i+roll<0) {
                arr[i] = Tarray[i + roll + arr.length];
            } else {
                arr[i] = Tarray[i + roll];
            }
        }
    }
    //----8.А теперь не используем массив?!
    //****Это довольно глупо и не оптимизировано, но лучше придумать не смог.
    private static void rollArrayExtra(int[] arr,int roll){

            for(int i=0;i<Math.abs(roll);i++) {
                if (roll<0){ rollOnceMinus(arr);}
                else{ rollOncePlus(arr);
            }
        }
    }
    private static void rollOncePlus(int[] arr){
        int a=arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i]=arr[i+1];
        }
        arr[arr.length-1]=a;
    }
    private static void rollOnceMinus(int[] arr){
        int a=arr[arr.length-1];
        for(int i=arr.length-1;i>0;i--){
            arr[i]=arr[i-1];
        }
        arr[0]=a;
    }


    public static void main(String[] args){
        int[] arr={1,1,0,0,1,0,1,1,0,0};
        System.out.println("---Задание 1---\nСоздали массив:  " + Arrays.toString(arr));
        invertArray(arr);
        System.out.println("Поменяли массив: "+Arrays.toString(arr)+"\n");
        int[] arr2=new int[8];
        fillArray(arr2);
        System.out.println("---Задание 2---\nАвтозаполнение пустого массива:  " + Arrays.toString(arr)+"\n");
        int[] arr3={ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("---Задание 3---\nВ массиве      :  " + Arrays.toString(arr3));
        multiplyArray(arr3);
        System.out.println("Умножаем всех <6 на 2:  " + Arrays.toString(arr3)+"\n");
        int[] arr4={ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("---Задание 4---\nМинимальное значение массива:  " + returnMin(arr4)+"\nМаксимальное значение массива:"+ returnMax(arr4)+"/n");
        int[][] arr5=new int[11][11];
        System.out.println("---Задание 5---\nЗаполняем диагональ:" );
        diagonal(arr5);
        int[] arr6={ 1,1,1,2,1};
        System.out.println("\n---Задание 6---\nМассив сбалансирован:" + balance(arr6));
        int[] arr7={ 1,2,3,4,5,6,7,8,9};
        System.out.println("\n---Задание 7,8---\nСдвиг массива:" + Arrays.toString(arr7));
        //rollArray(arr7,-3);
        rollArrayExtra(arr7,-3);
        System.out.println("Получили:" + Arrays.toString(arr7));
    }

}
