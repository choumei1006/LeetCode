package Easy;

/**
 * @author:choumei
 * @date:2019/11/25 23:19
 * @Description: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 */
public class isPalindrome_9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-12321));
    }
    public static boolean isPalindrome(int num){
        Integer number = num;
        String numStr = num+"";
        if(null == number  || numStr == "") return false;

        return isPalindromeStr(numStr);

    }
    public static boolean isPalindromeStr(String str){
        int strLen = str.length();
        if(strLen == 1) return true;
        else if(strLen == 2) return str.charAt(0) == str.charAt(1) ? true:false;
        if(str.charAt(0) == str.charAt(strLen-1)){
            return isPalindromeStr(str.substring(1,strLen-1));
        }else{
            return false;
        }

    }

    /**
     * 进阶:
     * 你能不将整数转为字符串来解决这个问题吗？
     */
}
