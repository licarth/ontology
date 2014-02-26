package fr.supelec.si.mineure_ws.ontology;

import java.util.HashMap;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;

import edu.uci.ics.jung.graph.util.Pair;

public class StringBasedComparisonResult {
	public StringBasedComparisonResult(OntModel ontology1, OntModel ontology2) {
		this.ontology1 = ontology1;
		this.ontology2 = ontology2;
	}

	private OntModel ontology1;
	private OntModel ontology2;

	public HashMap<Pair<OntClass>, Double> comparisonMatrix = new HashMap<>();

	public void print() {
		for (OntClass class1 : ontology1.listClasses().toList()) {
			for (OntClass class2 : ontology2.listClasses().toList()) {
				System.out.println(class1.getLocalName()+", "+ class2.getLocalName()+" : "+comparisonMatrix.get(new Pair<>(class1, class2)).toString());
			}
		}
	}




}
