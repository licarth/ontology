package fr.supelec.si.mineure_ws.ontology;

import com.hp.hpl.jena.ontology.OntModel;

public class OntologyComparator {

	static public class Builder {
		static OntologyComparator buildFromRDFFiles(String path1, String path2) {
			return null;
		}
	}
	
	private OntModel ontology1;
	private OntModel ontology2;
	
	public ComparisonResult compare(ComparisonMethod method) {
		switch (method) {
		
		case STRING_MATCHING:
			
			
			
			
			break;

		default:
			break;
		}
		return null;
	}
	
	
	
}
