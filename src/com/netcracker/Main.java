package com.netcracker;

import com.netcracker.ch1.*;
import com.netcracker.ch8.ComboLock;
import com.netcracker.ch9.Clock;
import com.netcracker.ch9.WorldClock;
import com.netcracker.ch9.chesspiece.Board;
import com.netcracker.ch9.employee.Employee;
import com.netcracker.ch9.employee.HourlyEmployee;
import com.netcracker.ch9.employee.Manager;
import com.netcracker.ch9.employee.SalariedEmployee;

public class Main {
    public static void main (String[] args) {
        testCashRegister();
        testSheet();
        testPerson();
        testStudent();
        testBattery();
        testComboLock();
        testEmployee();
        testClock();
        testChess();
    }
    static void testCashRegister(){
        CashRegister register = new CashRegister(7);

        register.recordPurchase(34.00);
        register.recordPurchase(20.00);
        register.recordPurchase(3.40);
        register.recordPurchase(6.97);
        register.recordPurchase(12.56);
        register.recordPurchase(24.9);
        register.recordPurchase(13.23);
        register.recordPurchase(63.4);
        register.recordPurchase(13.3);
        register.recordPurchase(14.2);
        register.giveChange();
        System.out.println("Sales Count: " + register.getItemCount());
        System.out.println("Expected:    10");
        System.out.println("Total Sales: " + register.getTotalTax());
        System.out.println("Expected:    205.96");

        CashRegister register1 = new CashRegister(7);
        register1.recordTaxablePurchase(59.99);
        register1.recordPurchase(10.00);
        register1.recievePayment(100);
        System.out.println("=================");
        System.out.println("Change: " + register1.giveChange());
        System.out.println("=================");
        System.out.println("Sales Count: " + register1.getItemCount());
        System.out.println("Expected:    2");
        System.out.println("Total Sales: " + register1.getTotalTax());
        System.out.println("Expected:    74.1893");
        System.out.println("======================================");
    }
    static void testSheet(){
        Sheet s = new Sheet();
        System.out.println(s);

        Sheet s1 =s.cutInHalf();
        System.out.println(s1);

        Sheet s2 =s1.cutInHalf();
        System.out.println(s2);

        Sheet s3 =s2.cutInHalf();
        System.out.println(s3);
        System.out.println("======================================");
    }
    static void testPerson(){
        Person p = new Person("Петя");
        Person p1 = new Person("Катя");
        Person p2 = new Person("Паша");
        Person p3 = new Person("Маша");
        Person p4 = new Person("Иван");
        System.out.println(p.getFriendNames());
        System.out.println("Friend Count = "+p.getFriendCount());
        System.out.println("Add "+p1.getName());
        p.befriend(p1);
        System.out.println("Add "+p2.getName());
        p.befriend(p2);
        System.out.println("Add "+p3.getName());
        p.befriend(p3);
        System.out.println("Add "+p4.getName());
        p.befriend(p4);
        System.out.println("Friend = "+p.getFriendNames());
        System.out.println("Friend Count = "+p.getFriendCount());
        System.out.println("unfriend "+p1.getName());
        p.unfriend(p1);
        System.out.println("Friend = "+p.getFriendNames());
        System.out.println("Friend Count = "+p.getFriendCount());
        System.out.println("unfriend "+p3.getName());
        p.unfriend(p3);
        System.out.println("Friend = "+p.getFriendNames());
        System.out.println("Friend Count = "+p.getFriendCount());
        System.out.println("Add "+p1.getName());
        p.befriend(p1);
        System.out.println("Friend = "+p.getFriendNames());
        System.out.println("Friend Count = "+p.getFriendCount());
        System.out.println("unfriend "+p3.getName());
        p.unfriend(p3);
        System.out.println("Friend = "+p.getFriendNames());
        System.out.println("Friend Count = "+p.getFriendCount());
        System.out.println("======================================");
    }
    static void testStudent(){
        Student student = new Student("Петя");

        student.addQuiz(50);
        student.addQuiz(35);
        student.addQuiz(100);
        student.addQuiz(75);

        System.out.println("Student Name: " + student.getName());
        System.out.println("Expected:     Петя");
        System.out.println("Total Score: " + student.getTotalScore());
        System.out.println("Expected:    260");
        System.out.println("Average Score: " + student.getAverageScore());
        System.out.println("Expected:      65.0");
        System.out.println("Get quiz count: " + student.getQuizCount());
        System.out.println("Expected:       4");
        System.out.println("======================================");
    }
    static void testBattery(){
        Battery aa = new Battery(2500);
        System.out.println("remaining capacity = "+aa.getRemainingCapacity());
        System.out.println("Expected:            2500.0");
        aa.drain(600);
        aa.drain(300);

        System.out.println("remaining capacity = "+aa.getRemainingCapacity());
        System.out.println("Expected:            1600.0");

        aa.charge();
        System.out.println("remaining capacity = "+aa.getRemainingCapacity());
        System.out.println("Expected:            2500.0");
        System.out.println("======================================");
    }
    static void testComboLock(){
        ComboLock comboLock = new ComboLock(10,5,15);
        System.out.println("set ComboLock(10,5,15)");
        System.out.println(comboLock);
        comboLock.turnLeft(56);
        comboLock.turnRight(10);
        comboLock.turnLeft(5);
        comboLock.turnRight(10);
        System.out.println(comboLock);
        System.out.println(comboLock.open());
        System.out.println("Expected: true");
        System.out.println("=========================");
        ComboLock comboLock1 = new ComboLock(20,30,10);
        System.out.println("set ComboLock(20,30,10)");
        System.out.println(comboLock1);
        comboLock1.turnLeft(56);
        comboLock1.turnRight(10);
        comboLock1.turnRight(10);
        System.out.println(comboLock1);
        comboLock1.turnLeft(20);
        comboLock1.turnLeft(10);
        comboLock1.turnRight(20);
        System.out.println(comboLock1);
        System.out.println(comboLock1.open());
        System.out.println("Expected: true");
        System.out.println("=========================");
        ComboLock comboLock2 = new ComboLock(20,30,10);
        System.out.println("set ComboLock(20,30,10)");
        System.out.println(comboLock2);
        comboLock2.turnLeft(56);
        comboLock2.turnRight(20);
        comboLock2.turnRight(10);
        System.out.println(comboLock2);
        comboLock2.turnLeft(40);
        comboLock2.turnRight(50);
        System.out.println(comboLock2);
        System.out.println(comboLock2.open());
        System.out.println("Expected: false");
        System.out.println("======================================");
    }
    static void testEmployee(){
        Employee[] staff = new Employee[3];
        staff[0] = new HourlyEmployee("Morgan, Harry", 30);
        staff[1] = new SalariedEmployee("Lin, Sally", 52000);
        staff[2] = new Manager("Smith, Mary", 104000, 50);
        for (Employee e : staff)
        {
            System.out.print("Hours worked by " + e.getName() + ": ");
            int hours = 20;
            System.out.println("Salary: " + e.weeklyPay(hours));
        }
        System.out.println("======================================");
    }
    static void testClock(){
        Clock clock = new Clock();
        System.out.println("time: "+clock.getTime());
        WorldClock worldClock = new WorldClock(10);
        System.out.println("time: "+worldClock.getTime() +" (+3)");
        clock.setAlarm(2,30);
        System.out.println("time: "+clock.getTime());
        worldClock.setAlarm(1,30);
        System.out.println("time: "+worldClock.getTime());
        clock.setAlarm(23,50);
        System.out.println("time: "+clock.getTime());
        System.out.println("======================================");
    }
    static void testChess(){
        Board board = new Board();
        board.display();

    }
}
