public class Driver {
  public static void main(String[] args) {
    KnightBoard board = new KnightBoard(3,3);
    System.out.println(board);

    //Should throw exception
    //KnightBoard board1 = new KnightBoard(0,3);

    System.out.println(board.solve(0,0));
    //System.out.println(board.solve(5,2)); //Should throw exception
    System.out.println(board);

    KnightBoard board1 = new KnightBoard(5,5);
    System.out.println(board1.solve(0,0));
    //System.out.println(board1.solve(4,4)); //Should throw exception
    System.out.println(board1);

    /*
    KnightBoard board2 = new KnightBoard(9,9);
    System.out.println(board2.solve(0,0));
    System.out.println(board2);
    */

    KnightBoard board3 = new KnightBoard(3,4);
    System.out.println(board3.solve(0,0));
    System.out.println(board3);
    System.out.println(board3.countSolutions(0,0));
  }
}
