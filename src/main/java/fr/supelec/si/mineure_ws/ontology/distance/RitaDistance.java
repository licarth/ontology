package fr.supelec.si.mineure_ws.ontology.distance;

import rita.wordnet.RiWordnet;

public class RitaDistance extends LangBased {
	private RiWordnet wordnet;
	
	public RitaDistance() {
		this.wordnet = new RiWordnet();
	}

	public double getSimilarity(String word1, String word2) {
		String nWord1 = normalizeWord(word1);
		String nWord2 = normalizeWord(word2);

		String pos = wordnet.getBestPos(nWord1);

		if (pos == null) return 0.0;
		
		return 1.0 - wordnet.getDistance(nWord1, nWord2, pos);
	}

}
