package fr.supelec.si.mineure_ws.ontology;

import java.io.InputStream;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;

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
		method.getComparisonStrategy()
	}
	

	
}
