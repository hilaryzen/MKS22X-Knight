public class Driver {
  public static void main(String[] args) {
    KnightBoard board = new KnightBoard(3,3);
    System.out.println(board);

    //Should throw exception
    //KnightBoard board1 = new KnightBoard(0,3);

    System.out.println(board.solve(0,0));
    System.out.println(board);

    KnightBoard board1 = new KnightBoard(5,5);
    System.out.println(board1.solve(0,0));
    System.out.println(board1);
  }
}
