package fr.supelec.si.mineure_ws.ontology.distance;

import rita.wordnet.RiWordnet;

public class testRita {

	public static void main(String[] args) {
		RiWordnet wordnet = new RiWordnet();
		String word = "runner";
		String[] pos = wordnet.getPos(word);
		for(int j = 0; j<pos.length; j++){
			int[] ids = wordnet.getSenseIds(word, pos[j]);
			for (int i = 0; i < ids.length; i++) {
				// Sense ID #

				System.out.println("Pour le mot " + word + " consid�r� comme un " + pos[j] + " :");

				String[] words = wordnet.getSynset(ids[i]);
				if (words != null) {
					System.out.println("Il y a " + words.length + " synonymes associ�s � " + word + " dans son " + i + "�me sens :");
					for (int k = 0; k < words.length; k++) System.out.print(words[k] + " ");
				} else {
					System.out.println("PAS de synonymes associ�s � " + word + " dans son " + i + "�me sens :");
				}
				System.out.println("");
				//System.out.println("n-------------------------");
			}
		}
		
		String[] synnn = wordnet.getSynonyms(word,pos[0]);
		for(int i = 0; i<synnn.length; i++) System.out.println(synnn[i] + " ");

		//		// Synonyms for all senses
		//		String word2 = "car";
		//		String[] pos2 = wordnet.getPos(word2);	
		//
		//		for(int i = 0; i<pos2.length; i++){
		//			int[] idSet = wordnet.getSenseIds(word2,pos2[i]);
		//			for(int k = 0; k<idSet.length; k++){
		//				
		//			}
		//			String[] result = wordnet.getSynset(word2, pos2[i]);
		//			if(result == null){
		//				System.out.println("Pas de synonymes associ�s � " + word2 + " dans son " + i + "�me sens.");
		//			}else{
		//				System.out.println("Synonymes associ�s � " + word2 + " dans son " + i + "�me sens :");
		//				for (int j = 0; j < result.length; j++) {
		//					System.out.println(result[j]);
		//				}
		//			}
		//		}
		//
		//		System.out.println(wordnet.getDistance("god", "writer", wordnet.getBestPos("writer")));


	}

}
