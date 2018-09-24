package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {
	public static final int WINDOW_WIDTH = 1000;
	public static final int WINDOW_HEIGHT = 800;
	private GridPane game;
	private FlowPane inventory;
	private AnchorPane options;
	private GridPane map;

	@Override public void start(Stage stage) {

		this.game = setGame();
		this.inventory = setInventory();
		this.options = setOptions();
		this.map = setMap();

		FlowPane stack = new FlowPane();

		stack.getChildren().addAll(inventory, options, map);
		
		stack.setPadding(new Insets(1,1,1,1));
		stack.setVgap(4);
		stack.setHgap(4);
		stack.setPrefWrapLength(50); // preferred width allows for two columns

		HBox hb = new HBox();
	
		hb.setSpacing(10);
		hb.getChildren().add(stack);
		HBox.setHgrow(stack, Priority.ALWAYS);
		
		// Set the alignment of the game to centre
		GridPane.setHalignment(this.game, HPos.CENTER);

		// Set the alignment of the the side panel to the right
		GridPane.setHalignment(hb, HPos.RIGHT);
		GridPane grid = new GridPane();
		grid.add(game, 0,0);
		grid.add(hb, 20, 0);

		// Set the Size of the VBox
		grid.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);		
		// Set the Style-properties of the BorderPane
		grid.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: blue;");

		// Create the Scene
		Scene scene = new Scene(grid);
		// Add the scene to the Stage
		stage.setScene(scene);
		// Set the title of the Stage
		stage.setTitle("An Adventure Game");
		// Display the Stage
		stage.show();		
	}

	public GridPane setGame() {
		GridPane grid = new GridPane();
		Text name = new Text("game");
		grid.add(name, 0, 0);
		grid.setStyle("-fx-background-color: red;");
		return grid;
	}

	public FlowPane setInventory() {
		FlowPane flow = new FlowPane();
		flow.setStyle("-fx-background-color: blue;");
		
		flow.setPadding(new Insets(1,1,1,1));
		flow.setVgap(4);
		flow.setHgap(4);
		flow.setPrefWrapLength(170); // preferred width allows for two columns

		Text pages[] = new Text[8];
		for (int i=0; i<8; i++) {
			pages[i] = new Text("inventory");
			flow.getChildren().addAll(pages[i]);
		}
		return flow;

	}

	public AnchorPane setOptions() {
		AnchorPane options = new AnchorPane();
		Button buttonSave = new Button("Save");
		Button buttonCancel = new Button("Cancel");


		HBox hb = new HBox();
		hb.setPrefWidth(170);
		hb.setPadding(new Insets(0, 10, 10, 10));
		hb.setSpacing(10);
		hb.getChildren().addAll(buttonSave, buttonCancel);
		options.setStyle("-fx-background-color: green;");

		options.getChildren().add(hb);
		AnchorPane.setTopAnchor(hb, 1.0);
		return options;
	}

	public GridPane setMap() {
		GridPane grid = new GridPane();
		Text name = new Text("map");
		grid.add(name, 0, 0);
		grid.setStyle("-fx-background-color: orange;");
		grid.setPrefWidth(170);
		return grid;
	}

	public GridPane setMove() {
		GridPane grid = new GridPane();
		Text name = new Text("move");
		grid.add(name, 0, 0);
		grid.setStyle("-fx-background-color: yellow;");
		return grid;
	}


	public static void main(String[] args) { 
		Application.launch(args); 
	}

}