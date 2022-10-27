package cn.bugstack.springframework.huawei;

import java.util.*;

/**
 * @Auther: 李清依
 * @Date: 2022/10/21 09:35
 * @Description:
 */
public class Main102 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Map<Character,Integer>map=new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c:chars
             ) {
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        StringBuilder sb=new StringBuilder();
        Collection<Integer> values = map.values();

    }
}
