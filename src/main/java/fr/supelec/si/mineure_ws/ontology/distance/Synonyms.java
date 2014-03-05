package fr.supelec.si.mineure_ws.ontology.distance;

import java.util.Vector;

import rita.wordnet.RiWordnet;

public class Synonyms extends LangBased {
	private RiWordnet wordnet;

	public Synonyms() {
		this.wordnet = new RiWordnet();
	}

	/* Returns
	 * 1.0 if both words are in common synset
	 * O.85 if one is hyponym of the others
	 * 0.0 otherwise
	 */
	public double getSimilarity(String word1, String word2) {
		String nWord1 = normalizeWord(word1);
		String nWord2 = normalizeWord(word2);

		String[] pos = wordnet.getPos(nWord1);

		if(pos!=null){
			
			//SYNONYMES PURS
			Vector<String> allSynonyms = getSynonymsOf(nWord1,pos);
			if(allSynonyms.contains(nWord2)){
				return 1.0;
			} 
			
			//HYPONYMES DE NWORD1
			Vector<String> allHyponyms1 = getHyponymsOf(nWord1,pos);
			if(allHyponyms1.contains(nWord2)){
				return 0.85;
			} 
			
			//HYPONYMES DE NWORD2 (=HYPERONYMES DE NWORD1)
			Vector<String> allHyponyms2 = getHyponymsOf(nWord2,pos);
			if(allHyponyms2.contains(nWord1)){
				return 0.85;
			}
		}


		return 0.0;
	}
	
	private Vector<String> getSynonymsOf(String word, String[] pos){
		Vector<String> allSynonyms = new Vector<String>();
		for(int k = 0; k<pos.length; k++){
			String[] allSynsets = wordnet.getAllSynsets(word, pos[k]);
			if(allSynsets!=null){
				for(int i = 0; i<allSynsets.length; i++) {
					allSynonyms.add(allSynsets[i]);
				}
			}
		}
		return allSynonyms;
	}
	
	private Vector<String> getHyponymsOf(String word, String[] pos){
		Vector<String> allHyponyms = new Vector<String>();
		for(int k = 0; k<pos.length; k++){
			String[] allHypoByPos = wordnet.getAllHyponyms(word, pos[k]);
			if(allHypoByPos!=null){
				for(int i = 0; i<allHypoByPos.length; i++) {
					allHyponyms.add(allHypoByPos[i]);
				}
			}
		}
		
		return allHyponyms;
	}

}
