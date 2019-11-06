package ru.geekbrains.javaone.lesson__c.online;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeMy {
    private static char field[][];
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int lengthWin;
    private static int fieldValue[][];
    private static Scanner scan=new Scanner(System.in);
    private static Random rand=new Random();
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';

    private static void initField(){
        fieldSizeX=6;
        fieldSizeY=6;
        lengthWin=4;//>=3
        fieldValue=new int[fieldSizeY][fieldSizeX];
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }
    private static void showField(){
        for(int i=0;i<fieldSizeY;i++){
            System.out.print("\n|");
            for(int j=0;j<fieldSizeX;j++){
                System.out.print(field[i][j] + "|");
            }
        }
        System.out.print("\n-----------");
    }
    private static void showValue(){
        for(int i=0;i<fieldSizeY;i++){
            System.out.print("\n|");
            for(int j=0;j<fieldSizeX;j++){
                System.out.print(fieldValue[i][j] + "|");
            }
        }
        System.out.print("\n----------");
    }
    private static void humanTurn(){
        int x,y;
        do {
            System.out.printf("Введите координаты X и Y (от 1 до %d) через %s",fieldSizeX,"пробел");
            x=scan.nextInt()-1;
            y=scan.nextInt()-1;
        }while(!isinField(x, y) || !isEmpty(field[x][y]));
        field[y][x] = DOT_HUMAN;
    }

    private static boolean isEmpty(char c) {
        return c == DOT_EMPTY;
    }
    private static boolean isinField(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && x < fieldSizeY;
    }
   //проверяем пустоту следующих lengthWin элементов

   private static int countEnemy(int x,int y,int plusX,int plusY) {
       int i = 1;
       for (int k = 0; k < lengthWin; k++) {
           if (field[y + k * plusY][x + k * plusX] == DOT_HUMAN) {
               i *= 3;
           } else if (field[y + k * plusY][x + k * plusX] == DOT_AI) {
               return 0;
           }
       }
       return i;
   }
    private static int canWin(int x,int y,int plusX,int plusY){
        int i = 0;
        for (int k = 0; k < lengthWin; k++)
            if (field[y + k * plusY][x + k * plusX] == DOT_AI)
                i += 1;
            if(lengthWin-i==1)
                return 50;
            return 0;

    }

    private static void fillNext(int x,int y,int plusX,int plusY){
        for (int k = 0; k < lengthWin; k++) {
            if (isEmpty(field[y + k * plusY][x + k * plusX]))
                fieldValue[y + k * plusY][x + k * plusX] += countEnemy(x, y, plusX, plusY);
            if (isEmpty(field[y + k * plusY][x + k * plusX]))
                fieldValue[y + k * plusY][x + k * plusX] += canWin(x,y,plusX,plusY);
        }
    }
    private static void aiTurn(){
        fieldCheckValue();
        int pX=0;
        int pY=0;
        int max=0;
        for (int y=0;y<fieldSizeY;y++){
            for (int x=0;x<fieldSizeX;x++) {
                if(fieldValue[y][x]>max){
                    pX=x;
                    pY=y;
                    max=fieldValue[y][x];
    }
}
        }

                field[pY][pX]=DOT_AI;
                showField();
    }
    private static void clearFieldValue(){
        for (int y=0;y<fieldSizeY;y++){
            for (int x=0;x<fieldSizeX;x++) {
            fieldValue[y][x]=0;
            }
        }
    }
    private static void fieldCheckValue(){
        clearFieldValue();
        checkDiagonal();
        checkHor();
        checkVert();
    }
    private static void checkDiagonal(){
        for (int i=0;i<=fieldSizeY-lengthWin;i++){
            for (int j=0;j<=fieldSizeX-lengthWin;j++){
                fillNext(j,i,1,1);
                //обратная диагональ
                fillNext(fieldSizeX-1-j,i,-1,1);
            }
        }
    }
    private static void checkVert() {
        for (int i = 0; i <= fieldSizeY-lengthWin; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                    fillNext(j,i,0,1);

            }
        }
    }
    private static void checkHor() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j <= fieldSizeX-lengthWin; j++) {
                    fillNext(j,i,1,0);
            }
        }
    }

    public static void main(String[] args){
        initField();
        while (true) {
            humanTurn();
            //
            aiTurn();
            showValue();
        }
    }

}
