package fr.supelec.si.mineure_ws.ontology;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

import edu.uci.ics.jung.graph.util.Pair;
import fr.supelec.si.mineure_ws.ontology.align.Alignement;
import fr.supelec.si.mineure_ws.ontology.align.SingleEqualsPair;

/**
 * 
 * A general class to compare two ontologies.
 * This class has methods that 
 * 
 * @author thomas
 *
 */
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

	public OntModel ontology1;
	public OntModel ontology2;

	public ComparisonResult result;

	public ComparisonResult stringBasedCompare(StringComparisonMethod method) {

		ComparisonResult res = new ComparisonResult(ontology1, ontology2);

		ExtendedIterator<OntClass> classes1It = ontology1.listClasses();
		while (classes1It.hasNext()) {
			OntClass class1 = classes1It.next();
			ExtendedIterator<OntClass> classes2It = ontology2.listClasses();

			while (classes2It.hasNext()) {
				OntClass class2 = classes2It.next();
				if (class1.getLocalName() != null && class2.getLocalName() != null){
					double similarity = method.getComparisonStrategy().getSimilarity(class1.getLocalName(), class2.getLocalName());
					res.similarityMatrix.put(new Pair(class1, class2), similarity);
				}
			}
		}
		result = res;
		return res;
	}


	public Alignement align() {
		//Alignement greedy algorithm.
		//Get 2 lists of concepts.

		HashMap<Pair<OntClass>, Double> similarityCopy = new HashMap<>(result.similarityMatrix);

		Alignement align = new Alignement();
		align.ont1 = ontology1;
		align.ont2 = ontology2;

		Pair<OntClass> maxPair = getMaxPairInHashmap(similarityCopy);

		while (maxPair != null) {
			align.alignment.put(new SingleEqualsPair<OntClass>(maxPair.getFirst(), maxPair.getSecond()), similarityCopy.get(maxPair));
			//Remove all entries that have class1 or class2.
			System.out.println(maxPair.getFirst().getLocalName() + " -- " + maxPair.getSecond().getLocalName() + " : "+similarityCopy.get(maxPair));
			removeAllEntries(maxPair, similarityCopy);
			maxPair = getMaxPairInHashmap(similarityCopy);
		}
		return align;
	}

	private void removeAllEntries(Pair<OntClass> maxPair,
			HashMap<Pair<OntClass>, Double> similarityMatrix) {
		Collection<Pair<OntClass>> toRemove = new ArrayList<Pair<OntClass>>();
		for (Pair<OntClass> pair : similarityMatrix.keySet()) {
			if (maxPair.contains(pair.getFirst()) || maxPair.contains(pair.getSecond())){
				toRemove.add(pair);
			}
		}
		
		for (Pair<OntClass> pair : toRemove) {
			similarityMatrix.remove(pair);
		}
	}


	private Pair<OntClass> getMaxPairInHashmap(HashMap<Pair<OntClass>, Double> hm) {
		Pair<OntClass> maxPair = null;
		double maxValue = -1.0;
		for (Pair<OntClass> pair : hm.keySet()) {
			if (hm.get(pair) != null && hm.get(pair) > maxValue) {
				maxPair = pair;
				maxValue = hm.get(pair);
			}
		}
		return maxPair;
	}

}