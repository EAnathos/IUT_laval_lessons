package Quick_sort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Get the array size and values.
        Scanner scan = new Scanner(System.in);

        System.out.println("How many values do you want in your array ?");
        int arrayLength = scan.nextInt();

        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            System.out.println("Enter the value of the " + (i + 1) + " element of the array");
            array[i] = scan.nextInt();
        }

        //Quick sort.
        quickSort(array, 0, arrayLength - 1);

        //Print the sorted array.
        System.out.println("Sorted array:");
        for (int i = 0; i < arrayLength; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static int partition(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = begin - 1, j = end + 1;
        while (true) {
            j--;
            while (array[j] > pivot) {
                i++;
            }
            while (array[i] < pivot) {
                if(i < j) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                } else {
                    return j;
                }
            }
        }
    }

    private static void quickSort(int[] array, int begin, int end) {
        int partitionIndex;
        if (begin < end) {
            partitionIndex = partition(array, begin, end);
            quickSort(array, begin, end);
            quickSort(array, end + 1, end);
        }
    }
}