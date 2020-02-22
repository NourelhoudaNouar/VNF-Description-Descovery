package visundGUI;

import java.io.File;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.Node;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;

import VikingMan.vikingM;

public class Login {

	String uname;
	String upswd;
	String urole;
	int Id;
	// vikingM vm=new vikingM();
	boolean cn = false;
	public OWLOntology viking;
	public OWLDataFactory df;
	public OWLOntologyManager manager;
	public IRI vikingIRI;
	public OWLReasonerFactory reasonerFactory;
	public OWLReasoner reasoner;

	public Login(String name, String pswd, String role, int id) throws OWLOntologyCreationException {
		super();
		this.uname = name;
		this.upswd = pswd;
		urole = role;
		Id = id;
		manager = OWLManager.createOWLOntologyManager();
		viking = manager.loadOntologyFromOntologyDocument(new File("C:\\Users\\adminnennouar\\Downloads\\DevPro.rdf"));
		//vikingIRI = IRI.create("http://www.semanticweb.org/pc/ontologies/2018/3/VIKING");
		//RI iri = IRI.create("https://w3id.org/laas-iot/viking");
		//viking= manager.loadOntologyFromOntologyDocument(iri );
		df = manager.getOWLDataFactory();
		reasonerFactory = new StructuralReasonerFactory();
		reasoner = reasonerFactory.createReasoner(viking);

		OWLClass personcls = manager.getOWLDataFactory()
				.getOWLClass(IRI.create("http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#Person"));
		OWLIndividual prsind = manager.getOWLDataFactory()
				.getOWLNamedIndividual(IRI.create("http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#" + name));

		System.out.println("the user name is : " + uname + "\n" + " its password is : " + upswd + "\n"
				+ "  and its role is: " + urole);

		NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(personcls, true);

		for (OWLNamedIndividual i : instances.getFlattened()) {

			if (i.getIRI().getFragment().equals(name)) {
				System.out.println("ind " + i.getIRI().getFragment());

				Set<OWLLiteral> dppsw = i
						.getDataPropertyValues(
								manager.getOWLDataFactory()
										.getOWLDataProperty(IRI.create(
												"http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#has_password")),
								viking);
				Set<OWLLiteral> dprole = i.getDataPropertyValues(manager.getOWLDataFactory().getOWLDataProperty(
						IRI.create("http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#has_role")), viking);
				Set<OWLLiteral> dpemail = i.getDataPropertyValues(
						manager.getOWLDataFactory().getOWLDataProperty(
								IRI.create("http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#has_email")),
						viking);

				for (OWLLiteral dpemail1 : dpemail) {
					System.out.println("email :" + dpemail1.getLiteral());
					for (OWLLiteral dppsw1 : dppsw) {

						System.out.println("pass :" + dppsw1.getLiteral());
						for (OWLLiteral dprole1 : dprole) {
							System.out.println("role :" + dprole1.getLiteral());

							if (dppsw1.getLiteral().equals(upswd) & dprole1.getLiteral().equals(urole)) {
								cn = true;

								System.out.println("the name and psw are  correct");
								if (urole.equals("Provider")) {
									System.out.println("it's provider");
									ProviderSpace ps = new ProviderSpace(name, dpemail1.getLiteral());
									ps.setVisible(true);
									// ps.main(null);
									

								} else if (urole.equals("Developer")) {
									DeveloperSpace ds = new DeveloperSpace(name, dpemail1.getLiteral());

									ds.setVisible(true);
									// ds.main(null);
								}

							} else {
								System.out.println("the name or role are not correct");
							}
						}
					}

				}
			}

		}

	}
}
