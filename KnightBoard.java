public class KnightBoard {
  private int[][] board;

  public KnightBoard(int startingRows, int startingCols) {
    board = new int[startingRows][startingCols];
  }

  public String toString() {
    String ans = "";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 0) {
          ans += "_ ";
        }
      }
      ans += '\n';
    }
  }
}
