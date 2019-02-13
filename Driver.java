public class Driver {
  public static void main(String[] args) {
    KnightBoard board = new KnightBoard(3,3);
    System.out.println(board);

    //Should throw exception
    //KnightBoard board1 = new KnightBoard(0,3);
  }
}
