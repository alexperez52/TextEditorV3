package utils;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Counter {

	public static int[] allInOne(String text) {
		final String sentREGEX = "[^?!.][?!.]";
		final String syllREGEX = "(?i)(ame)|(year)|(yell)|(else)|(umped)|[^aeiouy](ean)"
				+ "|[^aeiouy](ee)|\\s+(ache)|(mph)|(ps)|(ied)|(ies)"
				+ "|i[aeiouy]|[^n](aked)|(akes)|(ice)|r(eet)|(ened)"
				+ "|(ome)+\\s|(quent)|(use)|(all)|(poe)[aeiouy]|(lieve)"
				+ "|(ase)|(abe)+\\s|(ives)|(pet)|(ates)|(are)|[a-z][a-z]"
				+ "[^a-z](ed)|[a-z](ee)d|b(e)|(ing)|[^aeiouy](oad)|(orse)"
				+ "|(orced)|(oarse)+\\s|(ourse)+\\s|(lau)|(you)|(one)|y|"
				+ "(aced)|(ore)\\s|(ized)|(loo)|(loo)[snk]|(rey)|(ered)|"
				+ "(rea)[sdp]|(r[e]|a[l])|e[a]|au[se]|\\s+b[e]*^a|(ee)|p"
				+ "[o]|(oe)|[wshm]e+\\s(?!b?\\\\\\\\b)|i[aeiouy][aeiouy]*|"
				+ "[t]+[h]+[e]y|[e]+[bcdfghjklmnpqrstvwxz]|[i]es|[u]ee|[u]a"
				+ "a|[u]aa+[a]|[aiouy][iouy]*|e[aeiuy][ey]*(?!b?\\b)|[c]+[e]"
				+ "+[bcdfghjklmnpqrstvwxz]|[q]+[u]+[o]|[o]+[e]+[i]|e[y]|[l]+"
				+ "[e]*[aeiouy]|[u]|u[ouiy]|o[oauiy]|[o]|y[aiouy]";
		
		StringTokenizer counter = new StringTokenizer(text);
		Matcher m1 = Pattern.compile(sentREGEX).matcher(text);
		Matcher m2 = Pattern.compile(syllREGEX).matcher(text);
		int one = 0;
		int two =0;
		int three = 0;
		
		for(int i =0; i < text.length(); i++) {
			if(m1.find()) {
				one++;
			}
			if(m2.find()) {
				two++;
			}
		}
		
		three = counter.countTokens();
		
		return new int[]{one, two,three};
	}
	
	public static int wordCount(String text) {

		if (text == null || text.isEmpty()) {
			return 0;
		}
		StringTokenizer counter = new StringTokenizer(text);
		return counter.countTokens();

	}

	public static int sentenceCount(String text) {
		final String REGEX = "[^?!.][?!.]";
		Matcher m = Pattern.compile(REGEX).matcher(text);
		int count = 0;

		while(m.find()) {
			count++;
		}
		// return at least 1
		return Math.max(count, 1);

	}

	public static double fleschCount(String text) {
		// 206.835 - 1.015 x (words/sentences) - 84.6 x (syllables/words)
		double wordSentence = ((double) wordCount(text) / sentenceCount(text));
		double syllableWord = ((double) countSyllables(text) / wordCount(text));

		double result = 206.835 - 1.015 * (wordSentence) - 84.6 * (syllableWord);

	
		return ((int) (result * 100)) / 100.0;
	}

	public static int countSyllables(String word) {
		final String REGEX = "(?i)(ame)|(year)|(yell)|(else)|(umped)|[^aeiouy](ean)"
				+ "|[^aeiouy](ee)|\\s+(ache)|(mph)|(ps)|(ied)|(ies)"
				+ "|i[aeiouy]|[^n](aked)|(akes)|(ice)|r(eet)|(ened)"
				+ "|(ome)+\\s|(quent)|(use)|(all)|(poe)[aeiouy]|(lieve)"
				+ "|(ase)|(abe)+\\s|(ives)|(pet)|(ates)|(are)|[a-z][a-z]"
				+ "[^a-z](ed)|[a-z](ee)d|b(e)|(ing)|[^aeiouy](oad)|(orse)"
				+ "|(orced)|(oarse)+\\s|(ourse)+\\s|(lau)|(you)|(one)|y|"
				+ "(aced)|(ore)\\s|(ized)|(loo)|(loo)[snk]|(rey)|(ered)|"
				+ "(rea)[sdp]|(r[e]|a[l])|e[a]|au[se]|\\s+b[e]*^a|(ee)|p"
				+ "[o]|(oe)|[wshm]e+\\s(?!b?\\\\\\\\b)|i[aeiouy][aeiouy]*|"
				+ "[t]+[h]+[e]y|[e]+[bcdfghjklmnpqrstvwxz]|[i]es|[u]ee|[u]a"
				+ "a|[u]aa+[a]|[aiouy][iouy]*|e[aeiuy][ey]*(?!b?\\b)|[c]+[e]"
				+ "+[bcdfghjklmnpqrstvwxz]|[q]+[u]+[o]|[o]+[e]+[i]|e[y]|[l]+"
				+ "[e]*[aeiouy]|[u]|u[ouiy]|o[oauiy]|[o]|y[aiouy]";

		Matcher m = Pattern.compile(REGEX).matcher(word);

		int count = 0;


		while(m.find()) {
			count++;
		}
		// return at least 1
		return Math.max(count, 1);

	}
}
