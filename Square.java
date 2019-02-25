public class Square {
  private int row;
  private int col;
  private int outgoingMoves;

  public Square (int startingRow, int startingCol, int boardRows, int boardCols) {
    row = startingRow;
    col = startingCol;
    if (startingRow == 0 || startingRow == boardRows - 1) {
      if (startingCol == 0 || startingCol == boardCols - 1) {
        outgoingMoves = 2;
      }
    }
  }

  //public void setMoves (int )
}
