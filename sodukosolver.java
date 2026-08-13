class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];

       
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int val = board[r][c] - '0';
                    int boxIdx = (r / 3) * 3 + (c / 3);
                    rows[r][val] = true;
                    cols[c][val] = true;
                    boxes[boxIdx][val] = true;
                }
            }
        }

        backtrack(board, 0, 0, rows, cols, boxes);
    }

    private boolean backtrack(char[][] board, int r, int c, 
                              boolean[][] rows, boolean[][] cols, boolean[][] boxes) {
       
        if (r == 9) {
            return true;
        }

      
        if (c == 9) {
            return backtrack(board, r + 1, 0, rows, cols, boxes);
        }

      
        if (board[r][c] != '.') {
            return backtrack(board, r, c + 1, rows, cols, boxes);
        }

        int boxIdx = (r / 3) * 3 + (c / 3);

        for (int num = 1; num <= 9; num++) {
            if (!rows[r][num] && !cols[c][num] && !boxes[boxIdx][num]) {
           
                board[r][c] = (char) (num + '0');
                rows[r][num] = true;
                cols[c][num] = true;
                boxes[boxIdx][num] = true;

             
                if (backtrack(board, r, c + 1, rows, cols, boxes)) {
                    return true;
                }

              
                board[r][c] = '.';
                rows[r][num] = false;
                cols[c][num] = false;
                boxes[boxIdx][num] = false;
            }
        }

        return false; 
    }
}
