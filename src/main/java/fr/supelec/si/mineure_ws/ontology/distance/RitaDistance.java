package fr.supelec.si.mineure_ws.ontology.distance;

import rita.wordnet.RiWordnet;

public class RitaDistance extends LangBased {

	public RitaDistance() {
		// TODO Auto-generated constructor stub
	}

	public double getSimilarity(String word1, String word2) {
		String nWord1 = normalizeWord(word1);
		String nWord2 = normalizeWord(word2);

		RiWordnet wordnet = new RiWordnet();
		String pos = wordnet.getBestPos(nWord1);

		return 1.0 - wordnet.getDistance(nWord1, nWord2, pos);
	}

}
