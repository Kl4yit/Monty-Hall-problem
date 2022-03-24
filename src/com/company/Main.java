package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Door [] doors = new Door[3];
        Random rnd = new Random();
        int myRnd = rnd.nextInt(3);
        System.out.println(myRnd + 1);
        for (int i = 0; i < doors.length; i++) {
            if (i == myRnd){
                doors[i] = new Door(true);
                continue;
            }
            doors[i] = new Door(false);
        }
        Showman MontyHoll = Showman.getInstance(myRnd + 1);
        MontyHoll.chooseWrongDoor();
        MontyHoll.askRedecide();
    }
}
