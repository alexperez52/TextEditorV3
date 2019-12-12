package model;

import java.io.File;
import java.util.HashSet;
import java.util.Queue;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import utils.Alerts;
import utils.ColorHBox;
import utils.Counter;
import utils.DataHandler;
import utils.LoadDictionary;
import utils.MenuColors;
import view.CopyMenuItem;
import view.CutMenuItem;
import view.DeleteMenuItem;
import view.MarkovMenuItem;
import view.MenuBarHBox;
import view.PasteMenuItem;
import view.SelectAllMenuItem;
import view.SidePane;

public class TextEditorPane extends BorderPane {
	public static TextArea mainTextArea;
	public static TabPane mainTabPane;
	public static ColorHBox colorHbox = new ColorHBox();
	public static boolean isSaved = true;
	public static boolean isUniqueFileSaved = false;
	public static File savedFile = null;
	public static Tab tab1;
	public static BorderPane bp;
	public HashSet<String> dictionary;
	
	

	public TextEditorPane() {
		bp = new BorderPane();
		loadTa();

		bp.setTop(new MenuBarHBox());
		bp.setCenter(loadDefaultPane());
		bp.setBottom(colorHbox);
		updateViewMenu();
		   
	}
	
	public static void changeCenterToDefault() {
		
		bp.setCenter(loadDefaultPane());
	}
	public static void changeCenter() {
		bp.setCenter(loadTp());
	}
	
	public static Pane loadDefaultPane() {
		
		Pane pane = new Pane();
		File file = new File("icons/clay.png");
		Image image = new Image(file.toURI().toString());
		ImageView newView;
		newView = new ImageView(image);
		newView.setFitHeight(600);
		newView.setFitWidth(700);
	
	     
		
		pane.getChildren().add(newView);
		return pane;
		
	}
	private static TabPane loadTp() {
		mainTabPane = new TabPane();

		tab1 = new Tab();
		tab1.setText("Untitled");
		mainTabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		tab1.setContent(mainTextArea);
//		mainTabPane.getTabs().add(tab1);

		return mainTabPane;
	}

	private TextArea loadTa() {

		mainTextArea = new TextArea();

		mainTextArea.setStyle("-fx-focus-color: -fx-control-inner-background ;" + " -fx-faint-focus-color: white"
				+ " -fx-control-inner-background; " + "-fx-background-color: white;"
				+ "-fx-control-inner-background: white");
//		mainTextArea.setMaxHeight(1000);
		mainTextArea.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, new CornerRadii(0),
				new BorderWidths(10, 75, 0, 75))));

		// ta.setPadding(new Insets(50));
		mainTextArea.setWrapText(true);
		mainTextArea.setMinSize(700, 600);
		
		mainTextArea.setContextMenu(MenuColors.createLightMenu(createMenuItems()));

		return mainTextArea;

	}

	public static MenuItem[] createMenuItems() {
		CopyMenuItem copy = new CopyMenuItem();
		PasteMenuItem paste = new PasteMenuItem();
		CutMenuItem cut = new CutMenuItem();
		DeleteMenuItem delete = new DeleteMenuItem();
		SelectAllMenuItem selectAll = new SelectAllMenuItem();

		SeparatorMenuItem separate = new SeparatorMenuItem();

		
		
		paste.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN));
		copy.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
		cut.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
		selectAll.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));

		MenuItem[] list = {copy, paste, cut, delete, separate, selectAll};
		return list;
	}

	private static void updateViewMenu() {

		mainTextArea.textProperty().addListener(new ChangeListener<String>() {
		
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				
				
				isSaved = false;
				
				int wordCount1 = Counter.wordCount(mainTextArea.getText());
				int sentenceCount1 = Counter.sentenceCount(mainTextArea.getText());
				double fleschScore1 = Counter.fleschCount(mainTextArea.getText());
			
				
			//	Counter.allInOne(mainTextArea.getText());
				ColorHBox.wordCount.setText("Word Count: " + Integer.toString(wordCount1));
				ColorHBox.sentenceCount.setText("| Sentence Count: " + Integer.toString(sentenceCount1));
				ColorHBox.fleschScore.setText("| Flesch Score: " + Double.toString(fleschScore1));
				
			}
			
		});
		
	}


}
