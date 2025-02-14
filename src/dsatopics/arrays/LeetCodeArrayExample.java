package com.gaurav.dsalib.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LeetCodeArrayExample {

    public static void main(String[] args) {
        int[] arr = {3,1, 1, 2,2,4,4};
        int[] arr2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int []arr3={0,1,0,3,12};
        int[]arr4={2,3,4};
        int[]arr5={2,7,4,5};
        int[]arr6={ -2,1,-3,4,-1,2,1,-5,4};
        int[]arr7={1,0,1,0,1,0};
        int [] nums={2,3,5,10,50,80};
        int[]tripletSumArr={1,4,45,6,10,8};
        int [] maxPairSumArr= { 2536,1613,3366,162 };

//        System.out.println("\n Length of array after removal of element : "+removeElement(arr,3));
//        getSecondLargest(arr);
//        System.out.println("Removed duplicate count : "+ removeDuplicates(arr2));
//        moveZeroes(arr3);
//        System.out.println("Array of Sum Target : "+ Arrays.toString(twoSum(arr4, 6)));
//        System.out.println("Single number in Array : "+ findSingleNumberInArray(arr));
//        System.out.println("Missing number in Array : "+ missingNumber(arr4));
//        System.out.println("SubArray Sum : "+ subArraySum(arr6));
//        moveOnesAtEnd(arr7);
//        System.out.println("Array of Diff Target : "+ Arrays.toString(pairWithGivenDiff(nums, 45)));
//        System.out.println("Triplet sum is available in array : "+findTripletSum(tripletSumArr,6,13));
        System.out.println("Maximum pair sum in array : "+maxSum(maxPairSumArr));
    }


    /**
     * Find the two indices sum is equal to target
     *
     * @param numbers
     * @param target
     * @return
     */
    private static int[] twoSum(int[] numbers, int target) {

        HashMap<Integer,Integer>mapItem=new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement=target-numbers[i];
            if (mapItem.containsKey(complement)){
                return new int[]{mapItem.get(complement)+1,i+1};
            }
            mapItem.put(numbers[i],i);
        }
        return new int[]{};
    }

    /**
     * Find the target difference of two number in array
     * @param nums
     * @param diffTarget
     */
    private static int[] pairWithGivenDiff(int[]nums, int diffTarget){
        int start=0, end=1;
        while(end<nums.length){
            int complement=nums[end]-nums[start];
            if (complement==diffTarget){
                return new int []{nums[start],nums[end] };
            }else if(complement<diffTarget){
                end++;
            }else
                start++;
        }
        return null;
    }

    /**
     *  Find the triplet sum in array
     * @param nums
     * @param n
     * @param x
     * @return
     */
    private static int findTripletSum(int []nums, int n, int x){
        int ans=0;
        Arrays.sort(nums);
        for (int i = 0; i < n-2; i++) {
            ans=x-nums[i];
            int start=i+1;
            int end=n-1;
            while(start<end){
                if(nums[start]+nums[end]==ans){
                    return 1;
                }else if(nums[start]+nums[end]<ans){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return 0;
    }

    /**
     * Remove the element given from array
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int count = 0;
        for (int num : nums) {
            if (num != val) {
                count++;
            }
        }
        return count;
    }

    /**
     * Remove the duplicate element
     *
     * @param nums
     * @return
     */
    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 0;  // Pointer to track the position of unique elements
        // Loop through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If current element is not equal to the last unique element found
            if (nums[i] != nums[count]) {
                count++;  // Move pointer to next position
                nums[count] = nums[i];  // Place the unique element in the correct position
            }
        }

        // Return the count of unique elements (j + 1 because 'j' is zero-based)
        return count + 1;
    }

    /**
     * Second largest number in array
     *
     * @param arr
     * @return
     */
    private static int getSecondLargest(int[] arr) {
        // Code Here
        int first = -1;
        int second = -1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > first) {
                first = arr[i];
            } else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }
        System.out.println("\n Second largest number in Array : " + second);
        return second;
    }

    /**
     * Move zeros at the end of array
     * @param nums
     */
    private static void moveZeroes(int[] nums) {
        int n= nums.length;
        int i=1, j=0;
        while(i<n){
            if (nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j++;
            }else{
                i++;
            }
        }
        for (int k : nums) {
            System.out.print(k + " ");
        }
    }

    /**
     * Move all 1's at end
     * @param nums
     */
    private static void moveOnesAtEnd(int[]nums){
        int i=0,j=nums.length-1;
        if (nums.length==1)
            return;
        while (i<=j){
            if (nums[j]==0){
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                i++;
                j--;
            } else if (nums[i]==0) {
                i++;
            }else {
                j--;
            }
        }
        for (int num:nums){
            System.out.print(num+ "\t");
        }
    }

    /**
     * Union of Two sorted array
     * @param arr1
     * @param arr2
     * @return
     */
    private static int[] unionOfSortedArray(int[]arr1, int[]arr2){
        ArrayList<Integer>resultList=new ArrayList<>();
        int i=0,j=0;
        while(i<arr1.length && j< arr2.length){
            if (arr1[i]==arr2[j]){
                if (resultList.isEmpty() || resultList.get(resultList.size()-1)!=arr1[i]){
                    resultList.add(arr1[i]);
                }
                i++;
                j++;
            }else if(arr1[i]<arr2[j]){
                if (resultList.isEmpty() || resultList.get(resultList.size()-1)!=arr1[i]){
                    resultList.add(arr1[i]);
                }
                i++;
            }else {
                if (resultList.isEmpty() || resultList.get(resultList.size()-1)!=arr2[j]){
                    resultList.add(arr2[j]);
                }
                j++;
            }
        }

        while (i<arr1.length){
            if (resultList.isEmpty() || resultList.get(resultList.size()-1)!=arr1[i]){
                resultList.add(arr1[i]);
            }
            i++;
        }
        while (j<arr2.length){
            if (resultList.isEmpty() || resultList.get(resultList.size()-1)!=arr2[j]){
                resultList.add(arr2[j]);
            }
            j++;
        }
        int []resultArray=new int[resultList.size()];
        for (int k = 0; k < resultList.size(); k++) {
            resultArray[k]=resultList.get(k);
        }

        return resultArray;
    }

    /**
     * Find a single number in as array
     * @param nums
     * @return
     */
    private static int findSingleNumberInArray(int[]nums){
        int result=0;
        for (int num:nums){
            result^=num;
        }
        return result;
    }

    /**
     * Missing number in array
     * @param nums
     * @return
     */
    private static int missingNumber(int [] nums){
        int ans=nums.length;
        for (int i=0;i<ans+1;i++){
            ans^=nums[i];
            ans^=i;
        }
        return ans;
    }

    /**
     * Kadane's Algo
     * Find the maximum subarray sum
     * @param arr
     * @return
     */
    private static int subArraySum(int[]arr){
        int ans=Integer.MIN_VALUE;
        int sum=0;
        for (int i=0;i<arr.length;i++) {
            sum += arr[i];
            ans = Math.max(ans, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }

    /**
     * Find the maximum pair sum in array
     * @param nums
     * @return
     */
    private static int maxSum(int[] nums) {

        HashMap<Integer,Integer>maxMap=new HashMap<>();
        int maxSum=-1;
        for(int num:nums){
            int largestDigit=getLargestDigit(num);
            if (maxMap.containsKey(largestDigit)) {
                maxSum = Math.max(maxSum, maxMap.get(largestDigit) + num);
                maxMap.put(largestDigit, Math.max(maxMap.get(largestDigit), num));
            } else {
                maxMap.put(largestDigit, num);
            }
        }
        return maxSum;
    }

    /**
     * Find the largest digit from a number
     * @param num
     * @return
     */
    private static int getLargestDigit(int num){
        int maxDigit=0;
        while(num>0){
            maxDigit=Math.max(maxDigit,num%10);
            num/=10;
        }
        return maxDigit;
    }
}
