package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

import model.TextEditorPane;


public class DataHandler {

	public static String readData(File file) {
		StringBuilder text = new StringBuilder();
		try {
			Scanner read = new Scanner(file);
			read.useDelimiter("\\Z");
			while (read.hasNext()) {
			
				text.append(read.nextLine() + "\n");
			
			}
			read.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		
		return text.toString();

	}


	public static void saveData(File file) {

		try (PrintStream out = new PrintStream(new FileOutputStream(file.toString()))) {
			//TextEditorPane.isSaved = true;
			out.print(TextEditorPane.mainTextArea.getText());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
}
