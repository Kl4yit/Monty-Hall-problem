package com.company;

import java.util.*;

public class Showman {
    public static Showman instance;
    public static int prizeDoor;
    private static int usersChoice;
    private static int showmansChoice;
    public static String option;


    private Showman(int revealedDoor) {
        prizeDoor = revealedDoor;
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        usersChoice = rnd.nextInt(3) + 1;
        sayChosenDoor();
    }

    public static Showman getInstance(int prizeDoor){
        if(instance == null){
            instance = new Showman(prizeDoor);
            Random rnd = new Random();
            usersChoice = rnd.nextInt(3) + 1;
            return instance;
        }
        Random rnd = new Random();
        usersChoice = rnd.nextInt(3) + 1;
        instance.prizeDoor = prizeDoor;
        return instance;
    }

    public void sayChosenDoor(){
    }

    public int openDoor(int doorNum){
        if (doorNum == prizeDoor){
            return 1;
        }
        return 0;
    }

    public void chooseWrongDoor(){
        int [] nums = {1, 2, 3};
        if (usersChoice == prizeDoor){
            nums = deleteElement(nums, usersChoice -1);
            Random rnd = new Random();
            openDoor(nums[rnd.nextInt(2)]);
            showmansChoice = nums[rnd.nextInt(2)];
            return;
        } else if (usersChoice > prizeDoor){
            nums = deleteElement(nums, usersChoice - 1);
            nums = deleteElement(nums, prizeDoor - 1);
        } else {
            nums = deleteElement(nums, prizeDoor - 1);
            nums = deleteElement(nums, usersChoice - 1);

        }
        openDoor(nums[0]);
        showmansChoice = nums[0];
    }

    public int [] deleteElement(int [] intArray, int indexToDelete){
        int [] result = new int[intArray.length];
        System.arraycopy(intArray, 0, result, 0, indexToDelete);
        System.arraycopy(intArray, indexToDelete + 1, result, indexToDelete, intArray.length - indexToDelete - 1);
        return  result;
    }

    public int askRedecide(){
        if (option.equals("y")){
            int buffer = 0;
            for (int i = 1; i < 4; i++) {
                if ((i != usersChoice) && (i != showmansChoice)){
                    buffer = i;
                }
            }
            usersChoice = buffer;
            sayChosenDoor();
            return openDoor(usersChoice);
        }
        return openDoor(usersChoice);
    }
}
