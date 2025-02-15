package edu.westga.cs6910.nim.view;

import edu.westga.cs6910.nim.model.Game;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Defines the panel that displays either the number of sticks left on the pile
 * or the winner if the game is over.
 * 
 * @author CS6910
 * @version Summer 2023
 */
public class StatusPane extends GridPane implements InvalidationListener {
	private Game theGame;
	private Label lblStatus;

	/**
	 * Creates a new status pane that observes the specified game.
	 * 
	 * @param theGame the model object from which this pane gets its data
	 * 
	 * @requires theGame != null
	 */
	public StatusPane(Game theGame) {
		this.theGame = theGame;

		this.theGame.addListener(this);

		this.buildPane();
	}

	/**
	 * Builds Status pane
	 */
	private void buildPane() {
		this.add(new Label("~~ Game Info ~~"), 0, 0);

		this.lblStatus = new Label(this.theGame.toString());
		this.add(this.lblStatus, 0, 1);
		
		this.update();
	}

	/**
	 * Called when the game has become invalid.
	 * 
	 * @param observable theGame that triggered the invalidation
	 */
	@Override
	public void invalidated(Observable observable) {
		this.update();
	}

	/**
	 * Updates the label with the current game information.
	 */
	public void update() {
		if (this.theGame.isGameOver()) {
            this.lblStatus.setText(this.theGame.toString());
        } else {
            this.lblStatus.setText("Pile size: " + this.theGame.getSticksLeft());
        }
	}
}