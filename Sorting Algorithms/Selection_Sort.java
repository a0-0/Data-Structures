package com.company;

import java.util.Scanner;

public class Selection_Sort {
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
        String User_String = input.nextLine();
        String[] String_Array = User_String.split(" ");
        int[] intArray = new int[String_Array.length];
        for (int i = 0; i < String_Array.length; i++) {
            intArray[i] = Integer.parseInt(String_Array[i]);
        }

        Selection_Sort(intArray);

        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
    }

    private static void Selection_Sort(int[] array) {
        int largest = 0;
        int temp;
        for (int lastunsorted = array.length-1 ; lastunsorted > 0; lastunsorted--) {
            for (int j = 0; j <=lastunsorted; j++) {
                if (array[largest] < array[j]) {
                    largest = j;
                }
            }
            if (largest == lastunsorted) {
                return;
            }
            temp = array[lastunsorted];
            array[lastunsorted] = array[largest];
            array[largest] = temp;
        }
    }
}
