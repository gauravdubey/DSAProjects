package dsatopics.arrays.prefixsum;

import java.util.Arrays;

public class PrefixSumArrayExample {

    public static void main(String[] args) {
        System.out.println("\n These are the array examples");
        int l=2,r=5,x=3;
        int [] array= {10,13,16,20,24,27,30};
        int [] nums={1, 2, 3, -2, 5};
        int[]nums2={1, 2, 90, 10, 110};
        int []nums3={3,4,-2,5,8,20,-10,8};
        int[]height={0,1,0,2,1,0,1,3,2,1,2,1};
        int[]height2={4,2,0,3,2,5};
//        System.out.println("\n Input are : "+l+ "\t "+r+ "\t "+x);
//        printRangeArray(array,l,r,x);
//        System.out.println(" Maximum Subarray Sum : "+maxSubarraySum(nums));
//        System.out.println(" Maximum Difference of Array : "+maxDiffOfArray(nums2));
//        System.out.println(" Divide Array in Two SubArray : "+divideArrayInTwoSubArray(nums3));
        System.out.println(" Trapping Rain Water : "+trappingRainWater(height2));
    }

    /**
     * Range update query in array
     * @param a - Array which need to update
     * @param l - first index of array where from we start update
     * @param r - last index of array till that indext we need to update
     * @param x - Value which need to add in array value
     */
    private static void printRangeArray(int []a,int l,int r, int x){
        int n=a.length;
        int [] d = new int[n+1];
        // find the difference array
        for (int i=0;i<n; i++){
            if (i==0){
                d[i]=a[i];
                System.out.println("\n Difference Array : \n "+d[i]);
            }
            else{
                d[i]=a[i]-a[i-1];
                System.out.println(" "+d[i]);
            }
        }
        d[l]=d[l]+x;
        d[r+1]=d[r+1]-x;

        // find the Prefix sum array
        for (int i=0; i< n; i++){
            if (i==0){
                d[i]=a[i];
                System.out.println("\n print the Update Array : \n "+d[i]);
            }
            else {
                d[i]=d[i]+d[i-1];
                System.out.println(" "+d[i]);
            }
        }
    }

    /**
     * Kadane's Algorithm to find the maximum subarray sum
     * @param nums
     * @return
     */
    private static int maxSubarraySum(int[] nums){
        int maxSum=Integer.MIN_VALUE;
        int prefixSum=0;
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            maxSum=Math.max(maxSum,prefixSum);
            if (prefixSum<0){
                prefixSum=0;
            }
        }
        System.out.println("Max Sum : "+maxSum);
        return maxSum;
    }


    /**
     * Maximum difference of array
     * @param arr
     * @return
     */
    private static int maxDiffOfArray(int[]arr){
        int maxDiff=arr[1]-arr[0];
        int minElement=arr[0];
        for (int i=1;i<arr.length;i++){
            int diff=arr[i]-minElement;
            if (diff>maxDiff){
                maxDiff=diff;
            }
            if (arr[i]<minElement){
                minElement=arr[i];
            }
        }
        return maxDiff;
    }

    /**
     * Divide array in two subarray whose sum are equal
     * @param nums
     * @return
     */
    private static int divideArrayInTwoSubArray(int[] nums){
        int totalSum=0, prefixSum=0;
        for (int num:nums){
            totalSum+=num;
        }
        for (int num : nums) {
            prefixSum += num;
            if (totalSum == 2 * prefixSum)
                return 1;
        }
        return 0;
    }

    /**
     * Trapping Rain Water problem
     * @param height
     * @return
     */
    private static int trappingRainWater(int[] height) {
        int leftMax=0,rightMax=0,maxHeight=height[0], index=0, water=0;

        for (int i = 0; i < height.length; i++) {
            if (height[i]>maxHeight){
                maxHeight=height[i];
                index=i;
            }
        }
        /**
         * Left part logic
         */
        for (int i = 0; i < index; i++) {
            if (leftMax>height[i]){
                water+=(leftMax-height[i]);
            }else{
                leftMax=height[i];
            }
        }

        for (int i = height.length-1; i >index ; i--) {
            if (rightMax>height[i]){
                water+=(rightMax-height[i]);
            }else{
                rightMax=height[i];
            }
        }
        return water;
    }
    //Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

    /**
     * Product of array except self
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        int left=1,right=1;
        Arrays.fill(result,1);
        for (int i = 0; i < n; i++) {
            result[i]=left;
            left*=nums[i];
        }
        for (int i=n-1;i>=0;i--){
            result[i]*=right;
            right*=nums[i];
        }
        return result;
    }

}
