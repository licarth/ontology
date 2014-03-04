package fr.supelec.si.mineure_ws.ontology.distance;

public class Hamming extends StringBased {

	public Hamming() {
		// TODO Auto-generated constructor stub
	}

	public double getSimilarity(String word1, String word2) {
		String nWord1 = normalizeWord(word1);
		String nWord2 = normalizeWord(word2);
		int minOfLength = (nWord1.length() <= nWord2.length()) ? nWord1.length() : nWord2.length();
		int maxOfLength = (nWord1.length() <= nWord2.length()) ? nWord2.length() : nWord1.length();
		
		int counter = 0;
		
		for(int i = 0; i<minOfLength; i++){
			if(nWord1.charAt(i)!=nWord2.charAt(i))
				counter++;
		}
		
		double result = (double) (counter + Math.abs(maxOfLength - minOfLength))/maxOfLength;
		return 1 - result;
	}
	
	

}
