package fr.supelec.si.mineure_ws.ontology;

import java.io.InputStream;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

import edu.uci.ics.jung.graph.util.Pair;

public class OntologyComparator {

	static public class Builder {
		static OntologyComparator buildFromRDFFiles(String path1, String path2) {
			OntologyComparator comp = new OntologyComparator();
			comp.ontology1 = buildOntologyModelFromFile(path1);
			comp.ontology2 = buildOntologyModelFromFile(path2);

			return comp;
		}

		private static OntModel buildOntologyModelFromFile(String path) {
			OntModel model = ModelFactory.createOntologyModel();
			InputStream in = FileManager.get().open(path);
			if (in == null) {
				throw new IllegalArgumentException("File: " + path + " not found");
			}
			model.read(in, "");
			return model;
		}
	}

	private OntModel ontology1;
	private OntModel ontology2;

	public StringBasedComparisonResult stringBasedCompare(StringComparisonMethod method) {

		StringBasedComparisonResult res = new StringBasedComparisonResult(ontology1, ontology2);
	
		ExtendedIterator<OntClass> classes1It = ontology1.listClasses();
		while (classes1It.hasNext()) {
			OntClass class1 = classes1It.next();
			ExtendedIterator<OntClass> classes2It = ontology2.listClasses();

			while (classes2It.hasNext()) {
				OntClass class2 = classes2It.next();
				double similarity = method.getComparisonStrategy().getSimilarity(class1.getLocalName(), class2.getLocalName());
				res.comparisonMatrix.put(new Pair(class1, class2), similarity);
			}
		}
		return res;
	}
	
}