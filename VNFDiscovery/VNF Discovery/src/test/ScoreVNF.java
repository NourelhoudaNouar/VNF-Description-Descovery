package test;

import java.util.ArrayList;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.shared.PrefixMapping;
import org.apache.jena.util.FileManager;

public class ScoreVNF {
ArrayList<String> VNFConadidates=new ArrayList<>();

	public ArrayList<String> getVNFCondidates(String finalquery) {
		Model model = FileManager.get().loadModel("C:\\Users\\adminnennouar\\Downloads\\Viking_new_version.rdf");
		Query query = QueryFactory.create(finalquery);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet results = qe.execSelect();
		java.util.List<String> vars = results.getResultVars();

		PrefixMapping pm = query.getPrefixMapping();

		while (results.hasNext()) {
			QuerySolution querySolution = results.nextSolution();
			for (int i = 0; i < vars.size(); i++) {
				String var = vars.get(i).toString();
				RDFNode node = querySolution.get(var);
				String text = "";
				if (node.isURIResource()) {
					text = pm.shortForm(node.asNode().getURI());

				} else {
					text = node.toString();

				}
				// System.out.println("the result from list is "+text.substring(7));
				VNFConadidates.add(text.substring(7));

			}

		}
		return VNFConadidates;

	}
	
	public void ScoreVNFCondidate(ArrayList<String> VNFConadidates) {
		
		for (int i = 0; i < VNFConadidates.size(); i++) {
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
	}
	
}
