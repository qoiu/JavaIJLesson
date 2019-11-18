package ru.geekbrains.javaone.lesson_e.home;

import java.io.*;
import java.lang.reflect.Array;

public class DZ06 {
    public static void main(String[] args) {
        concFiles("first.txt", "second.txt", "third.txt");
        showFile("third.txt");
    }
    private static void concFiles(String name1,String name2,String nameOut) {
        try {
            StringBuilder str=new StringBuilder(getStrFromFile(name1));
            str.append(getStrFromFile(name2));
            FileOutputStream fout= new FileOutputStream(nameOut);
            PrintStream ps=new PrintStream(fout);
            ps.println(str);
            str
        }catch ( IOException e) {
        System.out.println("File not found");
        }
    }
    private static void showFile(String name){
        try {
            FileInputStream fRead = new FileInputStream(name);
            int i;
            while ((i=fRead.read()) !=-1)
                System.out.print((char)i);
        }catch ( IOException e) {
            System.out.println(name+": File not found");
        }
        InputStream io;
    }
    private static StringBuilder getStrFromFile(String name){
        StringBuilder str=new StringBuilder();
        try {
            FileInputStream fRead = new FileInputStream(name);
            int i;
            while ((i=fRead.read()) !=-1)
               str.append((char)i);
        }catch ( IOException e) {
            System.out.println(name+": File not found");
        }
        return str;
    }
}
