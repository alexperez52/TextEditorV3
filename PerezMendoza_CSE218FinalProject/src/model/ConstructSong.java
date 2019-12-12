package model;

import java.util.HashMap;
import java.util.LinkedList;

public class ConstructSong {
	
	private String song;
	private String count;
	
	public ConstructSong(String fullText ,String word, String count) {
		
		//ReadData.getUniqueWords(fullText);
	
		int number = Integer.parseInt(count);
		
		
		
		HashMap<String , LinkedList<String>> full = ReadData.values();
		
		song = ReadData.consSong(word, number, full);
		
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

}
