package Easy;

/**
 * @author:choumei
 * @date:2019/11/2421:59
 * @Description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 *  示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1],即[-2147483648,2147483647]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *  时间复杂度：O（log（x）） ,x中大约有log（x）位数字
 *  空间复杂度：O(1)
 */
public class reverseInteger_7 {
    public static void main(String[] args) {
        System.out.println(reverseInteger(-1234567897));
    }
    public static  int reverseInteger(int num){
        int rst = 0;
        while(num != 0){
            int rail = num % 10;
            num /= 10;

            if( rst > Integer.MAX_VALUE/10 || ( rst == Integer.MAX_VALUE/10 && rail > 7 )) return 0;
            if( rst < Integer.MIN_VALUE/10 || ( rst == Integer.MIN_VALUE/10 && rail > 8 )) return 0;
            rst = rst*10 + rail;
        }
        return rst;
    }
}
