package cn.bugstack.springframework.huawei;

import java.util.Scanner;

/**
 * @Auther: 李清依
 * @Date: 2022/10/21 08:41
 * @Description:
 */
public class Main106 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        StringBuilder sb=new StringBuilder();
        if (strings.length==1){
            sb.append(strings[0]).reverse();
            System.out.println(sb.toString());
        }else {
            int len=strings.length;
            for (int i = len-1; i >0 ; i--) {
                StringBuilder sb1=new StringBuilder();
                sb1.append(strings[i]).reverse();
                sb.append(sb1+" ");
            }
            StringBuilder sb2=new StringBuilder();
            sb2.append(strings[0]).reverse();
            sb.append(sb2);
            System.out.println(sb.toString());
        }
    }
    void reverse(String str){

    }

}
