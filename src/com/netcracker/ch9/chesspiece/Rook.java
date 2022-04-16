package com.netcracker.ch9.chesspiece;

import java.awt.*;
import java.util.ArrayList;

public class Rook extends ChessPiece{

    public Rook( Color color,String name, int row,int col){
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
        return s;
    }
}
