package view;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.TextEditorPane;
import utils.MenuColors;

public class PreSidePane extends VBox{

	
	
	public PreSidePane() {
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0),
				new BorderWidths(0, 1, 0, 1))));
		setStyle("-fx-background-color: lightgrey;");
		Button button = new Button();
		File file = new File("icons/openingIcon.png");
		Image image = new Image(file.toURI().toString());
		ImageView view;
		view = new ImageView(image);
		view.setFitHeight(20);
		view.setFitWidth(20);
		button.setGraphic(view);
		
		getChildren().add(button);
		button.setOnAction(e -> {
			
				TextEditorPane.bp.setRight(new SidePane());
				
		});
	}
}
