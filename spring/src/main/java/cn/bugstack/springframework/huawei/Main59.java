package cn.bugstack.springframework.huawei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Auther: 李清依
 * @Date: 2022/10/26 19:24
 * @Description:
 */
public class Main59 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (map.get(str.charAt(i)) == 1) {
                System.out.print(str.charAt(i));
                return;
            }
        }
        System.out.print("-1");
    }
}
