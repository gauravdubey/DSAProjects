package dsatopics.sorting;

public class SortingExamples {
    static int arr[] = {4, 3, 6, 7, 0, 1, 2};
    static int arr2[] = {4, 0, 1, 2};

    public static void main(String[] args) {
        System.out.println("\n **********  Sorting Example ***********");
//        selectionSort(arr);
//        bubbleSort(arr2);
        insertionSort(arr);
    }

    /**
     * Selection Sort
     *
     * @param arr
     */
    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
            System.out.println();
        }

    }

    /**
     * Bubble sort
     *
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean isSwapped;
        for (int i = 1; i < n; i++) {
            isSwapped = false;
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped)
                break;
        }
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    /**
     * Insertion Sort
     *
     * @param arr
     */
    private static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    private static void mergeSort(int[] arr) {

    }

    private static void quickSort(int[] arr) {

    }

    private static void heapSort(int[] arr) {

    }
}
