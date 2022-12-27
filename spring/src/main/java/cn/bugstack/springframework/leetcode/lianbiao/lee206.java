package cn.bugstack.springframework.leetcode.lianbiao;

/**
 * @Auther: 李清依
 * @Date: 2022/11/7 17:21
 * @Description:
 */
public class lee206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre=head,cur=head,next=null;
        while (cur!=null){
            next=head.next;
            head.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
