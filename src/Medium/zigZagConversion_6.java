package Medium;
import java.util.*;

/**
 * @author:choumei
 * @date:2019/11/2321:16
 * @Description: 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 */
public class zigZagConversion_6 {
    public static void main(String[] args) {

        //System.out.println(zigZagConvert("akdjbfsjdhfsjdbhbdf",5));
        //System.out.println(zigZagConvertPro2("akdjbfsjdhfsjdbhbdf",5));
        System.out.println(zigZagConvertPro3("PAYPALISHIRING",3));
        //----------问题扩展---------------
        /*char[][] rst;
        rst = zigZagConvertPro1("asdkjbskdjbfsuiefsndkcbskdjbhd",5);
        for (int i = 0; i < rst.length; i++) {
            for(int j = 0;j<rst[i].length;j++){
                System.out.print(rst[i][j]);
            }
            System.out.println("");
        }*/
    }

    /**
     * 参考官方题解：方法一：按行排序
     * @param s
     * @param rowNums
     * @return
     */
    public static String zigZagConvert(String s,int rowNums){
        if(Math.min(s.length(),rowNums) == 1){
            return s;
        }
        List<StringBuilder> rowsList = new ArrayList<StringBuilder>();
        for (int i = 0; i < Math.min(s.length(),rowNums) ; i++) {
            StringBuilder row = new StringBuilder();
            rowsList.add(row);
        }
        int rowIdx = 0;
        boolean isGoingDown = false;
        for (int i = 0; i < s.length() ; i++) {
            rowsList.get(rowIdx).append(s.charAt(i));
            if(rowIdx == 0 || rowIdx == rowNums -1)  isGoingDown = !isGoingDown;
            rowIdx += isGoingDown ? 1 : -1;
        }

        StringBuilder rstStr = new StringBuilder();
        for (StringBuilder curStr :rowsList) {
            rstStr.append(curStr);
        }
        return rstStr.toString();
    }


    /**
     * 问题扩展：返回构建的二维数组
     * @param s
     * @param rowNums
     * @return
     */
    public static char[][] zigZagConvertPro1(String s,int rowNums){

        if(Math.min(rowNums,s.length()) < 1){
            return null;
        }else if(Math.min(rowNums,s.length()) == 1){
            return new char[][]{new char[]{s.charAt(0)}};
        }

        int sLen = s.length();
        int rowCnt = rowNums;
        int colCnt = (sLen/(rowCnt+(rowNums-2)))*(rowNums-2+1) + (  (sLen%(rowCnt+(rowNums-2))) > rowCnt ? (sLen%(rowCnt+(rowNums-2)))%rowCnt+1 : 1 );
        char[][] rstList = new char[rowCnt][colCnt];

        int rowIdx = 0,colIdx = 0;
        boolean isGoingDown = false;
        for(char c : s.toCharArray()){
            rstList[rowIdx][colIdx] = c;
            if(rowIdx == 0  || rowIdx == rowNums -1)  isGoingDown = !isGoingDown;
            rowIdx += isGoingDown ? 1:-1;
            colIdx += isGoingDown ? 0:1;
        }
        return rstList;
    }

    public static String zigZagConvertPro2(String s,int rowNums){
        int sLen = s.length();
        StringBuilder rstStr = new StringBuilder();
        int cycleLen = 2*rowNums - 2;
        for (int i = 0; i < rowNums; i++){
            for (int j = 0; j+i < sLen ; j += cycleLen) {
                rstStr.append(s.charAt(i+j));
                if(i != 0 && i != rowNums-1  && j+cycleLen-i < sLen){
                    rstStr.append(s.charAt(j+cycleLen-i));
                }
            }
        }
        return rstStr.toString();
    }
    /**
     * 问题扩展：返回构建的二维数组对应的字符串
     * @param s
     * @param rowNums
     * @return
     */
    public static  String zigZagConvertPro3(String s,int rowNums){

        if(Math.min(rowNums,s.length()) < 1){
            return "";
        }else if(Math.min(rowNums,s.length()) == 1){
            return s;
        }

        int sLen = s.length();
        int rowCnt = rowNums;
        int colCnt = (sLen/(rowCnt+(rowNums-2)))*(rowNums-2+1) + (  (sLen%(rowCnt+(rowNums-2))) > rowCnt ? (sLen%(rowCnt+(rowNums-2)))%rowCnt+1 : 1 );
        Character[][] rstList = new Character[rowCnt][colCnt];

        int rowIdx = 0,colIdx = 0;
        boolean isGoingDown = false;
        for(char c : s.toCharArray()){
            rstList[rowIdx][colIdx] = c;
            if(rowIdx == 0  || rowIdx == rowNums -1)  isGoingDown = !isGoingDown;
            rowIdx += isGoingDown ? 1:-1;
            colIdx += isGoingDown ? 0:1;
        }
        StringBuilder rstStr = new StringBuilder();
        for (Character[] curCharList: rstList ) {
            for (int i = 0; i < curCharList.length ; i++) {
                if(null != curCharList[i] ){
                    rstStr.append(curCharList[i]);
                }
            }
        }
        return rstStr.toString();
    }
}
