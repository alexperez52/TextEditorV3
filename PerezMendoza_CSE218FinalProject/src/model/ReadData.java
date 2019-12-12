package model;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import utils.Counter;

public class ReadData {
	static String [] unsortedWords;

	public static void getUniqueWords(String file) {
		LinkedList<String> uWordsS = new LinkedList<>();

		unsortedWords = file.split("[\\s]+");
		
		uWordsS = sort(unsortedWords);
		
	}
	

	
	public static String consSong(String word, int count, HashMap<String, LinkedList<String>> map) {
		
		String song = word;
		
		String temp = song;
		String temp2 = "";		
		
		
		for(int i =1; i < count; i ++) {
			int size = map.get(temp).size();
			//System.out.println("size" + size);
			int random = (int) (Math.random() *size);
			//System.out.println(random);
			
			temp = map.get(temp).get(random);
			temp2 = temp;
			song += " " + temp2;
		
		//	System.out.println(i);
		}
		return song;
	}
	
	public static HashMap<String, LinkedList<String>> values(){
		
		HashMap<String, LinkedList<String>> theMap = new HashMap<>(Counter.wordCount(TextEditorPane.mainTextArea.getText()));
		
		String wordList = null;
        wordList = TextEditorPane.mainTextArea.getText();

        String[] words = wordList.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if (!theMap.containsKey(words[i])) {
                LinkedList<String> list = new LinkedList<String>();
                theMap.put(words[i], list);
            }
            if (i != words.length - 1) {
                theMap.get(words[i]).add(words[i + 1]);
            }
        }
	
      //  System.out.println(theMap);
	
        return theMap;
		
	}
	
	private static LinkedList<String> sort(String[] words) {

		LinkedList<String> wor = new LinkedList<>();
		HashSet<String> uw = new HashSet<>();

		for(int i = 0; i <words.length; i++) {
			uw.add(words[i]);
		}
		
		Iterator<String> iter = uw.iterator();
		while(iter.hasNext()) {
		wor.add(iter.next());
		}

		
		return wor;
		}
	
	
	
}
