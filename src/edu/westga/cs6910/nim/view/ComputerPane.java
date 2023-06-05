package edu.westga.cs6910.nim.view;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
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
	private Button btnTakeTurn;

	/**
	 * Creates a new ComputerPane that observes the specified game.
	 * And  Add this object as an listener of the Game.
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
	 *  Using the other pane classes as a model, build this pane.
	 */
	private void buildPane() {
		this.add(new Label("~~" + this.theComputer.getName() + "~~"), 0, 0);
        
		this.add(new Label("Number of stricks to take: "), 0, 1);
		
		this.btnTakeTurn = new Button("Take Turn");
		this.btnTakeTurn.setOnAction(new TakeTurnListener());
		this.add(this.btnTakeTurn, 0, 2);
	}

	@Override
	public void invalidated(Observable arg0) {
		if (this.theGame.isGameOver()) {
			this.setDisable(true);
			return;
		}

		boolean myTurn = this.theGame.getCurrentPlayer() == this.theComputer;

		if (!myTurn) {
			// TODO: Set the user interface to show the number of
			// sticks taken by the computer player.

		}
		// TODO: Disable if it is no longer the computer's turn, enable it if
		// it is the computer's turn

	}

	/*
	 * Defines the listener for takeTurnButton.
	 */
	private class TakeTurnListener implements EventHandler<ActionEvent> {

		/*
		 * Tells the Game to have its current player (i.e., the computer player) take
		 * its turn.
		 * 
		 * @see javafx.event.EventHandler#handle(T-extends-javafx.event.Event)
		 */
		@Override
		public void handle(ActionEvent arg0) {
			// TODO: if the game isn't finished:
			// - Set the computer's pile and number of sticks.
			// - Tell theGame to play a move.

		}
	}
}
