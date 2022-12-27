package cn.bugstack.springframework.leetcode.lianbiao;

import java.util.List;

/**
 * @Auther: 李清依
 * @Date: 2022/11/7 17:02
 * @Description:
 */
public class lee203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        while (pre.next!=null){
            if (pre.next.val==val){
                pre.next=pre.next.next;
            }else {
                pre=pre.next;
            }
        }
        return dummy.next;
    }
}
