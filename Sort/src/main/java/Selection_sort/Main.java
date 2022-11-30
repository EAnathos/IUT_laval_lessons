package Selection_sort;

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

        //Sort by selection.
        for (int i = 0; i < arrayLength; i++) {
            int min = array[i];
            int min_i = i;

            for (int j = i + 1; j < arrayLength; j++) {
                if (array[j] < min) {
                    min = array[j];
                    min_i = j;
                }
            }

            if (i != min_i) {
                int tmp = array[i];
                array[i] = array[min_i];
                array[min_i] = tmp;
            }
        }

        //Print the sorted array.
        System.out.println("Sorted array:");
        for (int i = 0; i < arrayLength; i++) {
            System.out.print(array[i] + " ");
        }
    }
}