package IA.ProbIA5;

/**
 * Created by bejar on 17/01/17.
 */
public class ProbIA5Board {
    /* Class independent from AIMA classes
       - It has to implement the state of the problem and its operators
     *

    /* State data structure
        vector with the parity of the coins (we can assume 0 = heads, 1 = tails
     */

    private int [] board;
    private static int [] solution;

    /* Constructor */
    public ProbIA5Board(int []init, int[] goal) {

        board = new int[init.length];
        solution = new int[init.length];

        for (int i = 0; i< init.length; i++) {
            board[i] = init[i];
            solution[i] = goal[i];
        }

    }

    public ProbIA5Board(ProbIA5Board copy) {
        board = new int[copy.board.length];
        for (int i = 0; i < copy.getLength(); ++i) {
            board[i] = copy.board[i];
        }

    }

    /* vvvvv TO COMPLETE vvvvv */
    public void flip_it(int i){
        // flip the coins i and i + 1

        boolean last = false;
        if (i == board.length - 1) last = true;

        if (board[i] == 0) board[i] = 1;
        else board[i] = 0;

        if (!last) {
            if (board[i+1] == 0) board[i+1] = 1;
            else board[i+1] = 0;
        }
        else {
            if (board[0] == 0) board[0] = 1;
            else board[0] = 0;
        }

    }

    /* Heuristic function */
    //This function helps us to know what is the next state to visit
    public double heuristic(){
        // compute the number of coins out of place respect to solution
        int outCoins = 0;
        for (int i = 0; i < board.length; ++i) {
            if (board[i] != solution[i]) outCoins = outCoins + 1;
        }
        return outCoins;
    }
    public boolean heuristic2() {
        int sumBoard = 0;
        int sumSol = 0;
        for (int i = 0; i < board.length; ++i) {
            sumBoard += board[i];
            sumSol += solution[i];
        }
        if (sumBoard != sumSol) return false;
        else return true;
    }

     /* Goal test */
     public boolean is_goal(){
         // compute if board = solution
         for (int i = 0; i < board.length - 1 ; ++i) {
             System.out.println("Estoy comparando: " + board[i] + " con " + solution[i+1]);
             if (board[i] != solution[i]) return false;
         }
         return true;
     }

    public int getLength() {
        return board.length;
    }

    public void printBoard() {
         for (int i = 0; i < board.length; ++i) {
             System.out.print(board[i] + " ");
         }
         System.out.println();
    }

}
