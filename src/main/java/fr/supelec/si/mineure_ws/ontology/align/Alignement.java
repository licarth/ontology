package fr.supelec.si.mineure_ws.ontology.align;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;

import org.apache.commons.collections15.Transformer;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;

public class Alignement {
	
	public OntModel ont1;
	public OntModel ont2;

	public HashMap<SingleEqualsPair<OntClass>, Double> alignment = new HashMap<>();
	
	
	public class EdgeWrapper{
		Double value;
		SingleEqualsPair<OntClass> pair;
		
		public EdgeWrapper(Double value, SingleEqualsPair<OntClass> pair) {
			super();
			this.value = value;
			this.pair = pair;
		}
		
		@Override
		public String toString() {
			return value.toString();
		}
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		ArrayList<SingleEqualsPair<OntClass>> list = new ArrayList<SingleEqualsPair<OntClass>>(alignment.keySet());
		
		Collections.sort(list, new Comparator<SingleEqualsPair<OntClass>>() {
		@Override
		public int compare(SingleEqualsPair<OntClass> o1,
				SingleEqualsPair<OntClass> o2) {
			return (int) Math.signum(alignment.get(o2) - alignment.get(o1));
		}
		
		});
		
		for (SingleEqualsPair<OntClass> pair : list) {
			sb.append(pair.getLeft().getLocalName() + " -- " + pair.getRight().getLocalName() + " : "+alignment.get(pair)+"\n");
		}
		return sb.toString();
	}
	
	public void print() {
		
		Graph<OntClass, EdgeWrapper> g = new DirectedSparseGraph<>();

		List<OntClass> classes1 = ont1.listClasses().toList();

		for (OntClass ontClass : classes1) {
			g.addVertex(ontClass);
		}
		
//		List<OntClass> classes2 = ont2.listClasses().toList();
//
//		for (OntClass ontClass : classes2) {
//			g.addVertex(ontClass);
//		}
//
//		for (SingleEqualsPair<OntClass> pair : alignment.keySet()) {
//			g.addEdge(new EdgeWrapper(alignment.get(pair), pair), pair.getLeft(), pair.getRight());
//		}
		
		//			for (OntClass ontClass : classes) {
		//				
		//			}

		// The Layout<V, E> is parameterized by the vertex and edge types
		Layout<OntClass, EdgeWrapper> layout = new CircleLayout<>(g);
		layout.setSize(new Dimension(300,300)); // sets the initial size of the space
		// The BasicVisualizationServer<V,E> is parameterized by the edge types
		BasicVisualizationServer<OntClass, EdgeWrapper> vv = 
				new BasicVisualizationServer<OntClass,EdgeWrapper>(layout);
		
		vv.getRenderContext().setVertexLabelTransformer(new Transformer<OntClass, String>() {

			@Override
			public String transform(OntClass ontClass) {
				return ontClass.getLabel("");
			}
		});

		vv.getRenderContext().setEdgeLabelTransformer(new Transformer<EdgeWrapper, String>() {

			@Override
			public String transform(EdgeWrapper arg0) {
				return arg0.value.toString();
			}
		});
		//			 vv.getRenderContext().setEdge

		vv.setPreferredSize(new Dimension(1000,100)); //Sets the viewing area size

		JFrame frame = new JFrame("Simple Graph View");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(vv); 
		frame.pack();
		frame.setVisible(true); 
		
	}
	
}
