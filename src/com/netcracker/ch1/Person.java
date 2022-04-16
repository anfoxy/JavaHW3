package com.netcracker.ch1;

public class Person {
    private String name;
    private String friends;
    private int friendCount;

    public Person(String name) {
        this.name = name;
        friendCount=0;
    }
    public void befriend(Person p){
        friendCount++;
        if(friends==null)friends="";
        friends += p.getName()+ " ";
    }
    public void unfriend(Person p){
        String s =friends;
        friends = friends.replaceAll(p.getName()+" ", "");

        if(!s.equals(friends))friendCount--;
    }
    public int getFriendCount(){
        return friendCount;
    }

    public String getName() {
        return name;
    }

    public String getFriendNames(){
     return friends;
    }
}
