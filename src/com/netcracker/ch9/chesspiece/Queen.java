package com.netcracker.ch9.chesspiece;

import java.awt.*;
import java.util.ArrayList;

public class Queen extends ChessPiece{

    public Queen( Color color,String name, int row,int col){
        this.color=color;
        this.name = name;
        this.row = row;
        this.col = col;
    }

    @Override
    public ArrayList<String> canMoveTo() {
        ArrayList<String> s = new ArrayList<>();
        s.addAll(movingForward(this));
        s.addAll(movingBack(this));
        s.addAll(movingLeft(this));
        s.addAll(movingRight(this));
        s.addAll(movingDiagonallyBackAndLeft(this));
        s.addAll(movingDiagonallyBackAndRight(this));
        s.addAll(movingDiagonallyForwardAndLeft(this));
        s.addAll(movingDiagonallyForwardAndRight(this));
        return s;
    }
    private ArrayList<String> movingLeft(ChessPiece piece){
        ArrayList<String> s = new ArrayList<>();
        for (int i = col-1; i>=0;i--){
            if(label.getBoard().checkChess(i, row)){
                s.add(""+row+" "+i);
            } else
            if(label.getBoard().checkChessColor(i, row,piece)) {
                s.add(""+row+" "+i);
                break;
            } else break;
        }
        return s;
    }
    private ArrayList<String> movingForward(ChessPiece piece){
        ArrayList<String> s = new ArrayList<>();
        for (int i = row+1; i<8;i++){
            if(label.getBoard().checkChess(col, i)) s.add(""+i+" "+col);
            else if(label.getBoard().checkChessColor(col, i,piece)) {
                s.add(""+i+" "+col);
                break;
            } else break;
        }
        return s;
    }
    private ArrayList<String> movingBack(ChessPiece piece){
        ArrayList<String> s = new ArrayList<>();
        for (int i = row-1; i>=0;i--){
            if(label.getBoard().checkChess(col, i)) s.add(""+i+" "+col);
            else if(label.getBoard().checkChessColor(col, i,piece)) {
                s.add(""+i+" "+col);
                break;
            } else break;
        }
        return s;
    }

    private ArrayList<String> movingRight(ChessPiece piece) {
        ArrayList<String> s = new ArrayList<>();
        for (int i = col + 1; i < 8; i++) {
            if (label.getBoard().checkChess(i, row)) s.add("" + row + " " + i);
            else if (label.getBoard().checkChessColor(i, row, piece)) {
                s.add("" + row + " " + i);
                break;
            } else break;
        }
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
