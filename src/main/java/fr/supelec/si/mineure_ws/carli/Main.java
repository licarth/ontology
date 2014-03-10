package fr.supelec.si.mineure_ws.carli;
import java.awt.Dimension;
import java.io.InputStream;
import java.util.List;

import javax.swing.JFrame;

import org.apache.commons.collections15.Transformer;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;

import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.SpringLayout2;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;


public class Main {
	private static void simpack() {
		// TODO Auto-generated method stub

	}
	public static void main(String[] args) {
//		simpack();
		jena();
		
	}

	private static void jena() {

		try {

			String inputFileName = "resources/amazon.owl";

			//create the reasoning model using the base
			OntModel inf = ModelFactory.createOntologyModel();
			// use the FileManager to find the input file
			InputStream in = FileManager.get().open(inputFileName);
			if (in == null) {
				throw new IllegalArgumentException("File: " + inputFileName + " not found");
			}
			inf.read(in, "");

			//			inf.read("http://www.imdb.com/title/tt0111161/?ref_=chttp_tt_1");
			//						String URI = "http://www.semanticweb.org/ontologies/2012/0/SBIRS.owl";

			//			ExtendedIterator classes = inf.listClasses();
			//			
			//			while (classes.hasNext()) {
			//				OntClass obj = (OntClass) classes.next();
			//
			//				String className = obj.getLocalName().toString();
			//				if (obj.hasSubClass()) {
			//					for (Iterator i = obj.listSubClasses(true); i.hasNext();) {
			//						OntClass c = (OntClass) i.next();
			//						System.out.println(c.getLocalName().toString() +":"+className+c.getSubClass().getComment(""));     
			//					}
			//				}
			//			}

			Graph<OntClass, String> g = new DirectedSparseGraph<>();

			List<OntClass> classes = inf.listClasses().toList();

			for (OntClass ontClass : classes) {
				g.addVertex(ontClass);
				for (OntClass subClass : ontClass.listSubClasses().toList()) {
					g.addEdge("subClassOf"+subClass+"-"+ontClass, subClass, ontClass);
				}
			}

			//			for (OntClass ontClass : classes) {
			//				
			//			}

			// The Layout<V, E> is parameterized by the vertex and edge types
			Layout<OntClass, String> layout = new SpringLayout2<>(g);
			layout.setSize(new Dimension(300,300)); // sets the initial size of the space
			// The BasicVisualizationServer<V,E> is parameterized by the edge types
			BasicVisualizationServer<OntClass,String> vv = 
					new BasicVisualizationServer<OntClass,String>(layout);
			vv.getRenderContext().setVertexLabelTransformer(new Transformer<OntClass, String>() {

				@Override
				public String transform(OntClass ontClass) {
					return ontClass.getLocalName();
				}
			});

			//			 vv.getRenderContext().setEdge

			vv.setPreferredSize(new Dimension(700,700)); //Sets the viewing area size

			JFrame frame = new JFrame("Simple Graph View");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(vv); 
			frame.pack();
			frame.setVisible(true); 




			//			Graph<RDFNode, Statement> g = new JenaJungGraph(inf);
			//			
			//			Layout<RDFNode, Statement> layout = new FRLayout(g);
			//			layout.setSize(new Dimension(600, 600));
			//			BasicVisualizationServer<RDFNode, Statement> viz =
			//					new BasicVisualizationServer<RDFNode, Statement>(layout);
			//			RenderContext context = viz.getRenderContext();
			//			context.setEdgeLabelTransformer(Transformers.EDGE); // property label
			//			context.setVertexLabelTransformer(Transformers.NODE); // node label
			//			viz.setPreferredSize(new Dimension(1000, 1000));
			//			JFrame frame = new JFrame("Jena Graph");
			//			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//			frame.getContentPane().add(viz);
			//			frame.pack();
			//			frame.setVisible(true);


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}





}
