package edu.up.cs301.pig;

public class PigGameState extends GameState {

    private int whoseTurn;
    private int player0Score;
    private int player1Score;
    private int addedTotal;
    private int dieValue;


    /** Default constructor for the game state */
    public PigGameState() {
    }//default ctor

    /**
     * Copy constructor of the default game state
     * @param original   The game state object we are copying over
     */
    public PigGameState(PigGameState original) {
    }//ctor
}
