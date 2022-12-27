package cn.bugstack.springframework.od;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: 李清依
 * @Date: 2022/11/14 15:44
 * @Description:
 */
public class liushuixian {
    public static void main(String[] args) {
        int res[]={8,4,3,2,10};
        int n =3;
        int m = 7;
        int i=0;
        Arrays.sort(res);
        List<Integer> list = new LinkedList<>();
        for(int j=0;j<res.length;j++){
            ((LinkedList<Integer>) list).addLast(res[j]);
        }
        int win[] = new int[n];
        int sum =0;
        while(!list.isEmpty()){
            for(int j=0;j<n;j++){
                if(win[j]==0&&!list.isEmpty())
                    win[j]=((LinkedList<Integer>) list).removeFirst();
            }
            Arrays.sort(win);
            int min =win[0];
            for(int j=0;j<n;j++){
                win[j]=win[j]-min;
            }
            sum=sum+min;
        }
        Arrays.sort(win);
        sum=sum+win[n-1];
        System.out.print(sum);
    }
}
