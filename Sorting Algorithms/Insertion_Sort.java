package com.company;

import java.util.Scanner;

public class Insertion_Sort {
    /***
     **
     * Created 19.04.2021
     * By: Ahmed E.A.I
     *
     *
     **
     ***/
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String[] String_Array = line.split(" ");
        int[] intarray = new int[String_Array.length];
        for (int i = 0; i < String_Array.length; i++) {
            intarray[i] = Integer.parseInt(String_Array[i]);
        }

        Insertion_sort(intarray);
        for (int i = 0; i < intarray.length; i++) {
            System.out.print(intarray[i] + " ");

        }
    }

    private static void Insertion_sort(int[] array) {
        for (int UnsortedArray = 1; UnsortedArray < array.length;
             UnsortedArray++) {
            int Element = array[UnsortedArray];
            int i;
            for (i = UnsortedArray; i > 0 && array[i - 1] > Element; i--) {
                array[i] = array[i - 1];
            }
            array[i] = Element;
        }
    }
}
