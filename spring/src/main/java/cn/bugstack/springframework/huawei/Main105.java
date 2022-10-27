package cn.bugstack.springframework.huawei;

import java.util.Scanner;

/**
 * @Auther: 李清依
 * @Date: 2022/10/21 08:56
 * @Description:
 */
public class Main105 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0, sum = 0, count1 = 0;
        while (scanner.hasNext()) {

            int i = scanner.nextInt();
            if (i < 0) {
                count++;
            } else {
                sum += i;
                count1++;
            }

        }
        System.out.println(count);
        if (count1==0){
            System.out.println(0.0);
        }else {
            System.out.printf("%1.f\n",sum/count1);
        }
    }
}
