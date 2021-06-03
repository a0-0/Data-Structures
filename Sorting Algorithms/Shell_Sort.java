package com.company;

import java.util.Scanner;

public class Shell_Sort {
    /***
     **
     * it depends on  gap  but in worst cases
     * it  will be
     * time =  n^2
     *
     * but in other cases it will  be more better
     * and faster
     **
     ***/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String User_String = input.nextLine();
        String[] String_Array = User_String.split(" ");
        int[] intArray = new int[String_Array.length];
        for (int i = 0; i < String_Array.length; i++) {
            intArray[i] = Integer.parseInt(String_Array[i]);
        }
        Shell_Sort(intArray);
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
    }

    public static void Shell_Sort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int element = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > element) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = element;
            }
        }
    }
}
