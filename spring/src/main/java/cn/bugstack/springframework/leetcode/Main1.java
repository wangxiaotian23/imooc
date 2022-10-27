package cn.bugstack.springframework.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: 李清依
 * @Date: 2022/9/25 09:43
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <str.length() ; i++) {
            list.add(Integer.parseInt(String.valueOf(str.charAt(i))));
        }
        String substring = str.substring(0, 3);
        int sum=0;
        for (int i = 0; i <3 ; i++) {
            sum+=list.get(i);
        }
        int sum1=sum;
        for (int i = 3; i <6 ; i++) {
            sum-=list.get(i);
        }
        int i=0,j=0,k=0;
        if (sum==0){
            if (list.get(3)==9){
                i=1;
                sum1-=1;
            }else {
                i=list.get(3);
            }
            if (list.get(4)<9){
                j=list.get(4)+1;
                k=sum1-i-j;
            }
        }
        System.out.println(substring+""+i+j+k);

    }
}
