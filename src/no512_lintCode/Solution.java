package no512_lintCode;

/**
 * https://www.lintcode.com/problem/decode-ways/description
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as AB (1 2) or L (12).
 * Example 2:
 *
 * Input: "10"
 * Output: 1
 */
public class Solution {
    public int numDecodings(String s) {

        if (s.length() == 0 ) {
            return 0;
        }


        if (s.charAt(0) == '0'){
            return 0;
        }

        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;  //dp[i] 表示从第一个字符到第i个字符的子字符串的最多的编码方式

        for(int i = 1; i < s.length();i++){
            if(s.charAt(i) == '0'){
                if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2'){
                    dp[i+1] = dp[i-1];
                }else {
                    return 0;
                }
            } else {
                if ( ( s.charAt(i-1) == '2' && s.charAt(i) <= '6' ) || s.charAt(i-1) == '1' ) {
                    dp[i+1] = dp[i] + dp[i-1];
                } else {
                    dp[i+1] = dp[i];
                }
            }

        }
        return dp[s.length()];
    }

    public static void main(String[] args){
        System.out.println(
                new Solution().numDecodings("120")
        );
    }
}
