package IA.ProbIA5;

import aima.search.framework.SuccessorFunction;
import aima.search.framework.Successor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bejar on 17/01/17
 */
public class ProbIA5SuccesorFunction implements SuccessorFunction{

    public List getSuccessors(Object state){
        ArrayList retval = new ArrayList();
        ProbIA5Board board = (ProbIA5Board) state;

        // Some code here
        // (flip all the consecutive pairs of coins and generate new states
        // Add the states to retval as Succesor("flip i j", new_state)
        // new_state has to be a copy of state

        for (int i = 0; i <= board.getLength()-1; ++i){
            board.flip_it(i);
            ProbIA5Board newState = new ProbIA5Board(board);
            Successor successor = new Successor("flip " + i + " " + (i+1), newState);
            if (newState.heuristic2())  retval.add(successor);
        }

        return retval; 

    }

}
