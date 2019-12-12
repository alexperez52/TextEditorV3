package utils;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.ConstructSong;
import model.TextEditorPane;

public class MarkovGenerator {

	
	public MarkovGenerator() {
	Stage stage = new Stage();
	
	VBox vbox = new VBox();
	
	HBox hbox = new HBox();
	hbox.setPadding(new Insets(10));
	hbox.setAlignment(Pos.CENTER);
	hbox.setSpacing(10);

	HBox hbox2 = new HBox();
	hbox2.setPadding(new Insets(10));
	hbox2.setAlignment(Pos.CENTER);
	hbox2.setSpacing(10);
	vbox.setPadding(new Insets(10));
	
	HBox hbox3 = new HBox();
	hbox3.setPadding(new Insets(10));
	hbox3.setAlignment(Pos.CENTER);
	
	Label word = new Label("Word");
	Label number = new Label("Count");
	Button confirm = new Button("Confirm");
	
	TextField wordTf = new TextField();
	TextField numberTf = new TextField();
	
	hbox.getChildren().addAll(word, wordTf);
	hbox2.getChildren().addAll(number, numberTf);
	hbox3.getChildren().add(confirm);
	vbox.getChildren().addAll(hbox, hbox2, hbox3);
	
	stage.setScene(new Scene(vbox));
	
	confirm.setOnAction(e -> {
		String fullText = TextEditorPane.mainTextArea.getText();
		
		ConstructSong construct = new ConstructSong(fullText, wordTf.getText(), numberTf.getText());

		TextEditorPane.mainTextArea.setText(construct.getSong());
		stage.close();
	});
	
	stage.showAndWait();
	
	
	
	}
}
