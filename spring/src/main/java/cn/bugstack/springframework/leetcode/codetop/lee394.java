package cn.bugstack.springframework.leetcode.codetop;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Auther: 李清依
 * @Date: 2022/11/8 20:47
 * @Description:
 */
public class lee394 {
    public String decodeString(String s) {
//创建数字栈，创建字符串栈 及临时数字和临时字符串
        Deque<Integer> stack_digit = new LinkedList<>();
        Deque<StringBuilder> stack_string = new LinkedList<>();
        int digit = 0;
        StringBuilder res = new StringBuilder();
        //遍历字符串 分4中情况
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                //如果是"[" 将临时数字和临时字符串入栈
                stack_digit.push(digit);
                stack_string.push(res);
                digit = 0;
                res = new StringBuilder();
            }else if (ch == ']') {
                //如果是"]" 将数字和字符串出栈 此时临时字符串res = 出栈字符串 + 出栈数字*res
                StringBuilder temp = stack_string.poll();
                int count = stack_digit.poll();
                for (int j = 0; j < count; j++) {
                    temp.append(res.toString());
                }
                res = temp;
            }else if (Character.isDigit(ch)) {
                //如果是数字 将字符转成整型数字 ch-‘0’。 注意数字不一定是个位 比如100[a] 所以digit要*10
                digit = digit*10 + ch - '0';
            }else {
                //如果是字符 直接将字符放在临时字符串中
                res.append(ch);
            }
        }
        return res.toString();
    }
}
