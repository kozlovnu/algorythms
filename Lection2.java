// массивы

// методы сортировки
// 

public class Lection2 {
    public static void main(String[] args) {
        int[] array = new int[] { 42, 6, 4, 8, 11, 45, 0 };
        // bubblesort(array);
        // directSort(array);
        // insertSort(array);
        System.out.println(findIndex(4, array));
        System.out.println(binarySearch(4, array));
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public static void bubblesort(int[] array) { // сортировка пузырьком O(n^2)
        boolean finish = true;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    finish = false;
                }
            }
        } while (!finish);
    }

    // сортировка выбором O(n^2)
    public static void directSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPosition]) {
                    minPosition = j;
                }
            }
            if (i != minPosition) {
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
    }

    // сортировка вставками O(n^2)
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    // простой поиск
    public static int findIndex(int value, int array[]){
        for(int i = 0; i < array.length; i++){
            if (array[i] == value){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int value, int[] array){
        return binarySearch(value, array, 0, array.length-1);
    }

    // бинарный поиск
    public static int binarySearch(int value, int[] array, int min, int max){
        int midpoint;
        if (max < min){
            return -1;
        } else {
            midpoint = (max - min) / 2 + min;
        }

        if (array[midpoint] < value){
            return binarySearch(value, array, midpoint + 1, max);
        } else{
            if (array[midpoint] > value){
                return binarySearch(value, array, min, midpoint -1);
            } else {
                return midpoint;
            }
        }
    }
}
