package cn.bugstack.springframework.leetcode.lianbiao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: 李清依
 * @Date: 2022/11/9 09:45
 * @Description:
 */
public class lee143 {
    private volatile static lee143 lee14;

    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        if (head == null) {
            return;
        }
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i==j){
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }


    public static lee143 getInstance() {
        if (lee14 == null) {
            synchronized (lee143.class) {
                if (lee14 == null) {
                    lee14 = new lee143();
                }
            }
        }
        return lee14;
    }
}
