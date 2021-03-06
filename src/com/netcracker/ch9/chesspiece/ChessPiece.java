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
