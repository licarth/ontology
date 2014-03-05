package fr.supelec.si.mineure_ws.ontology;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;

import edu.uci.ics.jung.graph.util.Pair;
import fr.supelec.si.mineure_ws.ontology.align.AlignmentFactory;

public class ComparisonResult {
	public ComparisonResult(OntModel ontology1, OntModel ontology2) {
		this.ontology1 = ontology1;
		this.ontology2 = ontology2;
	}

	private OntModel ontology1;
	private OntModel ontology2;

	public HashMap<Pair<OntClass>, Double> similarityMatrix = new HashMap<>();

	@Deprecated
	public void printOld() {
		for (OntClass class1 : ontology1.listClasses().toList()) {
			for (OntClass class2 : ontology2.listClasses().toList()) {
				System.out.println(class1.getLocalName()+", "+ class2.getLocalName()+" : "+similarityMatrix.get(new Pair<>(class1, class2)).toString());
			} 
		}
	}

	public void printCsv(String fileTitle) throws IOException{
		FileWriter outputFile = new FileWriter(String.format("output/"+fileTitle+".csv", "1", "2"));

		//Print col headers:
		StringBuffer sb = new StringBuffer();
		
		sb.append("");
		for (OntClass class2 : ontology2.listClasses().toList()) {
			sb.append(", "+class2.getLocalName());
		}
		sb.append("\n");
		
		for (OntClass class1 : ontology1.listClasses().toList()) {
			sb.append(class1.getLocalName());
			for (OntClass class2 : ontology2.listClasses().toList()) {
				Pair<OntClass> pair = new Pair<>(class1, class2);
				sb.append(", ");
				if (similarityMatrix.containsKey(pair)){
					sb.append(String.format(Locale.US, "%.2f", similarityMatrix.get(pair).doubleValue()));
				}
			}
			sb.append("\n");
		}
		
		outputFile.append(sb.toString());
		outputFile.close();
	}

	public AlignmentFactory generateAlignment() {
		
		//Apply filtering
		
		
		
		return null;
	}
	
}
