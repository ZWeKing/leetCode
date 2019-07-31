package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * Medium
 *
 * 5937
 *
 * 341
 *
 * Favorite
 *
 * Share
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || "".equals(s)) {
            return 0;
        }

        int p1 = 0;
        int p2 = 0;
        Map<Character,Integer> container = new HashMap<>();
        int length = s.length();
        int count = 0;

        while (p1 < length && p2 < length) {
            Character c = s.charAt(p2);
            if (!container.containsKey(c) ||
                    (container.containsKey(c) && ( container.get(c) < p1))) {
                count = (p2 - p1 + 1) > count ? (p2 - p1 + 1) : count;
            } else {
                int repeat = container.get(c);
                p1 = repeat + 1;
            }
            container.put(c,p2);
            p2++;
        }

        return count;
    }

    public static void main (String[] args) {
        int count = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("");
        System.out.println(count);
    }
}
