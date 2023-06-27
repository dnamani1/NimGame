package edu.westga.cs6910.nim.view;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Defines the panel that lets the user tell the computer player to take its
 * turn and that displays the number of sticks the computer player took on its
 * turn. This class was started by CS6910
 * 
 * @author Deeksha Namani
 * @version 6/5/2023
 * 
 */
public class ComputerPane extends GridPane implements InvalidationListener {
	private Game theGame;
	private Label lblNumberTaken;
	private ComputerPlayer theComputer;

	/**
	 * Creates a new ComputerPane that observes the specified game. And Add this
	 * object as an listener of the Game.
	 * 
	 * @param theGame the model object from which this pane gets its data
	 * 
	 * @requires theGame != null
	 */
	public ComputerPane(Game theGame) {
		this.theGame = theGame;
		this.theGame.addListener(this);

		this.theComputer = this.theGame.getComputerPlayer();

		this.buildPane();
	}

	/**
	 * Using the other pane classes as a model, build this pane.
	 */
	private void buildPane() {
		this.add(new Label("~~" + this.theComputer.getName() + "~~"), 0, 0);

		this.lblNumberTaken = new Label();
		this.add(this.lblNumberTaken, 0, 1);

		this.setDisable(true);
	}

	/**
	 * Set the user interface to show the number of sticks taken by the computer
	 * player. Disable if it is no longer the computer's turn, enable it if it is
	 * the computer's turn
	 */
	@Override
	public void invalidated(Observable arg0) {
		if (this.theGame.isGameOver()) {
			this.setDisable(true);
			return;
		}

		boolean myTurn = this.theGame.getCurrentPlayer() == this.theComputer;

		if (myTurn) {
			this.takeComputerTurn();
		}

		this.setDisable(myTurn);
	}

	/**
	 * Let the computer player take its turn and update the UI.
	 */
	public void takeComputerTurn() {
		if (!this.theGame.isGameOver()) {
			this.theComputer.setPileForThisTurn(this.theGame.getPile());
			this.theComputer.setNumberSticksToTake();
			this.theGame.play();
			this.lblNumberTaken.setText("Number of Sticks Taken: " + this.theComputer.getSticksOnThisTurn());
			
		}
	}

}
