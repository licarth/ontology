package fr.supelec.si.mineure_ws.ontology.distance;

import rita.wordnet.RiWordnet;

public class Synonyms extends LangBased {

	public Synonyms() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Returns 1.0 if both words are in common synset, 0.0 otherwise
	 * TODO Distinguer synonymes et hyponymes ?
	 */
	public double getSimilarity(String word1, String word2) {
		String nWord1 = normalizeWord(word1);
		String nWord2 = normalizeWord(word2);
		
		RiWordnet wordnet = new RiWordnet();
		
		String pos1 = wordnet.getBestPos(nWord1);
		if (pos1 == null) return 0.0;
		String pos2 = wordnet.getBestPos(nWord2);
		if (pos2 == null) return 0.0;
		
		String[] synonyms1 = wordnet.getAllSynonyms(nWord1, pos1);

		for(int i = 0; i<synonyms1.length; i++){
			if(synonyms1[i].equals(nWord2))
				return 1.0;
		}
		
		String[] synonyms2 = wordnet.getAllSynonyms(nWord2, pos2);
		for(int i = 0; i<synonyms2.length; i++){
			if(synonyms2[i].equals(nWord1)){
				System.out.println("R�f�rencement non bijectif.");
				return 1.0;
			}
		}
		
		return 0.0;
		
	}

}
