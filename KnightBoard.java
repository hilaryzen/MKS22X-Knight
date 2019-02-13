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
    return true;
  }

  private boolean solveH(int row, int col, int level) {
    if (level > board.length * board[0].length) {
      return true;
    }
    return false;
  }
}
