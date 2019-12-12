package view;

import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuItem;
import model.TextEditorPane;

public class StyleMenuItem extends CheckMenuItem{

	public StyleMenuItem() {
		super("Formatting / Spell Check");
	
		setOnAction(e -> {
			
			
			if(TextEditorPane.bp.getRight() != null) {
				TextEditorPane.bp.setRight(null);
			}
			
			else {
				TextEditorPane.bp.setRight(new PreSidePane());
			}
		});
	}

}
