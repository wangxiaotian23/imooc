package cn.bugstack.springframework.leetcode.lianbiao;

import java.util.LinkedList;

/**
 * @Auther: 李清依
 * @Date: 2022/11/9 14:15
 * @Description:
 */
public class test4 {
    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>();
        int arr[]={1,2,3,4,5};
        for (int i = 0; i < arr.length; i++) {
            list.addLast(arr[i]);
        }
        for(int m:list){
            System.out.println(m);
        }
    }
}
