package fr.supelec.si.mineure_ws.ontology;

import fr.supelec.si.mineure_ws.ontology.distance.Hamming;
import fr.supelec.si.mineure_ws.ontology.distance.StringDistanceComparator;
import fr.supelec.si.mineure_ws.ontology.distance.SubString;

public enum StringComparisonMethod {
	HAMMING(new Hamming()),
	SUBSTRING(new SubString()),
	
	;
	
	private StringDistanceComparator comparisonStrategy;
	
	StringComparisonMethod(StringDistanceComparator c) {
		this.comparisonStrategy = c;
	}

	public StringDistanceComparator getComparisonStrategy() {
		return comparisonStrategy;
	}
	
}