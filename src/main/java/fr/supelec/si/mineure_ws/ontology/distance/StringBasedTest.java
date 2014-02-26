package fr.supelec.si.mineure_ws.ontology.distance;

import org.junit.Before;
import org.junit.Test;

public class StringBasedTest {
	private String word1, word2;
	
	@Before
	public void setup(){
		this.word1 = "car";
		this.word2 = "airtransport";
	}
	
	@Test
	public void testHamming() {
		Hamming h = new Hamming();
		System.out.println("Similitude de Hamming = " + h.getSimilarity(word1,word2) + ".");
	}
	
	@Test
	public void testSubString(){
		SubString ss = new SubString();
		System.out.println("Similitude de sous-chaine = " + ss.getSimilarity(word1, word2) + ".");
	}

}
