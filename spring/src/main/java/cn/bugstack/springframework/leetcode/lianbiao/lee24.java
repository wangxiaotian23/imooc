package cn.bugstack.springframework.leetcode.lianbiao;

/**
 * @Auther: 李清依
 * @Date: 2022/11/8 10:46
 * @Description:
 */
public class lee24 {
    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode next=head.next;
        head.next=swapPairs(next.next);
        next.next=head;

        return next;
    }
}
