package ru.geekbrains.javaone.lesson_f.home;

import javafx.scene.layout.Pane;

import javax.management.ListenerNotFoundException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GameWindow extends JFrame {
    private static final int GW_heigth=507;
    private static final int GW_width=555;
    private static final int GW_x=650;
    private static final int GW_y=250;
    private GameMap map;
    private Settings settings;

    GameWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(GW_x,GW_y,GW_width,GW_heigth);
        setTitle("Tic Tac Toe");
        setResizable(false);
        JButton jb_Start=new JButton("Start");
        JButton jb_Exit=new JButton("<HTML><BODY><B>Exit</B><BODY><HTML>");
        JPanel panelBottom=new JPanel(new GridLayout(1,2));
        panelBottom.add(jb_Start);
        panelBottom.add(jb_Exit);
        map=new GameMap();
        settings=new Settings(this);
        add(map,BorderLayout.CENTER);
       add(panelBottom,BorderLayout.SOUTH);
        setVisible(true);
        jb_Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jb_Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

    }
    void startNewGame(int mode,int fieldSizeX, int fieldSizeY, int toWin) {
        map.startNewGame(mode,fieldSizeX,fieldSizeY,toWin);
    }
}
