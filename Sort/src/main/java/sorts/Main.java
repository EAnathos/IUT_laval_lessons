package sorts;

import java.util.*;

public class Main {
    static int [] array;
    static int [] arrayCopy;
    static int n=100000;
    static boolean DISPLAY=false;
    public static void main(String[] args) {
        //Get the array.
        long start,stop;  //sert pour calculer le temps des tris

        array = new int[n];

        Random r=new Random();
        for(int i=0;i<=n-1;i++)
            array[i]=r.nextInt(1000);	//We fill the array randomly

        arrayCopy=(int[]) array.clone(); // We keep a copy in order to apply different methods of sorting.

        if(DISPLAY) printArray();
        System.out.println();

        start = System.nanoTime();
        selectionSort();
        stop = System.nanoTime();

        if(DISPLAY) printArray();

        System.out.println("time of the select sort : " + (float) (stop - start)/1000000 +" ms\n");

        array=(int[]) arrayCopy.clone(); // Reset the array

        start = System.nanoTime();
        classicSort();
        stop = System.nanoTime();

        if(DISPLAY) printArray();

        System.out.println("Time of the insertion sort : " + (float) (stop - start)/1000000 +" ms\n");

        array=(int[]) arrayCopy.clone(); // Reset the array

        start = System.nanoTime();
        mergeSort(array,0,n-1);
        stop = System.nanoTime();

        if(DISPLAY) printArray();

        System.out.println("Time of the merge sort : " + (float) (stop - start)/1000000 +" ms\n");

        array=(int[]) arrayCopy.clone(); // Reset the array

        start = System.nanoTime();
        classicSort();
        stop = System.nanoTime();

        if(DISPLAY) printArray();

        System.out.println("Time of the classic Java sort : " + (float) (stop - start)/1000000 +" ms\n");
    }
    public static void printArray(){
        System.out.print("The Array :");

        for(int i=0;i<=n-1;i++)
            System.out.print(" "+array[i]);

        System.out.println(".");

    }

    public static void classicSort() {
        Arrays.sort(array);
    }

    public static void selectionSort(){
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int min_i = i;

            for (int j = i + 1; j < array.length; j++) {
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
    }

    public static void insertionSort() {
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;

            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = current;
        }
    }

    private static void merge (int[] array, int left, int middle, int right) {
        int leftLength = middle - left + 1;
        int rightLength = right - middle;

        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];

        //We copy the arrays in another arrays.
        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = array[left + i];
        }

        for (int i = 0; i < rightLength; i++) {
            rightArray[i] = array[middle + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        /* This one is useless because, it will always be the first array which will be sorted first.
        while (j < rightLength) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
        */
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

}