package view;

import java.io.File;
import java.util.Queue;

import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import model.TextEditorPane;
import utils.Alerts;
import utils.ColorHBox;
import utils.Counter;
import utils.LoadDictionary;

public class OpenMainMenuItem extends MenuItem{
	public OpenMainMenuItem() {
		
	super("Open");
	File file = new File("icons/openIcon.png");
	Image image = new Image(file.toURI().toString());
	ImageView view;
	view = new ImageView(image);
	view.setFitHeight(20);
	view.setFitWidth(20);
	setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
	setGraphic(view);
	setOnAction(e -> {
		
		if(!TextEditorPane.isSaved || TextEditorPane.isUniqueFileSaved) {
			Alerts.saveAlertOpenOpt();
			
		}
		else {
			
			Alerts.loadOpenOptions();
			
		}
	
	});
	}
}
