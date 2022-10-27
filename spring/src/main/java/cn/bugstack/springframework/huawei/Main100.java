package cn.bugstack.springframework.huawei;

import java.util.Scanner;

/**
 * @Auther: 李清依
 * @Date: 2022/10/23 15:20
 * @Description:
 */
public class Main100 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();

        int arr[]=new int[m+1];
        arr[1]=2;
        for (int i = 1; i <=m-1 ; i++) {
            arr[i+1]=arr[i]+3;
        }
        int sum=0;
        for (int i = 1; i <=m ; i++) {
            sum+=arr[i];
        }
        System.out.println(sum);
    }
}
