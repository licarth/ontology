package fr.supelec.si.mineure_ws.ontology;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.junit.Ignore;
import org.junit.Test;
import org.semanticweb.owl.align.Alignment;
import org.semanticweb.owl.align.AlignmentProcess;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.sparql.pfunction.library.alt;

import fr.inrialpes.exmo.align.impl.method.StringDistAlignment;
import fr.supelec.si.mineure_ws.ontology.align.Alignement;

public class OntologyComparisonTest {

	@Test
	@Ignore
	public void stringComparisions() throws IOException {
		String prefix = "amazon<-->bookstore";
		OntologyComparator comparator = OntologyComparator.Builder.buildFromRDFFiles("resources/amazon.owl", "resources/bookstore.owl");
		comparator.stringBasedCompare(StringComparisonMethod.HAMMING).printCsv(prefix+"-"+"hamming");
		comparator.stringBasedCompare(StringComparisonMethod.RITA).printCsv(prefix+"-"+"rita");
		comparator.stringBasedCompare(StringComparisonMethod.SUBSTRING).printCsv(prefix+"-"+"substring");
		comparator.stringBasedCompare(StringComparisonMethod.SYNONYMS).printCsv(prefix+"-"+"synonyms");
	}
	
	@Test
//	@Ignore
	public void align() throws Exception {
		
		for (StringComparisonMethod method : StringComparisonMethod.values()) {
			
		String prefix = "amazon<-->bookstore";
		OntologyComparator comparator = OntologyComparator.Builder.buildFromRDFFiles("resources/amazon.owl", "resources/bookstore.owl");
		comparator.stringBasedCompare(method).printCsv(prefix+"-"+"hamming");
		Alignement al = comparator.align();
		FileWriter fw = new FileWriter("output/alignment-"+method.name()+".txt");
		fw.append(al.toString());
		fw.flush();
		fw.close();
//		System.out.println(al);
		System.out.println();
		}
//		al.print();
	}
	
	@Test
	@Ignore
	public void test2() throws Exception {
		OntologyComparator comparator = OntologyComparator.Builder.buildFromRDFFiles("resources/amazon.owl", "resources/bookstore.owl");
		
//		OntModel ontology1 = comparator.ontology1;
//		OntModel ontology2 = comparator.ontology2;		
//		Properties params = new Properties();
//		// Run two different alignment methods (e.g., ngram distance and smoa)
//		AlignmentProcess a1 = new StringDistAlignment();
//		params.setProperty("stringFunction","smoaDistance");
//		a1.init ( ontology1, ontology2 );
//		a1.align( (Alignement)null, params );
//		AlignmentProcess a2 = new StringDistAlignment();
//		a2.init ( ontology1, ontology2 );
//		params = new Properties();
//		params.setProperty("stringFunction","ngramDistance");
//		a2.align( (Alignement)null, params );
		
		
		
	}
	
	
}
