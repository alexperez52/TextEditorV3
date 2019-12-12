package view;

import java.io.File;

import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.TextEditorPane;
import utils.Alerts;
import utils.Counter;

public class NewMainMenuItem extends MenuItem {

	
	public NewMainMenuItem() {
	
	super("New\t\t\t\t");
	File file = new File("icons/newIcon.png");
	Image image = new Image(file.toURI().toString());
	ImageView newView;
	newView = new ImageView(image);
	newView.setFitHeight(20);
	newView.setFitWidth(20);
	setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
	setGraphic(newView);
	setOnAction(e -> {
		
		
		
		
		if(TextEditorPane.isSaved && TextEditorPane.isUniqueFileSaved) {
			TextEditorPane.changeCenter();
			if(!TextEditorPane.mainTabPane.getTabs().contains(TextEditorPane.tab1)) {
			TextEditorPane.mainTabPane.getTabs().add(TextEditorPane.tab1);
			TextEditorPane.tab1.setText("Untitled");
			TextEditorPane.mainTextArea.clear();
			TextEditorPane.isSaved = true;
			TextEditorPane.isUniqueFileSaved = false;
			}
			else {
			TextEditorPane.mainTextArea.clear();
			TextEditorPane.tab1.setText("Untitled");
			
			TextEditorPane.isSaved = true;
			TextEditorPane.isUniqueFileSaved = false;
			}
		}
		else {
			if(TextEditorPane.isSaved) {
				TextEditorPane.changeCenter();

				if(!TextEditorPane.mainTabPane.getTabs().contains(TextEditorPane.tab1)) {
				TextEditorPane.mainTabPane.getTabs().add(TextEditorPane.tab1);
				TextEditorPane.tab1.setText("Untitled");
				TextEditorPane.mainTextArea.clear();

				}
				TextEditorPane.mainTextArea.clear();
				TextEditorPane.tab1.setText("Untitled");
				
				TextEditorPane.isSaved = true;
				TextEditorPane.isUniqueFileSaved = false;

				
			}
			else {
			Alerts.saveAlertNewOpt();
			
		
			}
		}
		
	});
	}
	   
}


