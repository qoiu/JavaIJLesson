package ru.geekbrains.javaone.lesson__c.online;

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
        lengthWin=3;
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
    }
    private static void showValue(){
        for(int i=0;i<fieldSizeY;i++){
            System.out.print("\n|");
            for(int j=0;j<fieldSizeX;j++){
                System.out.print(fieldValue[i][j] + "|");
            }
        }
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
        return x > 0 && x < fieldSizeX && y > 0 && x < fieldSizeY;
    }
   //проверяем пустоту следующих lengthWin элементов
    private static boolean checkNext(int x, int y, int plusX, int plusY) {
        for (int k = 0; k < lengthWin; k++)
            if (field[x + k*plusY][y + k*plusX] != DOT_EMPTY) {
                return false;
            }
        return true;
    }

    private static void aiTurn(){

    }
    private static void fieldCheckValue(){
        checkDiagonal();
        checkHor();
       checkVert();
    }

    private static void checkDiagonal(){
        for (int i=0;i<=fieldSizeY-lengthWin;i++){
            for (int j=0;j<=fieldSizeX-lengthWin;j++){
                if (checkNext(i,j,1,1))
                    for (int k = 0; k < lengthWin; k++) fieldValue[i+k][j+k] += 1;
                    //обратная диагональ
               if (checkNext(fieldSizeX-1-j,j,1,-1))
                    for (int k = 0; k < lengthWin; k++) fieldValue[i+k][fieldSizeX-1-(j +k)] += 1;
            }
        }
    }
    private static void checkVert() {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j <= fieldSizeY-lengthWin; j++) {
                if (checkNext(i,j,1,0))
                    for (int k = j; k < lengthWin+j; k++) fieldValue[k][i] += 1;
            }
        }
    }
    private static void checkHor() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j <= fieldSizeX-lengthWin; j++) {
                if (checkNext(j,i,0,1))
                    for (int k = j; k < lengthWin+j; k++) fieldValue[i][k] += 1;
            }
        }
    }

    public static void main(String[] args){
        initField();

       //humanTurn();
        showField();
        fieldCheckValue();
        showValue();
    }

}
