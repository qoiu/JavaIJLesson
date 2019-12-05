package ru.geekbrains.javaone.lesson_f.home;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Settings extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;
    private static final int Player_max=4;
    private GameWindow gameWindow;
    private JRadioButton[] jrb_Human,jrb_AI,jrb_None;

    private JSlider jsl_SizeX;
    private JSlider jsl_SizeY;
    private JSlider jsl_WinCondition;
    private JTextField[] jtf_pName;
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
        setLayout(new GridLayout(9+Player_max,1));

        addFieldSizeControl();
        JButton jbStart=new JButton("Start a game!!!");
        jbStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBtnStartGameClick();
            }
        });
        addGameModeComponents();//Добавляем компоненты
        add(jbStart);

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
        add(new JLabel("Choose player settings"));
        JPanel[] jp=new JPanel[Player_max];
        jrb_AI=new JRadioButton[Player_max];
        jrb_Human=new JRadioButton[Player_max];
        jrb_None=new JRadioButton[Player_max];
        jtf_pName=new JTextField[Player_max];
        for(int i=0;i<Player_max;i++) {
            jp[i]=new JPanel(new GridLayout(1,4));
            jtf_pName[i]=new JTextField("Player "+(i+1));
            jrb_Human[i] = new JRadioButton("Human");
            jrb_AI[i]= new JRadioButton("AI");
            jrb_None[i]= new JRadioButton("None");
            ButtonGroup btnGameMode = new ButtonGroup();
            btnGameMode.add(jrb_Human[i]);
            btnGameMode.add(jrb_AI[i]);
            btnGameMode.add(jrb_None[i]);
            jp[i].add(jtf_pName[i]);
            jp[i].add(jrb_Human[i]);
            jp[i].add(jrb_AI[i]);
            jp[i].add(jrb_None[i]);
            jrb_None[i].setSelected(true);
            //add(new JTextField("ssss"));
            add(jp[i]);
        }
        jrb_Human[0].setSelected(true);
        jrb_AI[1].setSelected(true);
    }


    private void onBtnStartGameClick(){
        int players=0;
        String[] playerName=new String[Player_max+1];
        boolean[] playerAI=new boolean[Player_max+1];
        for(int i=0;i<Player_max;i++)
        if (jrb_Human[i].isSelected()){
            players+=1;
            playerAI[players]=false;
            if(jtf_pName[i].getText().equals("Player "+(i+1))){
                playerName[players]="Player " + players;
            }else playerName[players]=jtf_pName[i].getText();
        }else if(jrb_AI[i].isSelected()){
            players+=1;
            playerAI[players]=true;
            if(jtf_pName[i].getText().equals("Player "+(i+1))){
                playerName[players]="AI " + players;
            }else playerName[players]=jtf_pName[i].getText();
        }
        if(players<2){
            return;
        }
        int fieldSizeX=jsl_SizeX.getValue();
        int fieldSizeY=jsl_SizeY.getValue();
        int winLength=jsl_WinCondition.getValue();
        gameWindow.startNewGame(new GameSet(players,playerAI, fieldSizeX, fieldSizeY, winLength,playerName));
        setVisible(false);
    }

}
