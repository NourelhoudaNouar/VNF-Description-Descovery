package test;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.plaf.metal.MetalFileChooserUI.FilterComboBoxRenderer;

import org.apache.commons.lang3.tuple.Triple;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.shared.PrefixMapping;
import org.apache.jena.sparql.syntax.ElementTriplesBlock;
import org.apache.jena.sparql.syntax.ElementUnion;
import org.apache.jena.util.FileManager;
import org.w3c.dom.Node;

public class testqueryy {
String finalquery;
java.util.List<QuerySolution> vnf;
ArrayList<String> VNFConadidates=new ArrayList<>();
	public testqueryy(String finalquery) {
		this.finalquery=finalquery;
		// TODO Auto-generated method stub
				/*
				 * Model model = FileManager.get().loadModel(
				 * "C:\\Users\\adminnennouar\\Downloads\\Viking_new_version.rdf"); String
				 * queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
				 * "PREFIX owl: <http://www.w3.org/2002/07/owl#>" +
				 * "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
				 * "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
				 * "PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#>" +
				 * "SELECT ?s ?p  WHERE { ?s a viking:VNF; viking:has_version ?p } ";
				 * 
				 * Query query = QueryFactory.create(queryString) ; QueryExecution
				 * qexec=QueryExecutionFactory.create(query, model); try { ResultSet results =
				 * qexec.execSelect() ;
				 * 
				 * for ( ; results.hasNext() ; ) { QuerySolution soln = results.nextSolution() ;
				 * System.out.print(ResultSetFormatter.asText(results) ); } } finally {
				 * qexec.close(); };
				 */
				/*
				 * String
				 * filename="C:\\Users\\adminnennouar\\Downloads\\Viking_new_version.owl";
				 * //Model model=ModelFactory.createDefaultModel(); OntModel
				 * model=ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM); File
				 * file=new File(filename); FileReader reader=new FileReader(file);
				 * model.read(reader,null);
				 */

				Model model = FileManager.get().loadModel("C:\\Users\\adminnennouar\\Downloads\\Viking_new_version.rdf");
				/*
				 * String
				 * queryString="PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n" +
				 * 
				 * "PREFIX : <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#>\r\n" +
				 * 
				 * "SELECT DISTINCT ?s ?p  WHERE { ?s :implements ?Transsizing, ?Transcoding, ?Transmuxing . }"
				 * ;
				 */

				/*String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n" +

						"PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#>\r\n" +

						//"ASK  WHERE { ?Tr_vnftesttranscoder2 :implements <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#Transcoding>.}";
						"SELECT DISTINCT ?s  WHERE { ?s viking:implements <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#Transsizing>, <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#Transcoding>, <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#Transmuxing> . }";
				*/
				Query query = QueryFactory.create(finalquery);
				QueryExecution qe = QueryExecutionFactory.create(query, model);
				// ResultSet results=qe.execSelect();
			
				  ResultSet results=qe.execSelect();
				 // ResultSetFormatter.out(System.out,results,query);
				
				  java.util.List<String> vars=results.getResultVars();
					
					PrefixMapping pm=query.getPrefixMapping();
					
					while (results.hasNext()) {
						QuerySolution querySolution =  results.nextSolution();
						for (int i = 0; i < vars.size(); i++) {
							String var=vars.get(i).toString();
							RDFNode node=querySolution.get(var);
							String text="";
							if (node.isURIResource()) {
								text=pm.shortForm(node.asNode().getURI());
								
							}else {
								text= node.toString();
								
							}
							//System.out.println("the result from list is "+text.substring(7));
							VNFConadidates.add(text.substring(7));

						}
						
					}
				
				
				
				
				
					//QuerySolution querySolution = (QuerySolution) results.next();
					
				  /*vnf=ResultSetFormatter.toList(results);
				 
				  
				for (int i = 0; i < vnf.size(); i++) {
					System.out.println("the result from list is "+vnf.get(i));

				}
				  
				/*  while (results.hasNext()) {
					  vnf=results.getResultVars();
				}
				  for (int i = 0; i < vnf.size(); i++) {
					System.out.println("the result from list is "+vnf.get(i));
				}*/
				 
				 
				
				/*boolean res = qe.execAsk();
				System.out.println("The result is " + res);*/
	}
	
}
