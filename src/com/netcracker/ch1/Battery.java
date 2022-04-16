package com.netcracker.ch1;

public class Battery {
    private double currentCapacity;
    private double batteryCapacity;

    public Battery(double capacity) {
        if(capacity<2000)capacity=2000;
        if(capacity>3000)capacity=3000;
        batteryCapacity = capacity;
        currentCapacity = capacity;
    }


    public void drain(double amount) {

        currentCapacity = currentCapacity - amount;
        if(currentCapacity<0)currentCapacity=0;
    }


    public void charge() {
        currentCapacity = batteryCapacity;
    }


    public double getRemainingCapacity() {
        return currentCapacity;
    }
}