import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> seen = new HashSet<>();

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                char current = board[row][col];

                if (current == '.') {
                    continue;
                }

                if (
                    !seen.add(current + " in row " + row) ||
                    !seen.add(current + " in col " + col) ||
                    !seen.add(current + " in box " + row/3 + "-" + col/3)
                ) {
                    return false;
                }
            }
        }

        return true;
    }
}