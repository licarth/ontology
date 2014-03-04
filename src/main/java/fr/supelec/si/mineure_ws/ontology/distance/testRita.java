package fr.supelec.si.mineure_ws.ontology.distance;

import rita.wordnet.RiWordnet;

public class testRita {

	public static void main(String[] args) {
		RiWordnet wordnet = new RiWordnet();
		String word = "run";
		String[] pos = wordnet.getPos(word);
		int[] ids = wordnet.getSenseIds(word, pos[0]);
		for (int i = 0; i < ids.length; i++) {
			  // Sense ID #
			  System.out.println("Sense: " + ids[i]);
			  String description = wordnet.getDescription(ids[i]);
			  // Sense Description (definition)
			  System.out.println("Description: " + description);
			  // All words that belong to this synset
			  String[] words = wordnet.getSynset(ids[i]);
			  if (words != null) {
			    System.out.print("Synset: ");
			    for (int j = 0; j < words.length; j++) System.out.print(words[j] + " ");
			  }
			  System.out.println("n-------------------------");
			}
		
		// Hyponyms for all senses
		String word2 = "writer";
		String pos2 = wordnet.getBestPos(word2);
		String[] result = wordnet.getAllSynonyms(word2, pos2);
		for (int i = 0; i < result.length; i++) {
		  System.out.println(result[i]);
		}



	}

}
