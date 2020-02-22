package VikingMan;

import java.io.File;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;


public class DeveloperInfo {
	public OWLOntology viking;
	public OWLDataFactory df;
	public OWLOntologyManager manager;
	public IRI vikingIRI;
	public OWLReasonerFactory reasonerFactory;
	public OWLReasoner reasoner;

	public DeveloperInfo() throws OWLOntologyCreationException {
		vikingM vm=new vikingM();
		viking=vm.LoadViking();
		manager = OWLManager.createOWLOntologyManager();
		viking=manager.loadOntologyFromOntologyDocument(new File("C:\\Users\\adminnennouar\\eclipse-workspace\\VNFDescription\\ontology\\Viking_v_impl.owl"));
		vikingIRI= IRI.create("http://www.semanticweb.org/pc/ontologies/2018/3/VIKING");
		df = manager.getOWLDataFactory();
		reasonerFactory = new StructuralReasonerFactory();	
		reasoner = reasonerFactory.createReasoner(viking);
		
		
		
		
		
	}

	public String GetDevinfo() {
		return null;
		
	}
	
	
	
	
}
