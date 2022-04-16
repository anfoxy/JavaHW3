package com.netcracker.ch9.chesspiece;

import java.awt.*;
import java.util.ArrayList;

public class Knight extends ChessPiece{

    public Knight( Color color ,String name, int row,int col){
        this.color=color;
        this.name = name;
        this.row = row;
        this.col = col;
    }

    @Override
    public ArrayList<String> canMoveTo() {
        ArrayList<String> s = new ArrayList<>();
        if(label.getBoard().checkChess(col+2, row+1)
                || label.getBoard().checkChessColor(col+2, row+1,this))
            s.add(""+(row+1)+" "+(col+2));
        if(label.getBoard().checkChess(col+1, row+2)
                || label.getBoard().checkChessColor(col+1, row+2,this))
            s.add(""+(row+2)+" "+(col+1));
        if(label.getBoard().checkChess(col-2, row-1)
                || label.getBoard().checkChessColor(col-2, row-1,this))
            s.add(""+(row-1)+" "+(col-2));
        if(label.getBoard().checkChess(col-1, row-2)
                || label.getBoard().checkChessColor(col-1, row-2,this))
            s.add(""+(row-2)+" "+(col-1));
        if(label.getBoard().checkChess(col-2, row+1)
                || label.getBoard().checkChessColor(col-2, row+1,this))
            s.add(""+(row+1)+" "+(col-2));
        if(label.getBoard().checkChess(col-1, row+2)
                || label.getBoard().checkChessColor(col-1, row+2,this))
            s.add(""+(row+2)+" "+(col-1));
        if(label.getBoard().checkChess(col+2, row-1)
                || label.getBoard().checkChessColor(col+2, row-1,this))
            s.add(""+(row-1)+" "+(col+2));
        if(label.getBoard().checkChess(col+1, row-2)
                || label.getBoard().checkChessColor(col+1, row-2,this))
            s.add(""+(row-2)+" "+(col+1));
        return s;
    }
}
