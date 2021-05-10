package solution_0051.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N 皇后
 *
 * @author ZhouYi
 * 2021/5/10 11:09 下午
 */
public class Solution {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<char[]> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            board.add(row);
        }
        trace(board, 0);
        return result;
    }

    public void trace(List<char[]> board, int row) {
        if (row == board.size()) {
            List<String> rowRes = new ArrayList<>();
            for (char[] chars : board) {
                rowRes.add(new String(chars));
            }
            result.add(rowRes);
            return;
        }

        for (int col = 0; col < board.size(); col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board.get(row)[col] = 'Q';

            trace(board, row + 1);

            board.get(row)[col] = '.';
        }

    }

    public boolean isValid(List<char[]> board, int row, int col) {
        int n = board.size();

        for (int i = 0; i < row; i++) {
            if (board.get(i)[col] == 'Q') {
                return false;
            }
        }

        for (int r = row - 1, c = col + 1; r >= 0 && c < n; r--, c++) {
            if (board.get(r)[c] == 'Q') {
                return false;
            }
        }

        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board.get(r)[c] == 'Q') {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        cases(5);
    }

    public static void cases(int n) {
        System.out.println(Arrays.toString(new Solution().solveNQueens(n).toArray()));
    }
}
