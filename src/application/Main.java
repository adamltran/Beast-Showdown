package application;
	
import enums.BeastList;
import enums.Moves;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class Main extends Application {
	
	public final int WIDTH = 600;
	public final int HEIGHT = 500;
	
	static Beast b1 = new Beast(BeastList.GORILLA);
	static Beast b2 = new Beast(BeastList.BEAR);
	static DamageSystem ds = new DamageSystem(b1, b2);
	static TurnSystem ts = new TurnSystem();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Group root = new Group();
			Scene scene = new Scene(root,WIDTH,HEIGHT);
			primaryStage.setTitle("Beast Showdown");
			
			Text t = new Text("Hello world!");
			Button b = new Button("Attack");
//			Button b2 = new Button("Player Stats");
//			Button b3 = new Button("About the game...");
//			Button b4 = new Button("I am a button.");
			
			t.setStroke(Color.BLACK);
			t.setFill(Color.BLACK);
			t.setTranslateY(300);
			
			HBox hbox = new HBox();
			hbox.getChildren().add(b);
//			hbox.getChildren().add(b2);
//			hbox.getChildren().add(b3);
//			hbox.getChildren().add(b4);
			hbox.setAlignment(Pos.CENTER);
			hbox.setTranslateX(WIDTH/2 - 200);
			hbox.setTranslateY(HEIGHT/2);
			
			root.getChildren().add(hbox);
			
//			EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
//
//				@Override
//				public void handle(ActionEvent event) {
//					
//				}
//				
//			};
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	
			BorderPane.setAlignment(t, Pos.CENTER);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);

		
		/*
		 * Flag that keeps giving turns until either beast dies
		 */
		boolean gameOver = false;
		while(!gameOver) {
			ts.turn(b1, b2, ds);
			if(b1.getHp() == 0 || b2.getHp() == 0) {
				gameOver = true;
			}
		}
		System.out.println("gameOver status: " + gameOver);
		


	}
}
