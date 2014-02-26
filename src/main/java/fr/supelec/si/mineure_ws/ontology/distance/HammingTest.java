package fr.supelec.si.mineure_ws.ontology.distance;

import static org.junit.Assert.*;

import org.junit.Test;

public class HammingTest {

	@Test
	public void test() {
		String word1 = "Bonjour";
		String word2 = "Abajour";
		
		Hamming h = new Hamming();
		System.out.println("Similitude = " + h.getSimilarity(word1,word2) + " .");
	}

}
