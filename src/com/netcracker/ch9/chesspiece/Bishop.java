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
}
