package cn.bugstack.springframework.huawei;

import java.util.Scanner;

/**
 * @Auther: 李清依
 * @Date: 2022/10/27 11:00
 * @Description:
 */
public class Main60 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m= scanner.nextInt();
        for (int i = m/2; i >=2 ; i--) {
            if (isPrime(i)&&isPrime(m-i)){
                System.out.println(m-i);
                System.out.println(i);
                break;
            }
        }
    }

    static boolean isPrime(int x){
        boolean flag=true;
        for (int i = 2; i <= x; i++) {
            if (x%i==0){
                flag=false;
                break;
            }
        }
        return flag;
    }
}
