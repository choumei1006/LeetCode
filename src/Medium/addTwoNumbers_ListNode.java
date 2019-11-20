package Medium;

/**
 * @author:choumei
 * @date:2019/11/210:20
 * @Description:
 */
public class addTwoNumbers_ListNode {

        int val;
        addTwoNumbers_ListNode next;
        addTwoNumbers_ListNode(int x){ val = x; }
        public void showListNode(){
            addTwoNumbers_ListNode cursor = this;
            while(null != cursor){
                System.out.println(cursor.val);
                //if(null != cursor.next)
                cursor = cursor.next;
            }
        }
}
