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
          if (board.length * board[0].length >= 10) {
            ans += " _ ";
          } else {
            ans += "_ ";
          }
        } else {
          if (board.length * board[0].length >= 10 && board[i][j] / 10 == 0) {
            ans = ans + " " + board[i][j] + " ";
          } else {
            ans = ans + board[i][j] + " ";
          }
        }
      }
      ans += '\n';
    }
    return ans;
  }

  //Adds knight to given square if possible
  public boolean addKnight(int row, int col, int level) {
    if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
      if (board[row][col] == 0) {
        board[row][col] = level;
        return true;
      }
    }
    return false;
  }

  //Removes knight by replacing value with 0
  public boolean removeKnight(int row, int col) {
    if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
      if (board[row][col] != 0) {
        board[row][col] = 0;
        return true;
      }
    }
    return false;
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
      if (addKnight(row, col, level)) {
        //Debugging
        //System.out.println(toString());
        for (int i = 0; i < movesR.length; i++) { //Loops through all possible moves
          if (solveH(row + movesR[i], col + movesC[i], level + 1, movesR, movesC)) {
            return true;
          }
          //removeKnight(row, col);
        }
        removeKnight(row, col);
      }
      return false;
    }
  }
}
