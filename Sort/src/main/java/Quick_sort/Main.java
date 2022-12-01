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

    private static int cloison(int[] array, int start, int end) {
        int counter = start;
        int pivot = array[end];

        for (int i = start + 1; i < end; i++) {
            if (array[i] < pivot) {
                counter++;
                int tmp = array[counter];
                cloison(array, counter, i);
            }
        }
        cloison(array, start, counter);
        return counter;
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = cloison(array, start, end);
            quickSort(array, start, pivot - 1);
            quickSort(array, pivot + 1, end);
        }
    }
}