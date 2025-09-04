package challenge.day2;

import java.util.HashMap;

public class SearchingStrings {
	
	/* Day 2 – Searching Strings
	 * Challenge: Implement indexOf() manually, and create a word frequency counter.
	 * Objectives: Linear search, loop mastery.
	 * Best Practice Tip: Avoid nested loops unless necessary.
	 * Success Criteria: Program finds all occurrences correctly.
	 */
	
	public static void wordFrequencyCounter(String val) {
		String[] words = val.split("[^a-zA-Z0-9]+");
		
		HashMap<String, Integer> wordCounter = new HashMap<String, Integer>(); 
		
		for(int i = 0; i < words.length; i++) {			
			if(!wordCounter.containsKey(words[i])) {
				wordCounter.put(words[i], 1);				
			}else {
				int countRepeatedWords = wordCounter.get(words[i]);
				wordCounter.replace(words[i], countRepeatedWords+=1);
			}
		}
		
		wordCounter.forEach((word, count) -> {
			System.out.println(word +" -> "+ count);
		});
	}
	
	public static int indexOf(String str, String search, int fromIndex) {
		for(int i = fromIndex; i < str.length(); i++) {
			
			String foundSearch = "";
			
			for(int j = 0; j < search.length(); j++) {
				try {
					if(search.charAt(j) == str.charAt(j + i)) {
						foundSearch += str.charAt(j + i);
					}else {
						foundSearch = "";
					}					
				}catch(StringIndexOutOfBoundsException e) {
					return -1;
				}
			}
			
			if(foundSearch.equals(search)) {
				return i;
			}
		
		}
		
		return -1;
	}

	public static void main(String[] args) {
		String myStr = "Hello planet earth, you are a great planet.";
		
		System.out.println(indexOf(myStr, "planet", 1));
		
		wordFrequencyCounter(myStr);
	}
}
