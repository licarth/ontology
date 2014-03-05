package fr.supelec.si.mineure_ws.ontology;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class OntologyComparisonTest {

	@Test
	public void stringComparisions() throws IOException {
		String prefix = "amazon<-->bookstore";
		OntologyComparator comparator = OntologyComparator.Builder.buildFromRDFFiles("resources/amazon.owl", "resources/bookstore.owl");
		comparator.stringBasedCompare(StringComparisonMethod.HAMMING).printCsv(prefix+"-"+"hamming");
		comparator.stringBasedCompare(StringComparisonMethod.RITA).printCsv(prefix+"-"+"rita");
		comparator.stringBasedCompare(StringComparisonMethod.SUBSTRING).printCsv(prefix+"-"+"substring");
		comparator.stringBasedCompare(StringComparisonMethod.SYNONYMS).printCsv(prefix+"-"+"synonyms");
	}
	
	@Test
	public void align() throws Exception {
		String prefix = "amazon<-->bookstore";
		OntologyComparator comparator = OntologyComparator.Builder.buildFromRDFFiles("resources/amazon.owl", "resources/bookstore.owl");
		comparator.stringBasedCompare(StringComparisonMethod.HAMMING).printCsv(prefix+"-"+"hamming");
		
		
		
	}
	
	
}
