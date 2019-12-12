package view;

import java.io.File;

import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import model.TextEditorPane;
import utils.Alerts;
import utils.DataHandler;

public class SaveMainMenuItem extends MenuItem{

	
	public SaveMainMenuItem() {
		super("Save");
		File file = new File("icons/saveIcon.png");
		Image image = new Image(file.toURI().toString());
		ImageView view;
		view = new ImageView(image);
		view.setFitHeight(20);
		view.setFitWidth(20);
		setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
		setGraphic(view);
		setOnAction(e -> {
			
			System.out.println(TextEditorPane.isUniqueFileSaved);
			System.out.println(TextEditorPane.isSaved);
			if(!TextEditorPane.isUniqueFileSaved) {
				if(!TextEditorPane.isSaved) {
				Alerts.loadSaveOptions();
				if(Alerts.savedFile == null) {
					
				}
				else {
				TextEditorPane.tab1.setText(Alerts.savedFile.getName());
				System.out.println(Alerts.savedFile.getName());
				}
				}
				else {
					System.out.println("nullto save");
				}
			}
			else {
				DataHandler.saveData(Alerts.savedFile);
				TextEditorPane.isSaved = true;

			}
			
		});
		
		}
}
