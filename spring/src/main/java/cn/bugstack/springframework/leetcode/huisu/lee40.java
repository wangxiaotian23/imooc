package cn.bugstack.springframework.leetcode.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: 李清依
 * @Date: 2022/11/6 22:32
 * @Description:
 */
public class lee40 {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer>list=new LinkedList<>();
        dfs(list,target,0,candidates,0);
        return res;
    }
    public void dfs(LinkedList<Integer> list, int target, int sum, int[] candidates, int start) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            if (!res.contains(list)) res.add(new ArrayList<>(list));
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            sum += candidates[i];
            dfs(list, target, sum, candidates, i+1);
            sum -= candidates[i];
            list.removeLast();

        }
    }
}
