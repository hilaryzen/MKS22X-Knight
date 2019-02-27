public class KnightBoard {
  private int[][] board;
  private int[][] outgoingMoves;
  private int[] movesR = {-2, -1, 1, 2, 2, 1, -1, -2};
  private int[] movesC = {1, 2, 2, 1, -1, -2, -2, -1};

  public KnightBoard(int startingRows, int startingCols) {
    if (startingRows <= 0 || startingCols <= 0) {
      throw new IllegalArgumentException();
    }
    board = new int[startingRows][startingCols];
    //Setting up board of outgoing moves
    outgoingMoves = new int[startingRows][startingCols];
    for (int i = 0; i < startingRows; i++) {
      for (int j = 0; j < startingCols; j++) {
        if (i == 0 || i == startingRows - 1) {
          if (j == 0 || j == startingCols - 1) {
            outgoingMoves[i][j] = 2;
          } else if (j == 1 || j == startingCols - 2) {
            outgoingMoves[i][j] = 3;
          } else {
            outgoingMoves[i][j] = 4;
          }
        } else if (i == 1 || i == startingRows - 2) {
          if (j == 0 || j == startingCols - 1) {
            outgoingMoves[i][j] = 3;
          } else if (j == 1 || j == startingCols - 2) {
            outgoingMoves[i][j] = 4;
          } else {
            outgoingMoves[i][j] = 6;
          }
        } else {
          if (j == 0 || j == startingCols - 1) {
            outgoingMoves[i][j] = 4;
          } else if (j == 1 || j == startingCols - 2) {
            outgoingMoves[i][j] = 6;
          } else {
            outgoingMoves[i][j] = 8;
          }
        }
      }
    }
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

  //Printing out the board of outgoing moves
  public String moves() {
    String ans = "";
    for (int i = 0; i < outgoingMoves.length; i++) {
      for (int j = 0; j < outgoingMoves[0].length; j++) {
        ans = ans + outgoingMoves[i][j] + " ";
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
        //Loop takes away one possible move to all squares knight can reach
        for (int i = 0; i < movesR.length; i++) {
          if (row + movesR[i] >= 0 && row + movesR[i] < board.length && col + movesC[i] >= 0 && col + movesC[i] < board[0].length) {
            outgoingMoves[row + movesR[i]][col + movesC[i]]--;
          }
        }
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
        //Loop adds back one possible move to all squares knight can reach
        for (int i = 0; i < movesR.length; i++) {
          if (row + movesR[i] >= 0 && row + movesR[i] < board.length && col + movesC[i] >= 0 && col + movesC[i] < board[0].length) {
            outgoingMoves[row + movesR[i]][col + movesC[i]]++;
          }
        }
        return true;
      }
    }
    return false;
  }

  //Modifies the board by labeling the moves from 1 to the area of board in knight move steps
  //Leaves board blank if there is no solution
  //Throws IllegalStateException when there are non-zero values
  //Throws IllegalArgumentException when parameters are negative or out of bounds
  public boolean solve(int startingRow, int startingCol) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] != 0) {
          throw new IllegalStateException();
        }
      }
    }
    if (startingRow < 0 || startingRow >= board.length || startingCol < 0 || startingCol >= board[startingRow].length) {
      throw new IllegalArgumentException();
    }
    return solveH(startingRow, startingCol, 1);
  }

  private boolean solveH(int row, int col, int level) {
    if (level > board.length * board[0].length) { //Checks if all squares have been filled
      return true;
    } else {
      if (addKnight(row, col, level)) {
        //Debugging
        //System.out.println(toString());
        for (int i = 0; i < movesR.length; i++) { //Loops through all possible moves
          if (solveH(row + movesR[i], col + movesC[i], level + 1)) {
            return true;
          }
          //removeKnight(row, col);
        }
        removeKnight(row, col);
      }
      return false;
    }
  }

  //Returns number of solutions specified from starting point
  //Throws IllegalStateException when there are non-zero values
  //Throws IllegalArgumentException when parameters are negative or out of bounds
  public int countSolutions(int startingRow, int startingCol) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] != 0) {
          throw new IllegalStateException();
        }
      }
    }
    if (startingRow < 0 || startingRow >= board.length || startingCol < 0 || startingCol >= board[startingRow].length) {
      throw new IllegalArgumentException();
    }
    return countH(startingRow, startingCol, 1);
  }

  private int countH(int row, int col, int level) {
    int total = 0;
    /*
    if (level > board.length * board[0].length) {
      return 1; //Base case for solved board
    } else {
      if (addKnight(row, col, level)) {
        for (int i = 0; i < movesR.length; i++) {
          total += countH(row + movesR[i], col + movesC[i], level + 1);
        }
        removeKnight(row,col);
      }
      return total;
    }
    */
    if (addKnight(row, col, level)) {
      if (level == board.length * board[0].length) { //Base case, when board is solved
        removeKnight(row, col);
        return 1;
      } else {
        for (int i = 0; i < movesR.length; i++) { //Loops through possible moves
          //Adds # of solutions from each possible move
          total += countH(row + movesR[i], col + movesC[i], level + 1);
        }
      }
      removeKnight(row, col);
    }
    return total;
  }
}
