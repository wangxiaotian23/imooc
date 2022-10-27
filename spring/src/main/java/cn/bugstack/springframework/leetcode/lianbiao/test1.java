package cn.bugstack.springframework.leetcode.lianbiao;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Auther: 李清依
 * @Date: 2022/9/29 10:15
 * @Description:
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class test1 {
    public boolean hasCycle(ListNode head) {
        List<ListNode> listNodeList = new ArrayList<>();
        while (head != null) {
            if (listNodeList.contains(head)) {
                return true;
            }
            listNodeList.add(head);
            head = head.next;
        }
        return false;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i = 0;
        ListNode l3 = new ListNode(0);
        ListNode cur = l3;
        int jin = 0;
        while (l1 != null || l2 != null || jin != 0) {
            if (l1 != null) {
                jin += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                jin += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(jin % 10);
            jin = jin / 10;

        }
        return l3.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l3 = new ListNode(0);
        ListNode cur = l3;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = new ListNode(list1.val);
                cur = cur.next;
                list1 = list1.next;
            } else {
                cur.next = new ListNode(list2.val);
                cur = cur.next;
                list1 = list1.next;
            }
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }

        return l3.next;
    }

    public ListNode partition(ListNode head, int x) {
        ListNode l3 = new ListNode(0);
        ListNode cur = l3;
        ListNode head1 = head;
        while (head != null) {
            if (head.val < x) {
                cur.next = new ListNode(head.val);
                cur = cur.next;
            }
            head = head.next;
        }
        while (head1 != null) {
            if (head1.val > x) {
                cur.next = new ListNode(head1.val);
                cur = cur.next;
            }
            head1 = head1.next;
        }
        return l3.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null)
            return null;
        if (lists.length == 1) {

        }
        ListNode l3 = new ListNode(0);
        ListNode cur = l3;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(
                lists.length, (a, b) -> (a.val - b.val)
        );
        for (ListNode head : lists) {
            if (head != null) {
                queue.add(head);
            }
        }
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            cur.next = new ListNode(poll.val);
            if (poll.next != null) {
                queue.add(poll.next);
            }
            cur = cur.next;
        }

        return l3.next;

    }

    /**
     * 19. 删除链表的倒数第 N 个结点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        int x = n;
        while (x > 0) {
            fast = fast.next;
            x--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return head;
    }

    /**
     * 876. 链表的中间结点
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 160. 相交链表
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    /**
     * 206. 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode last = reverseList1(head.next);
        head = head.next.next;
        head.next = null;
        return last;
    }

    ListNode reverseN(ListNode head, int n) {
        ListNode successor = null;
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;

    }

//    public ListNode reverseBetween(ListNode head, int left, int right) {
//
//    }

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            while (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    /**
     * 83. 删除排序链表中的重复元素
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            while (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

}
