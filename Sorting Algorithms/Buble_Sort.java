import java.util.Scanner;

public class Buble_Sort {
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
            intArray[i]= Integer.parseInt(String_Array[i]);
        }


        BubleSort(intArray);
        for (int i = 0; i < intArray.length; i++) {


            System.out.print(intArray[i] + " ");
        }
    }

    public static void BubleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    if (j == j + 1) {
                        return;
                    }
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
    }
}
