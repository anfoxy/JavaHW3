package com.netcracker.ch9.employee;

public abstract class Employee {
    protected String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   public abstract double weeklyPay(int s);

}
