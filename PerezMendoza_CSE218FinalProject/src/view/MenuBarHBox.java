package view;

import java.awt.Font;
import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.TextEditorPane;
import utils.ColorHBox;
import utils.MenuColors;

public class MenuBarHBox extends HBox{

	public static CheckMenuItem wordCountItem;
	public static CheckMenuItem sentenceCountItem;
	public static CheckMenuItem toggleAll;
	public static CheckMenuItem fleschScoreItem;
	public CheckMenuItem toggleDarkMode;
	public static NewMainMenuItem newOpt;
	public static CloseMainMenuItem closeOpt;
	public static OpenMainMenuItem openOpt;
	public static SaveMainMenuItem saveOpt;
	public static ExitMainMenuItem exitOpt;
	public static CheckMenuItem imageMenuItem;
	public static Text lbl, help, spacing;
	public static ImageView newView;
	public MenuBarHBox() {
		File file = new File("icons/babyjump.gif");
		Image image = new Image(file.toURI().toString());
		
		newView = new ImageView(image);
		newView.setFitHeight(20);
		newView.setFitWidth(20);
		spacing = new Text("                                                    ");
		help = new Text();
		newView.setOnMouseMoved(e ->{
			newView.setFitHeight(25);
			newView.setFitWidth(25);
			help.setText("CLICK ME !");
			help.setStyle("-fx-font: 22 arial;");
					
		});
		newView.setOnMouseExited(l -> {
			newView.setFitHeight(20);
			newView.setFitWidth(20);
			help.setText(null);
		});
		newView.setOnMouseClicked(e ->{
			HelpPopup a = new HelpPopup();
			try {
				a.start(new Stage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			});
		getChildren().addAll(blueMenuBar(), loadWhiteMenuBar(),spacing, newView,help);
		
		
		toggleDarkMode();
	}
	
	
	public MenuItem[] loadFileItems() {
		newOpt = new NewMainMenuItem();
		openOpt = new OpenMainMenuItem();
		closeOpt = new CloseMainMenuItem();
		saveOpt = new SaveMainMenuItem();
		exitOpt = new ExitMainMenuItem();
		
		MenuItem[] items = {newOpt, openOpt,closeOpt
				,saveOpt, exitOpt};
		return items;
	}
	
	private MenuBar blueMenuBar() {

		Menu fileMenu = new Menu("File");

		MenuItem[] items = loadFileItems();
		for (int i = 0; i < items.length - 1; i++) {
			fileMenu.getItems().add(items[i]);
		}

		fileMenu.getItems().addAll(new SeparatorMenuItem(), items[items.length - 1]);

		MenuBar mainMenuBar = new MenuBar(fileMenu);
		BackgroundFill backgroundColor = new BackgroundFill(Color.STEELBLUE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(backgroundColor);
		mainMenuBar.setBackground(background);
		return mainMenuBar;

	}
	private MenuBar loadWhiteMenuBar() {

		Menu viewMenu = new Menu("View");
		wordCountItem = new CheckMenuItem("Word Count");
		sentenceCountItem = new CheckMenuItem("Sentence Count");
		fleschScoreItem = new CheckMenuItem("Flesch Score");
		toggleAll = new CheckMenuItem("Toggle All");
		imageMenuItem = new CheckMenuItem("Credits");
		imageMenuItem.setSelected(true);
		viewMenu.getItems().addAll(wordCountItem, sentenceCountItem, fleschScoreItem, toggleAll,
				new SeparatorMenuItem(), imageMenuItem);

		Menu editMenu = new Menu("Edit");

		CopyMenuItem copy = new CopyMenuItem();
		CutMenuItem cut = new CutMenuItem();
		PasteMenuItem paste = new PasteMenuItem();
		DeleteMenuItem delete = new DeleteMenuItem();
		
		SeparatorMenuItem secondSeparate = new SeparatorMenuItem();
		
		secondSeparate.getContent().setStyle("-fx-border-color: red;" + 
				"-fx-border-insets: 0;");
		MarkovMenuItem markov = new MarkovMenuItem();

	
		editMenu.getItems().addAll(copy, cut, paste, new SeparatorMenuItem(), delete, secondSeparate, markov);

		Menu windowMenu = new Menu("Window");
		toggleDarkMode = new CheckMenuItem("Dark Mode");
		windowMenu.getItems().add(toggleDarkMode);
		
		Menu graphMenu = new Menu("Graph Analysis");
		GraphMenuItem graph = new GraphMenuItem();
		graphMenu.getItems().add(graph);


		
		
		
		Menu styleMenu = new Menu("Format");
		StyleMenuItem styleMenuItem = new StyleMenuItem();
		
		
		styleMenu.getItems().add(styleMenuItem);
		MenuBar restMenu = new MenuBar(viewMenu, editMenu, windowMenu, graphMenu, styleMenu);
		ColorHBox.loadStatusBarActions();
		ColorHBox.toggleViewMenuItems();

		return restMenu;
	}
	public void toggleDarkMode() {
		
		toggleDarkMode.setOnAction(e -> {
			

			if (toggleDarkMode.isSelected()) {
				
				MenuColors.isDarkMode = true;
				TextEditorPane.mainTextArea.setContextMenu(MenuColors.createDarkMenu(TextEditorPane.createMenuItems()));

			} else {
				MenuColors.isDarkMode = false;
				TextEditorPane.mainTextArea.setContextMenu(MenuColors.createLightMenu(TextEditorPane.createMenuItems()));
			}
		});

	}

}
