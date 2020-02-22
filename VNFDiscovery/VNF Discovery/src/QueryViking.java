
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;
import org.apache.jena.util.Locator;


public class QueryViking {
	
	
	public void Look4Transcoder() {
		
		/*FileManager.get().addLocator((Locator) QueryViking.class.getClassLoader());
		Model model=FileManager.get().loadModel("C:\\Users\\adminnennouar\\Downloads\\Viking_new_version.rdf");
		String queryString=" PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
				"select ?s  where {?s rdf:type  <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#Vcompressor>.";
		Query query=QueryFactory.create(queryString);
		QueryExecution qexec=QueryExecutionFactory.create(query);
		
		ResultSet results= qexec.execSelect();
		while (results.hasNext()) {
			QuerySolution querySolution = results.nextSolution();
			Literal name=querySolution.getLiteral("s");
			
			
		}*/
		Model model = FileManager.get().loadModel("C:\\Users\\adminnennouar\\Downloads\\Viking_new_version.owl");
		String queryString = "PREFIX m: <http://exemple.fr/mv#> " +
				"SELECT ?VNF ?Vtranscoder\r\n" + 
				"	WHERE {?VNF viking:is_Vnf_TypeOf ?Vtranscoder. }";
		Query query = QueryFactory.create(queryString) ;
		QueryExecution qexec=QueryExecutionFactory.create(query, model);
		try {
			ResultSet results = qexec.execSelect() ;
		
			for ( ; results.hasNext() ; ) {
			QuerySolution soln = results.nextSolution() ;
			Literal nom = soln.getLiteral("VNF") ;
			System.out.print(nom.toString());
					}
		} finally { qexec.close(); };
	}
	
	

}
