package assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SentenceSortingByVowelsCount {
	
	
	
	public int countVowels(String sentence) {
		int count = 0;
		
		String lowerCaseSentence = sentence.toLowerCase();
		
		for (int i = 0; i< lowerCaseSentence.length(); i++) {
			char ch = lowerCaseSentence.charAt(i);
			
			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		List<String> sentences = new ArrayList<String>();
		sentences.add("How are you");
		sentences.add("I am good");
		sentences.add("My name is indrajeet");
		sentences.add("what is your name ?");
		sentences.add("Bring me the thanos");
		sentences.add("I am ironman");
		sentences.add("I am inevitable");
		sentences.add("Avengers Assemble yaaahhhhhh!!!!!");
		
		System.out.println(sentences);
		
		SentenceSortingByVowelsCount vc = new SentenceSortingByVowelsCount();
		Map<String, Integer> senWithVowelCount = new HashMap<String, Integer>();
		
		for (String sen : sentences) {
			senWithVowelCount.put(sen, vc.countVowels(sen));
		}
		
		Map<String, Integer> sortedSentences = senWithVowelCount.entrySet()
				.stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.collect(Collectors.toMap(
				Map.Entry::getKey,
				Map.Entry::getValue,
				(e1,e2)->e1,
				LinkedHashMap::new));
		
		System.out.println(sortedSentences);
		
		
	}

}
