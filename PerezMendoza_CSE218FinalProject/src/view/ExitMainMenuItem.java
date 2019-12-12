package view;

import java.io.File;

import javafx.application.Platform;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import model.TextEditorPane;
import utils.Alerts;

public class ExitMainMenuItem extends MenuItem{

	
	public ExitMainMenuItem() {
		super("Exit");
		File file = new File("icons/exitIcon.png");
		Image image = new Image(file.toURI().toString());
		ImageView view;
		view = new ImageView(image);
		view.setFitHeight(20);
		view.setFitWidth(20);
		setAccelerator(new KeyCodeCombination(KeyCode.F4, KeyCombination.ALT_ANY));
		setGraphic(view);
		setOnAction(e -> {
			
			
			if(!TextEditorPane.isSaved) {
				Alerts.saveAlertOnExit();
			}
			else {
				Platform.exit();
			}
		});
		}
}
