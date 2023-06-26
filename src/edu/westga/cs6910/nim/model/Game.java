package edu.westga.cs6910.nim.model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Game represents a Nim game with 1 pile of sticks. This class was started by
 * CS6910
 * 
 * @author Deeksha Namani
 * @version 6/5/2023
 */
public class Game implements Observable {
	/** Constant to define the initial pile size */
	public static final int INITIAL_PILE_SIZE = 7;

	/**
	 * Constant to define the maximum number of sticks to be removed per turn
	 */
	public static final int MAX_STICKS_PER_TURN = 3;

	private HumanPlayer theHuman;
	private ComputerPlayer theComputer;

	private ObjectProperty<Player> currentPlayerObject;

	private Pile thePile;

	/**
	 * Creates a nim Game with the specified Players and a pile of INITIAL_PILE_SIZE
	 * sticks.
	 * 
	 * @param theComputer the automated player
	 * @param theHuman    the human player
	 * 
	 * @require theHuman != null && theComputer != null
	 * 
	 * @ensure humanPlayer().equals(theHuman) && computerPlayer.equals(theComputer)
	 *         && sticksLeft() == INITIAL_PILE_SIZE
	 */
	public Game(HumanPlayer theHuman, ComputerPlayer theComputer) {
		this.theHuman = theHuman;
		this.theComputer = theComputer;

		this.currentPlayerObject = new SimpleObjectProperty<Player>();

		this.thePile = new Pile(INITIAL_PILE_SIZE);
	}

	/**
	 * Initializes the game for play.
	 * 
	 * @param firstPlayer the Player who takes the first turn
	 * 
	 * @require firstPlayer != null &&
	 * 
	 * @ensures whoseTurn().equals(firstPlayer) && sticksLeft() == INITIAL_PILE_SIZE
	 */
	public void startNewGame(Player firstPlayer) {
		this.currentPlayerObject.setValue(firstPlayer);

		this.thePile.resetPile(INITIAL_PILE_SIZE);
	}

	/**
	 * Conducts a move in the game, allowing the appropriate Player to take a turn.
	 * Has no effect if the game is over.
	 * 
	 * 1. Tell the current player to take its turn. 2. Swap whose turn it is.
	 * 
	 * @requires !isGameOver()
	 * 
	 * @ensures (!whoseTurn().equals(whoseTurn()@prev) && sticksLeft()) &lt;
	 *          (sticksLeft()@prev)
	 */
	public void play() {
		if (!this.isGameOver()) {
			this.getCurrentPlayer().takeTurn();
			this.swapWhoseTurn();
		}

		this.isGameOver();
	}

	/**
	 * Returns the human Player object.
	 * 
	 * @return the human Player
	 */
	public HumanPlayer getHumanPlayer() {
		return this.theHuman;
	}

	/**
	 * Returns the computer Player object.
	 * 
	 * @return the computer Player
	 */
	public ComputerPlayer getComputerPlayer() {
		return this.theComputer;
	}

	/**
	 * Returns the Player whose turn it is.
	 * 
	 * @return the current Player
	 */
	public Player getCurrentPlayer() {
		return this.currentPlayerObject.getValue();
	}

	/**
	 * Returns the number of sticks remaining in the pile.
	 * 
	 * @return how many sticks are left in the pile
	 */
	public int getSticksLeft() {
		return this.thePile.getSticksLeft();
	}

	/**
	 * Return whether the game is over.
	 * 
	 * @return true iff sticksLeft() <= 1
	 */
	public boolean isGameOver() {
		return this.thePile.getSticksLeft() <= 1;
	}

	/**
	 * Returns the Pile used in this Game.
	 * 
	 * @return the Pile
	 */
	public Pile getPile() {
		return this.thePile;
	}

	/**
	 * Returns a String representing the pile size, or, if the game is over, the
	 * name of the winner.
	 * 
	 * @return a String representation of this Game
	 */
	@Override
	public String toString() {
		if (!this.isGameOver()) {
			return " Pile size: " + this.thePile.getSticksLeft();
		}

		String result = "Game over! Winner: ";
		if (this.currentPlayerObject.getValue() == this.theComputer) {
			result += this.theHuman.getName();
		} else {
			result += this.theComputer.getName();
		}
		return result;
	}

	/**
	 * Swap the players so that the other player becomes the current player.
	 */
	private void swapWhoseTurn() {
		if (this.currentPlayerObject.getValue() == this.theHuman) {
			this.currentPlayerObject.setValue(this.theComputer);
		} else {
			this.currentPlayerObject.setValue(this.theHuman);
		}
	}

	@Override
	public void addListener(InvalidationListener listener) {
		this.currentPlayerObject.addListener(listener);
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		this.currentPlayerObject.removeListener(listener);
	}
}
