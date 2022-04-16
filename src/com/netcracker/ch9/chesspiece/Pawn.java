package com.netcracker.ch9.chesspiece;

import java.awt.*;
import java.util.ArrayList;

public class Pawn extends ChessPiece{

    public Pawn( Color color,String name, int row,int col){
        this.color=color;
        this.name = name;
        this.row = row;
        this.col = col;

    }

    @Override
    public ArrayList<String> canMoveTo() {
        ArrayList<String> s = new ArrayList<>();
        if(color == Color.WHITE) {
            for (int i = col - 1; i < col + 2; i=i+2) {
                if (label.getBoard().checkChessColor(i, row+1,this))s.add("" + (row+1) + " " + i);
            }
            if (label.getBoard().checkChess(col,row+1)) s.add("" + (row+1)+ " " + col);
        }else {
            for (int i = col - 1; i < col + 2;  i=i+2) {
                if (label.getBoard().checkChessColor(i, row-1,this)) s.add("" + (row-1) + " " + i);
            }
            if (label.getBoard().checkChess(col,row-1)) s.add("" + (row-1) + " " + col);
        }
        return s;
    }
}
