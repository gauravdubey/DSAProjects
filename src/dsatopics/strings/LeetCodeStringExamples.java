package dsatopics.strings;

import java.util.HashMap;

public class LeetCodeStringExamples {

    public static void main(String[] args) {

//        System.out.println("\n  Isomorphic String : "+isIsomorphic("egg","adh"));
        System.out.println(" Word Pattern : "+wordPattern("abba","dog cat cat dog"));
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
}
