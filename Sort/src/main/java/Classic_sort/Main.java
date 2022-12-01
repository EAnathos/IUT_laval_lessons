package Classic_sort;

import java.util.Arrays;
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

        //sort with Arrays.sort()
        Arrays.sort(array);

        //Print the sorted array.
        System.out.println("Sorted array:");
        for (int i = 0; i < arrayLength; i++) {
            System.out.print(array[i] + " ");
        }
    }
}