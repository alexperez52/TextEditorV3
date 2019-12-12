package utils;

import java.io.File;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Pair;
import model.TextEditorPane;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Alerts {
	public static File savedFile = null;
	

	

	public static void saveAlertNewOpt() {
		
		
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

		alert.setHeaderText(null);
		alert.setGraphic(null);
		alert.setTitle("Save");
		alert.setContentText("You have unsaved Files. Would you like to save?");

		ButtonType yes = new ButtonType("Save", ButtonData.YES);
		ButtonType no = new ButtonType("Don't Save", ButtonData.NO);
		ButtonType cancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
		alert.getButtonTypes().setAll(yes, no, cancel);
		alert.showAndWait().ifPresent(e -> {
			if (e == yes) {
				
				if (TextEditorPane.isUniqueFileSaved) {
					
					
					if (savedFile != null) {
						DataHandler.saveData(savedFile);
						TextEditorPane.mainTextArea.clear();
						TextEditorPane.isSaved = true;
						TextEditorPane.isUniqueFileSaved = false;
						savedFile = null;
						//set file to null
						System.out.println("auto update");
						TextEditorPane.tab1.setText("Untitled");
						TextEditorPane.mainTextArea.clear();
					}
				} else {
					loadSaveOptions();
					if (!TextEditorPane.isSaved) {
						
						if (savedFile != null) {

							TextEditorPane.mainTextArea.clear();
							TextEditorPane.isSaved = true;
							TextEditorPane.isUniqueFileSaved = false;
							savedFile = null;
							TextEditorPane.tab1.setText("Untitled");
							TextEditorPane.mainTextArea.clear();
							//set file to null

						}
					}
				}

			} else if (e == no) {

				TextEditorPane.mainTextArea.clear();
				System.out.println("Dont save");
				TextEditorPane.isSaved = true;
				TextEditorPane.isUniqueFileSaved = false;
				savedFile = null;
				TextEditorPane.tab1.setText("Untitled");
				TextEditorPane.mainTextArea.clear();
			}
		});

	}

	public static void saveAlertOpenOpt() {

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

		alert.setHeaderText(null);
		alert.setGraphic(null);
		alert.setTitle("Save");
		alert.setContentText("You have unsaved Files. Would you like to save?");

		ButtonType yes = new ButtonType("Save", ButtonData.YES);
		ButtonType no = new ButtonType("Don't Save", ButtonData.NO);
		ButtonType cancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
		alert.getButtonTypes().setAll(yes, no, cancel);
		alert.showAndWait().ifPresent(e -> {
			if (e == yes) {

				if (TextEditorPane.isUniqueFileSaved) {
					System.out.println("manually update");
					
					DataHandler.saveData(savedFile);

					TextEditorPane.isSaved = true;
					
					if(savedFile != null) {
						loadOpenOptions();
						
						TextEditorPane.isUniqueFileSaved = false;


					}

				} else {
					if(!TextEditorPane.isSaved) {
					loadSaveOptions();
					loadOpenOptions();
					TextEditorPane.isSaved = true;
					TextEditorPane.isUniqueFileSaved = false;
					}
				}

			} else if (e == no) {
				loadOpenOptions();
				System.out.println("Dont save");
				TextEditorPane.isUniqueFileSaved = false;

			}

		});
	}

	public static void loadOpenOptions() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
		Stage newStage = new Stage();

		savedFile = fileChooser.showOpenDialog(newStage);
		
		if (savedFile != null) {
			//TextEditorPane.isTyping = false;
			
			TextEditorPane.changeCenter();
			if(!TextEditorPane.mainTabPane.getTabs().contains(TextEditorPane.tab1)) {

				TextEditorPane.mainTabPane.getTabs().add(TextEditorPane.tab1);
				TextEditorPane.tab1.setText(Alerts.savedFile.getName());

				}
			else {

				TextEditorPane.tab1.setText(Alerts.savedFile.getName());
				
			}
			long start = System.nanoTime();
			
			TextEditorPane.mainTextArea.setText(DataHandler.readData(savedFile));
			System.out.println(System.nanoTime() - start );
			
			Alerts.savedFile = savedFile.getAbsoluteFile();
			TextEditorPane.savedFile = savedFile.getAbsoluteFile();
			TextEditorPane.isSaved = true;

			TextEditorPane.isUniqueFileSaved = true;
		
			
			
		}
		
	}
	
	public static File loadSaveOptions() {

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
		Stage newStage = new Stage();
		savedFile = null;
		savedFile = fileChooser.showSaveDialog(newStage);
		if (savedFile != null) {
//
//			TextEditorPane.mainTextArea.setText(DataHandler.readData(savedFile));
//			Alerts.savedFile = savedFile.getAbsoluteFile();
//			TextEditorPane.savedFile = savedFile.getAbsoluteFile();
			TextEditorPane.isSaved = true;
//
			TextEditorPane.isUniqueFileSaved = true;
			DataHandler.saveData(savedFile);
		}

		return savedFile;
	}


	public static void saveAlertOnExit() {

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

		alert.setHeaderText(null);
		alert.setGraphic(null);
		alert.setTitle("Save");
		alert.setContentText("You have unsaved Files. Would you like to save?");

		ButtonType yes = new ButtonType("Save", ButtonData.YES);
		ButtonType no = new ButtonType("Don't Save", ButtonData.NO);
		ButtonType cancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
		alert.getButtonTypes().setAll(yes, no, cancel);
		alert.showAndWait().ifPresent(e -> {
			if (e == yes) {
			
				if (!TextEditorPane.isUniqueFileSaved) {
					System.out.println("manually update");
					
					
					loadSaveOptions();
					
					if(savedFile!= null) {
					TextEditorPane.isSaved = true;
					Platform.exit();
					
					}

				} else {
					DataHandler.saveData(savedFile);
					TextEditorPane.isSaved = true;
					
					if(savedFile != null) {
					Platform.exit();
					}

				}
			} else if (e == no) {

				Platform.exit();
				System.out.println("Dont save");

			}
		});
	}

	

}
