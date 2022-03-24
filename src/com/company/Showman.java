package com.company;

import java.util.*;

public class Showman {
    public static Showman instance;
    public static int prizeDoor;
    private static int usersChoice;
    private static int showmansChoice;


    private Showman(int revealedDoor) {
        prizeDoor = revealedDoor;
        System.out.println("Welcome to the \"Monty Hall problem\"");
        System.out.println("-----------------------------------------------------");
        System.out.println("You have a choice of three doors. Choose any of them!");
        System.out.println("+-+   +-+   +-+");
        System.out.println("|1|   |2|   |3|");
        System.out.println("+-+   +-+   +-+\n");
        System.out.println("To continue input the door number:");
        Scanner scanner = new Scanner(System.in);
        usersChoice = scanner.nextInt();
        sayChosenDoor();
    }

    public static Showman getInstance(int prizeDoor){
        if(instance == null){
            instance = new Showman(prizeDoor);
        }
        return instance;
    }

    public void sayChosenDoor(){
        System.out.println("You chose a door №" + usersChoice);
    }

    public void openDoor(int doorNum){
        System.out.println("---Showman opens the door №" + doorNum + "---");
        if (doorNum == prizeDoor){
            System.out.println("!!!you won a prize!!!");
            return;
        }
        System.out.println("---It's empty here---");
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

    public void askRedecide(){
        System.out.println("Would you like to change your selection?\n(y/n)");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        if (option.equals("y")){
            int buffer = 0;
            for (int i = 1; i < 4; i++) {
                if ((i != usersChoice) && (i != showmansChoice)){
                    buffer = i;
                }
            }
            usersChoice = buffer;
            sayChosenDoor();
            openDoor(usersChoice);
            return;
        }
        openDoor(usersChoice);
    }
}
