package ru.geekbrains.javaone.lesson_f.home;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Settings extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;
    private GameWindow gameWindow;
    private JRadioButton jrb_HvsAI;
    private JRadioButton jrb_HvsH;
    private JSlider jsl_SizeX;
    private JSlider jsl_SizeY;
    private JSlider jsl_WinCondition;
    private static final String FIELD_SIZE_PREFIX_X = "Field size x is: ";
    private static final String FIELD_SIZE_PREFIX_Y = "Field size y is: ";
    private static final String WIN_LENGTH_PREFIX = "Winning length is: ";
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final int MIN_WIN_LENGTH = 3;

    Settings(GameWindow gameWindow){
        this.gameWindow=gameWindow;
        setResizable(false);
        Rectangle gameWindowBounds=gameWindow.getBounds();
        int posX=(int) gameWindowBounds.getCenterX()-WINDOW_WIDTH/2;
        int posY=(int) gameWindowBounds.getCenterY()-WINDOW_HEIGHT/2;
        setBounds(posX,posY,WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("Settings");
        setLayout(new GridLayout(11,1));
        addGameModeComponents();//Добавляем компоненты
        addFieldSizeControl();

    }

    private void addFieldSizeControl() {
        add(new JLabel("Choose fiekd size"));
        JLabel jlFieldX=new JLabel(FIELD_SIZE_PREFIX_X + MIN_FIELD_SIZE);
        jsl_SizeX= new JSlider(MIN_FIELD_SIZE,MAX_FIELD_SIZE,MIN_FIELD_SIZE);
        JLabel jlFieldY=new JLabel(FIELD_SIZE_PREFIX_Y + MIN_FIELD_SIZE);
        jsl_SizeY=new JSlider(MIN_FIELD_SIZE,MAX_FIELD_SIZE,MIN_FIELD_SIZE);
        JLabel jlWinCond=new JLabel(WIN_LENGTH_PREFIX+MIN_WIN_LENGTH);
        jsl_WinCondition=new JSlider(MIN_WIN_LENGTH,MIN_FIELD_SIZE,MIN_WIN_LENGTH);
        ChangeListener chList=new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jsl_WinCondition.setMaximum(Math.min(jsl_SizeY.getValue(), jsl_SizeX.getValue()));
                jlWinCond.setText(WIN_LENGTH_PREFIX+jsl_WinCondition.getValue());
                jlFieldX.setText(FIELD_SIZE_PREFIX_X+jsl_SizeX.getValue());
                jlFieldY.setText(FIELD_SIZE_PREFIX_Y+jsl_SizeY.getValue());
            }
        };
        jsl_SizeY.addChangeListener(chList);
        jsl_SizeX.addChangeListener(chList);
        jsl_WinCondition.addChangeListener(chList);
        add(jlFieldX);
        add(jsl_SizeX);
        add(jlFieldY);
        add(jsl_SizeY);
        add(jlWinCond);
        add(jsl_WinCondition);

    }


    private void addGameModeComponents() {
        add(new JLabel("Choose game mode"));
        jrb_HvsAI=new JRadioButton("Human vs AI");
        jrb_HvsH=new JRadioButton("Human vs Human");
        ButtonGroup btnGameMode=new ButtonGroup();
        btnGameMode.add(jrb_HvsAI);
        btnGameMode.add(jrb_HvsH);
        jrb_HvsAI.setSelected(true);
        add(jrb_HvsAI);
        add(jrb_HvsH);
    }
}
