package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("User always redicide:");
        solve("y");

        System.out.println("User never redicide:");
        solve("n");

        System.out.println("User choose randomly:");
        solve("r");
    }

    public static void solve(String option){
        String[] strarr = {"y", "n"};
        int[] resArr = {0, 0} ;
        Showman MontyHoll = Showman.getInstance(1);
        Random rnd = new Random();
        MontyHoll.option = option;
        for (int j = 0; j < 1000; j++) {
            if (option.equals("r")){
                MontyHoll.option = strarr[rnd.nextInt(2)];
            }
            Door [] doors = new Door[3];
            int myRnd = rnd.nextInt(3);

            for (int i = 0; i < doors.length; i++) {
                if (i == myRnd){
                    doors[i] = new Door(true);
                    continue;
                }
                doors[i] = new Door(false);
            }
            MontyHoll = Showman.getInstance(myRnd + 1);
            MontyHoll.chooseWrongDoor();
            int res = MontyHoll.askRedecide();
            resArr[res] += 1;
        }
        System.out.println(Arrays.toString(resArr));
    }
}
