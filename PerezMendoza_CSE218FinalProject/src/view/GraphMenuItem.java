package view;

import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class GraphMenuItem extends MenuItem {

	public GraphMenuItem() {
		super("Graph");

		setOnAction(e -> {
			
			GraphTest a =new GraphTest();
			try {
				a.start(new Stage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		}


}
