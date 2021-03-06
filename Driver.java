import java.util.Arrays;

public class Driver {
  public static void main(String[] args) {
    KnightBoard board = new KnightBoard(3,3);
    System.out.println(board);
    System.out.println(board.moves());

    //Should throw exception
    //KnightBoard board1 = new KnightBoard(0,3);

    System.out.println(board.solve(0,0));
    //System.out.println(board.solve(5,2)); //Should throw exception
    System.out.println(board);

    KnightBoard board1 = new KnightBoard(5,5);
    System.out.println(board1.moves());
    System.out.println(board1.solve(0,0));
    //System.out.println(board1.solve(4,4)); //Should throw exception
    System.out.println(board1);

    System.out.println("Testing optimized solve");
    KnightBoard board2 = new KnightBoard(80,80);
    System.out.println(board2.solve(0,0));
    //System.out.println(board2);

    /*
    KnightBoard board3 = new KnightBoard(3,4);
    System.out.println(board3.moves());
    //System.out.println(board3.solve(0,0));
    //System.out.println(board3);
    System.out.println("Solutions for 3 by 4 (should be 2): " + board3.countSolutions(0,0));

    KnightBoard board4 = new KnightBoard(4,5);
    System.out.println("Solutions for 4 by 5 (should be 32): " + board4.countSolutions(0,0));

    KnightBoard board5 = new KnightBoard(4,6);
    System.out.println("Solutions for 4 by 6 (should be 220): " + board5.countSolutions(0,0));

    KnightBoard board6 = new KnightBoard(5,5);
    System.out.println("Solutions for 5 by 5 (should be 304): " + board6.countSolutions(0,0));
    */

    //Testing addKnight and removeKnight
    /*
    KnightBoard board7 = new KnightBoard(8,8);
    board7.addKnight(0,0,1);
    board7.addKnight(3,3,14);
    board7.removeKnight(0,0);
    System.out.println(board7);
    System.out.println(board7.moves());
    */

    //Testing sort
    /*
    System.out.println("Sorted arrays for (4,4): ");
    board7.sortMoves(4,4);
    System.out.println("Sorted arrays for (0,7): ");
    board7.sortMoves(0,7);
    */
  }
}
