package edu.westga.cs6910.nim.view;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.Player;
import edu.westga.cs6910.nim.model.strategy.CautiousStrategy;
import edu.westga.cs6910.nim.model.strategy.GreedyStrategy;
import edu.westga.cs6910.nim.model.strategy.NumberOfSticksStrategy;
import edu.westga.cs6910.nim.model.strategy.RandomStrategy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Defines a GUI for the 1-pile Nim game. This class was started by CS6910
 * 
 * @author Deeksha Namani
 * @version 6/5/2023
 */
public class NimPane extends BorderPane {
	private Game theGame;
	private BorderPane pnContent;
	private HumanPane pnHumanPlayer;
	private ComputerPane pnComputerPlayer;
	private StatusPane pnGameInfo;
	private NewGamePane pnChooseFirstPlayer;
	private ComboBox<Integer> cmbPileSize;
	private boolean isPileSizeChosen;

	/**
	 * Creates a pane object to provide the view for the specified Game model
	 * object. 1. Using the 'first player chooser pane' as a guide Create an HBox
	 * with the appropriate style, then make a human player pane and add it to the
	 * HBox. Finally add the HBox to the content pane
	 * 
	 * 2. Using the other panes as a guide, create and add a status pane
	 * 
	 * 3. Using the other panes as a guide, create and add a computer pane
	 * 
	 * @param theGame the domain model object representing the Nim game
	 * 
	 * @requires theGame != null
	 * @ensures the pane is displayed properly
	 */
	public NimPane(Game theGame) {
		this.theGame = theGame;
		this.isPileSizeChosen = false;

		this.pnContent = new BorderPane();

		this.setTop(this.buildMenuBar());

		this.addFirstPlayerChooserPane(theGame);

		HBox hboxHumanPlayer = new HBox();
		hboxHumanPlayer.getStyleClass().add("pane-border");
		this.pnHumanPlayer = new HumanPane(theGame);
		hboxHumanPlayer.getChildren().add(this.pnHumanPlayer);
		this.pnContent.setLeft(hboxHumanPlayer);

		VBox vboxPileSizeChooser = new VBox();
		vboxPileSizeChooser.getStyleClass().add("pane-border");
		this.addPileSizeChooser(vboxPileSizeChooser);
		this.pnContent.setCenter(vboxPileSizeChooser);

		HBox hboxStatus = new HBox();
		hboxStatus.getStyleClass().add("pane-border");
		this.pnGameInfo = new StatusPane(theGame);
		hboxStatus.getChildren().add(this.pnGameInfo);
		this.pnContent.setBottom(hboxStatus);

		HBox hboxComputerPlayer = new HBox();
		hboxComputerPlayer.getStyleClass().add("pane-border");
		this.pnComputerPlayer = new ComputerPane(theGame);
		hboxComputerPlayer.getChildren().add(this.pnComputerPlayer);
		this.pnContent.setRight(hboxComputerPlayer);

		this.setCenter(this.pnContent);
	}

	/**
	 * This method creates the menu bar with menu and menu items.
	 * 
	 * @return menu bar.
	 */
	private MenuBar buildMenuBar() {
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(this.createGameMenu(), this.createStrategyMenu());
		return menuBar;
	}

	/**
	 * This method creates menu game, with exit menu items.
	 * 
	 * @return game menu.
	 */
	private Menu createGameMenu() {
		Menu gameMenu = new Menu("_Game");

		MenuItem newGameItem = new MenuItem("_New Game");
		newGameItem.setMnemonicParsing(true);
		newGameItem.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
		newGameItem.setOnAction(event -> this.startNewGame());

		gameMenu.getItems().add(newGameItem);

		MenuItem exitItem = new MenuItem("E_xit");
		exitItem.setMnemonicParsing(true);
		exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
		exitItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});

		gameMenu.getItems().add(exitItem);

		return gameMenu;
	}

	/**
	 * This method creates strategy menu with caution, greedy, random menu items.
	 * 
	 * @return strategy menu.
	 */
	private Menu createStrategyMenu() {
		Menu strategyMenu = new Menu("_Strategy");

		MenuItem cautiousItem = this.createStrategyMenuItem("_Cautious", "Ctrl+C", new CautiousStrategy());
		MenuItem greedyItem = this.createStrategyMenuItem("Gr_eedy", "Ctrl+E", new GreedyStrategy());
		MenuItem randomItem = this.createStrategyMenuItem("_Random", "Ctrl+R", new RandomStrategy());

		strategyMenu.getItems().addAll(cautiousItem, greedyItem, randomItem);
		return strategyMenu;
	}

	/**
	 * Creates a menu item for the specified strategy with the given name,
	 * accelerator, and strategy object.
	 *
	 * @param name        the name of the menu item
	 * @param accelerator the keyboard accelerator for the menu item
	 * @param strategy    the strategy object to be set
	 * @return the created menu item
	 */
	private MenuItem createStrategyMenuItem(String name, String accelerator, NumberOfSticksStrategy strategy) {
		MenuItem menuItem = new MenuItem(name);
		menuItem.setMnemonicParsing(true);
		menuItem.setAccelerator(KeyCombination.keyCombination(accelerator));
		menuItem.setOnAction(event -> this.setStrategyForComputerPlayer(strategy));
		return menuItem;
	}

	/**
	 * Starts a new Game when called.
	 */
	private void startNewGame() {
		Player firstPlayer;
		if (this.pnChooseFirstPlayer.getSelectedFirstPlayer() != null) {
			firstPlayer = this.pnChooseFirstPlayer.getSelectedFirstPlayer();
		} else if (this.pnChooseFirstPlayer.getRadHumanPlayer().isSelected()) {
			firstPlayer = this.theGame.getHumanPlayer();
		} else if (this.pnChooseFirstPlayer.getRadComputerPlayer().isSelected()) {
			firstPlayer = this.theGame.getComputerPlayer();
		} else {
			return;
		}

		int selectedPileSize = this.cmbPileSize.getValue();
		
		this.theGame.startNewGame(firstPlayer, selectedPileSize);
		this.pnHumanPlayer.setDisable(firstPlayer != this.theGame.getHumanPlayer());
		this.pnComputerPlayer.setDisable(firstPlayer != this.theGame.getComputerPlayer());
		this.pnHumanPlayer.resetNumberToTakeComboBox();

		if (firstPlayer == this.theGame.getComputerPlayer()) {
			this.pnComputerPlayer.takeComputerTurn();
		}
		
		this.isPileSizeChosen = true;
        this.cmbPileSize.setDisable(true);
		this.pnGameInfo.update();
	}

	/**
	 * Sets the strategy for the computer player.
	 *
	 * @param strategy the strategy object to be set
	 */
	private void setStrategyForComputerPlayer(NumberOfSticksStrategy strategy) {
		Player computerPlayer = this.theGame.getComputerPlayer();
		if (computerPlayer instanceof ComputerPlayer) {
			ComputerPlayer computer = (ComputerPlayer) computerPlayer;
			computer.setStrategy(strategy);
		}
	}

	/**
	 * Adding Choose First Player pane on top of the content pane.
	 * 
	 * @param theGame the Game object
	 * 
	 */
	private void addFirstPlayerChooserPane(Game theGame) {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("pane-border");
		this.pnChooseFirstPlayer = new NewGamePane(theGame);
		topBox.getChildren().add(this.pnChooseFirstPlayer);
		this.pnContent.setTop(topBox);
	}

	/**
	 * Adding the Pile Size chooser dropdown to the content pane.
	 * 
	 * @param dropDownPane main
	 */
	private void addPileSizeChooser(VBox dropDownPane) {
		this.cmbPileSize = new ComboBox<>();
		this.cmbPileSize.getItems().addAll(5, 6, 7, 8, 9, 10);
		this.cmbPileSize.setValue(this.theGame.getPile().getSticksLeft());

		this.cmbPileSize.setOnAction(event -> {
			int selectedPileSize = this.cmbPileSize.getValue();
			this.theGame.startNewGame(this.pnChooseFirstPlayer.getSelectedFirstPlayer(), selectedPileSize);
			this.cmbPileSize.setDisable(true);
			this.pnGameInfo.update();
		});

		Label lblPileSize = new Label("Pile Size:");
		dropDownPane.getChildren().addAll(lblPileSize, this.cmbPileSize);
		if (this.isPileSizeChosen) {
	        this.cmbPileSize.setDisable(true);
	    }
	}

	/*
	 * Defines the panel in which the user selects which Player plays first.
	 */
	private final class NewGamePane extends GridPane {
		private RadioButton radHumanPlayer;
		private RadioButton radComputerPlayer;
		private Player selectedFirstPlayer;
		private Button btnRandomPlayer;

		private Game theGame;
		private Player theHuman;
		private Player theComputer;

		private NewGamePane(Game theGame) {
			this.theGame = theGame;

			this.theHuman = this.theGame.getHumanPlayer();
			this.theComputer = this.theGame.getComputerPlayer();

			this.buildPane();
		}

		/**
		 * Instantiate the computer player button and set its action listener.
		 * 
		 * Create a ToggleGroup and add the 2 radio buttons to it.
		 * 
		 * Add the 2 radio buttons to this pane.
		 * 
		 */
		private void buildPane() {
			this.setHgap(20);

			this.radHumanPlayer = new RadioButton(this.theHuman.getName());
			this.radHumanPlayer.setOnAction(new HumanFirstListener());

			this.radComputerPlayer = new RadioButton(this.theComputer.getName());
			this.radComputerPlayer.setOnAction(new ComputerFirstListener());

			ToggleGroup toggleGroup = new ToggleGroup();
			this.radHumanPlayer.setToggleGroup(toggleGroup);
			this.radComputerPlayer.setToggleGroup(toggleGroup);

			this.btnRandomPlayer = new Button("Select Random Player");
			this.btnRandomPlayer.setOnAction(new RandomFirstListener());

			this.add(this.radHumanPlayer, 0, 0);
			this.add(this.radComputerPlayer, 1, 0);
			this.add(this.btnRandomPlayer, 2, 0);
		}

		/*
		 * Defines the listener for computer player first button.
		 */
		private class ComputerFirstListener implements EventHandler<ActionEvent> {
			@Override
			/**
			 * Enables the ComputerPlayerPanel and starts a new game. Event handler for a
			 * click in the computerPlayerButton.
			 */
			public void handle(ActionEvent arg0) {
				NewGamePane.this.selectedFirstPlayer = NewGamePane.this.theComputer;
				NimPane.this.pnComputerPlayer.setDisable(false);
				NimPane.this.pnChooseFirstPlayer.setDisable(true);
				int selectedPileSize = NimPane.this.cmbPileSize.getValue();
				NimPane.this.theGame.startNewGame(NewGamePane.this.selectedFirstPlayer, selectedPileSize);

				NimPane.this.pnComputerPlayer.takeComputerTurn();
			}
		}

		/*
		 * Defines the listener for human player first button.
		 */
		private class HumanFirstListener implements EventHandler<ActionEvent> {
			/*
			 * Sets up user interface and starts a new game. Event handler for a click in
			 * the human player button.
			 * 
			 * Enable the human player pane and start a game with the human playing first.
			 */
			@Override
			public void handle(ActionEvent event) {
				NewGamePane.this.selectedFirstPlayer = NewGamePane.this.theHuman;
				NimPane.this.pnChooseFirstPlayer.setDisable(true);
				NimPane.this.pnHumanPlayer.setDisable(false);
				int selectedPileSize = NimPane.this.cmbPileSize.getValue();
				NimPane.this.theGame.startNewGame(NewGamePane.this.selectedFirstPlayer, selectedPileSize);
			}
		}

		private class RandomFirstListener implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent event) {
				if (Math.random() < 0.5) {
					NewGamePane.this.radHumanPlayer.setSelected(true);
					NimPane.this.pnHumanPlayer.setDisable(false);
					NimPane.this.pnChooseFirstPlayer.setDisable(true);
					int selectedPileSize = NimPane.this.cmbPileSize.getValue();
					NimPane.this.theGame.startNewGame(NimPane.this.theGame.getHumanPlayer(), selectedPileSize);
				} else {
					NewGamePane.this.radComputerPlayer.setSelected(true);
					NimPane.this.pnComputerPlayer.setDisable(false);
					NimPane.this.pnChooseFirstPlayer.setDisable(true);
					int selectedPileSize = NimPane.this.cmbPileSize.getValue();
					NimPane.this.theGame.startNewGame(NimPane.this.theGame.getComputerPlayer(), selectedPileSize);
				}
			}
		}

		/**
		 * Gets Selected First Player
		 * 
		 * @return First Player
		 */
		public Player getSelectedFirstPlayer() {
			return this.selectedFirstPlayer;
		}

		/**
		 * Returns the radio button for the human player.
		 * 
		 * @return the radio button for the human player
		 */
		public RadioButton getRadHumanPlayer() {
			return this.radHumanPlayer;
		}

		/**
		 * Returns the radio button for the computer player.
		 * 
		 * @return the radio button for the computer player
		 */
		public RadioButton getRadComputerPlayer() {
			return this.radComputerPlayer;
		}
	}
}
