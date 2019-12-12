package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HelpPopup extends Application{

	@Override
	public void start(Stage primary) throws Exception {
		
		BorderPane mainPage = new BorderPane();
		
		
		Scene mainScene = new Scene(mainPage, 200, 200);
		primary.setTitle("Credits");
		primary.setScene(mainScene);
		VBox credits = new VBox();
		Label credits0 = new Label ("Credits");
		Label credits1 = new Label ("Created By: Alexis Perez-Mendoza");
		Label credits2 = new Label ("Version 1.0 ©");
		Label credits3 = new Label ();
		credits0.setTextFill(Color.BLACK);
		credits1.setTextFill(Color.BLACK);
		credits2.setTextFill(Color.BLACK);
		credits3.setTextFill(Color.BLACK);
		credits.getChildren().addAll(credits0,credits1,credits2,credits3);
		credits0.setAlignment(Pos.CENTER);
		credits1.setAlignment(Pos.CENTER);
		credits2.setAlignment(Pos.CENTER);
		credits3.setAlignment(Pos.CENTER);
		credits.setAlignment(Pos.CENTER);
		mainPage.setCenter(credits);

		primary.show();
		
		
	}

	
	
	
}
