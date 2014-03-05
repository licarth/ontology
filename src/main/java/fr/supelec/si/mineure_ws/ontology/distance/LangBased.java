package fr.supelec.si.mineure_ws.ontology.distance;

public abstract class LangBased implements StringDistanceComparator {

	public LangBased() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getSimilarity(String word1, String word2) {
		// TODO Auto-generated method stub
		return 0;
	}

	static public String normalizeWord(String word){
		String nWord = word.toLowerCase();
		//TODO Other transformations to implement
		return nWord;
	}
}
