package com.gaurav.dsalib.strings;

import java.util.HashMap;

public class LeetCodeStringExamples {

    public static void main(String[] args) {

//        System.out.println("\n  Isomorphic String : "+isIsomorphic("egg","adh"));
//        System.out.println(" Word Pattern : "+wordPattern("abba","dog cat cat dog"));
        System.out.println(" Anagram String : "+isAnagram("anagram","nagaram"));
    }

    /**
     * Check whether string is Isomorphic or not
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character,Character>mapOne=new HashMap<>();
        HashMap<Character,Character>mapTwo=new HashMap<>();

        for(int i=0;i<s.length(); i++){
            char char1=s.charAt(i);
            char char2=t.charAt(i);
            if(mapOne.containsKey(char1)){
                if(mapOne.get(char1)!=char2){
                    return false;
                }
            }else{
                mapOne.put(char1,char2);
            }

            if (mapTwo.containsKey(char2)) {
                if (mapTwo.get(char2) != char1) {
                    return false;
                }
            } else {
                mapTwo.put(char2, char1);
            }
        }

        return true;
    }

    /**
     * Check whether string is match with the pattern or not
     * @param pattern
     * @param s
     * @return
     */
    private static boolean wordPattern(String pattern, String s) {
        HashMap<Character,String>mapOne=new HashMap<>();
        String []arr=s.split(" ");
        if (pattern.length()!=arr.length){
            return false;
        }
        for (int i=0;i<pattern.length();i++){
            char char1=pattern.charAt(i);
            String char2=arr[i];
            if(mapOne.containsKey(char1)){
                if(!mapOne.get(char1).equals(char2)){
                    return false;
                }
            }else if(mapOne.containsValue(char2)){
                return false;
            }
            else{
                mapOne.put(char1,char2);
            }
        }
        return true;
    }


    /**
     * Check whether string is Anagram or not
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer>mapOne=new HashMap<>();
        HashMap<Character,Integer>mapTwo=new HashMap<>();
        for (int i=0;i<s.length();i++) {
            char char1 = s.charAt(i);
            char char2 = t.charAt(i);
            mapOne.put(char1,mapOne.getOrDefault(char1,0)+1);
            mapTwo.put(char2,mapTwo.getOrDefault(char2,0)+1);
        }
        return mapOne.equals(mapTwo);
    }

    /**
     * Reverse of word in String
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        // Trim leading/trailing spaces & split by multiple spaces
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        // Iterate in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) result.append(" "); // Add space except for last word
        }

        return result.toString();
    }

}
