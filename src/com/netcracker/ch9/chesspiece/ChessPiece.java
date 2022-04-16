package com.netcracker.ch9.chesspiece;

import java.awt.*;
import java.util.ArrayList;

public abstract class ChessPiece {
    protected String name;
    protected String position;
    protected Color color;
    ChessLabel label;
    Board board;
    protected int col;
    protected int row;

    protected ArrayList<String> movingDiagonallyForwardAndLeft(ChessPiece piece){
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

    protected ArrayList<String> movingDiagonallyForwardAndRight(ChessPiece piece){
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

    protected ArrayList<String> movingDiagonallyBackAndRight(ChessPiece piece){
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
    protected ArrayList<String> movingDiagonallyBackAndLeft(ChessPiece piece){
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

    protected ArrayList<String> movingLeft(ChessPiece piece){
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
    protected ArrayList<String> movingForward(ChessPiece piece){
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
    protected ArrayList<String> movingBack(ChessPiece piece){
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

    protected ArrayList<String> movingRight(ChessPiece piece) {
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

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer("");
        s.append(name);
        s.append(color == Color.WHITE ? "W" : "B");
        return s.toString();
    }

    public  void setPosition(String coordinates) {
        position = coordinates;
    }

    public String getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChessLabel getLabel() {
        return label;
    }

    public void setLabel(ChessLabel label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public abstract ArrayList<String> canMoveTo();

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

}
