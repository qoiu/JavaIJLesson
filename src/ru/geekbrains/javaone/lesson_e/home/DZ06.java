package ru.geekbrains.javaone.lesson_e.home;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DZ06 {
    public static void main(String[] args){
        try {
            FileInputStream fRead = new FileInputStream("C:\\Users\\qoiu\\IdeaProjects\\World\\src\\ru\\geekbrains\\javaone\\lesson_e\\home\\first.txt");
           int i;
            while ((i=fRead.read()) !=-1)
                System.out.print((char)i);
        }catch ( IOException e) {
        System.out.println("File not found");
        }
        InputStream io;
    }
}
