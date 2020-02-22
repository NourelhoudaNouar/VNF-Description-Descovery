package VikingMan;

import java.io.File;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLXMLOntologyFormat;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;

public class vikingM {
	
	public OWLOntology viking;
	public OWLDataFactory df;
	public OWLOntologyManager manager;
	public IRI vikingIRI;
	public OWLReasonerFactory reasonerFactory;
	public OWLReasoner reasoner;
	
	
	public void VikingM() throws OWLOntologyCreationException {
		manager = OWLManager.createOWLOntologyManager();
		//loadviking=manager.loadOntologyFromOntologyDocument(new File("C:\\Users\\PC\\Downloads\\Viking_v_impl.owl"));
		vikingIRI= IRI.create("http://www.semanticweb.org/pc/ontologies/2018/3/VIKING");
		viking=manager.loadOntologyFromOntologyDocument(new File("C:\\Users\\adminnennouar\\Downloads\\Viking_new_version.owl"));
		df = manager.getOWLDataFactory();
		reasonerFactory = new StructuralReasonerFactory();	
		reasoner = reasonerFactory.createReasoner(viking);
		
	}
	public OWLOntology LoadViking() throws OWLOntologyCreationException {
		return manager.loadOntologyFromOntologyDocument(new File("C:\\Users\\adminnennouar\\Downloads\\Viking_new_version.owl"));
	}
	
	/*----------------------------------*/

	public void SaveViking(File Fileout) throws OWLOntologyStorageException {
		OWLXMLOntologyFormat owlxmlFormat = new OWLXMLOntologyFormat();
		manager.saveOntology(viking, owlxmlFormat, IRI.create(Fileout.toURI()));
		
	}
	/*----------------------------------*/
	public void RemoveViking() {
		manager.removeOntology(viking);
	}
	public IRI vikingIRI() {
		return vikingIRI= IRI.create("http://www.semanticweb.org/pc/ontologies/2018/3/VIKING");
		
	}

}
