package com.wy.interview;

/**
 * @Author WangYang
 * @Description:
 * @Date Created in 10:32 2019/3/19
 */
public class LeetCode2 {
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dream = new ListNode(0);
        ListNode ret = dream;
        int curry = 0,x,y,sum=0;
        while (p1!=null||p2!=null){
            x = p1==null?0:p1.val;
            y = p2==null?0:p2.val;
            curry = sum+x+y;
            sum = curry/10;
            ListNode temp = new ListNode(sum%10);
            dream.next = temp;
            dream = dream.next;
        }
        return ret.next;
    }
}
