package cn.bugstack.springframework.huawei;

import java.util.Scanner;

/**
 * @Auther: 李清依
 * @Date: 2022/10/20 08:58
 * @Description:
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextLine()){
//            String str=in.nextLine();
//
//            if (str.length()<8){
//                StringBuilder sb=new StringBuilder();
//                sb.append(str);
//                int x=8-str.length();
//                while (x>0){
//                    sb.append("0");
//                    x--;
//                }
//                System.out.println(sb.toString());
//            }else if(str.length()==8) {
//                System.out.println(str);
//            }else {
//                int len=str.length();
//                int x=len/8;
//                int i=0;
//                while (x>0){
//                    System.out.println(str.substring(i,i+8));
//                    i=i+8;
//                    x--;
//                }
//                StringBuilder sb=new StringBuilder();
//                int y=len%8;
//                sb.append(str, i, i+y);
//                y=8-y;
//                while (y>=0){
//                    sb.append("0");
//                    y--;
//                }
//                System.out.println(sb.toString());
//            }
//        }
        while (in.hasNextLine()){
            String str=in.nextLine();
            StringBuilder sb=new StringBuilder();
            if (str.length()%8!=0){
                int x=8-str.length()%8;
                sb.append(str);
                for (int i = 0; i <x ; i++) {
                    sb.append("0");
                }
            }
            while (sb.length()>=0){
                System.out.println(sb.substring(0,8));
                sb.delete(0,8);
            }
        }
    }
}
