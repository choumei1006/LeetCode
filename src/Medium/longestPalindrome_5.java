package Medium;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author:choumei
 * @date:2019/11/2222:40
 * @Description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
 * Note：自解超时，感谢官方题解"优化四：中心扩展算法"
 */
public class longestPalindrome_5 {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println(LocalDateTime.now().format(dtf));
        System.out.println(longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        //System.out.println(longestPalindrome("asdfgfdsasdfgfdsedfgh"));
        System.out.println(LocalDateTime.now().format(dtf));
    }


    public static String longestPalindrome(String s){
        if(null == s || s.length() <= 0){
            return null;
        }
        int start = 0,end = 0;
        for (int i = 0; i < s.length() ; i++) {
            int maxLen1 = expandAroundCenter(s,i,i);
            int maxLen2 = expandAroundCenter(s,i,i+1);
            int maxLenRst = Math.max(maxLen1,maxLen2);
            if(maxLenRst > end - start   +1) {
                start = i - (maxLenRst - 1) / 2;
                end = i + maxLenRst / 2;
            }
        }
        return s.substring(start,end+1);
    }

    //计算以[left,right]为中心的最长回文长度
    public static int expandAroundCenter(String s ,int left,int right){
        int L = left,R = right;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }

    //自解(超时)
    public static String longestPalindrome2(String s){
        int sLen = s.length();
        String maxPalindrome = "";
        int maxPalindromeLen = 0;
        int i = 0;
        while(i <= sLen-maxPalindromeLen){
            for(int j = sLen;j > i;j--){
                String curStr = s.substring(i,j);
                if(isPalindrome(curStr)){
                    if(j-i> maxPalindromeLen){
                        maxPalindrome = curStr;
                        maxPalindromeLen = curStr.length();
                    }
                    break;
                }
            }
            i++;
        }
        return maxPalindrome;
    }

    //判断一个字符串是否是回文
    public static boolean isPalindrome(String s){
        int sLen = s.length();
        if(sLen == 1){
            return true;
        }else if(sLen == 2){
            return s.charAt(0) == s.charAt(1) ? true:false;
        }else{
            if(s.charAt(0) == s.charAt(sLen-1)){
                String subStr = s.substring(1,sLen-1);
                return isPalindrome(subStr);
            }else{
                return false;
            }
        }
    }
}
