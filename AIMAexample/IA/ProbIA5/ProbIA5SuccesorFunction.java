package IA.ProbIA5;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

import javax.swing.text.StyledEditorKit;
import java.util.*;

/**
 * Created by bejar on 17/01/17
 */
public class ProbIA5SuccesorFunction implements SuccessorFunction{

    public List getSuccessors(Object state){
        List retval = new ArrayList();
        ProbIA5Board board = (ProbIA5Board) state;
        int currentHeuristic = 0;
        // Some code here
        // (flip all the consecutive pairs of coins and generate new states
        // Add the states to retval as Succesor("flip i j", new_state)
        // new_state has to be a copy of state

        for (int i = 0; i < board.getLength(); ++i) {
            ProbIA5Board newState = board.getCopy();
            newState.flip_it(i);
            Successor successor = new Successor("Flip: " + i + " and flip: " + (i+1)% board.getLength(), newState);
            retval.add(successor);
        }

        return retval;

    }

}
