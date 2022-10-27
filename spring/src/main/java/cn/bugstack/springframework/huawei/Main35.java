package cn.bugstack.springframework.huawei;

import java.io.IOException;
import java.util.Scanner;

/**
 * @Auther: 李清依
 * @Date: 2022/10/25 16:42
 * @Description:
 */
public class Main35 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();
        for(int i = 0; i < col; i++){
            for(int j = i; j < col; j++){
                System.out.print((j+1)*(j+2)/2-i+" ");
            }
            System.out.println();
        }
    }
}
