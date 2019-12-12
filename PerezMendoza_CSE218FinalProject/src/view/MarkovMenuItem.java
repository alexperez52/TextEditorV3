package view;

import java.io.File;

import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import utils.MarkovGenerator;

public class MarkovMenuItem extends MenuItem {

	public MarkovMenuItem() {
		super("Markov");
		File file = new File("icons/markov.png");
		Image image = new Image(file.toURI().toString());
		ImageView view;
		view = new ImageView(image);
		view.setFitHeight(20);
		view.setFitWidth(20);
		setAccelerator(new KeyCodeCombination(KeyCode.M, KeyCombination.CONTROL_DOWN));
		setGraphic(view);
		setOnAction(e -> {
			new MarkovGenerator();
		});
		
		}
}
