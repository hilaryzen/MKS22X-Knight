public class KnightBoard {
  private int[][] board;

  public KnightBoard(int startingRows, int startingCols) {
    if (startingRows <= 0 || startingCols <= 0) {
      throw new IllegalArgumentException();
    }
    board = new int[startingRows][startingCols];
  }

  //Blank boards display underscores
  //Otherwise displays numbers showing knight's path
  public String toString() {
    String ans = "";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 0) {
          ans += "_ ";
        } else {
          ans = ans + board[i][j] + " ";
        }
      }
      ans += '\n';
    }
    return ans;
  }

  //Modifies the board by labeling the moves from 1 to the area of board in knight move steps
  public boolean solve(int startingRow, int startingCol) {
    int[] movesR = {-2, -1, 1, 2, 2, 1, -1, -2};
    int[] movesC = {1, 2, 2, 1, -1, -2, -2, -1};
    return solveH(0,0,1, movesR, movesC);
  }

  private boolean solveH(int row, int col, int level, int[] movesR, int[] movesC) {
    if (level > board.length * board[0].length) { //Checks if all squares have been filled
      return true;
    } else {
      for (int i = 0; i < movesR.length; i++) { //Loops through all possible moves
        //Checking if row and col are within the board
        if (row + movesR[i] >= 0 && row + movesR[i] < board.length && col + movesC[i] >= 0 && col + movesC[i] < board[0].length) {
          if (board[row + movesR[i]][col + movesC[i]] == 0 && solveH(row + 2, col + 1, level + 1)) {
            board[row + 2][col + 1] = level;
            return true;
          }
        }
      }
    }
    return false;
  }
}
