package ru.geekbrains.javaone.lesson_f.home;

import javax.swing.*;
import java.awt.*;

class GameMap extends JPanel {
    static final int GM_HvsAI=0;
    static final int GM_HvsH=1;
    private int  mode,fieldSizeX,fieldSizeY,winLength;
   GameMap(){
        setBackground(Color.BLACK);
    }
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.WHITE);
        for(int i=1;i<fieldSizeX;i++)
            g.drawLine((getWidth()/fieldSizeX)*(i), 0, (getWidth()/fieldSizeX)*(i), getHeight());
        for(int i=1;i<fieldSizeY;i++)
            g.drawLine(0,(getHeight()/fieldSizeY)*i,  getWidth(),(getHeight()/fieldSizeY)*i);
    }
    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
       this.mode=mode;
       this.fieldSizeX=fieldSizeX;
       this.fieldSizeY=fieldSizeY;
       this.winLength=winLength;
        System.out.printf("mode=%d, fieldSize=%d, winLen=%d\n", mode, fieldSizeX, winLength);
        repaint();
    }
}
