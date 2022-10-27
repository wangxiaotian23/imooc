package cn.bugstack.springframework.leetcode.codetop;

import java.util.*;

/**
 * @Auther: 李清依
 * @Date: 2022/10/14 22:14
 * @Description:
 */
public class test1 {
    /**
     * 15. 三数之和
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1, R = len - 1;
            while (L < R) {
                List<Integer> list = new ArrayList<>();
                int sum = nums[L] + nums[R] + nums[i];
                if (sum == 0) {
                    list.add(nums[i]);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    res.add(list);
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                } else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return res;
    }

    /**
     * 121. 买卖股票的最佳时机
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE, len = prices.length;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            if (prices[i] < min) {
                prices[i] = min;
            } else {
                int x = prices[i] - min;
                max = Math.max(x, max);
            }

        }
        return max;
    }

    public int maxSubArray1(int[] nums) {
        int len = nums.length;
        int dp[] = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] < 0) {
                dp[i - 1] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
        }
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = nums[0], max = Integer.MIN_VALUE, count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (sum < nums[i]) {
                sum = nums[i];
            }
            sum += nums[i];
            max = Math.max(sum, max);

        }
        return max;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        dfs(res, list, nums, 0);
        return res;

    }

    public void dfs(List<List<Integer>> res, LinkedList<Integer> list, int[] nums, int start) {
        res.add(new LinkedList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            dfs(res, list, nums, i + 1);
            list.removeLast();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        dfs1(res, list, nums);
        return res;
    }

    public void dfs1(List<List<Integer>> res, LinkedList<Integer> list, int nums[]) {
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            dfs1(res, list, nums);
            list.removeLast();
        }
    }

    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1, len2 = num2.length() - 1;
        int jin = 0, i = 0, j = 0, sum = 0;
        StringBuilder sb = new StringBuilder();
        while (len1 >= 0 || len2 >= 0 || jin != 0) {
            int x = 0;
            if (len1 >= 0) {
                x += num1.charAt(len1--) - '0';
            }
            if (len2 >= 0) {
                x += num2.charAt(len2--) - '0';
            }
            x += jin;
            sb.append(x % 10);
            jin = x / 10;
        }
        sb.reverse();
        return sb.toString();
    }

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int dp[] = new int[len];

        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public void nextPermutation(int[] nums) {
        List<Integer> list = new ArrayList<>();

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (char c:
             array) {
            if (c=='('){
                stack.push(')');
            }else if (c=='{'){
                stack.push('}');
            }else if (c=='['){
                stack.push(']');
            }else if (stack.pop()!=c){
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        test1 test1 = new test1();
        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(test1.addStrings(String.valueOf(11), String.valueOf(123)));
    }
}
