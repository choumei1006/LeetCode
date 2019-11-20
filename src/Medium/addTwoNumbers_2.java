package Medium;

import java.sql.SQLOutput;
import  Medium.addTwoNumbers_ListNode;

/**
 * @author:choumei
 * @date:2019/11/2023:49
 * @Description: 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class addTwoNumbers_2 {
    public static void main(String[] args) {

        //创建链表1
        addTwoNumbers_ListNode l1_2 = new addTwoNumbers_ListNode(7);
        addTwoNumbers_ListNode l1_3 = new addTwoNumbers_ListNode(6);
        addTwoNumbers_ListNode l1 = new addTwoNumbers_ListNode(2);
        l1.next = l1_2;
        l1_2.next = l1_3;

        //创建链表2
        addTwoNumbers_ListNode l2_2 = new addTwoNumbers_ListNode(9);
        addTwoNumbers_ListNode l2_3 = new addTwoNumbers_ListNode(5);
        addTwoNumbers_ListNode l2 = new addTwoNumbers_ListNode(3);
        l2.next = l2_2;
        l2_2.next = l2_3;

        addTwoNumbers(l1,l2).showListNode();
    }

    public static  addTwoNumbers_ListNode addTwoNumbers(addTwoNumbers_ListNode l1,addTwoNumbers_ListNode l2){
        addTwoNumbers_ListNode root = new addTwoNumbers_ListNode(0);
        addTwoNumbers_ListNode cursor = root;
        Integer surplus = 0;
        while(null != l1 || null != l2  || 0 != surplus){
            int l1val = l1 != null ? l1.val: 0;
            int l2val = l2 != null ? l2.val : 0;

            int sumVal = l1val+l2val+surplus;

            surplus = sumVal/10;

            addTwoNumbers_ListNode sumNode = new addTwoNumbers_ListNode(sumVal%10);

            cursor.next = sumNode;
            cursor = sumNode;

            if(null != l1)  l1 = l1.next;
            if(null != l2) l2 = l2.next;
        }
        return root.next;
    }

}


