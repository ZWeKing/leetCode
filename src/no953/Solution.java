package no953;

import java.util.HashMap;
import java.util.Map;

/**
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 *
 *
 * Note:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are english lowercase letters.
 */
public class Solution {

    Map<Character,Integer> map = null;

    public boolean isAlienSorted(String[] words, String order) {

        map = new HashMap<>();

        map.put(' ',0);

        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i+1);
        }

        if(words.length == 1){
            return true;
        }

        for(int i=0;i<words.length-1;i++){
            if(!checkOrder(words[i],words[i+1])){
                return false;
            }
        }


        return true;
    }

    public boolean checkOrder(String w1,String w2){
        int length = w1.length()>w2.length()?w2.length():w1.length();

        for(int i = 0;i<length;i++){
            if(map.get(w1.charAt(i)) < map.get(w2.charAt(i))){
                return true;
            }
            if(map.get(w1.charAt(i)) == map.get(w2.charAt(i))){
                continue;
            }
            if(map.get(w1.charAt(i)) > map.get(w2.charAt(i))){
                return false;
            }
        }

        if(w1.length()>w2.length()){
            return false;
        }

        return true;

    }

    public static void main(String[] args){
        String[] str = new String[]{"hello","leetcode"};
        System.out.println(new Solution().isAlienSorted(str,"hlabcdefgijkmnopqrstuvwxyz"));
    }
}
