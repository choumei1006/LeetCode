package Hard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author:choumei
 * @date:2019/11/26 22:10
 * @Description: 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 *   '.' 匹配任意单个字符
 *   '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 */
public class regularExpressionMatch_10 {
    public static void main(String[] args) {
        Pattern pattern  = Pattern.compile(".*");
        Matcher m = pattern.matcher("");
        String s = "12";
        //System.out.println(s.substring(1));
        //System.out.println(m.find());
        System.out.println(isMatch("","jjj"));
    }

    /**
     * 自解有误
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch1(String s,String p){

        int sLen = s.length() , pLen = p.length();
        if(pLen == 0) return true;
        int sIndex = -1;
        int pIndex = -1;
        while(pIndex+1 < pLen){
            char curChar_s = s.charAt(sIndex+1);
            char curChar_p = p.charAt(pIndex+1);
            switch(curChar_p){
                case '*':
                    if(pIndex == -1){
                        return false;
                    }else {
                        char preExp = p.charAt(pIndex);
                        if (preExp == '.') {
                            if(pIndex+2 == pLen) return true;
                            char afterCurChar = p.charAt(pIndex+2);
                            int intense = afterCurChar == '.' ? 2:1;
                            while(sIndex+1 < sLen && s.charAt(sIndex+intense) != afterCurChar){
                                sIndex++;
                            }
                            if(sIndex+1 == sLen) return false;
                            pIndex++;
                        }else{
                            if(pIndex+2 == pLen) return true;
                            char afterCurChar = p.charAt(pIndex+2);
                            int intense = afterCurChar == '.' ? 2:1;
                            while(sIndex+1 < sLen && s.charAt(sIndex+intense) != afterCurChar){
                                sIndex++;
                            }
                            if(sIndex+1 == sLen) return false;
                            pIndex++;
                        }
                    }
                    break;
                case '.':
                    pIndex++;
                    sIndex++;
                    break;
                default:
                    if(p.charAt(pIndex+1) == s.charAt(sIndex+1)){
                        pIndex++;
                        sIndex++;
                    }else{
                        return false;
                    }
                    break;
            }
        }

        return sIndex < sLen ? true : false;

    }

    public static boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }

}
