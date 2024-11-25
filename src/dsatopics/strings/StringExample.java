package dsatopics.strings;

import java.util.HashSet;
import java.util.Stack;

public class StringExample {
    public static void main(String[] args) {
        String str="24637594";
        String strPallindrome="A man, a plan, a canal: Panama";
        int[]arr={1,2,4,5,6,7,3,8,};
//        System.out.println("\n Length of longest substring without repeating character : "+longestSubstring(str));
//        System.out.println("\n Largest Odd substring : "+largestOddSubstring(str));
//        sumOfSize(arr,3);
//        System.out.println("\n String Palindrome or not : "+isPalindrome(strPallindrome));
        System.out.println("\n Reverse number : "+reverseNumber(120));

    }

    /**
     * #1
     * Reverse of String
     *
     * @param input
     * @return
     */
    private static String reverseString(String input) {
        if (input == null)
            throw new IllegalArgumentException("String can not be null");
        else if (input.isEmpty() || input.length() == 1) {
            return input;
        } else {
            return reverseString(input.substring(1)) + input.charAt(0);
        }
    }

    /**
     * Remove the duplicate adjacent char in string
     *
     * @param str
     * @return
     */
    private static String removeDuplicateChar(String str) {
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        if (n <= 1)
            return str;
        else {
            for (int i = 0; i < n; i++) {
                char c = str.charAt(i);
                if (i < n - 1 && c == str.charAt(i + 1)) {
                    i++;
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    /**
     * Remove the duplicate adjacent char in string by using stack
     *
     * @param str
     * @return
     */
    private static String removeDuplicateCharByStack(String str) {

        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    /**
     * Largest Odd Substring
     * @param num
     * @return
     */
    private static String largestOddSubstring(String num){
        for(int i=num.length()-1;i>=0; i--){
            if(num.charAt(i)%2!=0){
                return num.substring(0,i+1);
            }
        }
        return "";
    }

    /**
     * Check String is palindrome or not
     * @param s
     * @return
     */
    private static boolean isPalindrome(String s) {
        if (s.isEmpty() || s.length()==1){
            return true;
        }
        String updateStr=s.toLowerCase().trim().replaceAll("[^A-Za-z0-9]","");
        int len= updateStr.length();
        int start=0, end = len-1;
        while(start<=end){
            if(updateStr.charAt(start)==updateStr.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }

    /**
     * More generic way
     * @param s
     * @return
     */
    public boolean isPalindromeSecond(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst )) {
                start++;
            } else if(!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }

    /**
     * Reverse the number
     * @param number
     * @return 321 = 1*10 +
     */
    private static int reverseNumber(int number){
        boolean isNegative=number<0;
        number=Math.abs(number);
        int revNum=0;
        while (number>0){
            int digit= number%10;
            if (revNum > (Integer.MAX_VALUE - digit) / 10) {
                return 0;  // Return 0 if the reversal exceeds 32-bit signed integer range
            }
            revNum=revNum*10+digit;
            number/=10;
        }
        return isNegative? -revNum : revNum;
    }



}
