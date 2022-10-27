package cn.bugstack.springframework.huawei;

import java.util.Scanner;

/**
 * @Auther: 李清依
 * @Date: 2022/10/23 15:26
 * @Description:
 */
public class Main75 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        for(int n1 = 0 ; n1 < 14;n1++){
            for(int n2 = 0; n2 <= 25;n2++){
                if(7*n1+4*n2==100){
                    int n3 = 100 - n1 - n2;
                    System.out.println(n1+" "+n2+" "+n3);
                }
            }
        }
    }
}
