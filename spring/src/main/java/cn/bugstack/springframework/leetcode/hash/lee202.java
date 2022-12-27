package cn.bugstack.springframework.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: 李清依
 * @Date: 2022/11/8 14:39
 * @Description:
 */
public class lee202 {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();

        while (n!=1&&!set.contains(n)){
            set.add(n);
            n=getN(n);

        }
        return n==1;
    }

    public int getN(int n) {
        int sum = 0;
        while (n > 0) {
            int x = n % 10;
            sum += n * n;
            n = n / 10;
        }
        return sum;
    }
}
