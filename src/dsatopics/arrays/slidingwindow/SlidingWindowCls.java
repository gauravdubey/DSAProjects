package dsatopics.arrays.slidingwindow;

import java.util.HashSet;

public class SlidingWindowCls {

    public static void main(String[] args) {

    }

    // ******************   Sliding Window problems  *****************//
    /**
     * find the longest substring without repeating character
     *
     * @param str
     * @return
     */
    private static int longestSubstring(String str) {
        HashSet<Character> set = new HashSet<>();
        int first = 0, len = 0;

        for (int second = 0; second < str.length(); second++) {
            while (set.contains(str.charAt(second))) {
                set.remove(str.charAt(first));
                first++;
            }
            set.add(str.charAt(second));
            len = Math.max(len, second - first + 1);
        }
        return len;
    }

    /**
     * Fixed size - Sliding window problem : Find the minimum sum of
     * @param arr
     * @param k
     * @return
     */
    private static int sumOfSize(int[]arr,int k){
        int start=0, end=0, sum=0;
        int minSum=Integer.MAX_VALUE, maxSum=Integer.MIN_VALUE;

        while (end<arr.length){
            sum+=arr[end];
            if (end-start+1<k){
                end++;
            }else {
                if (sum<minSum){
                    minSum=sum;
                } else if (sum>maxSum) {
                    maxSum=sum;
                }
                System.out.println("\n Sum = "+sum);
                sum-=arr[start];
                start++;
                end++;
            }
        }
        System.out.println("\n Min Sum = "+minSum);
        System.out.println("\n Max Sum = "+maxSum);
        return sum;
    }
}
