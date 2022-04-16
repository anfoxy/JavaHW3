package com.netcracker.ch8;

import java.util.ArrayList;

public class ComboLock {

    private int p1,p2,p3;
    private int currentPosition;
    private int secret1,secret2,secret3;
    private ArrayList<Integer> move = new ArrayList<Integer>();

    public ComboLock(int secret1, int secret2, int secret3) {
        this.secret1 = secret1;
        this.secret2 = secret2;
        this.secret3 = secret3;
        currentPosition = 0;
        p1=-1;
        p2=-1;
        p3=-1;
    }
    public void reset() {
        currentPosition =0;
        p1=-1;
        p2=-1;
        p3=-1;
        move.clear();
    }
    public void turnRight(int ticks) {

        if(currentPosition + ticks > 39) {
            int temp1 = 39 - currentPosition + 1;
            currentPosition = ticks - temp1;
        } else {
            currentPosition = currentPosition + ticks;
        }

        if(move.isEmpty()){
            p1 =currentPosition;
            move.add(1);
        }else if(move.get(move.size()-1)==1){
            p1 =currentPosition;
        }else {
            p3 =currentPosition;
            move.add(1);
        }
        System.out.println("currentPosition = "+currentPosition);
    }


    public void turnLeft(int ticks) {
        if(move.isEmpty()){
            System.out.println("don't move");
            return;
        }
        if(currentPosition - ticks < 0) {
            int temp1 = (currentPosition + 1) - ticks;
            temp1 = Math.abs(temp1);
            currentPosition = 39  - temp1;
        } else {
            currentPosition = currentPosition - ticks;
        }

       if(move.get(move.size()-1)==2){
            p2 =currentPosition;
        }else {
            p2 =currentPosition;
            move.add(2);
        }
        System.out.println("currentPosition = "+currentPosition);
    }

    public boolean open() {
        ArrayList<Integer> correctMoves = new ArrayList<Integer>();
        boolean unlocked=false;
        correctMoves.add(1);
        correctMoves.add(2);
        correctMoves.add(1);
        if(move.equals(correctMoves) && p1==secret1&&p2==secret2&&p3==secret3) {
            unlocked = true;
        }
        return unlocked;
    }

    @Override
    public String toString() {
        return "ComboLock{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", currentPosition=" + currentPosition;
    }
}
