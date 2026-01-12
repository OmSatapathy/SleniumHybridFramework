package corejava;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

public class Alphanumeric {

	public static void main(String[] args) {
		
		RandomStringGenerator randomStringGenerator =
		        new RandomStringGenerator.Builder()
		                .withinRange('0', 'z')
		                .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
		                .build();
		randomStringGenerator.generate(12);
		
		System.out.println(randomStringGenerator.generate(6));

	}

}
