package fr.supelec.si.mineure_ws.ontology.distance;

import org.junit.Before;
import org.junit.Test;

public class LangBasedTest {
	private String word1, word2;

	@Before
	public void setup(){
		this.word1 = "run";
		this.word2 = "sygb";
	}
	
	@Test
	public void testSynonyms() {
		Synonyms s = new Synonyms();
		System.out.println("Similarité par synonymes = " + s.getSimilarity(word1, word2) + ".");
	}

	@Test
	public void testRitaDistance() {
		RitaDistance rd = new RitaDistance();
		System.out.println("Similarité par distance de RiTa = " + rd.getSimilarity(word1, word2) + ".");
	}

}
