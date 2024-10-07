package Array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        Set<Character> row = new HashSet<>();
        Set<Character> column = new HashSet<>();
        Set<String> square = new HashSet<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < board.length; i++) {
            row.clear();
            column.clear();

            if (i % 3 == 0 && i != 0) {
                square.clear();
                System.out.println("square cleared at i = " + i);
            }

            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j]) ||
                    board[j][i] != '.' && !column.add(board[j][i])) {
                    return false;
                }

                if (board[i][j] != '.') {
                    sb.append(board[i][j]);
                    sb.append(i/3);
                    sb.append(j/3);

                    System.out.println("in square[" + i/3 + "][" + j/3 + "], val = " + board[i][j]);
                    System.out.println(sb.toString());

                    if (!square.add(sb.toString())) {
                        System.out.println(sb.toString());
                        System.out.println("at i = " + i + ", j = " + j);
                        return false;
                    }
                }

                sb.setLength(0);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        isValidSudoku(new char[][] {
            {'.','.','.','.','.','.','5','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'9','3','.','.','2','.','4','.','.'},
            {'.','.','7','.','.','.','3','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','3','4','.','.','.','.'},
            {'.','.','.','.','.','3','.','.','.'},
            {'.','.','.','.','.','5','2','.','.'}
        });
    }
}
