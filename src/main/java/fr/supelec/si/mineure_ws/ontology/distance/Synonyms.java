package fr.supelec.si.mineure_ws.ontology.distance;

import java.util.Vector;

import rita.wordnet.RiWordnet;

public class Synonyms extends LangBased {
	private RiWordnet wordnet;

	public Synonyms() {
		this.wordnet = new RiWordnet();
	}

	/*
	 * Returns 1.0 if both words are in common synset, 0.0 otherwise
	 * On suppose que tout est symétrique
	 */
	public double getSimilarity(String word1, String word2) {
		String nWord1 = normalizeWord(word1);
		String nWord2 = normalizeWord(word2);

		String[] pos = wordnet.getPos(nWord1);

		if(pos!=null){

			Vector<String> allSynonyms = new Vector<String>();
			for(int k = 0; k<pos.length; k++){
				String[] allSynsets = wordnet.getAllSynsets(nWord1, pos[k]);
				for(int i = 0; i<allSynsets.length; i++) {
					allSynonyms.add(allSynsets[i]);
				}
			}


			if(allSynonyms.contains(nWord2)){
				return 1.0;
			} 
		}


		return 0.0;

	}

}
