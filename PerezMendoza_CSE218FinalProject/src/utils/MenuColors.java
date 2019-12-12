package utils;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import model.TextEditorPane;
import view.SidePane;

public class MenuColors {
	public static boolean isDarkMode;
	public static ContextMenu createDarkMenu(MenuItem[] items) {

		ContextMenu darkMenu = new ContextMenu();
		for (int i = 0; i < items.length; i++) {
			darkMenu.getItems().add(items[i]);
		}

		for (MenuItem m : darkMenu.getItems()) {
			
			m.setStyle("fx-background-color:transparent;" + 
					"-fx-padding: 0.2em 0.1em 0.2em 0.1em;" + 
					"-fx-text-fill: rgba(255, 255, 255, 0.6);" + 
					"-fx-effect: null;" + 
					"-fx-font-size: 13px;" + 
					"-fx-font-family: 'Open Sans';"+
					"-fx-text-fill: rgba(255, 255, 255, 0.6);");
			
		}

		darkMenu.getItems().get(3).setStyle("-fx-text-fill: #f04747;");
		darkMenu.setStyle("-fx-background-color: rgba(40, 43, 48, 1);" + 
				"-fx-background-insets: 0;" + 
				"-fx-padding: 5px;" + 
				"-fx-background-radius: 5px;" + 
				"-fx-border-radius: 5px;" + 
				"-fx-border-color: rgba(245, 245, 245, 0.1);" + 
				"-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.6) , 6, 0.0 , 0 , 0);");
		
		TextEditorPane.mainTextArea.setStyle(SidePane.color + SidePane.size + "-fx-focus-color: -fx-control-inner-background ;"
				+ " -fx-faint-focus-color: #424242" + " -fx-control-inner-background; "
				+ "-fx-background-color: #424242;" + "-fx-control-inner-background: #424242");

		TextEditorPane.mainTextArea.setMaxHeight(1000);
		TextEditorPane.mainTextArea.setBorder(new Border(new BorderStroke(Color.DIMGRAY, BorderStrokeStyle.SOLID,
				new CornerRadii(0), new BorderWidths(10, 75, 0, 75))));

		TextEditorPane.colorHbox.setStyle("-fx-background-color: dimgrey; -fx-control-inner-background: #303030");
		TextEditorPane.colorHbox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0),
				new BorderWidths(1, 0, 0, 0))));
		
		return darkMenu;
	}

	public static ContextMenu createLightMenu(MenuItem[] items) {

		ContextMenu lightMenu = new ContextMenu();
		for (int i = 0; i < items.length; i++) {
			lightMenu.getItems().add(items[i]);
		}
		for (MenuItem m : lightMenu.getItems()) {
			m.setStyle("fx-background-color:transparent;" + 
					"-fx-padding: 0.2em 0.1em 0.2em 0.1em;" + 
					"-fx-effect: null;" + 
					"-fx-font-size: 13px;" + 
					"-fx-font-family: 'Open Sans';"+
					"-fx-text-fill: dimgrey; ");
			
		}
		lightMenu.getItems().get(3).setStyle("-fx-text-fill: #f04747;");
		lightMenu.setStyle("-fx-background-color: white;" + 
				"-fx-background-insets: 0;" + 
				"-fx-padding: 5px;" + 
				"-fx-background-radius: 5px;" + 
				"-fx-border-radius: 5px;" + 
				"-fx-border-color: rgba(245, 245, 245, 0.1);" + 
				"-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.6) , 6, 0.0 , 0 , 0);");
		TextEditorPane.mainTextArea.setStyle("-fx-focus-color: -fx-control-inner-background ;"
				+ " -fx-faint-focus-color: #424242" + " -fx-control-inner-background; "
				+ "-fx-background-color: #424242;" + "-fx-control-inner-background: #424242");

		TextEditorPane.mainTextArea.setStyle(SidePane.color + SidePane.size + "-fx-focus-color: -fx-control-inner-background ;"
				+ " -fx-faint-focus-color: white" + " -fx-control-inner-background; "
				+ "-fx-background-color: white;" + "-fx-control-inner-background: white");
		TextEditorPane.mainTextArea.setMaxHeight(1000);
		TextEditorPane.mainTextArea.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID,
				new CornerRadii(0), new BorderWidths(10, 75, 0, 75))));

		TextEditorPane.colorHbox.setStyle("-fx-background-color: white; -fx-control-inner-background: white");
		TextEditorPane.colorHbox.setBorder(new Border(new BorderStroke(Color.DIMGREY, BorderStrokeStyle.SOLID, new CornerRadii(0),
				new BorderWidths(1, 0, 0, 0))));
	
		return lightMenu;
	}
}
