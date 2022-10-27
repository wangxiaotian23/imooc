package cn.bugstack.springframework.leetcode;

import java.util.*;

/**
 * @Auther: 李清依
 * @Date: 2022/9/25 09:13
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();

        for (int i = 1; i <= m; i++) {
            map.put(i,"ye");
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <=m ; j++) {
                if (j%i==0){
                    if (map.get(j)=="ye"){
                        map.put(j,"red");
                    }else {
                        map.put(j,"ye");
                    }
                }
            }
        }
        for (int i = 1; i <=m ; i++) {
            if (map.get(i)=="ye"){
                list.add(i);
            }
        }
        for (int i = 0; i < list.size()-1; i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.print(list.get(list.size()-1));

    }
}
