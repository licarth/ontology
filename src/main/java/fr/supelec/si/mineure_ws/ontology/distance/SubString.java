package fr.supelec.si.mineure_ws.ontology.distance;

public class SubString extends StringBased {

	public SubString() {
		// TODO Auto-generated constructor stub
	}
	
	public double getSimilarity(String word1, String word2) {
		String nWord1 = normalizeWord(word1);
		String nWord2 = normalizeWord(word2);
		
		int length1 = nWord1.length();
		int length2 = nWord2.length();
		
		int t = longestCommonSubstring(nWord1,nWord2);
		
		double result = (double) (2*t)/(length1 + length2);
		return result;	
	}

	public static int longestCommonSubstring(String S1, String S2)
	{
	   // int Start = 0;
	    int Max = 0;
	    for (int i = 0; i < S1.length(); i++)
	    {
	        for (int j = 0; j < S2.length(); j++)
	        {
	            int x = 0;
	            while (S1.charAt(i + x) == S2.charAt(j + x))
	            {
	                x++;
	                if (((i + x) >= S1.length()) || ((j + x) >= S2.length())) break;
	            }
	            if (x > Max)
	            {
	                Max = x;
	                //Start = i;
	            }
	         }
	    }
	    return Max;
	}
}
