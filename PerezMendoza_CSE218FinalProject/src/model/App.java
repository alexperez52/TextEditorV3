package model;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class App extends Application {

	public static void main(String[] args) {

		
		Application.launch();
	}

	@Override
	public void start(Stage primary) throws Exception {
	
		@SuppressWarnings("static-access")
		Scene scene = new Scene(new TextEditorPane().bp);
		
		primary.setScene(scene);
		primary.setMaximized(false);
		primary.setResizable(true);
		File file = new File("icons/tri.png");
		Image image = new Image(file.toURI().toString());
		primary.setTitle("Clay ©");
		primary.getIcons().add(image);
		
		primary.show();
	}

}
