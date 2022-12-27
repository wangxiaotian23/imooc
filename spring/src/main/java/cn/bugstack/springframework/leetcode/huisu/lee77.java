package cn.bugstack.springframework.leetcode.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: 李清依
 * @Date: 2022/11/6 21:00
 * @Description:
 */
public class lee77 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        dfs(list, n, k, 1);
        return res;
    }

    public void dfs(LinkedList<Integer> list, int n, int k, int start) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(list, n, k, i + 1);
            list.removeLast();
        }
    }
}
