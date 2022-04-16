package com.netcracker.ch9.chesspiece;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class ChessLabel extends JLabel  implements MouseListener {

    Font font = new Font("Ariel", Font.PLAIN, 32);
    private Color currentColor;
    private ChessPiece chessPiece;
    private Board board;
    private Boolean flagCapture;
    private ChessPiece сaptureChess;
    private int col;
    private int row;

    ChessLabel(String s, Board board, ChessPiece chessPiece, int row,int col) {
        super(s);
        this.chessPiece = chessPiece;
        this.board = board;
        if (chessPiece != null) this.chessPiece.setLabel(this);
        flagCapture = false;
        сaptureChess = null;
        this.col=col;
        this.row=row;
        addMouseListener(this);

    }

    void changeChess(ChessPiece captureChess) {

        chessPiece = captureChess;
        chessPiece.setLabel(this);
        chessPiece.setCol(col);
        chessPiece.setRow(row);
        setText(captureChess.getName());

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (checkingCurrentFigureKing()) {
            JOptionPane.showMessageDialog(board, "Конец игры!");
            System.exit(1);
        } else {
            if (checkingPossibilityMove()) {
                if (!(board.getFlagHighlight())) {
                    if (chessPiece != null) board.highlightChess(chessPiece.canMoveTo(), chessPiece);
                } else {
                    if (flagCapture) {
                        int r = сaptureChess.getRow();
                        int c = сaptureChess.getCol();
                        changeChess(сaptureChess);
                        board.setChess(r, c);
                        board.setWhitesMove(!board.getWhitesMove());
                    }
                    board.removeTheLightFromChess();
                }
            }
        }
    }

    private boolean checkingPossibilityMove() {
        return chessPiece == null || сaptureChess != null ||
                (board.getWhitesMove() && chessPiece.getColor().equals(Color.WHITE)) ||
                (!board.getWhitesMove() && chessPiece.getColor().equals(Color.BLACK));
    }

    private boolean checkingCurrentFigureKing() {
        return chessPiece instanceof King && сaptureChess != null;
    }

    void setHighlight(ChessPiece captureChess) {
        setBackground(Color.GREEN);
        flagCapture = true;
        сaptureChess = captureChess;
    }

    void backHighlight() {
        setBackground(currentColor);
        flagCapture = false;
        сaptureChess = null;
    }

    void set(int idx, int row) {
        setFont(font);
        setOpaque(true);
        setBackground((idx + row) % 2 == 0 ? new Color(139, 69, 19) : new Color(222, 184, 135));
        currentColor = getBackground();
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    public ChessPiece getChessPiece() {

        return chessPiece;
    }

    public void setChessPiece(ChessPiece chessPiece) {

        this.chessPiece = chessPiece;
    }




    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {

        this.board = board;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}