package IA.ProbIA5;

import java.util.ArrayList;

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
    private ArrayList<String> states;

    /* Constructor */
    public ProbIA5Board(int []init, int[] goal) {

        board = new int[init.length];
        solution = new int[init.length];


        for (int i = 0; i< init.length; i++) {
            board[i] = init[i];
            solution[i] = goal[i];
        }
    }


    /* Creates a copy of the board */
    public ProbIA5Board getCopy() {
        int[] copyBoard = new int[board.length];
        int[] copySolution = new int[board.length];

        for (int i = 0; i < board.length;  ++i) {
            copyBoard[i] = this.board[i];
            copySolution[i] = this.solution[i];
        }

        return new ProbIA5Board(copyBoard, copySolution);
    }

    /* vvvvv TO COMPLETE vvvvv */
    public void flip_it(int i){

       if (board[i] == 0) board[i] = 1;
       else board[i] = 0;

       int indexRange = (i+1)%board.length;

       if (board[indexRange] == 0) board[indexRange] = 1;
       else board[indexRange] = 0;
    }

    /* Heuristic function */
    public long heuristic(){
        // compute the number of coins out of place respect to solution
        int outCoins = 0;
        for (int i = 0; i < board.length; ++i) {
            if (board[i] != solution[i]) outCoins += 1;
        }
        return outCoins;
    }

     /* Goal test */
     public boolean is_goal(){
         boolean is_goal = true;
         for (int i = 0; i < board.length; ++i) {
             if (board[i] != solution[i]) is_goal = false;
         }
         return is_goal;
     }

     /* auxiliary functions */

     // Some functions will be needed for creating a copy of the state

    public int getLength() {
        return this.board.length;
    }

    public void addStateDescription() {
        String description = "";
        description += "State description: \n";
        for (int i = 0; i < this.board.length; ++i) {
            description += this.board[i] + " ";
        }
        description += "\n";

        System.out.println(description);
    }

    public int get(int i) {
        int index = i%board.length;
        return board[index];
    }
    /* ^^^^^ TO COMPLETE ^^^^^ */

}
