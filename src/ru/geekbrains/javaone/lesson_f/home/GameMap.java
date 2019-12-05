package ru.geekbrains.javaone.lesson_f.home;

import sun.awt.image.codec.JPEGParam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class GameMap extends JPanel {
    private int winState;
    private static final int Padding=5;
    private static final String MSG_DRAW="Draw";
    private  int players,curPlayer;
    private  boolean[] playerAI;
    private static boolean isInitilized;
    private int fieldSizeX;
    private int fieldSizeY;
    private String[] playerName;
    private TicTacToe engine;
    private int cellHeight,cellWidth;
    private Color[] pColor={Color.gray,Color.RED,Color.BLUE,Color.orange,Color.GREEN};
   GameMap(){
        setBackground(Color.BLACK);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }
    private void render(Graphics g){
       if(!isInitilized)return;
        g.setColor(Color.BLACK);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.WHITE);
        cellHeight=getHeight()/fieldSizeY;
        cellWidth=getWidth()/fieldSizeX;
        for(int i=1;i<fieldSizeX;i++)
            g.drawLine(cellWidth*i, 0, cellWidth*i, getHeight());
        for(int i=1;i<fieldSizeY;i++)
            g.drawLine(0,cellHeight*i,  getWidth(),cellHeight*i);
        for(int x=0;x<fieldSizeX;x++)
        for(int y=0;y<fieldSizeY;y++)
            if(engine.getValue(x,y)>0){
               g.setColor(pColor[engine.getValue(x,y)]);
               g.fillOval(cellWidth*x+Padding,cellHeight*y+Padding,cellWidth-Padding*2,cellHeight-Padding*2);
            }
        if(winState!=-1)
            showMessageGameOver(g);
    }
    void startNewGame(GameSet gs) {
       this.players=gs.players;
       this.playerAI=gs.playerAI;
       this.fieldSizeX=gs.fieldSizeX;
       this.fieldSizeY=gs.fieldSizeY;
       this.playerName=gs.playerName;
       curPlayer=1;
       winState=-1;
        engine=new TicTacToe(fieldSizeX,fieldSizeY, gs.winLength,players);
        isInitilized=true;
        repaint();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
               update(e);
            }
        });

    }

    private void showMessageGameOver(Graphics g) {
        g.setColor(pColor[winState]);
        g.fillRect(0, getHeight()/2-40 , getWidth(), 70);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Times new roman", Font.BOLD, 48));
        if (winState==0) {
            g.drawString(MSG_DRAW, 70, getHeight() / 2);
        }else if(winState>0){
            String str=playerName[winState]+" win";
            g.drawString(str, 70, getHeight() / 2);
        }
    }

    private void update(MouseEvent e) {
        if (!isInitilized) return;
        if (winState!=-1) return;
        if(!playerAI[curPlayer]) {
            int cellX = e.getX() / cellWidth;
            int cellY = e.getY() / cellHeight;
            if (!engine.isinField(cellX, cellY) || !engine.isEmpty(cellX, cellY)) return;
            engine.setField(cellX, cellY, curPlayer);
            //System.out.println("x:"+cellX+" y:"+cellY);
            nextPlayer();
        }
        while(playerAI[curPlayer]){
               if (winState!=-1) return;
               engine.aiTurn(curPlayer);
               nextPlayer();
        }
    }
    private void checkWin(){
        if (engine.checkWin(curPlayer)) {
            System.out.print(playerName[curPlayer]+" win");
            winState=curPlayer;
        }else if (engine.isDraw()) {
            System.out.print("draw");
            winState=0;
        }
    }
    private void nextPlayer(){
       checkWin();
       repaint();
       if(curPlayer>=players)curPlayer=0;
       curPlayer+=1;
    }
}
