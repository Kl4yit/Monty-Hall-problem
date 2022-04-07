package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] resArr = {0, 0} ;
        for (int j = 0; j < 1000; j++) {
            Door [] doors = new Door[3];
            Random rnd = new Random();
            int myRnd = rnd.nextInt(3);

            for (int i = 0; i < doors.length; i++) {
                if (i == myRnd){
                    doors[i] = new Door(true);
                    continue;
                }
                doors[i] = new Door(false);
            }
            Showman MontyHoll = Showman.getInstance(myRnd + 1);
            MontyHoll.chooseWrongDoor();
            int res = MontyHoll.askRedecide();
            resArr[res] += 1;
        }
        System.out.println(Arrays.toString(resArr));
    }
}
