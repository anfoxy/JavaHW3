package com.netcracker.ch9.chesspiece;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public class Board extends JFrame {


    private Boolean flagHighlight;
    private ChessLabel[][] labels;
    private Boolean whitesMove;

    public Boolean getWhitesMove() {
        return whitesMove;
    }

    public void setWhitesMove(Boolean whitesMove) {
        this.whitesMove = whitesMove;
    }

    public void setLabel(ChessLabel labels, int r, int c) {
        this.labels[r][c] = labels;
    }

    public ChessLabel getLabel(int r, int c) {
        return labels[r][c];
    }

    public Boolean getFlagHighlight() {
        return flagHighlight;
    }

    public void setFlagHighlight(Boolean flagHighlight) {
        this.flagHighlight = flagHighlight;
    }

    public Board() {
        labels = new ChessLabel[8][8];
        flagHighlight = false;
        whitesMove = true;
        initialization();
    }


    public ChessPiece getChess(int c, int r) {
        return labels[r][c].getChessPiece();
    }


    public void setChess(int r, int c) {
        labels[r][c].setChessPiece(null);
        labels[r][c].setText("");
    }

    public void highlightChess(ArrayList<String> s, ChessPiece chessPiece) {
        for (String s1 : s) {
            labels[Integer.parseInt(s1.substring(0, 1))][Integer.parseInt(s1.substring(2, 3))].setHighlight(chessPiece);
        }
        flagHighlight = true;
    }

    public void removeTheLightFromChess() {
        for (ChessLabel[] label : labels) {
            for (int col = 0; col < labels[0].length; col++) {
                label[col].backHighlight();
            }
        }
        flagHighlight = false;
    }

    public boolean checkChess(int c, int r) {
        return c >= 0 && c < 8 && r >= 0 && r < 8 && getChess(c, r) == null;
    }

    public boolean checkChessColor(int c, int r, ChessPiece piece) {
        return c >= 0 && c < 8 && r >= 0 && r < 8
                && getChess(c, r) != null && !(getChess(c, r).getColor().equals(piece.getColor()));
    }

    public void display() {
        setTitle("playing chess");


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container contentPane = getContentPane();
        GridLayout gridLayout = new GridLayout(8, 8);

        contentPane.setLayout(gridLayout);


        for (int row = 0; row < labels.length; row++) {
            for (int col = 0; col < labels[0].length; col++) {
                labels[row][col].set(col, row);
                contentPane.add(labels[row][col]);
            }
        }
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        String str = "Оба партнёра должны играть по очереди, делая каждый раз один ход.\n " +
                     "Игрок, который имеет белые фигуры, начинает партию.";
        JOptionPane.showMessageDialog(this, str);
    }

    public void initialization() {

        labels[0][0] = new ChessLabel("\u2656", this, new Rook(Color.WHITE, "\u2656", 0, 0), 0, 0);
        labels[0][1] = new ChessLabel("\u2658", this, new Knight(Color.WHITE, "\u2658", 0, 1), 0, 1);
        labels[0][2] = new ChessLabel("\u2657", this, new Bishop(Color.WHITE, "\u2657", 0, 2), 0, 2);
        labels[0][3] = new ChessLabel("\u2655", this, new Queen(Color.WHITE, "\u2655", 0, 3), 0, 3);
        labels[0][4] = new ChessLabel("\u2654", this, new King(Color.WHITE, "\u2654", 0, 4), 0, 4);
        labels[0][5] = new ChessLabel("\u2657", this, new Bishop(Color.WHITE, "\u2657", 0, 5), 0, 5);
        labels[0][6] = new ChessLabel("\u2658", this, new Knight(Color.WHITE, "\u2658", 0, 6), 0, 6);
        labels[0][7] = new ChessLabel("\u2656", this, new Rook(Color.WHITE, "\u2656", 0, 7), 0, 7);
        labels[7][0] = new ChessLabel("\u265C", this, new Rook(Color.BLACK, "\u265C", 7, 0), 7, 0);
        labels[7][1] = new ChessLabel("\u265E", this, new Knight(Color.BLACK, "\u265E", 7, 1), 7, 1);
        labels[7][2] = new ChessLabel("\u265D", this, new Bishop(Color.BLACK, "\u265D", 7, 2), 7, 2);
        labels[7][3] = new ChessLabel("\u265B", this, new Queen(Color.BLACK, "\u265B", 7, 3), 7, 3);
        labels[7][4] = new ChessLabel("\u265A", this, new King(Color.BLACK, "\u265A", 7, 4), 7, 4);
        labels[7][5] = new ChessLabel("\u265D", this, new Bishop(Color.BLACK, "\u265D", 7, 5), 7, 5);
        labels[7][6] = new ChessLabel("\u265E", this, new Knight(Color.BLACK, "\u265E", 7, 6), 7, 6);
        labels[7][7] = new ChessLabel("\u265C", this, new Rook(Color.BLACK, "\u265C", 7, 7), 7, 7);

        for (int col = 0; col < labels[0].length; col++) {
            labels[1][col] = new ChessLabel("\u2659", this, new Pawn(Color.WHITE, "\u2659", 1, col), 1, col);
        }
        for (int col = 0; col < labels[0].length; col++) {
            labels[6][col] = new ChessLabel("\u265F", this, new Pawn(Color.BLACK, "\u265F", 6, col), 6, col);
        }
        for (int row = 2; row < 6; row++) {
            for (int col = 0; col < labels[0].length; col++) {
                labels[row][col] = new ChessLabel("", this, null,row,col);
            }
        }

    }
}