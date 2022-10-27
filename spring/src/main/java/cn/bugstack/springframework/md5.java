package cn.bugstack.springframework;

import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 李清依
 * @Date: 2022/10/6 15:22
 * @Description:
 */
public class md5 {

    /**
     * 22. 括号生成
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(curStr+"(",left-1,right,res);
        }
        if (right > 0) {
            dfs(curStr+")",left,right-1,res);
        }
    }


    public static void main(String[] args) {
        String str = "4b4c46edc6e7e6cd";
        String s = DigestUtils.md5DigestAsHex(str.getBytes());
        System.out.println(s);
    }
}
