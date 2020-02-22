package visundGUI;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

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
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;

public class VikingManip {

	OWLOntology viking;
	OWLDataFactory df;
	OWLOntologyManager manager;
	IRI vikingIRI;
	OWLReasonerFactory reasonerFactory;
	OWLReasoner reasoner;

	public void init() throws OWLOntologyCreationException {
		/*
		 * VikingManip Vmp= new VikingManip();
		 * 
		 * manager = Vmp.manager; viking = Vmp.viking; vikingIRI = Vmp.vikingIRI; df =
		 * Vmp.df; reasonerFactory = Vmp.reasonerFactory; reasoner = Vmp.reasoner;
		 */
		manager = OWLManager.createOWLOntologyManager();
		// loadviking=manager.loadOntologyFromOntologyDocument(new
		// File("C:\\Users\\PC\\Downloads\\Viking_v_impl.owl"));
		vikingIRI = IRI.create("http://www.semanticweb.org/pc/ontologies/2018/3/VIKING");
		IRI iri = IRI.create("https://w3id.org/laas-iot/viking");
		//viking= manager.loadOntologyFromOntologyDocument(iri );
		viking = manager.loadOntologyFromOntologyDocument(
				new File("C:\\Users\\adminnennouar\\Downloads\\DevPro.rdf"));
		df = manager.getOWLDataFactory();
		reasonerFactory = new StructuralReasonerFactory();
		reasoner = reasonerFactory.createReasoner(viking);
	}

	public void setVnfIndividual(String vnfnm,String provider) throws OWLOntologyStorageException {

		OWLClass VNFcls = manager.getOWLDataFactory()
				.getOWLClass(IRI.create("http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#VNF"));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + vnfnm));
		OWLClassAssertionAxiom classAssertion = df.getOWLClassAssertionAxiom(VNFcls, vnfind);
		manager.addAxiom(viking, classAssertion);
		
		OWLDataProperty prv = df.getOWLDataProperty(IRI.create(vikingIRI + "#" + "has_provider"));
		OWLDataPropertyAssertionAxiom Axiom = df.getOWLDataPropertyAssertionAxiom(prv, vnfind, provider);
		manager.addAxiom(viking, Axiom);
		
		OWLDataProperty validation = df.getOWLDataProperty(IRI.create(vikingIRI + "#" + "validated"));
		OWLDataPropertyAssertionAxiom Axiom1 = df.getOWLDataPropertyAssertionAxiom(validation, vnfind, false);
		manager.addAxiom(viking, Axiom1);

		manager.saveOntology(viking);
	}

	public void setVNFdescDataProperty(String vnfnm, String description) throws OWLOntologyStorageException {
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + vnfnm));
		OWLDataProperty vnfdescription = df.getOWLDataProperty(IRI.create(vikingIRI + "#" + "has_VNF_description"));

		OWLDataPropertyAssertionAxiom Axiom = df.getOWLDataPropertyAssertionAxiom(vnfdescription, vnfind, description);

		manager.addAxiom(viking, Axiom);
		manager.saveOntology(viking);
	}

	public void setVNFIDDataProperty(String vnfnm, String ID) throws OWLOntologyStorageException {
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + vnfnm));
		OWLDataProperty vnfID = df.getOWLDataProperty(IRI.create(vikingIRI + "#" + "has_VNF_ID"));

		OWLDataPropertyAssertionAxiom Axiom = df.getOWLDataPropertyAssertionAxiom(vnfID, vnfind, ID);

		manager.addAxiom(viking, Axiom);
		manager.saveOntology(viking);
	}

	public void setVNFVersionDataProperty(String vnfnm, String version) throws OWLOntologyStorageException {
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + vnfnm));
		OWLDataProperty vnfversion = df.getOWLDataProperty(IRI.create(vikingIRI + "#" + "has_version"));

		OWLDataPropertyAssertionAxiom Axiom = df.getOWLDataPropertyAssertionAxiom(vnfversion, vnfind, version);

		manager.addAxiom(viking, Axiom);
		manager.saveOntology(viking);
	}

	public void setVNFvendorDataProperty(String vnfnm, String vendor) throws OWLOntologyStorageException {
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + vnfnm));
		OWLDataProperty vnfvendor = df.getOWLDataProperty(IRI.create(vikingIRI + "#" + "has_vendor"));

		OWLDataPropertyAssertionAxiom Axiom = df.getOWLDataPropertyAssertionAxiom(vnfvendor, vnfind, vendor);

		manager.addAxiom(viking, Axiom);
		manager.saveOntology(viking);
	}

	public void setVNFdateDataProperty(String vnfnm, String releaseddate) throws OWLOntologyStorageException {
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + vnfnm));
		OWLDataProperty vnfdate = df.getOWLDataProperty(IRI.create(vikingIRI + "#" + "has_released_date"));

		OWLDataPropertyAssertionAxiom Axiom = df.getOWLDataPropertyAssertionAxiom(vnfdate, vnfind, releaseddate);

		manager.addAxiom(viking, Axiom);
		manager.saveOntology(viking);
	}

	public void setVnfIndividualTypeTr(String vnfnm) throws OWLOntologyStorageException {

		OWLClass VNFcls = manager.getOWLDataFactory()
				.getOWLClass(IRI.create("http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#Vtranscoder"));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + vnfnm));
		OWLClassAssertionAxiom classAssertion = df.getOWLClassAssertionAxiom(VNFcls, vnfind);
		manager.addAxiom(viking, classAssertion);
		manager.saveOntology(viking);
	}

	public void setVNFistypeoftr(String vnfnm, String tpvnfnm) throws OWLOntologyStorageException {
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + vnfnm));
		OWLObjectProperty vnfistypeof = df.getOWLObjectProperty(IRI.create(vikingIRI + "#is_Vnf_TypeOf"));
		OWLIndividual dvind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + tpvnfnm));
		OWLObjectPropertyAssertionAxiom axiom1 = df.getOWLObjectPropertyAssertionAxiom(vnfistypeof, vnfind, dvind);
		manager.addAxiom(viking, axiom1);
		manager.saveOntology(viking);
	}

	public void setVnfIndividualTypeCp(String vnfnm) throws OWLOntologyStorageException {

		OWLClass VNFcls = manager.getOWLDataFactory()
				.getOWLClass(IRI.create("http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#Vcompressor"));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + vnfnm));
		OWLClassAssertionAxiom classAssertion = df.getOWLClassAssertionAxiom(VNFcls, vnfind);
		manager.addAxiom(viking, classAssertion);
		manager.saveOntology(viking);
	}

	public void setVNFistypeofCp(String vnfnm, String tpvnfnm) throws OWLOntologyStorageException {

		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + vnfnm));
		OWLObjectProperty vnfistypeof = df.getOWLObjectProperty(IRI.create(vikingIRI + "#is_Vnf_TypeOf"));
		OWLIndividual dvind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + tpvnfnm));
		OWLObjectPropertyAssertionAxiom axiom1 = df.getOWLObjectPropertyAssertionAxiom(vnfistypeof, vnfind, dvind);
		manager.addAxiom(viking, axiom1);
		manager.saveOntology(viking);
	}

	public void setVnfIndividualTypeMx(String vnfnm) throws OWLOntologyStorageException {

		OWLClass VNFcls = manager.getOWLDataFactory()
				.getOWLClass(IRI.create("http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#Vmixer"));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + vnfnm));
		OWLClassAssertionAxiom classAssertion = df.getOWLClassAssertionAxiom(VNFcls, vnfind);
		manager.addAxiom(viking, classAssertion);
		manager.saveOntology(viking);
	}

	public void setVNFistypeofmx(String vnfnm, String tpvnfnm) throws OWLOntologyStorageException {
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + vnfnm));
		OWLObjectProperty vnfistypeof = df.getOWLObjectProperty(IRI.create(vikingIRI + "#is_Vnf_TypeOf"));
		OWLIndividual dvind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + tpvnfnm));
		OWLObjectPropertyAssertionAxiom axiom1 = df.getOWLObjectPropertyAssertionAxiom(vnfistypeof, vnfind, dvind);
		manager.addAxiom(viking, axiom1);
		manager.saveOntology(viking);
		///////

	}

	public void setdevloperVnf(String dvname, String vnfnm) throws OWLOntologyStorageException {
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + vnfnm));
		OWLObjectProperty developevnf = df.getOWLObjectProperty(IRI.create(vikingIRI + "#develope"));
		OWLIndividual dvind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + dvname));
		OWLObjectPropertyAssertionAxiom axiom1 = df.getOWLObjectPropertyAssertionAxiom(developevnf, dvind, vnfind);
		manager.addAxiom(viking, axiom1);
		manager.saveOntology(viking);
	}

	public List getTranscoderOp() throws OWLOntologyCreationException {

		init();
		List trascOpArray = new List();

		for (OWLClass c : viking.getClassesInSignature()) {
			if (c.getIRI().getFragment().equals("Transcoding_operation")) {
				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				System.out.println(c.getIRI().getFragment());
				for (OWLNamedIndividual i : instances.getFlattened()) {
					System.out.println(i.getIRI().getFragment());
					trascOpArray.add(i.getIRI().getFragment());

				}
			}
		}

		return trascOpArray;

	}

	
	public List getContent() throws OWLOntologyCreationException {

		init();
		List content = new List();

		for (OWLClass c : viking.getClassesInSignature()) {
			if (c.getIRI().getFragment().equals("Content")) {
				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				System.out.println(c.getIRI().getFragment());
				for (OWLNamedIndividual i : instances.getFlattened()) {
					System.out.println(i.getIRI().getFragment());
					content.add(i.getIRI().getFragment());

				}
			}
		}

		return content;

	}
	public List getTranscoderTech() throws OWLOntologyCreationException {
		init();
		List trascTechArray = new List();

		for (OWLClass c : viking.getClassesInSignature()) {
			if (c.getIRI().getFragment().equals("Transcoding_technique")) {
				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				System.out.println(c.getIRI().getFragment());
				for (OWLNamedIndividual i : instances.getFlattened()) {
					System.out.println(i.getIRI().getFragment());
					trascTechArray.add(i.getIRI().getFragment());

				}
			}
		}
		return trascTechArray;

	}

	public List getTranscoderStand() throws OWLOntologyCreationException {
		init();
		List trascStandArray = new List();

		for (OWLClass c : viking.getClassesInSignature()) {
			if (c.getIRI().getFragment().equals("Transcoding_standard")) {
				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				System.out.println(c.getIRI().getFragment());
				for (OWLNamedIndividual i : instances.getFlattened()) {
					System.out.println(i.getIRI().getFragment());
					trascStandArray.add(i.getIRI().getFragment());

				}
			}
		}
		return trascStandArray;

	}

	public void setTranscoderOp(String VNFname, String indv) throws OWLOntologyStorageException {

		OWLIndividual trOpind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + indv));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfImplementsOp = df.getOWLObjectProperty(IRI.create(vikingIRI + "#implements"));
		OWLObjectPropertyAssertionAxiom vnfImplementsOpAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfImplementsOp,
				vnfind, trOpind);
		manager.addAxiom(viking, vnfImplementsOpAxiom);
		manager.saveOntology(viking);
		// OWLClassAssertionAxiom trOpclassAssertion =
		// df.getOWLClassAssertionAxiom(trOpcls, trOpind);
		// manager.addAxiom(viking, trOpclassAssertion);

	}
	

	public void setTranscoderTech(String VNFname, String indv) throws OWLOntologyStorageException {

		OWLIndividual trTechind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + indv));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfAppliesTech = df.getOWLObjectProperty(IRI.create(vikingIRI + "#applies"));
		OWLObjectPropertyAssertionAxiom vnfAppliesTechAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfAppliesTech,
				vnfind, trTechind);
		manager.addAxiom(viking, vnfAppliesTechAxiom);
		manager.saveOntology(viking);

	}

	public void setTranscoderStand(String VNFname, String indv) throws OWLOntologyStorageException {

		OWLIndividual trStandind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + indv));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfSupportsStand = df.getOWLObjectProperty(IRI.create(vikingIRI + "#supports"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfSupportsStand,
				vnfind, trStandind);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setVideoContent(String VNFname, String video) throws OWLOntologyStorageException {

		OWLIndividual trvideocntind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + video));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequestsVideoCnt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#requests"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df
				.getOWLObjectPropertyAssertionAxiom(vnfRequestsVideoCnt, vnfind, trvideocntind);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrVideoFormatI(String VNFname, String[] trVideoFI) throws OWLOntologyStorageException {
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#requires_VideoFormat"));
		for (String i : trVideoFI) {
			OWLIndividual formatid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + i));
			OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df
					.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt, vnfind, formatid);
			manager.addAxiom(viking, vnfSupportsStandAxiom);
		}

		manager.saveOntology(viking);

	}

	public void setTrVideoResolutionI(String VNFname, String resolution) throws OWLOntologyStorageException {

		OWLIndividual resolutionid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + resolution));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#requires_Videoresolution"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, resolutionid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrVideoCodecI(String VNFname, String codec) throws OWLOntologyStorageException {

		OWLIndividual codecid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + codec));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#requires_VideoCodec"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, codecid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setBitrateind(String bitrate) throws OWLOntologyStorageException {
///////////////////////////////
		OWLClass Bitratecls = manager.getOWLDataFactory()
				.getOWLClass(IRI.create("http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#Bitrate"));
		OWLIndividual bitrateind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + bitrate));
		OWLClassAssertionAxiom classAssertion = df.getOWLClassAssertionAxiom(Bitratecls, bitrateind);
		manager.addAxiom(viking, classAssertion);
		manager.saveOntology(viking);
	}

	public void setTrVideoBitrateI(String VNFname, String bitrate) throws OWLOntologyStorageException {

		/////////
		OWLIndividual bitrateid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + bitrate));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#requires_VideoBitrate"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, bitrateid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrVideoFormatO(String VNFname, String format) throws OWLOntologyStorageException {

		OWLIndividual formatid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + format));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#supplies_VideoFormat"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, formatid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrVideoResolutionO(String VNFname, String resolution) throws OWLOntologyStorageException {

		OWLIndividual resolutionid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + resolution));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#supplies_Videoresolution"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, resolutionid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrVideoCodecO(String VNFname, String codec) throws OWLOntologyStorageException {

		OWLIndividual codecid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + codec));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#supplies_VideoCodec"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, codecid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrVideoBitrateO(String VNFname, String bitrate) throws OWLOntologyStorageException {

		OWLIndividual bitrateid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + bitrate));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#supplies_VideoBitrate"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, bitrateid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTranscoderVideoContentOutput(String VNFname, String videocnt) throws OWLOntologyStorageException {

		OWLIndividual trvideocntind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + videocnt));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfDeliversVideoCnt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#delivers"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df
				.getOWLObjectPropertyAssertionAxiom(vnfDeliversVideoCnt, vnfind, trvideocntind);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setAudioContent(String VNFname) throws OWLOntologyStorageException {

		OWLIndividual traudiocntind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#Audio"));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequestsAudioCnt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#requests"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df
				.getOWLObjectPropertyAssertionAxiom(vnfRequestsAudioCnt, vnfind, traudiocntind);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTranscoderAudioContentOutput(String VNFname, String audiocnt) throws OWLOntologyStorageException {

		OWLIndividual traudiocntind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + audiocnt));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfDeliversAudioCnt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#delivers"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df
				.getOWLObjectPropertyAssertionAxiom(vnfDeliversAudioCnt, vnfind, traudiocntind);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrAudioFormatI(String VNFname, String format) throws OWLOntologyStorageException {

		OWLIndividual formatid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + format));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#requires_AudiFormat"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, formatid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrAudioResolutionI(String VNFname, String resolution) throws OWLOntologyStorageException {

		OWLIndividual resolutionid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + resolution));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#requires_Audioresolution"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, resolutionid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrAudioCodecI(String VNFname, String codec) throws OWLOntologyStorageException {

		OWLIndividual codecid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + codec));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#requires_AudioCodec"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, codecid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrAudioBitrateI(String VNFname, String bitrate) throws OWLOntologyStorageException {

		OWLIndividual bitrateid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + bitrate));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#requires_AudioBitrate"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, bitrateid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrAudioFormatO(String VNFname, String format) throws OWLOntologyStorageException {

		OWLIndividual formatid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + format));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#supplies_AudiFormat"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, formatid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrAudioResolutionO(String VNFname, String resolution) throws OWLOntologyStorageException {

		OWLIndividual resolutionid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + resolution));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#supplies_Audioresolution"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, resolutionid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrAudioCodecO(String VNFname, String codec) throws OWLOntologyStorageException {

		OWLIndividual codecid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + codec));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#supplies_AudioCodec"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, codecid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrAudioBitrateO(String VNFname, String bitrate) throws OWLOntologyStorageException {

		OWLIndividual bitrateid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + bitrate));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#supplies_AudioBitrate"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, bitrateid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setImageContent(String VNFname) throws OWLOntologyStorageException {

		OWLIndividual trimagecntind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#Image"));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequestsImageCnt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#requests"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df
				.getOWLObjectPropertyAssertionAxiom(vnfRequestsImageCnt, vnfind, trimagecntind);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTranscoderImageContentOutput(String VNFname, String imagecnt) throws OWLOntologyStorageException {

		OWLIndividual trimagecntind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + imagecnt));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfDeliversImageCnt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#delivers"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df
				.getOWLObjectPropertyAssertionAxiom(vnfDeliversImageCnt, vnfind, trimagecntind);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrImageFormatI(String VNFname, String format) throws OWLOntologyStorageException {

		OWLIndividual formatid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + format));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#requires_ImageFormat"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, formatid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrImageResolutionI(String VNFname, String resolution) throws OWLOntologyStorageException {

		OWLIndividual resolutionid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + resolution));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#requires_Imageresolution"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, resolutionid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrImageCodecI(String VNFname, String codec) throws OWLOntologyStorageException {

		OWLIndividual codecid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + codec));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#requires_ImageCodec"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, codecid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrImageBitrateI(String VNFname, String bitrate) throws OWLOntologyStorageException {

		OWLIndividual bitrateid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + bitrate));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#requires_ImageBitrate"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, bitrateid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrImageFormatO(String VNFname, String format) throws OWLOntologyStorageException {

		OWLIndividual formatid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + format));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#supplies_ImageFormat"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, formatid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrImageResolutionO(String VNFname, String resolution) throws OWLOntologyStorageException {

		OWLIndividual resolutionid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + resolution));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#supplies_Imageresolution"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, resolutionid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrImageCodecO(String VNFname, String codec) throws OWLOntologyStorageException {

		OWLIndividual codecid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + codec));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#supplies_ImageCodec"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, codecid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTrImageBitrateO(String VNFname, String bitrate) throws OWLOntologyStorageException {

		OWLIndividual bitrateid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + bitrate));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequiresAtt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#supplies_ImageBitrate"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfRequiresAtt,
				vnfind, bitrateid);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	/*
	 * public void setTranscoderVideo(String VNFname, String cnt) throws
	 * OWLOntologyStorageException {
	 * 
	 * OWLIndividual trcntind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#"
	 * + cnt)); OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI
	 * + "#" + VNFname)); OWLObjectProperty vnfRequestsCnt =
	 * df.getOWLObjectProperty(IRI.create(vikingIRI + "#requests"));
	 * OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom =
	 * df.getOWLObjectPropertyAssertionAxiom(vnfSupportsStand, vnfind, trStandind);
	 * manager.addAxiom(viking, vnfSupportsStandAxiom);
	 * manager.saveOntology(viking);
	 * 
	 * }
	 */

	public List getMixOp() throws OWLOntologyCreationException {

		init();
		List MixOpArray = new List();

		for (OWLClass c : viking.getClassesInSignature()) {
			if (c.getIRI().getFragment().equals("Mixing_operation")) {
				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				System.out.println(c.getIRI().getFragment());
				for (OWLNamedIndividual i : instances.getFlattened()) {
					System.out.println(i.getIRI().getFragment());
					MixOpArray.add(i.getIRI().getFragment());

				}
			}
		}

		return MixOpArray;

	}

	public List getMixTech() throws OWLOntologyCreationException {

		init();
		List MixTechArray = new List();

		for (OWLClass c : viking.getClassesInSignature()) {
			if (c.getIRI().getFragment().equals("Mixing_technique")) {
				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				System.out.println(c.getIRI().getFragment());
				for (OWLNamedIndividual i : instances.getFlattened()) {
					System.out.println(i.getIRI().getFragment());
					MixTechArray.add(i.getIRI().getFragment());

				}
			}
		}

		return MixTechArray;

	}

	public void setMixOp(String VNFname, String indv) throws OWLOntologyStorageException {

		OWLIndividual mixOpind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + indv));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfImplementsMixOp = df.getOWLObjectProperty(IRI.create(vikingIRI + "#implements"));
		OWLObjectPropertyAssertionAxiom vnfImplementsMixOpAxiom = df
				.getOWLObjectPropertyAssertionAxiom(vnfImplementsMixOp, vnfind, mixOpind);
		manager.addAxiom(viking, vnfImplementsMixOpAxiom);
		manager.saveOntology(viking);

	}

	public void setMixTech(String VNFname, String indv) throws OWLOntologyStorageException {

		OWLIndividual mixTechind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + indv));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfAppliesMixTech = df.getOWLObjectProperty(IRI.create(vikingIRI + "#applies"));
		OWLObjectPropertyAssertionAxiom vnfAppliesMixTechAxiom = df
				.getOWLObjectPropertyAssertionAxiom(vnfAppliesMixTech, vnfind, mixTechind);
		manager.addAxiom(viking, vnfAppliesMixTechAxiom);
		manager.saveOntology(viking);

	}

	public List getCompOp() throws OWLOntologyCreationException {

		init();
		List CompOpArray = new List();

		for (OWLClass c : viking.getClassesInSignature()) {
			if (c.getIRI().getFragment().equals("Compressing_operation")) {
				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				System.out.println(c.getIRI().getFragment());
				for (OWLNamedIndividual i : instances.getFlattened()) {
					System.out.println(i.getIRI().getFragment());
					CompOpArray.add(i.getIRI().getFragment());

				}
			}
		}

		return CompOpArray;

	}

	public List getCompTech() throws OWLOntologyCreationException {

		init();
		List CompTechArray = new List();

		for (OWLClass c : viking.getClassesInSignature()) {
			if (c.getIRI().getFragment().equals("Compression_technique")) {
				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				System.out.println(c.getIRI().getFragment());
				for (OWLNamedIndividual i : instances.getFlattened()) {
					System.out.println(i.getIRI().getFragment());
					CompTechArray.add(i.getIRI().getFragment());

				}
			}
		}

		return CompTechArray;

	}

	public List getCompStand() throws OWLOntologyCreationException {

		init();
		List CompStandArray = new List();

		for (OWLClass c : viking.getClassesInSignature()) {
			if (c.getIRI().getFragment().equals("Compression_standard")) {
				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				System.out.println(c.getIRI().getFragment());
				for (OWLNamedIndividual i : instances.getFlattened()) {
					System.out.println(i.getIRI().getFragment());
					CompStandArray.add(i.getIRI().getFragment());

				}
			}
		}

		return CompStandArray;

	}

	public void setCpVideoContent(String VNFname, String video) throws OWLOntologyStorageException {

		OWLIndividual trvideocntind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + video));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfRequestsVideoCnt = df.getOWLObjectProperty(IRI.create(vikingIRI + "#requests"));
		OWLObjectPropertyAssertionAxiom vnfSupportsStandAxiom = df
				.getOWLObjectPropertyAssertionAxiom(vnfRequestsVideoCnt, vnfind, trvideocntind);
		manager.addAxiom(viking, vnfSupportsStandAxiom);
		manager.saveOntology(viking);

	}

	public void setCompOp(String VNFname, String indv) throws OWLOntologyStorageException {

		OWLIndividual CompOpind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + indv));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfImplementsCompOp = df.getOWLObjectProperty(IRI.create(vikingIRI + "#implements"));
		OWLObjectPropertyAssertionAxiom vnfImplementsCompOpAxiom = df
				.getOWLObjectPropertyAssertionAxiom(vnfImplementsCompOp, vnfind, CompOpind);
		manager.addAxiom(viking, vnfImplementsCompOpAxiom);
		manager.saveOntology(viking);

	}

	public void setCompTech(String VNFname, String indv) throws OWLOntologyStorageException {

		OWLIndividual CompTechind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + indv));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfAppliesCompTech = df.getOWLObjectProperty(IRI.create(vikingIRI + "#applies"));
		OWLObjectPropertyAssertionAxiom vnfAppliesCompTechAxiom = df
				.getOWLObjectPropertyAssertionAxiom(vnfAppliesCompTech, vnfind, CompTechind);
		manager.addAxiom(viking, vnfAppliesCompTechAxiom);
		manager.saveOntology(viking);

	}

	public void setCompStand(String VNFname, String indv) throws OWLOntologyStorageException {

		OWLIndividual CompStandind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + indv));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfSupportsCompStand = df.getOWLObjectProperty(IRI.create(vikingIRI + "#supports"));
		OWLObjectPropertyAssertionAxiom vnfSupportsCompStandAxiom = df
				.getOWLObjectPropertyAssertionAxiom(vnfSupportsCompStand, vnfind, CompStandind);
		manager.addAxiom(viking, vnfSupportsCompStandAxiom);
		manager.saveOntology(viking);

	}

	public void setCompMaxSizeind(String indv) throws OWLOntologyStorageException {
		OWLClass maxsizecls = manager.getOWLDataFactory()
				.getOWLClass(IRI.create("http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#Size"));
		OWLIndividual maxsizeind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + indv));
		OWLClassAssertionAxiom classAssertion = df.getOWLClassAssertionAxiom(maxsizecls, maxsizeind);
		manager.addAxiom(viking, classAssertion);
		manager.saveOntology(viking);

	}

	public void setCompMaxSize(String VNFname, String indv) throws OWLOntologyStorageException {

		OWLIndividual CompMaxSizeind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + indv));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfrequiresmaxsize = df.getOWLObjectProperty(IRI.create(vikingIRI + "#requires_maxSize"));
		OWLObjectPropertyAssertionAxiom vnfSupportsCompStandAxiom = df
				.getOWLObjectPropertyAssertionAxiom(vnfrequiresmaxsize, vnfind, CompMaxSizeind);
		manager.addAxiom(viking, vnfSupportsCompStandAxiom);
		manager.saveOntology(viking);

	}

	public void setTranscodingContent(String VNFname, String Content) {
		OWLClass TrContentVideoClass = df.getOWLClass(IRI.create(vikingIRI + "#" + "Video"));
		OWLIndividual TrContentVideoind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + Content + VNFname));
		OWLClassAssertionAxiom classAssertion = df.getOWLClassAssertionAxiom(TrContentVideoClass, TrContentVideoind);
		manager.addAxiom(viking, classAssertion);
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));

	}

	public List getVideoFormat() throws OWLOntologyCreationException {
		init();
		List videoFormat = new List();

		for (OWLClass c : viking.getClassesInSignature()) {
			if (c.getIRI().getFragment().equals("Video_format")) {
				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				System.out.println(c.getIRI().getFragment());
				for (OWLNamedIndividual i : instances.getFlattened()) {
					System.out.println(i.getIRI().getFragment());
					videoFormat.add(i.getIRI().getFragment());

				}
			}
		}

		return videoFormat;

	}

	public List getAudioFormat() throws OWLOntologyCreationException {
		init();
		List audioFormat = new List();

		for (OWLClass c : viking.getClassesInSignature()) {
			if (c.getIRI().getFragment().equals("Audio_format")) {
				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				System.out.println(c.getIRI().getFragment());
				for (OWLNamedIndividual i : instances.getFlattened()) {
					System.out.println(i.getIRI().getFragment());
					audioFormat.add(i.getIRI().getFragment());

				}
			}
		}

		return audioFormat;

	}

	public List getImageFormat() throws OWLOntologyCreationException {
		init();
		List imageFormat = new List();

		for (OWLClass c : viking.getClassesInSignature()) {
			if (c.getIRI().getFragment().equals("Image_format")) {
				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				System.out.println(c.getIRI().getFragment());
				for (OWLNamedIndividual i : instances.getFlattened()) {
					System.out.println(i.getIRI().getFragment());
					imageFormat.add(i.getIRI().getFragment());

				}
			}
		}

		return imageFormat;

	}

	public List getResolution() throws OWLOntologyCreationException {
		init();
		List resolution = new List();

		for (OWLClass c : viking.getClassesInSignature()) {
			if (c.getIRI().getFragment().equals("Resolution")) {
				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				System.out.println(c.getIRI().getFragment());
				for (OWLNamedIndividual i : instances.getFlattened()) {
					System.out.println(i.getIRI().getFragment());
					resolution.add(i.getIRI().getFragment().substring(1));

				}
			}
		}

		return resolution;

	}

	public List getVideoCodec() throws OWLOntologyCreationException {
		init();
		List videoCodec = new List();

		for (OWLClass c : viking.getClassesInSignature()) {
			if (c.getIRI().getFragment().equals("Video_codec")) {
				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				System.out.println(c.getIRI().getFragment());
				for (OWLNamedIndividual i : instances.getFlattened()) {
					System.out.println(i.getIRI().getFragment());
					videoCodec.add(i.getIRI().getFragment());

				}
			}
		}

		return videoCodec;

	}

	public List getImageCodec() throws OWLOntologyCreationException {
		init();
		List ImageCodec = new List();

		for (OWLClass c : viking.getClassesInSignature()) {
			if (c.getIRI().getFragment().equals("Image_codec")) {
				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				System.out.println(c.getIRI().getFragment());
				for (OWLNamedIndividual i : instances.getFlattened()) {
					System.out.println(i.getIRI().getFragment());
					ImageCodec.add(i.getIRI().getFragment());

				}
			}
		}

		return ImageCodec;

	}

	public List getAudioCodec() throws OWLOntologyCreationException {
		init();
		List AudioCodec = new List();

		for (OWLClass c : viking.getClassesInSignature()) {
			if (c.getIRI().getFragment().equals("Audio_codec")) {
				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				System.out.println(c.getIRI().getFragment());
				for (OWLNamedIndividual i : instances.getFlattened()) {
					System.out.println(i.getIRI().getFragment());
					AudioCodec.add(i.getIRI().getFragment());

				}
			}
		}

		return AudioCodec;

	}

	public List getdevice() throws OWLOntologyCreationException {
		init();
		List device = new List();

		for (OWLClass c : viking.getClassesInSignature()) {
			if (c.getIRI().getFragment().equals("Device")) {
				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				System.out.println(c.getIRI().getFragment());
				for (OWLNamedIndividual i : instances.getFlattened()) {
					System.out.println(i.getIRI().getFragment());
					device.add(i.getIRI().getFragment());

				}
			}
		}

		return device;

	}

	public void setdevice(String VNFname, String device) throws OWLOntologyStorageException {

		OWLIndividual dvc = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + device));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfcoversdevice = df.getOWLObjectProperty(IRI.create(vikingIRI + "#covers"));
		OWLObjectPropertyAssertionAxiom vnfSupportsCompStandAxiom = df
				.getOWLObjectPropertyAssertionAxiom(vnfcoversdevice, vnfind, dvc);
		manager.addAxiom(viking, vnfSupportsCompStandAxiom);
		manager.saveOntology(viking);

	}

	public void setfeature(String VNFname, String feature) throws OWLOntologyStorageException {

		OWLIndividual ftr = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + feature));
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + VNFname));
		OWLObjectProperty vnfoffersfeature = df.getOWLObjectProperty(IRI.create(vikingIRI + "#offers"));
		OWLObjectPropertyAssertionAxiom vnfSupportsCompStandAxiom = df
				.getOWLObjectPropertyAssertionAxiom(vnfoffersfeature, vnfind, ftr);
		manager.addAxiom(viking, vnfSupportsCompStandAxiom);
		manager.saveOntology(viking);

	}

	public List getfeature() throws OWLOntologyCreationException {
		init();
		List feature = new List();

		for (OWLClass c : viking.getClassesInSignature()) {
			if (c.getIRI().getFragment().equals("Feature")) {
				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				System.out.println(c.getIRI().getFragment());
				for (OWLNamedIndividual i : instances.getFlattened()) {
					System.out.println(i.getIRI().getFragment());
					feature.add(i.getIRI().getFragment());

				}
			}
		}

		return feature;

	}

	public void setpropasedprice(String vnfnm, double price, String cr) throws OWLOntologyStorageException {
		
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + vnfnm));
		OWLDataProperty vnfhasprice = df.getOWLDataProperty(IRI.create(vikingIRI + "#" + "has_price"));
if (cr=="USD") {
	OWLDataPropertyAssertionAxiom Axiom = df.getOWLDataPropertyAssertionAxiom(vnfhasprice, vnfind, price*0.87);	
	manager.addAxiom(viking, Axiom);
		}
		
OWLDataPropertyAssertionAxiom Axiom = df.getOWLDataPropertyAssertionAxiom(vnfhasprice, vnfind, price);	
manager.addAxiom(viking, Axiom);
		manager.addAxiom(viking, Axiom);
		manager.saveOntology(viking);
		
		
//////////////////////////////////////////////
		OWLClass billingcls = manager.getOWLDataFactory().getOWLClass(IRI.create("http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#Billing"));
		OWLIndividual priceid = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + price+cr));
		OWLClassAssertionAxiom classAssertion = df.getOWLClassAssertionAxiom(billingcls, priceid);
		manager.addAxiom(viking, classAssertion);

		OWLObjectProperty vnfcostsprice = df.getOWLObjectProperty(IRI.create(vikingIRI + "#costs"));
		OWLObjectPropertyAssertionAxiom vnfSupportsCompStandAxiom = df.getOWLObjectPropertyAssertionAxiom(vnfcostsprice,
				vnfind, priceid);
		manager.addAxiom(viking, vnfSupportsCompStandAxiom);
		manager.saveOntology(viking);

	}

	public void setVNFdeployementdescription(String vnfnm, double network, String vnfnetworkunit, double cpu, double memory, String vnfmemoryunit, double storage,String vnfstorageunit,
			String depurl, String vnf_url ) throws OWLOntologyStorageException {
		OWLIndividual vnfind = df.getOWLNamedIndividual(IRI.create(vikingIRI + "#" + vnfnm));
		OWLDataProperty vnfnetwork = df.getOWLDataProperty(IRI.create(vikingIRI + "#" + "has_network_resource"));
		OWLDataProperty networkunit = df.getOWLDataProperty(IRI.create(vikingIRI + "#" + "has_network_unit"));

		OWLDataProperty vnfcpu = df.getOWLDataProperty(IRI.create(vikingIRI + "#" + "has_CPU_Resource"));

		OWLDataProperty vnfmemory = df.getOWLDataProperty(IRI.create(vikingIRI + "#" + "has_memory_resource"));
		OWLDataProperty memoryunit = df.getOWLDataProperty(IRI.create(vikingIRI + "#" + "has_Memory_unit"));

		OWLDataProperty vnfstorage = df.getOWLDataProperty(IRI.create(vikingIRI + "#" + "has_storage_resource"));
		OWLDataProperty storageunit = df.getOWLDataProperty(IRI.create(vikingIRI + "#" + "has_storage_unit"));

		OWLDataProperty vnfdeploymentURL = df
				.getOWLDataProperty(IRI.create(vikingIRI + "#" + "has_deployment_description_URI"));
		OWLDataProperty vnfURL = df.getOWLDataProperty(IRI.create(vikingIRI + "#" + "has_VNF_URI"));

		
		
		
		
		
		if (network!=0) {
			
			switch (vnfnetworkunit)
			{
			  case "MB":
			    network=network*1000;
			    break;
			  case "GB":
				  network=network*1000*1000;
			    break;
			  case "TB":
				  network=network*1000*1000*1000;			    
			    break;
			}
			
			
			
			OWLDataPropertyAssertionAxiom Axiom = df.getOWLDataPropertyAssertionAxiom(vnfnetwork, vnfind, network);
			manager.addAxiom(viking, Axiom);
		}

		if (cpu!=0) {
			OWLDataPropertyAssertionAxiom Axiom1 = df.getOWLDataPropertyAssertionAxiom(vnfcpu, vnfind, cpu);
			manager.addAxiom(viking, Axiom1);
		}

		if (memory!=0) {
			switch (vnfmemoryunit)
			{
			  case "MB":
				  memory=memory*1024;
			    break;
			  case "GB":
				  memory=memory*1024*1024;
			    break;
			  case "TB":
				  memory=memory*1024*1024*1024;			    
			    break;
			}
			OWLDataPropertyAssertionAxiom Axiom2 = df.getOWLDataPropertyAssertionAxiom(vnfmemory, vnfind, memory);
			manager.addAxiom(viking, Axiom2);

		}
		if (storage!=0) {
			switch (vnfstorageunit)
			{
			  case "MB":
				  memory=memory*1024;
			    break;
			  case "GB":
				  memory=memory*1024*1024;
			    break;
			  case "TB":
				  memory=memory*1024*1024*1024;			    
			    break;
			}
			OWLDataPropertyAssertionAxiom Axiom3 = df.getOWLDataPropertyAssertionAxiom(vnfstorage, vnfind, storage);
			manager.addAxiom(viking, Axiom3);
		}
		if (!depurl.isEmpty()) {
			OWLDataPropertyAssertionAxiom Axiom4 = df.getOWLDataPropertyAssertionAxiom(vnfdeploymentURL, vnfind,
					depurl);
			manager.addAxiom(viking, Axiom4);

		}
		if (!vnf_url.isEmpty()) {
			OWLDataPropertyAssertionAxiom Axiom5 = df.getOWLDataPropertyAssertionAxiom(vnfURL, vnfind, vnf_url);
			manager.addAxiom(viking, Axiom5);

		}

		manager.saveOntology(viking);
	}
	public List getProvider() {
		List providers = new List();
		for (OWLClass c : viking.getClassesInSignature()) {
			if (c.getIRI().getFragment().equals("Provider")) {
				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				System.out.println(c.getIRI().getFragment());
				for (OWLNamedIndividual i : instances.getFlattened()) {
					System.out.println(i.getIRI().getFragment());
					providers.add(i.getIRI().getFragment());

				}
			}
		}
		return providers;

	}
	public List getnotvalidatevnf() {
		List notvalidatevnf=new List();
		Model model = FileManager.get().loadModel("C:\\Users\\adminnennouar\\Downloads\\DevPro.rdf");
		String finalquery="PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#>\r\n" + 
				"		SELECT ?x WHERE{?x viking:validated ?y FILTER(?y=true).}";
		Query query = QueryFactory.create(finalquery);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet results = qe.execSelect();
		java.util.List<String> vars = results.getResultVars();

		PrefixMapping pm = query.getPrefixMapping();
		while (results.hasNext()) {
			QuerySolution querySolution = results.nextSolution();
			// RDFNode x = querySolution.get("vnf") ;
			// Literal l = querySolution.getLiteral("vnf") ;

			for (int i = 0; i < vars.size(); i++) {
				String var = vars.get(i).toString();
				System.out.println("the var is" + var);
				RDFNode node = querySolution.get(var);
				String text = "";
				if (node.isURIResource()) {
					text = pm.shortForm(node.asNode().getURI());

				} else {
					text = node.toString();

				}
				notvalidatevnf.add(text.substring(7));
				// System.out.println("the result from list is "+text.substring(7));

			}

		}
		qe.close();
		return notvalidatevnf;
	}
}
