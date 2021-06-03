package Arrays_Lists;

/***
 *
 * created by: Ahmed ELsaid A.I.A
 *
 * 1.06.2021
 *
 * **/
public class Sorting {
    public static void main(String[] args) {
        int[] array = {20, 35, -15, 7, 55, 1, -22};
//        BubbleSort(array);
//        SelectionSort(array);
//        InsertionSort(array);
//        ShellSort(array);
//        mergeSort(array, 0, array.length);
//        quickSort(array, 0, array.length);
//        countingSort(array, -22, 55);
//        int[] radixArray = { 4725, 4586, 1330, 8792, 1594, 5729 };
//        radixSort(radixArray, 10, 4);
        printArray(array);
    }
    /*** RadixSort*/
    //{ 4725, 4586, 1330, 8792, 1594, 5729 }
    public static void radixSort(int[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(int[] input, int position, int radix) {
        int numItems = input.length;
        int[] countArray = new int[radix];
        for (int value: input) {
            countArray[getDigit(position, value, radix)]++;
        }
        // Adjust the count array
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }
        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] =
                    input[tempIndex];
        }
        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
    }
    public static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }

    /*** countingSort*/
    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void countingSort(int[] input, int min, int max) {
        int[] countArray = new int[(max - min) + 1];
        for (int i = 0; i < input.length; i++) {
            countArray[input[i] - min]++;
        }
        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
                input[j++] = i;
                countArray[i - min]--;
            }
        }
    }

    /*** QuickSort*/
    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void quickSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);
//        for (int i = 0; i < input.length; i++) {
////            System.out.println(input[i]);
//        }
        quickSort(input, pivotIndex + 1, end);
    }

    public static int partition(int[] input, int start, int end) {
        // This is using the first element as the pivot
        int pivot = input[start];
        int i = start;
        int j = end;
        while (i < j) {
            // NOTE: empty loop body
            while (i < j && input[--j] >= pivot) ;
            if (i < j) {
                input[i] = input[j];
            }
            // NOTE: empty loop body
            while (i < j && input[++i] <= pivot) ;
            if (i < j) {
                input[j] = input[i];
            }
        }
        input[j] = pivot;
        return j;
    }

    /*** MergeSort*/
    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void mergeSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void merge(int[] input, int start, int mid, int end) {
        if (input[mid - 1] <= input[mid]) {
            return;
        }
        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }

    /*** ShellSort*/
    // { 20, 35, -15, 7, 55, 1, -22 }
    public static int[] ShellSort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int NewElement = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > NewElement) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = NewElement;
            }
        }
        return array;
    }

    /*** InsertionSort*/
    // { 20, 35, -15, 7, 55, 1, -22 }
    public static int[] InsertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int NewElement = array[i];
            int j;
            for (j = i; j > 0 && array[j - 1] > NewElement; j--) {
                array[j] = array[j - 1];
            }
            array[j] = NewElement;
        }
        return array;
    }

    /*** SelectionSort*/
    // { 20, 35, -15, 7, 55, 1, -22 }
    public static int[] SelectionSort(int[] array) {

        boolean flag = true;
        while (flag) {
            int temp;
            for (int i = array.length - 1; i > 0; i--) {
                int largest = 0;
                for (int j = 1; j <= i; j++) {
                    if (array[j] > array[largest]) {
                        largest = j;
                    }
                }
                temp = array[largest];
                array[largest] = array[i];
                array[i] = temp;
            }
            flag = false;
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /*** BubbleSort*/
    // { 20, 35, -15, 7, 55, 1, -22 }
    public static int[] BubbleSort(int[] array) {
        boolean flag = false;
        while (!flag) {
            int temp;
            for (int i = array.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (array[j] > array[j + 1]) {
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    } else
                        flag = true;
                }
            }
        }
        return array;
    }
}
