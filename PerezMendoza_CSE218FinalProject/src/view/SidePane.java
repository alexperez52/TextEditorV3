package view;

import java.io.File;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.TextEditorPane;
import utils.MenuColors;

public class SidePane extends VBox{

	ComboBox combo;
	static ColorPicker cp;
	TextField textSize, textColor;
	Button confirmSize, button, spellCheck;
	public static String size, color;
	public SidePane() {
		
		
		 cp = new ColorPicker();
		combo = new ComboBox();
		combo.setMaxWidth(20);
		combo.setEditable(true);
		combo.getItems().add(8);
		combo.getItems().add(9);
		combo.getItems().add(10);
		combo.getItems().add(11);
		combo.getItems().add(12);
		combo.getItems().add(14);
		combo.getItems().add(16);
		combo.getItems().add(18);
		combo.getItems().add(20);
		combo.getItems().add(22);
		combo.getItems().add(24);
		combo.getItems().add(26);
		combo.getItems().add(28);
		combo.getItems().add(36);
		combo.getItems().add(48);
		combo.getItems().add(72);
		
		
		
		
		
		setStyle("-fx-background-color: lightgrey;");
		button = new Button();
		File file = new File("icons/openingIcon.png");
		Image image = new Image(file.toURI().toString());
		ImageView view;
		view = new ImageView(image);
		view.setFitHeight(20);
		view.setFitWidth(20);
		button.setGraphic(view);
		
		spellCheck = new Button("Spell Check");
		
		//close.setGraphic("icons/closingIc.png");
		HBox textSizeBox = new HBox();
		textSize = new TextField();
		Label size = new Label("Size");
		Label color = new Label("Color");
		confirmSize = new Button("Confirm");
		textSizeBox.getChildren().addAll( textSize);
		textSize.setPromptText("Set Text Size");
		textSize.setMaxWidth(60);
		HBox colorBox = new HBox();
		textColor = new TextField();
		textColor.setPromptText("Set Text Color");
		textColor.setMaxWidth(60);
		colorBox.getChildren().addAll( textColor);
		
		cp.setValue(Color.BLACK);
		setPadding(new Insets(5));
		setSpacing(10);
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0),
				new BorderWidths(0, 1, 0, 1))));
		
		loadActions();
		getChildren().addAll(button, size, combo, color, cp, confirmSize, spellCheck);
		
		
		
	}
	
	private void loadActions() {
		
	
		confirmSize.setOnAction(e -> {
				
			String sizeFix = (String) combo.getValue();
			String colorFix = "#" + cp.getValue().toString().substring(2, cp.getValue().toString().length());
			
			size = "-fx-font: " + sizeFix + " arial;";
			color = "-fx-text-inner-color: " + colorFix + ";";


			
			if(MenuColors.isDarkMode) {
				
				TextEditorPane.mainTextArea.setStyle(size + color + "-fx-focus-color: -fx-control-inner-background ;"
						+ " -fx-faint-focus-color: #424242" + " -fx-control-inner-background; "
						+ "-fx-background-color: #424242;" + "-fx-control-inner-background: #424242");

				TextEditorPane.mainTextArea.setMaxHeight(1000);
				TextEditorPane.mainTextArea.setBorder(new Border(new BorderStroke(Color.DIMGRAY, BorderStrokeStyle.SOLID,
						new CornerRadii(0), new BorderWidths(10, 75, 0, 75))));

			}
			else {
				System.out.println(cp.getValue());
				System.out.println(combo.getValue().toString());
				TextEditorPane.mainTextArea.setStyle(size + color);
				

			}

		});

		
		button.setOnAction(e -> {
				
				TextEditorPane.bp.setRight(new PreSidePane());
			
		});
		spellCheck.setOnAction(e -> {
			
			ErrorWordsWindow a = new ErrorWordsWindow();
			try {
				a.start(new Stage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
	}
	
	
	
}


