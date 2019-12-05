package ru.geekbrains.javaone.lesson_f.home;

import java.util.Random;

class TicTacToe {
        private Random random=new Random();
        private int[][] field;
        private int fieldSizeX,fieldSizeY,lenWin;
        private int players;
        TicTacToe(int fieldSizeX, int fieldSizeY, int lenWin, int players){
            this.fieldSizeX=fieldSizeX;
            this.fieldSizeY=fieldSizeY;
            this.players=players;
            this.lenWin=lenWin;

             field=new int[fieldSizeX][fieldSizeY];
        }
        void setField(int x, int y, int player){field[x][y]=player;}
        int getValue(int x, int y){return field[x][y];}
        boolean isinField(int x, int y){
            return (x>=0 && y>=0 && x<fieldSizeX && y<fieldSizeY);
        }
        boolean isEmpty(int x, int y){
            return (field[x][y]==0);
        }
        boolean isDraw(){
            for(int x=0;x<fieldSizeX;x++){
                for(int y=0;y<fieldSizeY;y++){
                    if(field[x][y]==0)return false;}}
            System.out.print("DRAW");
            return true;
        }
        void aiTurn(int player){
            if(aiWinCheck(player,lenWin,player)) return;
                for(int k=lenWin;k>=2;k--)
                    for(int i=1;i<=players;i++)
                        if(i!=player)
                    if( aiWinCheck(i,k,player)) return;
            for(int k=lenWin;k>2;k--)
                if( aiWinCheck(player,k,player)) return;
            int x, y;
            do {
                x = random.nextInt(fieldSizeX);
                y = random.nextInt(fieldSizeY);
            } while (!isEmpty(x, y));
            field[x][y] = player;
        }
        private boolean aiWinCheck(int player,int winLen,int curPlayer){
            for (int y=0;y<fieldSizeY;y++){
                for (int x=0;x<fieldSizeX;x++) {
                    if(isEmpty(x,y)){
                        field[x][y]=player;
                        if(checkWin(player,winLen)){
                            field[x][y]=curPlayer;
                            return true;
                        }
                        field[x][y]=0;
                    }
                }
            }
            return false;
        }
        private boolean checkWin(int player, int winLen){
        for (int x=0;x<fieldSizeX;x++){
            for (int y=0;y<fieldSizeY;y++){
                    if (countSymb(fieldSizeX - 1 - x, y, -1, 1, player, winLen))return true;
                    if (countSymb(x, y, 1, 1, player,winLen))return true;
                    if (countSymb(x, y, 1, 0, player,winLen)) return true;
                    if (countSymb(x, y, 0, 1, player,winLen)) return true;
            }
        }
        return false;
        }
        boolean checkWin(int player){ return checkWin(player,lenWin);}
        private boolean countSymb(int x,int y,int plusX,int plusY,int player, int winLen){
            int i = 0;
            if(!isinField(x+(winLen-1)*plusX,y+(winLen-1)*plusY)) return false;
                for (int k = 0; k < winLen; k++)
                    if (field[x  + k * plusX][y + k * plusY] != player)
                         return false;
            return true;
        }


}
