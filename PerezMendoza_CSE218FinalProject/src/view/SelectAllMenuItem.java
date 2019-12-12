package view;

import java.io.File;

import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import model.TextEditorPane;

public class SelectAllMenuItem extends MenuItem {

	public SelectAllMenuItem() {
		super("Select All");
		File file = new File("icons/selectAll.jpg");
		Image image = new Image(file.toURI().toString());
		ImageView selectAllView;
		selectAllView = new ImageView(image);
		selectAllView.setFitHeight(20);
		selectAllView.setFitWidth(20);
		setGraphic(selectAllView);
		setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));

		setOnAction(e -> {
			TextEditorPane.mainTextArea.selectAll();
		});
	}
}
