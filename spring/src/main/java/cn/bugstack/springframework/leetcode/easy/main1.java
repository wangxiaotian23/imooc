package cn.bugstack.springframework.leetcode.easy;

import java.util.Stack;

/**
 * @Auther: 李清依
 * @Date: 2022/10/8 08:44
 * @Description:
 */
public class main1 {
    /**
     * 977. 有序数组的平方
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1, k = nums.length - 1;
        int arr[] = new int[nums.length];
        while (i <= j) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                arr[k] = nums[j] * nums[j];
                j--;
            } else {
                arr[k] = nums[i] * nums[i];
                i++;
            }
            k--;
        }
        return arr;
    }


}

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        // 数据栈和辅助栈一定会增加元素
        stack.add(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.add(x);
        } else {
            minStack.add(minStack.peek());
        }
    }

    public void pop() {
        // 两个栈都得 pop
        if (!stack.isEmpty()) {
            minStack.pop();
            stack.pop();
        }
    }
    

    public int top() {
        if (!stack.isEmpty()){
            return (int)stack.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if (!minStack.isEmpty()){
            return (int)minStack.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}
