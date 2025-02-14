package com.gaurav.dsalib.twopointer;

import java.util.Arrays;
import java.util.HashMap;

public class TwoPointerExample {

    public static void main(String[] args) {
        System.out.println("Two Pointer Approach Examples");
        String str = "A man, a plan, a canal: Panama";
        int[] nums = {2, 3, 5, 10, 50, 80};
        int[] arr = {2, 3, 4};
        int []arr2 = {2,3,1,2,4,3};
        int [] arr3 = {1,8,6,2,5,4,8,3,7};
//        System.out.println("String is palindrome : " + isPalindrome(str));
//        System.out.println("Array of Sum Target : " + Arrays.toString(twoSum(arr, 6)));
//        System.out.println("Array of Diff Target : "+ Arrays.toString(pairWithGivenDiff(nums, 45)));
//        System.out.println("Minimum length of subarray : "+minSubArrayLen(7,arr2));
        System.out.println("Maximum area of container with more water : "+maxArea(arr3));
    }


    /**
     * Find the String is pallindrome or not
     *
     * @param str
     * @return
     */
    private static boolean isPalindrome(String str) {
        if (str.isEmpty())
            return true;

        int start = 0, end = str.length() - 1;
        ;
        while (start <= end) {
            char currStart = str.charAt(start);
            char currEnd = str.charAt(end);
            if (!Character.isLetterOrDigit(currStart)) {
                start++;
            } else if (!Character.isLetterOrDigit(currEnd)) {
                end--;
            } else {
                if (Character.toLowerCase(currStart) != Character.toLowerCase(currEnd)) {
                    return false;
                } else {
                    start++;
                    end--;
                }
            }
        }
        return true;
    }

    /**
     * Find the two indices sum is equal to target
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> mapItem = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (mapItem.containsKey(complement)) {
                return new int[]{mapItem.get(complement) + 1, i + 1};
            }
            mapItem.put(numbers[i], i);
        }
        return new int[]{};
    }

    /**
     * Find the target difference of two number in array
     *
     * @param nums
     * @param diffTarget
     * @return
     */
    private static int[] pairWithGivenDiff(int[] nums, int diffTarget) {
        int start = 0, end = 1;
        while (end < nums.length) {
            if (nums[end] - nums[start] == diffTarget) {
                return new int[]{nums[start], nums[end]};
            } else if (nums[end] - nums[start] < diffTarget) {
                end++;
            } else {
                start++;
            }
            if (start == end)
                end++;
        }
        return null;
    }

    /**
     * Find the minimum length of subarray whose sum is greater than or equal to target
     * @param target
     * @param nums
     * @return
     */
    private static int minSubArrayLen(int target, int[] nums) {

        int start = 0, end = 0, sum = 0, minLen = Integer.MAX_VALUE;
        for (end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    /**
     * Find the maximum area of container with most water
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            int containerLength = right - left;
            int area = containerLength * Math.min(height[left], height[right]);
            res = Math.max(res, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
