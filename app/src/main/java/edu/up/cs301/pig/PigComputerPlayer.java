package edu.up.cs301.pig;

import android.graphics.Color;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {

        //Flashes the screen red when not a PigGameState object
        if (!(info instanceof PigGameState)) {
            //info is not a PigGameState object
            return;
        }

        PigGameState pigGameState = new PigGameState( (PigGameState) info);

        if (pigGameState.getTurn() == playerNum) {
            return;
        } else {
            Random rand = new Random();

            int makeMove = rand.nextInt(2);

            if (makeMove == 0) {
                PigRollAction action = new PigRollAction(this);
                game.sendAction(action);
            } else {
                PigHoldAction action = new PigHoldAction(this);
                game.sendAction(action);
            }
        }



    }//receiveInfo

}
