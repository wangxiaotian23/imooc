package cn.bugstack.springframework.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: 李清依
 * @Date: 2022/10/23 15:36
 * @Description:
 */
public class Main101 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int m=scanner.nextInt();
            List<Integer>list=new ArrayList<>();
            for (int i = 0; i <m ; i++) {
                int n=scanner.nextInt();
                list.add(n);
            }
            int x=scanner.nextInt();
            if (x==0){
                Collections.sort(list);
                for (int i = 0; i <list.size()-1 ; i++) {
                    System.out.print(list.get(i)+" ");
                }
                System.out.print(list.get(list.size()-1));
            }else {
                Collections.sort(list);
                Collections.reverse(list);
                for (int i = 0; i <list.size()-1 ; i++) {
                    System.out.print(list.get(i)+" ");
                }
                System.out.print(list.get(list.size()-1));
            }
        }
    }
}
