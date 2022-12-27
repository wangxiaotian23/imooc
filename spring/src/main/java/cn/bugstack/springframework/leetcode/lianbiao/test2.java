package cn.bugstack.springframework.leetcode.lianbiao;

import java.util.*;

/**
 * @Auther: 李清依
 * @Date: 2022/10/30 22:14
 * @Description:
 */
public class test2 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    public ListNode reverse(ListNode a, ListNode b) {
        ListNode cur = a, pre = null, next = a;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        Map<Integer, Integer> map = new LinkedHashMap<>();
        ListNode dummy = head;
        while (dummy != null) {
            int i = dummy.val;
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
            dummy=dummy.next;
        }
        Set <Integer>entries = map.keySet();
        ListNode dummy1=new ListNode(0);
        ListNode l1=dummy1;
        for (Object o:entries
             ) {
            if (map.get(o)==1){
                ListNode l2 = new ListNode((int) o);
                l1.next=l2;
                l1=l1.next;
            }
        }
        return dummy1.next;
        
    }
    public ListNode deleteDuplicates1(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode next=head.next;
        if (head.val==next.val){
            while (head.val==next.val){
                next=next.next;
            }
            head=deleteDuplicates1(next);
        }else {
            head.next=deleteDuplicates1(head);
        }

        return head;
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pollFirst());
        }
        for (int m : list) {
            System.out.println(m);
        }
    }
}
