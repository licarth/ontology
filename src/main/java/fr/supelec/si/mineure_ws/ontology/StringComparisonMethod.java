package fr.supelec.si.mineure_ws.ontology;

import fr.supelec.si.mineure_ws.ontology.distance.Hamming;
import fr.supelec.si.mineure_ws.ontology.distance.RitaDistance;
import fr.supelec.si.mineure_ws.ontology.distance.StringDistanceComparator;
import fr.supelec.si.mineure_ws.ontology.distance.SubString;
import fr.supelec.si.mineure_ws.ontology.distance.Synonyms;

public enum StringComparisonMethod {
	HAMMING(new Hamming()),
	SUBSTRING(new SubString()),
	RITA(new RitaDistance()),
	SYNONYMS(new Synonyms()),
	;
	
	private StringDistanceComparator comparisonStrategy;
	
	StringComparisonMethod(StringDistanceComparator c) {
		this.comparisonStrategy = c;
	}

	public StringDistanceComparator getComparisonStrategy() {
		return comparisonStrategy;
	}
	
}