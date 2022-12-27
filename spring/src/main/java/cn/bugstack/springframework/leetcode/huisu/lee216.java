package cn.bugstack.springframework.leetcode.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: 李清依
 * @Date: 2022/11/6 21:10
 * @Description:
 */
public class lee216 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        LinkedList<Integer> list = new LinkedList<>();
        dfs(list, n, k, 1, 0);
        return res;
    }

    public void dfs(LinkedList<Integer> list, int n, int k, int start, int sum) {
        if (sum > n) {
            return;
        }
        if (list.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(list));
            }

        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            sum += i;
            dfs(list, n, k, i + 1, sum);
            sum -= i;
            list.removeLast();

        }
    }
}
