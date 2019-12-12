package view;

import java.io.File;

import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import model.TextEditorPane;

public class PasteMenuItem extends MenuItem{
	public PasteMenuItem() {
		super("Paste");
		File file = new File("icons/pasteIcon.png");
		Image image = new Image(file.toURI().toString());
		ImageView pasteView;
		pasteView = new ImageView(image);
		pasteView.setFitHeight(20);
		pasteView.setFitWidth(20);
		setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN));

		setGraphic(pasteView);

		
		setOnAction(e -> {
			TextEditorPane.mainTextArea.paste();
		});
	}

}
