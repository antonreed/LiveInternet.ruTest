package com.antonreed;

public class LoginStep {

    public void restart(){
        System.out.println("restart");
    }

    public void start(){
        System.out.println("start");
        System.out.println("stop");
    }

    public void stop(){
        System.out.println("stop");
        System.out.println("start");
    }
}
