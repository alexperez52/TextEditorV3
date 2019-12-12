package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import model.TextEditorPane;

public class LoadDictionary {

	
	public static int errorCount;
	public static HashSet<String> loadDictionary() {
		
		File file = new File("inputData/dictionary.txt");
		
		
		StringBuilder text = new StringBuilder();
		int counter = 0;
		try {
			Scanner read = new Scanner(file);
			read.useDelimiter("\\Z");
			while (read.hasNext()) {
				counter++;
				text.append(read.nextLine() + "\n");
			
			}
			read.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		
		String [] wholeDict = text.toString().split("[^\\w']+");
		
		HashSet<String> dictionary = new HashSet<>(counter);
		for(int i = 0; i < wholeDict.length;i++) {
			
		
			dictionary.add(wholeDict[i]);
		}
		
		return dictionary;
	}
	
	public static LinkedList<String> misspelledWords(){
		LinkedList<String> errorWords = new LinkedList<>();
		HashSet<String> dictionary = loadDictionary();
		errorCount = 0;
		String [] words = TextEditorPane.mainTextArea.getText().toString().split("[^\\w']+");
		for(int i =0 ; i < words.length; i++) {
			if(!dictionary.contains(words[i]) && !dictionary.contains(words[i].toLowerCase())) {
				errorWords.add(words[i]);
				errorCount++;
			}
		}
		System.out.println(errorCount);
		System.out.println(errorWords);
		
		System.out.println(dictionary.contains("epic"));
		return errorWords;
		
	}

}
