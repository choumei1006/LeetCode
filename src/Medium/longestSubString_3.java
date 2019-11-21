package Medium;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:choumei
 * @date:2019/11/2122:58
 * @Description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * Note:感谢官方题解《思路之优化的滑动窗口》指点迷津，重解；
 * 时间复杂度：O（n）
 * 空间复杂度：O（min(m,n)）   m:字符集/字母m的长度 ；    n:字符串的长度n；
 */
public class longestSubString_3 {
    public static void main(String[] args) {
        System.out.println(longestSubString2("ashsasdahs"));
    }

    //优化的滑动窗口
    public static int longestSubString(String s){
        int maxLen = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0,j=0; j < s.length(); ++j) {
            char curChar = s.charAt(j);
            if(map.containsKey(curChar)){
                i = Math.max(i,map.get(curChar));
            }
            maxLen = Math.max(maxLen,j-i+1);
            map.put(curChar,j+1);
        }
        return maxLen;
    }

    //初次解答（非最优）
    public static int longestSubString2(String s){
        String maxStr = "";
        int maxLen = 0;
        for (int i = 0; i <s.length() ; i++) {
            char curChar = s.charAt(i);
            int index = maxStr.indexOf(curChar);
            maxStr +=curChar;
            if(index >= 0){
                 maxStr = maxStr.substring(index+1);
            }
            maxLen = Math.max(maxLen,maxStr.length());
        }
        return maxLen;
    }
}

