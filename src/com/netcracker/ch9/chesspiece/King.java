package com.netcracker.ch9.chesspiece;

import java.awt.*;
import java.util.ArrayList;

public class King extends ChessPiece{

    public King( Color color ,String name, int row,int col){
        this.color=color;
        this.name = name;
        this.row = row;
        this.col = col;
    }

    @Override
    public ArrayList<String> canMoveTo() {
        ArrayList<String> s = new ArrayList<>();
        for (int c = col-1;c<col+2;c++){
            for (int r = row-1;r<row+2;r++) {
                if(label.getBoard().checkChess(c, r) || label.getBoard().checkChessColor(c, r,this))
                    s.add(""+r+" "+c);
            }
        }
        return s;
    }
}
