package cn.bugstack.springframework.leetcode.hard;

/**
 * @Auther: 李清依
 * @Date: 2022/11/9 09:25
 * @Description:
 */
public class lee41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean barrel[] = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i]<=nums.length) {
                barrel[nums[i]] =true;
            }
        }
        for (int i = 1; i <nums.length ; i++) {
            if (barrel[i]==false){
                return i;
            }
        }

        return len + 1;
    }
}
