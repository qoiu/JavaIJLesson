package ru.geekbrains.javaone.lesson_f.home;

import javax.swing.*;
import java.awt.*;

class GameMap extends JPanel {
   GameMap(){
        setBackground(Color.BLACK);
        //setVisible(true);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.printf("mode=%d, fieldSize=%d, winLen=%d\n", mode, fieldSizeX, winLength);
    }
}
