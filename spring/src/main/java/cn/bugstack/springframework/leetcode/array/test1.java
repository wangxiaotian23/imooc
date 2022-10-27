package cn.bugstack.springframework.leetcode.array;

/**
 * @Auther: 李清依
 * @Date: 2022/10/12 11:36
 * @Description:
 */
public class test1 {
    /**
     * 27. 移除元素
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[k++] = nums[i];
        }
        return k;
    }

    /**
     * 80. 删除有序数组中的重复项 II
     *
     * @param nums
     * @return
     */
//    public int removeDuplicates(int[] nums) {
//        int i=0;
//        for (int j = 0; j < ; j++) {
//
//        }
//
//        return i;
//    }

    /**
     * 189. 轮转数组
     *
     * @param nums
     * @param k
     */

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);

    }

    public void reverse(int nums[], int start, int end) {
        for (int i = start, j = end; start < end; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

//    /**
//     * 134. 加油站
//     *
//     * @param gas
//     * @param cost
//     * @return
//     */
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//
//    }


}
