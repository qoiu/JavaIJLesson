package ru.geekbrains.javaone.lesson_e.home;

import java.io.*;
import java.util.Scanner;

public class DZ06 {
    private static Scanner scan=new Scanner(System.in);
    public static void main(String[] args) {
        concFiles("first.txt", "second.txt", "third.txt");
       // System.out.println("London capital "+wordExist("London.txt","London capital"));
       //System.out.println(folderSearch("London"));
        String find="";
        System.out.println("Введите слово и я проверю есть ли оно в папке");
        while (true){
            find= scan.nextLine();
            System.out.println(folderSearch(find));
        }
    }

    private static boolean folderSearch(String str) {
        File dir = new File(System.getProperty("user.dir"));
        File[] allFiles = dir.listFiles();
            assert allFiles != null;
            for (File allFile : allFiles) {
                if(checkFileType(allFile.getName(),".txt") && wordExist(allFile.getName(), str)) return true;
            }
        return false;
    }
    private static boolean checkFileType(String str,String type){
        return (str.length()>=type.length() && str.substring(str.length()-type.length()).equals(type));
    }
    private static boolean wordExist(String str, String find){
        StringBuilder sb=getStrFromFile(str);
        if (sb.length()>=find.length())
        for(int i=0;i<sb.length()-find.length();i++){
           if (sb.substring(i,i+find.length()).toLowerCase().equals(find.toLowerCase()))
              return true;
        }
        return false;
    }

    private static void concFiles(String name1,String name2,String nameOut) {
        try {
            String str=new String(getStrFromFile(name1));
            str+="\n"+getStrFromFile(name2);
            FileOutputStream fout= new FileOutputStream(nameOut);
            PrintStream ps=new PrintStream(fout);
            ps.println(str);
                    }catch ( IOException e) {
        System.out.println("File not found");
        }
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
