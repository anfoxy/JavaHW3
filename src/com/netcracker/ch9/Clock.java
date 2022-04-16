package com.netcracker.ch9;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;

public class Clock {
    private int alarmHours;
    private int alarmMinutes;
    public Clock(){
        alarmHours=25;
        alarmMinutes=25;
    }

    public int getHours(){
        return Integer.parseInt(java.time.LocalTime.now().toString().substring(0,2));

    }
    public int getMinutes(){
        return Integer.parseInt(java.time.LocalTime.now().toString().substring(3,5));
    }
    public String getTime(){
        int a= getHours();
        int b =getMinutes();
       if((alarmHours==getHours() && alarmMinutes<=getMinutes()) || alarmHours<getHours()){
            alarmHours=25;
            alarmMinutes=25;
            return getHours() + ":" + getMinutes()+ " Alarm!";
        }else  return getHours() + ":" + getMinutes();

    }
    public void setAlarm(int hours, int minutes){

        alarmHours=hours;
        alarmMinutes = minutes;
        System.out.println("the alarm clock is set for "+alarmHours+":"+alarmMinutes);
    }
}
