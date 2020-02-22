import java.awt.List;
import java.io.File;
import java.util.ArrayList;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;


public class VikingManag {
	OWLOntology viking;
	OWLDataFactory df;
	OWLOntologyManager manager;
	IRI vikingIRI;
	OWLReasonerFactory reasonerFactory;
	OWLReasoner reasoner;


public void init() throws OWLOntologyCreationException {
	
	manager = OWLManager.createOWLOntologyManager();
	vikingIRI = IRI.create("http://www.semanticweb.org/pc/ontologies/2018/3/VIKING");
	viking = manager.loadOntologyFromOntologyDocument(
			new File("C:\\Users\\adminnennouar\\Downloads\\Viking_new_version.owl"));
	df = manager.getOWLDataFactory();
	reasonerFactory = new StructuralReasonerFactory();
	reasoner = reasonerFactory.createReasoner(viking);
}

public ArrayList<String> VNFDTrType() throws OWLOntologyCreationException {
	
	init();
	ArrayList<String> VNFDs = new ArrayList<String>();

	for (OWLClass c : viking.getClassesInSignature()) {
		if (c.getIRI().getFragment().equals("Vtranscoder")) {
			NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
			for (OWLNamedIndividual i : instances.getFlattened()) {
				//System.out.println(i.getIRI().getFragment());
				VNFDs.add(i.getIRI().getFragment());

			}
		}
	}
	return VNFDs;
	
	
}
public ArrayList<String> VNFDMxType() throws OWLOntologyCreationException {
	
	init();
	ArrayList<String>  VNFDs=new ArrayList<String>() ;
	for (OWLClass c : viking.getClassesInSignature()) {
		if (c.getIRI().getFragment().equals("Vmixer")) {
			NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
			for (OWLNamedIndividual i : instances.getFlattened()) {
				//System.out.println(i.getIRI().getFragment());
				VNFDs.add(i.getIRI().getFragment());

			}
		}
	}

	return VNFDs;
	
	
}
public ArrayList<String> VNFDCpType() throws OWLOntologyCreationException {
	
	init();
	ArrayList<String> VNFDs =new ArrayList<String>() ;
	for (OWLClass c : viking.getClassesInSignature()) {
		if (c.getIRI().getFragment().equals("Vcompressor")) {
			NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
			for (OWLNamedIndividual i : instances.getFlattened()) {
				//System.out.println(i.getIRI().getFragment());
				VNFDs.add(i.getIRI().getFragment());

			}
		}
	}


	return VNFDs;
	
	
}

public List getTranscoderOp() throws OWLOntologyCreationException {

	init();
	List trascOpArray = new List();

	for (OWLClass c : viking.getClassesInSignature()) {
		if (c.getIRI().getFragment().equals("Transcoding_operation")) {
			NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
			//System.out.println(c.getIRI().getFragment());
			for (OWLNamedIndividual i : instances.getFlattened()) {
				System.out.println(i.getIRI().getFragment());
				trascOpArray.add(i.getIRI().getFragment());

			}
		}
	}

	return trascOpArray;

}

public List getTranscoderTech() throws OWLOntologyCreationException {
	init();
	List trascTechArray = new List();

	for (OWLClass c : viking.getClassesInSignature()) {
		if (c.getIRI().getFragment().equals("Transcoding_technique")) {
			NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
			//System.out.println(c.getIRI().getFragment());
			for (OWLNamedIndividual i : instances.getFlattened()) {
				//System.out.println(i.getIRI().getFragment());
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
			//System.out.println(c.getIRI().getFragment());
			for (OWLNamedIndividual i : instances.getFlattened()) {
				//System.out.println(i.getIRI().getFragment());
				trascStandArray.add(i.getIRI().getFragment());

			}
		}
	}
	return trascStandArray;

}
public List getVideoFormat() throws OWLOntologyCreationException {
	init();
	List videoFormat = new List();

	for (OWLClass c : viking.getClassesInSignature()) {
		if (c.getIRI().getFragment().equals("Video_format")) {
			NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
			//System.out.println(c.getIRI().getFragment());
			for (OWLNamedIndividual i : instances.getFlattened()) {
				//System.out.println(i.getIRI().getFragment());
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
			//System.out.println(c.getIRI().getFragment());
			for (OWLNamedIndividual i : instances.getFlattened()) {
				//System.out.println(i.getIRI().getFragment());
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
			//System.out.println(c.getIRI().getFragment());
			for (OWLNamedIndividual i : instances.getFlattened()) {
				//System.out.println(i.getIRI().getFragment());
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
			//System.out.println(c.getIRI().getFragment());
			for (OWLNamedIndividual i : instances.getFlattened()) {
				//System.out.println(i.getIRI().getFragment());
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
			//System.out.println(c.getIRI().getFragment());
			for (OWLNamedIndividual i : instances.getFlattened()) {
				//System.out.println(i.getIRI().getFragment());
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
			//System.out.println(c.getIRI().getFragment());
			for (OWLNamedIndividual i : instances.getFlattened()) {
				//System.out.println(i.getIRI().getFragment());
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
			//System.out.println(c.getIRI().getFragment());
			for (OWLNamedIndividual i : instances.getFlattened()) {
				//System.out.println(i.getIRI().getFragment());
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
			//System.out.println(c.getIRI().getFragment());
			for (OWLNamedIndividual i : instances.getFlattened()) {
				//System.out.println(i.getIRI().getFragment());
				device.add(i.getIRI().getFragment());

			}
		}
	}

	return device;

}
public List getfeature() throws OWLOntologyCreationException {
	init();
	List feature = new List();

	for (OWLClass c : viking.getClassesInSignature()) {
		if (c.getIRI().getFragment().equals("Feature")) {
			NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
			//System.out.println(c.getIRI().getFragment());
			for (OWLNamedIndividual i : instances.getFlattened()) {
				//System.out.println(i.getIRI().getFragment());
				feature.add(i.getIRI().getFragment());

			}
		}
	}

	return feature;

}
public List getMixOp() throws OWLOntologyCreationException {

	init();
	List MixOpArray = new List();

	for (OWLClass c : viking.getClassesInSignature()) {
		if (c.getIRI().getFragment().equals("Mixing_operation")) {
			NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
			//System.out.println(c.getIRI().getFragment());
			for (OWLNamedIndividual i : instances.getFlattened()) {
				//System.out.println(i.getIRI().getFragment());
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
			//System.out.println(c.getIRI().getFragment());
			for (OWLNamedIndividual i : instances.getFlattened()) {
				//System.out.println(i.getIRI().getFragment());
				MixTechArray.add(i.getIRI().getFragment());

			}
		}
	}

	return MixTechArray;

}
public List getCompOp() throws OWLOntologyCreationException {

	init();
	List CompOpArray = new List();

	for (OWLClass c : viking.getClassesInSignature()) {
		if (c.getIRI().getFragment().equals("Compressing_operation")) {
			NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
			//System.out.println(c.getIRI().getFragment());
			for (OWLNamedIndividual i : instances.getFlattened()) {
				//System.out.println(i.getIRI().getFragment());
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
			//System.out.println(c.getIRI().getFragment());
			for (OWLNamedIndividual i : instances.getFlattened()) {
				//System.out.println(i.getIRI().getFragment());
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
			//System.out.println(c.getIRI().getFragment());
			for (OWLNamedIndividual i : instances.getFlattened()) {
				//System.out.println(i.getIRI().getFragment());
				CompStandArray.add(i.getIRI().getFragment());

			}
		}
	}

	return CompStandArray;

}
}