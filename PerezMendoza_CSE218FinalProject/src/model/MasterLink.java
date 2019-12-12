package model;
import java.util.LinkedList;

public class MasterLink {
	private String uniqueWord;
	private LinkedList<String> babyWords;
	
	
	public MasterLink(String word) {
		this.setUniqueWord(word);
		setBabyWords(new LinkedList<>());
	}


	public String getUniqueWord() {
		return uniqueWord;
	}


	public void setUniqueWord(String uniqueWord) {
		this.uniqueWord = uniqueWord;
	}


	public LinkedList<String> getBabyWords() {
		return babyWords;
	}


	public void setBabyWords(LinkedList<String> babyWords) {
		this.babyWords = babyWords;
	}

	public String toString() {
		return uniqueWord + " : " + babyWords;
	}
}
