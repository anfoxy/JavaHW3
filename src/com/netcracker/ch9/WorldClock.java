package com.netcracker.ch9;

public class WorldClock extends Clock{
   private int timeOffset;
    public WorldClock(int timeOffset) {
        this.timeOffset= timeOffset;
    }

    @Override
    public int getHours() {
       int r = super.getHours()+timeOffset;
        return r >= 24 ? r - 24 : r;

    }

    @Override
    public int getMinutes() {
        return super.getMinutes();
    }
}
