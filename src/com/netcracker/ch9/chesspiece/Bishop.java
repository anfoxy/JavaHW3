package com.netcracker.ch9.chesspiece;

import java.awt.*;
import java.util.ArrayList;

public class Bishop extends ChessPiece{


    public Bishop(Color color, String name , int row,int col){
        this.color=color;
        this.name = name;
        this.row = row;
        this.col = col;
    }
    @Override
    public ArrayList<String> canMoveTo() {
        ArrayList<String> s = new ArrayList<>();
        s.addAll(movingDiagonallyForwardAndLeft(this));
        s.addAll(movingDiagonallyForwardAndRight(this));
        s.addAll(movingDiagonallyBackAndLeft(this));
        s.addAll(movingDiagonallyBackAndRight(this));
        return s;
    }

    private ArrayList<String> movingDiagonallyForwardAndLeft(ChessPiece piece){
        ArrayList<String> s = new ArrayList<>();
        int c = col-1;
        int r = row+1;
        while (true){
            if(label.getBoard().checkChess(c, r)) {
                s.add("" + r + " " + c);
                c --;
                r ++;
            } else
            if(label.getBoard().checkChessColor(c, r,piece)) {
                s.add(""+r+" "+c);
                break;
            } else break;
        }

        return s;
    }

    private ArrayList<String> movingDiagonallyForwardAndRight(ChessPiece piece){
        ArrayList<String> s = new ArrayList<>();
        int c = col+1;
        int r = row+1;
        while (true){
            if(label.getBoard().checkChess(c, r)) {
                s.add("" + r + " " + c);
                c ++;
                r ++;
            } else
            if(label.getBoard().checkChessColor(c, r,piece)) {
                s.add(""+r+" "+c);
                break;
            } else break;
        }

        return s;
    }

    private ArrayList<String> movingDiagonallyBackAndRight(ChessPiece piece){
        ArrayList<String> s = new ArrayList<>();
        int c = col+1;
        int r = row-1;
        while (true){
            if(label.getBoard().checkChess(c, r)) {
                s.add("" + r + " " + c);
                c ++;
                r --;
            } else
            if(label.getBoard().checkChessColor(c, r,piece)) {
                s.add(""+r+" "+c);
                break;
            } else break;
        }

        return s;
    }
    private ArrayList<String> movingDiagonallyBackAndLeft(ChessPiece piece){
        ArrayList<String> s = new ArrayList<>();
        int c = col-1;
        int r = row-1;
        while (true){
            if(label.getBoard().checkChess(c, r)) {
                s.add("" + r + " " + c);
                c --;
                r --;
            } else
            if(label.getBoard().checkChessColor(c, r,piece)) {
                s.add(""+r+" "+c);
                break;
            } else break;
        }
        return s;
    }


}
