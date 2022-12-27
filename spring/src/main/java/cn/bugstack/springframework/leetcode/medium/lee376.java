package cn.bugstack.springframework.leetcode.medium;

/**
 * @Auther: 李清依
 * @Date: 2022/11/14 17:09
 * @Description:
 */
public class lee376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int up = 1, down = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
       return Math.max(up, down);
    }
}
