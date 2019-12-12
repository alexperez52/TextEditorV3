package view;

import java.io.File;

import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import model.TextEditorPane;

public class CopyMenuItem extends MenuItem{

	public CopyMenuItem() {
		super("Copy\t\t");
		File file = new File("icons/copyIcon.png");
		Image image = new Image(file.toURI().toString());
		ImageView copyView;
		copyView = new ImageView(image);
		copyView.setFitHeight(20);
		copyView.setFitWidth(20);
		setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
		setGraphic(copyView);
		setOnAction(e -> {
			TextEditorPane.mainTextArea.copy();
		});
	}
}
