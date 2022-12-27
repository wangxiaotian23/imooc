package cn.bugstack.springframework.leetcode.codetop;

/**
 * @Auther: 李清依
 * @Date: 2022/11/8 20:16
 * @Description:
 */
public class lee79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs1(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;
    }

    int dx1[] = {-1, 0, 1, 0}, dy1[] = {0, 1, 0, -1};

    public boolean dfs1(char[][] board, int i, int j, int u,String word) {

        if (board[i][j]!=word.charAt(u)){
            return false;
        }
        if (u==word.length()-1){
            return true;
        }
        char temp=board[i][j];
        board[i][j]='.';

        for (int k = 0; k <4 ; k++) {
            int x=dx1[k]+i;int y=dy1[k]+j;
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length||board[x][y]=='.') {
                continue;
            }
            if (dfs1(board,i,j,u+1,word)){
                return true;
            }
        }
        board[i][j]=temp;
        return false;

    }

//    // 存放几个偏移量，方便修改x，y坐标向四周搜索
//    int[] dx = new int[]{-1, 0, 1, 0};
//    int[] dy = new int[]{0, 1, 0, -1};
//
//    // 题设数组、题设单词、枚举到了word的第几个位置、xy为当然搜索的二维字符网格横纵坐标
//    boolean dfs(char[][] board, String word, int u, int x, int y) {
//        if (board[x][y] != word.charAt(u))// 递归边界1
//        {
//            return false;
//        } // 如果没有匹配到word第u个字符，直接退出，不符题意
//
//        if (u == word.length() - 1) {// 递归边界2
//            return true;// 搜索到单词末尾，完成目标，返回ture
//        }
//
//        char char_temp = board[x][y];// 临时存一下
//        board[x][y] = '.';// 这里随意，保证前后一致即可，主要是改成特殊字母避免重复搜索
//
//        for (int i = 0; i < 4; i++) {// board[x][y]==word.charAt(u) 为真，且没有到边界，向四周搜索
//            int a = x + dx[i]; // 加减一些偏移量实现四周搜索，如i=1时，a、b的值是x-1、y不变，即向左搜索
//            int b = y + dy[i];
//            if (a < 0 || a >= board.length || b < 0 || b >= board[0].length || board[a][b] == '.') {
//                continue; // 当到达搜索边界或者找到了已经搜过的字符，换一个位置重新搜
//            }
//            if (dfs(board, word, u + 1, a, b)) {
//                return true; // 如果没有到上个if检测的检测的边界或者已经搜索过的，则对word的下一个字符进行dfs搜索递归
//            }
//        }
//        // 回溯，将填充的.变回去
//        board[x][y] = char_temp;
//        return false;
//    }
}
