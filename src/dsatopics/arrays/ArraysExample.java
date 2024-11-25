package dsatopics.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ArraysExample {
    static int[] arr = {1, 2, 3, 7, 5};
    static int[] arr2 = {1, 2, 3, 5, 6, 7};

    static int[] arr3 = {142, 112, 54, 69, 148, 45, 63, 158, 38, 60, 124, 142, 130, 179, 117,
            36, 191, 43, 89, 107, 41, 143, 65, 49, 47, 6, 91, 130, 171, 151, 7, 102, 194, 149,
            30, 24, 85, 155, 157, 41, 167, 177, 132, 109, 145, 40, 27, 124, 138, 139, 119, 83, 130,
            142, 34, 116, 40, 59, 105, 131, 178, 107, 74, 187, 22, 146, 125, 73, 71, 30, 178, 174, 98, 113};
    static int[] arr4 = {11, 12, 70, 37, 30, 63, 49, 12, 32, 63, 12, 51, 64, 45, 8,67, 34, 1, 17, 67, 55, 23, 11, 42, 65, 73, 41,
            67, 67, 53, 29, 28, 49, 36, 38, 34, 21, 55, 14, 55, 33, 33, 23, 48, 14, 14, 1 ,41, 4, 10, 37, 16, 61, 73, 18, 24, 73,
            51, 57, 23, 32, 66, 7, 63, 61, 24, 18, 9};
    static int[] arr5 = {-1, -100, 3, 99};
    static int[] nums = {1, 2, 3, 4, 5, 6, 7};
    static int[] nums1 = {1, 2, 3};
    static int[] prices = {7, 1, 5, 3, 6, 4};
    static int[] prices2 = {3, 3, 5, 0, 0, 3, 1, 4};
    static int[] arr6 ={0, 2, 1, 2, 0};
    public static void main(String[] args) {
        System.out.println("This is DS Sample Programs!!");
//        System.out.println("\n Input of program = " + arr.length);
//        System.out.println("Output Programs == "+ minofArray(arr,6));
//        System.out.println("Missing Number is  = " + missingNum(arr2, 6));
//        reverseOfArray(arr2, 3, 5);
//        printNumber(10);
//        minMaxOfArray(arr,6);
//        subarraySum(arr3, 74, 665);
//        subArrayOfSum(arr,5,12);
//        System.out.println("Duplicate Items list : "+duplicateItems(arr4,6));
//        printRepeating(arr6,5);
//        rotateArray(arr5,2);
//        rotateArrayOptimized(nums,3);
//        maxProfit(prices);
        maxProfit2(prices);
//        duplicates(arr4);
        int []arr ={1,2,3,4};
//        rotateArrayByIndex(arr);
    }

    /**
     * Sum of Array of lenth n
     *
     * @param arr
     * @param n   - lenth of array
     * @return
     */
    private static int sumOfArray(int[] arr, int n) {
        if (n == 0)
            return n;
        else
            return arr[n - 1] + sumOfArray(arr, n - 1);
    }

    /**
     * Reverse the array from index l to index k
     *
     * @param arr
     * @param l   - start index
     * @param k   - end index
     */
    private static void reverseOfArray(int[] arr, int l, int k) {
        int temp = 0;
        while (l < k) {
            temp = arr[l];
            arr[l] = arr[k];
            arr[k] = temp;
            l++;
            k--;
        }
        // Print the array
        System.out.println("\n Update Array ");
        for (int j : arr) {
            System.out.println(" " + j);
        }
    }

    /**
     * Rotate the array by index
     * @param arr
     */
    private static void rotateArrayByIndex(int[] arr){
        // Input = { 1,2,3,4 }
        //Output = {2,1,4,3}

        for (int i = 0; i <arr.length ; i=i+2) {
            int temp=arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(" "+arr[i]);
        }
    }

    /**
     * Rotate Array by K times
     *
     * @param nums
     * @param k
     */
    public static void rotateArray(int[] nums, int k) {
        int n = nums.length;
        int s = 0;
        while (s < k) {
            int temp = nums[n - 1];
            for (int i = n - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            s++;
        }
        System.out.println("Update Array : ");
        for (int num : nums) {
            System.out.println(num + " ");
        }
    }

    /**
     * Rotate the Array by K steps -- Optimize way
     *
     * @param nums
     * @param k
     */
    public static void rotateArrayOptimized(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k is larger than array length

        reverse(nums, 0, n - 1); // Reverse the entire array
        reverse(nums, 0, k - 1); // Reverse the first k elements
        reverse(nums, k, n - 1); // Reverse the remaining n-k elements

        System.out.println("Rotated Array : ");
        for (int num : nums) {
            System.out.println(num + " ");
        }
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }


    private static void printNumber(int n) {
        if (n == 0)
            return;
        else {
            printNumber(n - 1);
            System.out.println(" " + n);
        }
    }

    private static int maxofArray(int[] arr, int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return arr[0];
        else {
            return Math.max(maxofArray(arr, n - 1), arr[n - 1]);
        }
    }

    private static int minofArray(int[] arr, int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return arr[0];
        else {
            return Math.min(minofArray(arr, n - 1), arr[n - 1]);
        }
    }


    /**
     * Find the best price of Stock
     *
     * @param price
     * @return
     */
    private static int maxProfit(int[] price) {
        int i = 0;
        int n = price.length;
        int sellIndex = 0, purchaseIndex = 0;
        int maxProfit = 0, sellPrice = 0, minPrice = price[0];
        while (i < n) {
            if (price[i] <= minPrice) {
                minPrice = price[i];
                purchaseIndex = i;
            } else {
                if (sellPrice <= price[i] || purchaseIndex > sellIndex) {
                    sellPrice = price[i];
                    sellIndex = i;
                }
                maxProfit = Math.max(maxProfit, sellPrice - minPrice);
            }
            i++;
        }
        System.out.println("\n Sell Index = " + sellIndex + "\t Purchase Index :" + purchaseIndex);
        System.out.println("\n Buy Price = " + minPrice);
        System.out.println("\n Sell Price = " + sellPrice);
        System.out.println("\n max Profile = " + maxProfit);
        return maxProfit;
    }

    /**
     * Find the best time to buy and sell the stocks
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int lsf = Integer.MAX_VALUE; // least so far
        int op = 0; // overall profit
        int pist = 0; // profit if sold today

        for (int price : prices) {
            if (price < lsf) { // if we found new buy value which is more smaller then previous one
                lsf = price;
            }
            pist = price - lsf;
            if (op < pist) {
                op = pist;
            }
        }
        System.out.println("Buy Price = " + lsf);
        System.out.println("Sell Price = " + pist);
        System.out.println("max Profile = " + op);
        return op;
    }

    /**
     * Return the cost of climbing with min cost
     *
     * @param cost
     * @param n
     * @return
     */
    private static int minCostStair(int[] cost, int n) {
        int[] dp = new int[n + 1];
        if (n <= 1)
            return 0;
        else if (n == 2) {
            return dp[n] = Math.min(cost[0], cost[1]);
        } else {
            return dp[n] = Math.min(minCostStair(cost, n - 1) + cost[n - 1], minCostStair(cost, n - 2) + cost[n - 2]);
        }
    }


    /**
     * Find the min and max element in array of size n
     *
     * @param arr
     * @param n
     */
    private static void minMaxOfArray(int[] arr, int n) {

        int min = 0, max = 0;
        if (n == 0)
            return;
        if (n == 1) {
            min = arr[0];
            max = arr[0];
        } else {
            for (int i = 0; i < n; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                } else if (arr[i] < min) {
                    min = arr[i];
                }
            }
            System.out.println("Min element = " + min);
            System.out.println("Max element = " + max);
        }
    }

    /**
     * Find the missing number
     *
     * @param arr
     * @param n
     * @return
     */
    private static int missingNum(int[] arr, int n) {
        /*int sum=((n+1)*(n+2))/2;
        for (int i = 0; i <= n; i++) {
            sum-=arr[i];
        }
        return sum;*/
        int total = 1;
        for (int i = 2; i <= (n + 1); i++) {
            total += i;
            total -= arr[i - 2];
        }
        return total;
    }

    /**
     * Subarray of sum is equal of target sum
     *
     * @param arr
     * @param n
     * @param targetSum
     */
    private static void subarraySum(int[] arr, int n, int targetSum) {
        ArrayList<Integer> indexList = new ArrayList<>();
        indexList.clear();
        int currentSum = arr[0];
        int start = 0;

        for (int end = 1; end <= n; end++) {
            while (currentSum > targetSum && start < end - 1) {
                currentSum -= arr[start];
                start++;
            }

            if (currentSum == targetSum) {
                System.out.println("\n Subarray found between indices :Start Index -  " + start + " End Index - " + (end - 1));
            }
            if (end < n) {
                currentSum += arr[end];
            }
        }
    }

    /**
     * Find the sum of subarray equal to targetSum
     *
     * @param arr
     * @param n
     * @param targetSum
     * @return
     */
    private static int subArrayOfSum(int[] arr, int n, int targetSum) {
        int sum = 0;
        int start = 0;
        HashMap<Integer, Integer> mapPrevSum = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == targetSum) {
                start++;
            }
            if (mapPrevSum.containsKey(sum - targetSum)) {
                start += mapPrevSum.get(sum - targetSum);
            } else {
                mapPrevSum.put(sum, start);
            }
        }
        System.out.println("\n find the occurence of target sum  " + start);
        return start;
    }


    static ArrayList<Integer> duplicateItems(int[] arr, int n) {

        ArrayList<Integer> seenList = new ArrayList<>();
        ArrayList<Integer> duplicateList = new ArrayList<>();
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            if (seenList.contains(arr[start])) {
                if (!duplicateList.contains(arr[start])) {
                    duplicateList.add(arr[start]);
                }
            } else {
                seenList.add(arr[start]);
            }
            start++;
        }
        return duplicateList;
    }

    // function to find repeating elements
    static void printRepeating(int[] arr, int n) {
        // First check all the values that are
        // present in an array then go to that
        // values as indexes and increment by
        // the size of array
        for (int i = 0; i < n; i++) {
            int index = arr[i] % n;
            arr[index] += n;
        }

        // Now check which value exists more
        // than once by dividing with the size
        // of array
        for (int i = 0; i < n; i++) {
            if ((arr[i] / n) >= 2)
                System.out.print(i + " ");
        }
    }

    static void miniMaxSum(List<Integer> arr) {
        int n = arr.size();
        int sumTotal = (n * (n + 1)) / 2;
        int minSum = 0;
        int maxSum = 0;
        for (int i = 0; i < n - 1; i++) {
            minSum += arr.get(i);
        }
        for (int i = 1; i < n; i++) {
            maxSum += arr.get(i);
        }
        System.out.println("\n Total Sum : " + sumTotal);
        System.out.println("\n Minimum Sum : " + minSum);
        System.out.println("\n Maximum Sum : " + maxSum);
    }

    /**
     * Find the duplicate items in the list
     *
     * @param arr
     * @return
     */
    public static ArrayList<Integer> duplicates(int[] arr) {
        // code here
        ArrayList<Integer> duplicateItemList = new ArrayList<>();
        HashMap<Integer, Boolean> mapArray = new HashMap<>();
        for (int j : arr) {
            if (mapArray.containsKey(j)) {
                mapArray.put(j, true);
            } else {
                mapArray.put(j, false);
            }
        }
        mapArray.forEach((key, repeatValue) -> {
            if (repeatValue) {
                duplicateItemList.add(key);
            }
        });

        if (!duplicateItemList.isEmpty()){
            Collections.sort(duplicateItemList);
            for (int i = 0; i < duplicateItemList.size(); i++) {
                System.out.println(duplicateItemList.get(i));
            }
        }else {
            duplicateItemList.add(-1);
        }

        return duplicateItemList;
    }
}
