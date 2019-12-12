package view;

import java.io.File;

import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import model.TextEditorPane;

public class CutMenuItem extends MenuItem {

	public CutMenuItem() {
			super("Cut");
			File file = new File("icons/cutIcon.png");
			Image image = new Image(file.toURI().toString());
			ImageView cutView;
			cutView = new ImageView(image);
			cutView.setFitHeight(20);
			cutView.setFitWidth(20);
			setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
			setGraphic(cutView);
			setOnAction(e -> {
				TextEditorPane.mainTextArea.cut();
			});
	}
}
