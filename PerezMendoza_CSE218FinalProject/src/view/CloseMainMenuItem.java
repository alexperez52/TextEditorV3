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

public class CloseMainMenuItem extends MenuItem {

	public CloseMainMenuItem() {
	super("Close");
	File file = new File("icons/closeIcon.png");
	Image image = new Image(file.toURI().toString());
	ImageView view;
	view = new ImageView(image);
	view.setFitHeight(20);
	view.setFitWidth(20);
	setAccelerator(new KeyCodeCombination(KeyCode.W, KeyCombination.CONTROL_DOWN));
	setGraphic(view);
	setOnAction(e -> {
		
		if(TextEditorPane.isSaved) {
			
			TextEditorPane.mainTextArea.clear();
			TextEditorPane.isUniqueFileSaved = false;
			TextEditorPane.isSaved =true;
			if(TextEditorPane.mainTabPane != null ) {
				

				TextEditorPane.mainTabPane.getTabs().remove(TextEditorPane.tab1);
				TextEditorPane.changeCenterToDefault();
				}
		}
		else {
			Alerts.saveAlertNewOpt();
			if(TextEditorPane.mainTabPane.getTabs().size() != 0 && TextEditorPane.isSaved) {
				TextEditorPane.changeCenterToDefault();
				TextEditorPane.mainTabPane.getTabs().remove(TextEditorPane.tab1);
			}

		}
		
	});
	}
	
}
