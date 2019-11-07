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
        fieldSizeX=5;
        fieldSizeY=5;
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
    private static void humanTurn(){
        int x,y;
        do {
            System.out.printf("Введите координаты X и Y (от 1 до %d) через %s",fieldSizeX,"пробел");
            x=scan.nextInt()-1;
            y=scan.nextInt()-1;
        }while(!isinField(x, y) || !isEmpty(field[y][x]));
        field[y][x] = DOT_HUMAN;
       showField();
    }

    private static boolean isEmpty(char c) {
        return c == DOT_EMPTY;
    }//Проверяем значение в ячейке
    private static boolean isinField(int x, int y){return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;}//Проверяем не улетела ли ячейка
    private static int countSymb(int x,int y,int plusX,int plusY,char c) {
        int i = 0;
        if(isinField(x+(lengthWin-1)*plusX,y+(lengthWin-1)*plusY))
        for (int k = 0; k < lengthWin; k++)
            if (field[y + k * plusY][x + k * plusX] == c)
                i += 1;
            return i;
    }//Вычисляем кол-во победных символов в линии
    private static void fillNext(int x,int y,int plusX,int plusY){
        if(isinField(x+(lengthWin-1)*plusX,y+(lengthWin-1)*plusY))
        for (int k = 0; k < lengthWin; k++) {
            if (isEmpty(field[y + k * plusY][x + k * plusX]))
                fieldValue[y + k * plusY][x + k * plusX] += countSymb(x,y,plusX,plusY,DOT_HUMAN)*lengthWin;
            //проверяем есть ли у противниеа шансы на победу
            if (isEmpty(field[y + k * plusY][x + k * plusX]))
                fieldValue[y + k * plusY][x + k * plusX] += (lengthWin-countSymb(x,y,plusX,plusY,DOT_AI)==1)?50:1;
            //Находим возможность победить
        }
        if(!isEmpty(field[y][x]))fieldValue[y][x]=0;
    }//Магический метод вычисляющий
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
    }//Ход ИИ
    private static void clearFieldValue(){
        for (int y=0;y<fieldSizeY;y++){
            for (int x=0;x<fieldSizeX;x++) {
            fieldValue[y][x]=0;
            }
        }
    }//Обнуление FieldValue
    private static void fieldCheckValue(){
        clearFieldValue();
        for (int i=0;i<fieldSizeY;i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                fillNext(j,i,1,1);
                fillNext(fieldSizeX-1-j,i,-1,1);
                fillNext(j,i,0,1);
                fillNext(j,i,1,0);
            }
        }
    }//начинаем проверку по вертикали, горизонтали, диагонали
    private static boolean isDraw() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }//проверка ничьей
    private static boolean checkWin(char C){
        for (int y=0;y<fieldSizeY;y++){
            for (int x=0;x<fieldSizeX;x++){
                for (int k = 0; k < lengthWin; k++) {
                    if (countSymb(fieldSizeX - 1 - y, x, -1, 1, C) == lengthWin) return true;
                    if (countSymb(y, x, 1, 1, C) == lengthWin) return true;
                    if (countSymb(y, x, 1, 0, C) == lengthWin) return true;
                    if (countSymb(y, x, 0, 1, C) == lengthWin) return true;
                }
            }
        }
        return false;
    }//проверка победы
    public static void main(String[] args){
        initField();
        while (true) {
            humanTurn();
            if (checkWin(DOT_HUMAN)) {
                System.out.print("\nHuman win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
            aiTurn();
            if (checkWin(DOT_AI)){
                System.out.print("\nAI win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
        }
    }
}