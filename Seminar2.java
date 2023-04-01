import java.util.Random;

public class Seminar2 {

    public static void main(String[] args) {
        int[] array = new int[] { 5, -4, 23, 9, -3, 0 };
        // int[] array = new int[100000];

        // for (int i = 0; i < array.length; i++) {
        //     array[i] = new Random().nextInt(-1000, 1000);
        // }
        // long start = System.currentTimeMillis();
        // bubbleSort(array);
        // long finish = System.currentTimeMillis();

        // long quickStart = System.currentTimeMillis();
        quickSort(array, 0, array.length - 1);
        // long quickFinish = System.currentTimeMillis();

        // System.out.println("Bubblesort: " + (finish - start));
        // System.out.println("Quicksort: " + (quickFinish - quickStart));
        
        System.out.println(binarySearch(23, array, 0, array.length));

        // for (int i = 0; i < array.length; i++) {
        // System.out.print(array[i] + " ");
        // }

    }

    public static int binarySearch(int value, int[] array, int min, int max) {
        int middle;
        if (max < min) {
            return -1;
        } else {
            middle = min + (max - min) / 2;
        }

        if (array[middle] < value) {
            return binarySearch(value, array, middle + 1, max);
        } else {
            if (array[middle] > value) {
            return binarySearch(value, array, min, middle - 1);
        } else {
            return middle;
        }
    }

    }

    public static void bubbleSort(int[] array) {
        boolean flag = true;
        do {
            flag = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                    flag = false;
                }
            }
        } while (!flag);
    }

    public static void quickSort(int[] array, int minposition, int maxposition) {

        int leftposition = minposition;
        int rightposition = maxposition;
        int pivot = array[(leftposition + rightposition) / 2];
        do {
            while (array[leftposition] < pivot) {
                leftposition++;
            }
            while (array[rightposition] > pivot) {
                rightposition--;
            }
            if (leftposition <= rightposition) {
                if (leftposition < rightposition) {
                    int temp = array[leftposition];
                    array[leftposition] = array[rightposition];
                    array[rightposition] = temp;
                }
                leftposition++;
                rightposition--;
            }
        } while (leftposition <= rightposition);

        if (leftposition < maxposition) {
            quickSort(array, leftposition, maxposition);
        }
        if (minposition < rightposition) {
            quickSort(array, minposition, rightposition);
        }

    }
}
