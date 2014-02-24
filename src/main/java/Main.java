import java.io.InputStream;
import java.util.Iterator;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;


public class Main {
	public static void main(String[] args) {
		try {

			String inputFileName = "resources/example.owl";
			
			//create the reasoning model using the base
			OntModel inf = ModelFactory.createOntologyModel();
			// use the FileManager to find the input file
			InputStream in = FileManager.get().open(inputFileName);
			if (in == null) {
				throw new IllegalArgumentException("File: " + inputFileName + " not found");
			}
			inf.read(in, "");

//			String URI = "http://www.semanticweb.org/ontologies/2012/0/SBIRS.owl";

			ExtendedIterator classes = inf.listClasses();
			while (classes.hasNext()) {
				OntClass obj = (OntClass) classes.next();

				String className = obj.getLocalName().toString();
				if (obj.hasSubClass()) {
					for (Iterator i = obj.listSubClasses(true); i.hasNext();) {
						OntClass c = (OntClass) i.next();
						System.out.println(c.getLocalName().toString() +":"+className+c.getSubClass().getComment(""));     
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


	}
}
