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
<<<<<<< HEAD
=======
		
		RiWordnet wordnet = new RiWordnet();
		
		String pos1 = wordnet.getBestPos(nWord1);
		if (pos1 == null) return 0.0;
		String pos2 = wordnet.getBestPos(nWord2);
		if (pos2 == null) return 0.0;
		
		String[] synonyms1 = wordnet.getAllSynonyms(nWord1, pos1);
>>>>>>> branch 'master' of git@github.com:licarth/ontology.git

<<<<<<< HEAD
		String[] pos = wordnet.getPos(nWord1);

		if(pos!=null){

			Vector<String> allSynonyms = new Vector<String>();
			for(int k = 0; k<pos.length; k++){
				String[] allSynsets = wordnet.getAllSynsets(nWord1, pos[k]);
				if(allSynsets!=null){
					for(int i = 0; i<allSynsets.length; i++) {
						allSynonyms.add(allSynsets[i]);
					}
				}
=======
		for(int i = 0; i<synonyms1.length; i++){
			if(synonyms1[i].equals(nWord2))
				return 1.0;
		}
		
		String[] synonyms2 = wordnet.getAllSynonyms(nWord2, pos2);
		for(int i = 0; i<synonyms2.length; i++){
			if(synonyms2[i].equals(nWord1)){
				System.out.println("Rï¿½fï¿½rencement non bijectif.");
				return 1.0;
>>>>>>> branch 'master' of git@github.com:licarth/ontology.git
			}


			if(allSynonyms.contains(nWord2)){
				return 1.0;
			} 
		}


		return 0.0;

	}

}
