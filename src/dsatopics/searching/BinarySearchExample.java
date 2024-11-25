package dsatopics.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchExample {

    static int arrEven[] = {2, 4, 5, 7, 9, 11, 14, 18};
    static int arrOdd[] = {2, 4, 5, 7, 9, 11, 14};
    static int arrOCC[] = {1, 2, 3, 3, 3, 5};
    static int arrMountain[] = {3, 4, 5, 8, 11, 15, 1, 2};
    static int sortedArr[] = {7, 8, 9, 10, 2, 3};
    static int rotatedArr[] = {4, 5, 6, 7, 0, 1, 2};
    static int rotatedArr2[] = {1, 3, 5};
    static ArrayList<Integer>arrList=new ArrayList<>(Arrays.asList(3, 4, 5, 8, 11, 15, 1, 2));
    public static void main(String[] args) {
        System.out.println("\n **********  Binary Search ***********");
//        System.out.println("\n Array Items size : " + arrEven.length);
//        System.out.println("\n Searched Items available at position : " + rightMostOccurence(arrOCC, 6, 3));
//        System.out.println("\n Total Items available in array : " + totalNoOfDuplicateItem(arrOCC, 6, 3));
//        System.out.println("\n Peek element in Mountain Array : " + peekItemInMountainArray(arrMountain, 8));
//        System.out.println("\n Pivot element in Sorted Array : " + pivotItemInSortedArray(rotatedArr, 7));
//        System.out.println("\n Squarer root of given number : " + squareRootAnyNumber(101));
//        System.out.println("\n Item in rotated sorted array : " + searchItemInRotatedArray(rotatedArr2, 1));
        System.out.println("\n Peak Item : " + findPeakElement(arrList));


    }


    /**
     * Search item using Binary search in sorted array
     *
     * @param arr
     * @param n
     * @param key
     * @return
     */
    static int binarySearchItem(int[] arr, int n, int key) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

//    Find the left most occurence in sorted array

    /**
     * Find the left most occurence in sorted array.
     *
     * @param arr
     * @param n
     * @param key
     * @return
     */
    private static int leftMostOccurence(int[] arr, int n, int key) {
        int left = 0;
        int right = n - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                ans = mid;
                right = mid - 1;
            } else if (key > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /**
     * find the right most occurence in sorted array
     *
     * @param arr
     * @param n
     * @param key
     * @return
     */
    private static int rightMostOccurence(int[] arr, int n, int key) {
        int left = 0;
        int right = n - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                ans = mid;
                left = mid + 1;
            } else if (key > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /**
     * Find the total no of duplicate element in array
     *
     * @param arr
     * @param n
     * @param key
     * @return
     */
    private static int totalNoOfDuplicateItem(int[] arr, int n, int key) {
        int noOfLeftMostOcc = leftMostOccurence(arr, n, key);
        int noRightMostOcc = rightMostOccurence(arr, n, key);
        return (noRightMostOcc - noOfLeftMostOcc) + 1;
    }


    /**
     * Find the peek element in Mountain Array
     *
     * @param arr
     * @param n
     * @return
     */
    private static int peekItemInMountainArray(int[] arr, int n) {
        int left = 0;
        int right = n - 1;
        int mid = left + (right - left) / 2;
        while (left < right) {
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
            mid = left + (right - left) / 2;
        }
        return arr[left];
    }

    static int pivotItemInSortedArray(int[] arr, int n) {
        int left = 0;
        int right = n - 1;
        int mid = left + (right - left) / 2;
        while (left < right) {
            if (arr[mid] >= arr[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
            mid = left + (right - left) / 2;
        }
        return arr[left];
    }

    static int searchItemInRotatedArray(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == right) {
            if (nums[left] == target)
                return left;
        }
        return -1;
    }

    /**
     * Find the square root of given number using Binary search
     *
     * @param n
     * @return
     */
    static int findSquareRootInt(int n) {
        int ans = -1;
        int start = 0;
        int end = n - 1;
        int mid = start + (end - start) / 2;
        while (start <= end) {
            int square = mid * mid;
            if (square == n) {
                return mid;
            } else if (square < n) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return ans;
    }

    private static double morePrecision(int n, int precision, int temSol) {
        double factor = 1;
        double ans = temSol;

        for (int i = 0; i < precision; i++) {
            factor = factor / 10;
            for (double j = ans; j * j < n; j = j + factor) {
                ans = j;
            }
        }
        return ans;
    }

    /**
     * Square root of Any number using Binary Search
     *
     * @param n
     * @return
     */
    private static double squareRootAnyNumber(int n) {
        int tempSol = findSquareRootInt(n);

        return morePrecision(n, 3, tempSol);
    }

    public static int findPeakElement(List<Integer> a) {
        // Code here
        int start = 0, end = a.size()-1,mid;
        while (start <= end) {
             mid = end + (start - end) / 2;
            if (a.get(mid) > a.get(mid - 1) && a.get(mid) > a.get(mid + 1)) {
                return mid;
            } else if (a.get(mid) > a.get(mid - 1)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
