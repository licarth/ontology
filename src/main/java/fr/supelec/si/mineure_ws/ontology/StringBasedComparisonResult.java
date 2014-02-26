package fr.supelec.si.mineure_ws.ontology;

import java.util.HashMap;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.reasoner.rulesys.impl.TempNodeCache.NodePair;

public class StringBasedComparisonResult {
	private OntModel ontology1;
	private OntModel ontology2;
	
	private HashMap<NodePair, Double> comparisonMatrix;
	
}
