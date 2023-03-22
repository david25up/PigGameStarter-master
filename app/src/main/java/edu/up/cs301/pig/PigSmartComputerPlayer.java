package edu.up.cs301.pig;

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
public class PigSmartComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigSmartComputerPlayer(String name) {
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

        int currScore;
        int oppScore;
        if (playerNum == 0) {
            currScore = pigGameState.getPlayer0Score();
            oppScore = pigGameState.getPlayer1Score();
        } else {
            currScore = pigGameState.getPlayer1Score();
            oppScore = pigGameState.getPlayer0Score();
        }

        int diff = 50 - currScore;
        int oppDiff = 50 - oppScore;

        if (pigGameState.getCurrTotal() >= diff || pigGameState.getCurrTotal() >= oppDiff || diff <= 10) {
            PigHoldAction action = new PigHoldAction(this);
            game.sendAction(action);
        } else {
            PigRollAction action = new PigRollAction(this);
            game.sendAction(action);
        }
    }//receiveInfo

}
