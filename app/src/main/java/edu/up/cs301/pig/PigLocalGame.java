package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

// dummy comment, to see if commit and push work from srvegdahl account

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    PigGameState gameInstance;

    /** This ctor creates a new game state */
    public PigLocalGame() {
        gameInstance = new PigGameState();
    }//default ctor

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        return (playerIdx == gameInstance.getTurn());
    }//canMove

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        int playerCount = players.length;
        int playerTurn = gameInstance.getTurn();

        if (action instanceof PigHoldAction) {
            if (playerTurn == 0) {
                gameInstance.setPlayer0Score(gameInstance.getPlayer0Score() + gameInstance.getCurrTotal());
                gameInstance.setCurrTotal(0);
            } else if (playerTurn == 1) {
                gameInstance.setPlayer1Score(gameInstance.getPlayer1Score() + gameInstance.getCurrTotal());
                gameInstance.setCurrTotal(0);
            }
            if (playerCount > 1) {
                gameInstance.flipTurn();
            }
            return true;
        } else if (action instanceof PigRollAction) {
            Random rand = new Random();

            gameInstance.setDieValue(rand.nextInt(6) + 1);
            int dieVal = gameInstance.getDieValue();
            if (dieVal != 1) {
                gameInstance.setCurrTotal(gameInstance.getCurrTotal() + dieVal);
            } else if (dieVal == 1) {
                gameInstance.setCurrTotal(0);
                if (playerCount > 1) {
                    gameInstance.flipTurn();
                }
            }
            return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState temp = new PigGameState(gameInstance);
        p.sendInfo(temp);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if (gameInstance.getPlayer0Score() >= 50) {//Checks player0
            return "Player 0 has won the game";
        } else if (gameInstance.getPlayer1Score() >= 50){//Checks player1
            return "Player 1 has won the game";
        } return null;
    }//checkIfGameOver

}// class PigLocalGame
