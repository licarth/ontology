package fr.supelec.si.mineure_ws.ontology;

import java.io.IOException;

import org.junit.Test;

public class OntologyComparisonTest {

	@Test
	public void test() throws IOException {
		OntologyComparator comparator = OntologyComparator.Builder.buildFromRDFFiles("resources/example.owl", "resources/example.owl");
		comparator.stringBasedCompare(StringComparisonMethod.HAMMING).printCsv();
	}
}
