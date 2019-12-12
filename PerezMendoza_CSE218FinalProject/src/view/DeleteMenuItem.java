package view;

import java.io.File;

import javafx.scene.control.IndexRange;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import model.TextEditorPane;

public class DeleteMenuItem extends MenuItem{

	public DeleteMenuItem() {
		super("Delete");
		File file = new File("icons/deleteIcon.png");
		Image image = new Image(file.toURI().toString());
		ImageView deleteView;
		deleteView = new ImageView(image);
		deleteView.setFitHeight(20);
		deleteView.setFitWidth(20);
		setAccelerator(new KeyCodeCombination(KeyCode.DELETE));

		setGraphic(deleteView);
		setOnAction(e -> {
			TextEditorPane.mainTextArea.deleteText(new IndexRange(TextEditorPane.mainTextArea.getSelection()));
		});
		
	}
}
