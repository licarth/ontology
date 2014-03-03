package fr.supelec.si.mineure_ws.ontology;

import org.junit.Test;

public class OntologyComparisonTests {

	@Test
	public void test() {
		OntologyComparator comparator = OntologyComparator.Builder.buildFromRDFFiles("resources/example.owl", "resources/example.owl");
		comparator.stringBasedCompare(StringComparisonMethod.SUBSTRING).print();
		
	}
}
