package cn.bugstack.springframework.leetcode.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: 李清依
 * @Date: 2022/11/6 21:40
 * @Description:
 */
public class lee17 {

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(digits, sb, numString, 0);
        return res;
    }

    public void dfs(String digits, StringBuilder sb, String[] numString, int num) {
        if (num== digits.length()) {
            res.add(sb.toString());
            return;
        }
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i <str.length() ; i++) {
            sb.append(str.charAt(i));
            dfs(digits, sb, numString, num+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
