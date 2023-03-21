package edu.up.cs301.pig;

public class PigGameState extends GameState {

    private int whoseTurn;
    private int player0Score;
    private int player1Score;
    private int addedTotal;
    private int dieValue;


    /** Default constructor for the game state */
    public PigGameState() {
        whoseTurn = 0;
        player0Score = 0;
        player1Score = 0;
        addedTotal = 0;
    }//default ctor

    /**
     * Copy constructor of the default game state
     * @param original   The game state object we are copying over
     */
    public PigGameState(PigGameState original) {
        whoseTurn = original.whoseTurn;
        player0Score = original.player0Score;
        player1Score = original.player1Score;
        addedTotal = original.addedTotal;
        dieValue = original.dieValue;
    }//ctor
}
