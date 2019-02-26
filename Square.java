public class Square {
  private int row;
  private int col;
  private int outgoingMoves;

  public Square(int startingRow, int startingCol, int boardRows, int boardCols) {
    row = startingRow;
    col = startingCol;
    if (startingRow == 0 || startingRow == boardRows - 1) {
      if (startingCol == 0 || startingCol == boardCols - 1) {
        outgoingMoves = 2;
      } else if (startingCol == 1 || startingCol == boardCols - 2) {
        outgoingMoves = 3;
      } else {
        outgoingMoves = 4;
      }
    } else if (startingRow == 1 || startingRow == boardRows - 2) {
      if (startingCol == 0 || startingCol == boardCols - 1) {
        outgoingMoves = 3;
      } else if (startingCol == 1 || startingCol == boardCols - 2) {
        outgoingMoves = 4;
      } else {
        outgoingMoves = 6;
      }
    } else {
      if (startingCol == 0 || startingCol == boardCols - 1) {
        outgoingMoves = 4;
      } else if (startingCol == 1 || startingCol == boardCols - 2) {
        outgoingMoves = 6;
      } else {
        outgoingMoves = 8;
      }
    }
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  public int getMoves() {
    return outgoingMoves;
  }

  public void setMoves(int newMoves) {
    outgoingMoves = newMoves;
  }
}
