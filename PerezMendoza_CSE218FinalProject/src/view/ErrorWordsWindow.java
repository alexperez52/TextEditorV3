package view;

import java.util.LinkedList;


import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.LoadDictionary;

public class ErrorWordsWindow extends Application{
	Label label;

	@Override
	public void start(Stage stage) throws Exception {
		
		LinkedList<String> a = LoadDictionary.misspelledWords();
		
		VBox vBox = new VBox();
		label = new Label("Misspelled Words: " + a.size());
		
			ScrollPane sp = new ScrollPane();
			TableView<String> tableView = new TableView<String>();

	        TableColumn<String, String> column1 = new TableColumn<>("Misspelled Words");
	        column1.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));
//	        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));


	        tableView.getColumns().add(column1);

	        for(int i =0; i < a.size(); i ++) {
	        tableView.getItems().add(a.get(i));
	        }

	        sp.setContent(tableView);
	        
	        Button acknowledge = new Button("Acknowledge");
	        acknowledge.setOnAction(e ->{

	        	if(tableView.getSelectionModel().getSelectedCells() != null) {
	        		ObservableList<String> wordSelected, allWords;
	        		allWords = tableView.getItems();
	        		wordSelected = tableView.getSelectionModel().getSelectedItems();
	        		wordSelected.forEach(allWords::remove);
	        	LoadDictionary.errorCount--;
	        	label.setText("Misspelled Words: " + LoadDictionary.errorCount);
	        	}

	        });
	        
	        vBox.getChildren().addAll(label, sp, acknowledge);
	        
	        
	        
	        
	        Scene scene = new Scene(vBox);
	        stage.setScene(scene);
	        stage.show();
	        
		
		
		
	}

}
