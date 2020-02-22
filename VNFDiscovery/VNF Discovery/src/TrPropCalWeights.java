import java.awt.List;
import java.util.ArrayList;

import javax.print.attribute.Attribute;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.shared.PrefixMapping;
import org.apache.jena.sparql.function.library.substring;
import org.apache.jena.util.FileManager;

import test.testqueryy;

public class TrPropCalWeights {
	VNFandScore vnf_sc;
	ArrayList<Pair> trOplist;
	ArrayList<Pair> trTechlist;
	ArrayList<Pair> trStdlist;
	ArrayList<Pair> trCtlist;
	ArrayList<Pair> trCtAttlist;
	int nbFP=0, nbPrefB=0, nbPrefC=0, nbNFP=0;
	Transcoder transcoderReq;
	ContentAttInputOutput trVideoIO;
	ContentAttInputOutput trAudioIO;

	ContentAttInputOutput trImageIO;
	elementIO trAudioFormat, trImageFormat, trVideoFormat;
	elementIO trAudioCodec, trImageCodec, trVideoCodec;
	elementIO trAudioResolution, trImageResolution, trVideoResolution;
	String[] trAudioFormatI, trAudioFormatO, trAudioCodecI, trAudioCodecO, trAudioResolutionI, trAudioResolutionO,
			trImageFormatI, trImageFormatO, trImageCodecI, trImageCodecO, trImageResolutionI, trImageResolutionO,
			trVideoFormatI, trVideoFormatO, trVideoCodecI, trVideoCodecO, trVideoResolutionI, trVideoResolutionO;
	float WFP, WNFP, WPrefB, WPrefC, WPref, gwfp, gwnfp, gwpref;
	Transcoder Op, Tech, Std, Ct, CtAtt, CtIO;
	ContentInputOutput trCtIOlist;
	boolean v, a, i, f, c, r, b;
	int nbVideoFormatI, nbVideoFormatO, nbVideoCodecI, nbVideoCodecO, nbVideoResolutionI, nbVideoResolutionO;
	int nbAudioFormatI, nbAudioFormatO, nbAudioCodecI, nbAudioCodecO, nbAudioResolutionI, nbAudioResolutionO;
	int nbImageFormatI, nbImageFormatO, nbImageResolutionI, nbImageResolutionO;
	ArrayList<Pair> devices;
	ArrayList<Pair> features;
	String price=null, cpu=null, memory=null, network=null, storage=null;
	String prefix = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> SELECT DISTINCT ?vnf  WHERE{  ";
	String query;
	ArrayList<String> req = new ArrayList<>();
	String Man_op = "", Man_ct = "", Man_ctatt = "", Man_tech = "", Man_std = "";
	String Man_IFI = "";
	String Man_ARO = "";
	String Man_ARI = "";
	String Man_ACO = "";
	String Man_ACI = "";
	String Man_AFO = "";
	String Man_AFI = "";
	String Man_VRO = "";
	String Man_VRI = "";
	String Man_VCO = "";
	String Man_VCI = "";
	String Man_VFO = "";
	String Man_VFI = "";
	String Man_IRO = "";
	String Man_IRI = "";
	String Man_IFO = "";
	String Man_price = "";
	String Man_cpu = "";
	String Man_network = "";
	String Man_memory = "";
	String Man_storage = "";
	String Man_device = "";
	String Man_feature = "";

	String prop_uri = "<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#";

	public TrPropCalWeights(Boolean v, Boolean a, Boolean i, Boolean f, Boolean c, Boolean r, Boolean b,
			Transcoder transcoderReq, ArrayList<Pair> devices, ArrayList<Pair> features, String price, String cpu,
			String memory, String network, String storage, int gwfp, int gwnfp, int gwpref) {
		this.transcoderReq = transcoderReq;
		this.gwfp = gwfp;
		this.gwnfp = gwnfp;
		this.gwpref = gwpref;
		this.v = v;
		this.a = a;
		this.i = i;
		this.f = f;
		this.c = c;
		this.r = r;
		this.b = b;
		this.devices = devices;
		this.features = features;
		this.price = price;
		this.cpu = cpu;
		this.memory = memory;
		this.network = network;
		this.storage = storage;

		System.out.println(" ///////////**********Transcoder Request**********/////////// ");
		calculateWFP();
		calculateWNFP();
		calculateWPref();

	}

	public void calculateWFP() {

		/////////// **************** TRANSCODER FUNCTIONAL
		/////////// PROPERTIES********************///////////////

		trOplist = transcoderReq.TrOplist;

		for (int i = 0; i < trOplist.size(); i++) {
			if (!trOplist.get(i).pref.equals("A- Mandatory")) {
				nbFP++;
			}
			// System.out.println(" the transcoder operations requested are : " + p.prop);

		}

		trTechlist = transcoderReq.TrTechlist;
		
		  for (int i = 0; i < trTechlist.size(); i++) { 
			  if (!trTechlist.get(i).pref.equals("A- Mandatory")) {
					nbFP++;
			}
		  //System.out.println(" the transcoder techniques requested are : " + p.prop); 
		  }
		 
		trStdlist = transcoderReq.TrSdlist;
		
		  for (int i = 0; i < trStdlist.size(); i++) {
			  if (!trStdlist.get(i).pref.equals("A- Mandatory")) {
					nbFP++;
			}
		  }
		 // System.out.println(" the transcoder standards requested are : " + p.prop); }
		 
		trCtlist = transcoderReq.TrCtlist;
		
		  for (int i = 0; i < trCtlist.size(); i++) { 
			  if (!trCtlist.get(i).prop.equals("A- Mandatory")) {
					nbFP++;

			}
		  }
		 // System.out.println(" the transcoder Contents requested are : " + p.prop); }
		 
		trCtAttlist = transcoderReq.TrCtAttlist;
		
		/* for (int i = 0; i < trCtAttlist.size(); i++) { 
		 if (!trCtAttlist.get(i).pref.equals("A- Mandatory")) {
				nbFP++;

		}
		 }*/
		 //System.out.println(" the transcoder Content Attributs requested are : " + p.prop); }
		 

		trCtIOlist = transcoderReq.CtIO;

		////// Audio Input/Output/////////

		if (a == true) {
			trAudioFormatI = trCtIOlist.TrAudioIO.Format.input;

			nbAudioFormatI = trAudioFormatI.length;
		
			 for (String s : trAudioFormatI) {
				 if (!s.contains("A- Mandatory")) {
						nbFP++;

				}}
			// System.out.println(" the audio Input format requested are : " + s); }
			 

			trAudioFormatO = trCtIOlist.TrAudioIO.Format.output;
			nbAudioFormatO = trAudioFormatO.length;
			
			 for (String s : trAudioFormatO) {
				 if (!s.contains("A- Mandatory")) {
						nbFP++;

				}
			 }
			// System.out.println(" the audio Output format requested are : " + s); }
			 

			trAudioCodecI = trCtIOlist.TrAudioIO.Codec.input;
			nbAudioCodecI = trAudioCodecI.length;
			
			  for (String s : trAudioCodecI) {
				  if (!s.contains("A- Mandatory")) {
						nbFP++;

				}
			 //System.out.println(" the audio Input Codec requested are : " + s);
			 }
			 
			trAudioCodecO = trCtIOlist.TrAudioIO.Codec.output;
			nbAudioCodecO = trAudioCodecO.length;
			
			  for (String s : trAudioCodecO) {
				  if (!s.contains("A- Mandatory")) {
						nbFP++;

				}
			  //System.out.println(" the audio Output Codec requested are : " + s); 
			  }
			 

			trAudioResolutionI = trCtIOlist.TrAudioIO.Resolution.input;
			nbAudioResolutionI = trAudioResolutionI.length;
			
			  for (String s : trAudioResolutionI) {
				  if (!s.contains("A- Mandatory")) {
						nbFP++;

				}
			 // System.out.println(" the audio Input Resolution requested are : " + s); 
			  }
			 
			trAudioResolutionO = trCtIOlist.TrAudioIO.Resolution.output;
			nbAudioResolutionO = trAudioResolutionO.length;
			
			  for (String s : trAudioResolutionO) {
				  if (!s.contains("A- Mandatory")) {
						nbFP++;

				}
			  //System.out.println(" the audio Output Resolution requested are : " + s); 
			  }
			 

			
			
			 

			
		}
		////// Image Input/Output/////////

		if (i) {
			trImageFormatI = trCtIOlist.TrImageIO.Format.input;
			nbImageFormatI = trImageFormatI.length;
			for (String s : trImageFormatI) {
				  if (!s.contains("A- Mandatory")) {
						nbFP++;

				}
			  }
			trImageFormatO = trCtIOlist.TrImageIO.Format.output;
			nbImageFormatO = trImageFormatO.length;
			for (String s : trImageFormatO) {
				  if (!s.contains("A- Mandatory")) {
						nbFP++;

				}
			  }
			trImageResolutionI = trCtIOlist.TrImageIO.Resolution.input;
			nbImageResolutionI = trImageResolutionI.length;
			for (String s : trImageResolutionI) {
				  if (!s.contains("A- Mandatory")) {
						nbFP++;

				}
			  }
			trImageResolutionO = trCtIOlist.TrImageIO.Resolution.output;
			nbImageResolutionO = trImageResolutionO.length;
			for (String s : trImageResolutionO) {
				  if (!s.contains("A- Mandatory")) {
						nbFP++;

				}
			  }

		}
		////// Video Input/Output/////////
		if (v) {
			trVideoFormatI = trCtIOlist.TrVideoIO.Format.input;
			nbVideoFormatI = trVideoFormatI.length;
			for (String s :trVideoFormatI) {
				  if (!s.contains("A- Mandatory")) {
						nbFP++;

				}
			  }
			trVideoFormatO = trCtIOlist.TrVideoIO.Format.output;
			nbVideoFormatO = trVideoFormatO.length;
			for (String s :trVideoFormatO) {
				  if (!s.contains("A- Mandatory")) {
						nbFP++;

				}
			  }
			trVideoCodecI = trCtIOlist.TrVideoIO.Codec.input;
			nbVideoCodecI = trVideoCodecI.length;
			for (String s :trVideoCodecI) {
				  if (!s.contains("A- Mandatory")) {
						nbFP++;

				}
			  }
			trVideoCodecO = trCtIOlist.TrVideoIO.Codec.output;
			nbVideoCodecO = trVideoCodecO.length;
			for (String s :trVideoCodecO) {
				  if (!s.contains("A- Mandatory")) {
						nbFP++;

				}
			  }
			trVideoResolutionI = trCtIOlist.TrVideoIO.Resolution.input;
			nbVideoResolutionI = trVideoResolutionI.length;
			for (String s :trVideoResolutionI) {
				  if (!s.contains("A- Mandatory")) {
						nbFP++;

				}
			  }
			trVideoResolutionO = trCtIOlist.TrVideoIO.Resolution.output;
			nbVideoResolutionO = trVideoResolutionO.length;
			for (String s :trVideoResolutionO) {
				  if (!s.contains("A- Mandatory")) {
						nbFP++;

				}
			  }

		}

		//////////////////// **************** NUMBER OF FUNCTIONAL
		//////////////////// PROPERTIES********************///////////////////////////////////////

		/*nbFP = trOplist.size() + trTechlist.size() + trStdlist.size() + trCtlist.size() + nbVideoResolutionO
				+ nbVideoResolutionI + nbVideoCodecO + nbVideoCodecI + nbVideoFormatO + nbVideoFormatI + nbAudioFormatI
				+ nbAudioFormatO + nbAudioCodecI + nbAudioCodecO + nbAudioResolutionI + nbAudioResolutionO
				+ nbImageFormatI + nbImageFormatO + nbImageResolutionI + nbImageResolutionO;*/

		
	
		
		System.out.println("the number of FP is: " + nbFP);
		WFP = gwfp / nbFP;
		System.out.println("the weight of FP is: " + WFP);

	}

	public void calculateWNFP() {
		///////// Non Functional properties requested/////////
		
		if (!price.contains("Choose Preference")) {
			
			nbNFP++;
		}
		if (!cpu.contains("Choose Preference")) {
			nbNFP++;
		}
		if (!memory.contains("Choose Preference")) {
			nbNFP++;
		}
		if (!network.contains("Choose Preference")) {
			nbNFP++;
		}
		if (!storage.contains("Choose Preference")) {
			nbNFP++;
		}

		nbNFP = nbNFP + devices.size() + features.size();
		System.out.println("the number of NFP is: " + nbNFP);
		WNFP = gwnfp / nbNFP;
		System.out.println("the weight of NFP is: " + WNFP);
	}

	public void calculateWPref() {

		if (!price.contains("Choose Preference")) {
			String[] ps = price.split("# ");
			String p0 = ps[0];
			String p = ps[1];
			if (p.contains("B- Preferable")) {

				nbPrefB++;
			} else if (p.contains("C- Optional")) {
				nbPrefC++;
			} else if (p.contains("A- Mandatory")) {
				////// create the query
				Man_price = "?vnf viking:has_price  ?price.\r\n" + "FILTER( ?price<" + p0 + ").";
			}
			// System.out.println("the requested Price is " + p0 + " the preference is :" +
			// p);
		}
		if (!cpu.contains("Choose Preference")) {
			String[] ps = price.split("# ");
			String p0 = ps[0];
			String p = ps[1];
			if (p.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.contains("C- Optional")) {
				nbPrefC++;
			} else if (p.contains("A- Mandatory")) {
				Man_cpu = "?vnf viking:has_CPU_Resource  ?cpu.\r\n" + "FILTER( ?cpu<" + p0 + ").";
			}
			// System.out.println("the requested CPU is " + p0 + " the preference is :" +
			// p);
		}
		if (!memory.contains("Choose Preference")) {
			String[] ps = memory.split("# ");
			String p0 = ps[0];

			String p = ps[1];
			if (p.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.contains("C- Optional")) {
				nbPrefC++;
			} else if (p.contains("A- Mandatory")) {
				Man_memory = "?vnf viking:has_memory_resource  ?memory.\r\n" + "FILTER( ?memory<" + p0 + ").";
			}
			// System.out.println("the requested Memory is " + p0 + " the preference is :" +
			// p);
		}
		if (!network.contains("Choose Preference")) {
			String[] ps = network.split("# ");
			String p0 = ps[0];

			String p = ps[1];
			if (p.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.contains("C- Optional")) {
				nbPrefC++;
			} else if (p.contains("A- Mandatory")) {
				Man_network = "?vnf viking:has_network_resource ?network.\r\n" + "FILTER( ?network<" + p0 + ").";
			}
			// System.out.println("the requested Network is " + p0 + " the preference is :"
			// + p);
		}
		if (!storage.contains("Choose Preference")) {
			String[] ps = storage.split("# ");
			String p0 = ps[0];

			String p = ps[1];
			if (p.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.contains("C- Optional")) {
				nbPrefC++;
			} else if (p.contains("A- Mandatory")) {
				Man_storage = "?vnf viking:has_storage_resource ?storage.\r\n" + "FILTER( ?storage<" + p0 + ").";
			}
			// System.out.println("the requested Storage is " + p0 + " the preference is :"
			// + p);
		}

		for (int i = 0; i < devices.size(); i++) {
			Pair p = devices.get(i);
			if (p.pref.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.pref.contains("C- Optional")) {
				nbPrefC++;
			} else if (p.pref.contains("A- Mandatory")) {
				Man_device = Man_device + prop_uri + p.prop + "> ,";
			}
			// System.out.println("the requested Device is " + p.prop + " the preference is
			// :" + p.pref);
		}
		if (!devices.isEmpty() & !Man_device.isEmpty()) {
			Man_device = "?vnf viking:covers " + Man_device.substring(0, Man_device.length() - 1) + ".";
		}
		for (int i = 0; i < features.size(); i++) {
			Pair p = features.get(i);
			if (p.pref.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.pref.contains("C- Optional")) {
				nbPrefC++;
			} else if (p.pref.contains("A- Mandatory")) {
				Man_feature = Man_feature + prop_uri + p.prop + "> ,";

			}
			// System.out.println("the requested Feature is " + p.prop + " the preference is
			// :" + p.pref);
		}
		if (!features.isEmpty() & !Man_feature.isEmpty()) {
			Man_feature = "?vnf viking:offers " + Man_feature.substring(0, Man_feature.length() - 1) + ".";
		}
		for (int i = 0; i < trOplist.size(); i++) {
			Pair p = trOplist.get(i);
			if (p.pref.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.pref.contains("C- Optional")) {
				nbPrefC++;
			} else if (p.pref.contains("A- Mandatory")) {
				Man_op = Man_op + prop_uri + p.prop + "> ,";
			}

			// testqueryy tsqe=new testqueryy(finalquery);

			// System.out.println("the requested Transcoding operation is " + p.prop + " the
			// preference is :" + p.pref);
		}
		if (!trOplist.isEmpty() & !Man_op.isEmpty()) {
			Man_op = "?vnf viking:implements " + Man_op.substring(0, Man_op.length() - 1) + ".";
		}
		/*
		 * int j = 0; for (String string : req) { if (j==req.size()-1) {
		 * cond_vnf=cond_vnf+string+"."; }else { cond_vnf=cond_vnf+string+","; j++; }
		 * query=prefix+var_vnf +cond_vnf+"}"; }
		 */
		// query=prefix+var_vnf +cond_vnf+"}";
		// System.out.println(" the transcoder Query is : " +Man_op);
		for (int i = 0; i < trTechlist.size(); i++) {
			Pair p = trTechlist.get(i);
			if (p.pref.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.pref.contains("C- Optional")) {
				nbPrefC++;
			} else if (p.pref.contains("A- Mandatory")) {
				Man_tech = Man_tech + prop_uri + p.prop + "> ,";
			}
			// System.out.println("the requested Transcoding technique is "+ p.prop +" the
			// preference is :"+p.pref);
		}
		if (!trTechlist.isEmpty() & !Man_tech.isEmpty()) {
			Man_tech = "?vnf viking:applies " + Man_tech.substring(0, Man_tech.length() - 1) + ".";

		}
		for (int i = 0; i < trStdlist.size(); i++) {
			Pair p = trStdlist.get(i);
			if (p.pref.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.pref.contains("C- Optional")) {
				nbPrefC++;
			} else if (p.pref.contains("A- Mandatory")) {
				Man_std = Man_std + prop_uri + p.prop + "> ,";

			}
			// System.out.println("the requested Transcoding Standard is "+ p.prop +" the
			// preference is :"+p.pref);
		}
		if (!trStdlist.isEmpty() & !Man_std.isEmpty()) {
			Man_std = "?vnf viking:supports " + Man_std.substring(0, Man_std.length() - 1) + ".";

		}
		for (int i = 0; i < trCtlist.size(); i++) {
			Pair p = trCtlist.get(i);
			if (p.pref.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.pref.contains("C- Optional")) {
				nbPrefC++;
			} else if (p.pref.contains("A- Mandatory")) {
				Man_ct = Man_ct + prop_uri + p.prop + "> ,";

			}
			// System.out.println("the requested Content is "+ p.prop +" the preference is
			// :"+p.pref);
		}
		if (!trCtlist.isEmpty() & !Man_ct.isEmpty()) {
			Man_ct = "?vnf viking:requests " + Man_ct.substring(0, Man_ct.length() - 1) + " .";

		}
		/*
		 * for (int i = 0; i < trCtAttlist.size(); i++) { Pair p = trCtAttlist.get(i);
		 * if (p.pref.contains("B- Preferable")) { nbPrefB++; } else if
		 * (p.pref.contains("C- Optional")) { nbPrefC++; } else if
		 * (p.pref.contains("A- Mandatory")) { Man_ctatt = Man_ctatt + prop_uri + p.prop
		 * + "> ,"; } // System.out.println("the requested Content Attributs is "+
		 * p.prop +" the // preference is :"+p.pref); } if (!trCtAttlist.isEmpty()) {
		 * Man_ctatt = "?vnf viking:supplies " + Man_ctatt.substring(0,
		 * Man_ctatt.length() - 1) + " .";
		 * 
		 * }
		 */
		if (i == true) {

			for (String s : trImageFormatI) {
				String[] parts = s.split("# ");
				String p0 = parts[0];
				String p = parts[1];
				if (p.contains("B- Preferable")) {
					nbPrefB++;
				} else if (p.contains("C- Optional")) {
					nbPrefC++;
				} else if (p.contains("A- Mandatory")) {
					Man_IFI = Man_IFI + prop_uri + p0 + "> ,";
				}
				// System.out.println("the requested Input image format is "+ p0 +" the
				// preference is :"+p);
			}
			if (trImageFormatI.length != 0 & !Man_IFI.isEmpty()) {
				Man_IFI = "?vnf viking:requires_ImageFormat " + Man_IFI.substring(0, Man_IFI.length() - 1) + " .";

			}
			for (String s : trImageFormatO) {
				String[] parts = s.split("# ");
				String p0 = parts[0];

				String p = parts[1];
				if (p.contains("B- Preferable")) {
					nbPrefB++;
				} else if (p.contains("C- Optional")) {
					nbPrefC++;
				} else if (p.contains("A- Mandatory")) {
					Man_IFO = Man_IFO + prop_uri + p0 + "> ,";

				}
				// System.out.println("the requested Output image format is "+ p0 +" the
				// preference is :"+p);

			}
			if (trImageFormatO.length != 0 & !Man_IFO.isEmpty()) {
				Man_IFO = "?vnf viking:supplies_ImageFormat " + Man_IFO.substring(0, Man_IFO.length() - 1) + " .";

			}
			for (String s : trImageResolutionI) {
				String[] parts = s.split("# ");
				String p0 = parts[0];

				String p = parts[1];
				if (p.contains("B- Preferable")) {
					nbPrefB++;
				} else if (p.contains("C- Optional")) {
					nbPrefC++;
				} else if (p.contains("A- Mandatory")) {
					Man_IRI = Man_IRI + prop_uri + p0 + "> ,";

				}
				// System.out.println("the requested Input image Resolution is "+ p0 +" the
				// preference is :"+p);

			}
			if (trImageResolutionI.length != 0 & !Man_IRI.isEmpty()) {
				Man_IRI = "?vnf viking:requires_ImageResolution " + Man_IRI.substring(0, Man_IRI.length() - 1) + " .";

			}
			for (String s : trImageResolutionO) {
				String[] parts = s.split("# ");
				String p0 = parts[0];

				String p = parts[1];
				if (p.contains("B- Preferable")) {
					nbPrefB++;
				} else if (p.contains("C- Optional")) {
					nbPrefC++;
				} else if (p.contains("A- Mandatory")) {
					Man_IRO = Man_IRO + prop_uri + p0 + "> ,";

				}

				// System.out.println("the requested Output image Resolution is "+ p0 +" the
				// preference is :"+p);

			}
			if (trImageResolutionO.length != 0 & !Man_IRO.isEmpty()) {
				Man_IRO = "?vnf viking:supplies_ImageResolution " + Man_IRO.substring(0, Man_IRO.length() - 1) + " .";

			}

		}
		if (v == true) {

			for (String s : trVideoFormatI) {
				String[] parts = s.split("# ");
				String p0 = parts[0];

				String p = parts[1];
				if (p.contains("B- Preferable")) {
					nbPrefB++;
				} else if (p.contains("C- Optional")) {
					nbPrefC++;
				} else if (p.contains("A- Mandatory")) {
					Man_VFI = Man_VFI + prop_uri + p0 + "> ,";

				}
				// System.out.println("the requested Input Video Format is "+ p0 +" the
				// preference is :"+p);

			}
			if (trVideoFormatI.length != 0 & !Man_VFI.isEmpty()) {
				Man_VFI = "?vnf viking:requires_VideoForamt " + Man_VFI.substring(0, Man_VFI.length() - 1) + " .";

			}
			for (String s : trVideoFormatO) {
				String[] parts = s.split("# ");
				String p0 = parts[0];

				String p = parts[1];
				if (p.contains("B- Preferable")) {
					nbPrefB++;
				} else if (p.contains("C- Optional")) {
					nbPrefC++;
				} else if (p.contains("A- Mandatory")) {
					Man_VFO = Man_VFO + prop_uri + p0 + "> ,";

				}
				// System.out.println("the requested Output Video Format is "+ p0 +" the
				// preference is :"+p);

			}
			if (trVideoFormatO.length != 0 & !Man_VFI.isEmpty()) {
				Man_VFO = "?vnf viking:supplies_VideoForamt " + Man_VFO.substring(0, Man_VFO.length() - 1) + " .";

			}
			for (String s : trVideoCodecI) {
				String[] parts = s.split("# ");
				String p0 = parts[0];

				String p = parts[1];
				if (p.contains("B- Preferable")) {
					nbPrefB++;
				} else if (p.contains("C- Optional")) {
					nbPrefC++;
				} else if (p.contains("A- Mandatory")) {
					Man_VCI = Man_VCI + prop_uri + p0 + "> ,";

				}
				// System.out.println("the requested Input Video Codec is "+ p0 +" the
				// preference is :"+p);

			}
			if (trVideoCodecI.length != 0 & !Man_VCI.isEmpty()) {
				Man_VCI = "?vnf viking:requires_VideoCodec " + Man_VCI.substring(0, Man_VCI.length() - 1) + " .";

			}
			for (String s : trVideoCodecO) {
				String[] parts = s.split("# ");
				String p0 = parts[0];

				String p = parts[1];
				if (p.contains("B- Preferable")) {
					nbPrefB++;
				} else if (p.contains("C- Optional")) {
					nbPrefC++;
				} else if (p.contains("A- Mandatory")) {
					Man_VCO = Man_VCO + prop_uri + p0 + "> ,";

				}
				// System.out.println("the requested Output Video Codec is "+ p0 +" the
				// preference is :"+p);

			}
			if (trVideoCodecO.length != 0 & !Man_VCO.isEmpty()) {
				Man_VCO = "?vnf viking:supplies_VideoCodec " + Man_VCO.substring(0, Man_VCO.length() - 1) + " .";

			}
			for (String s : trVideoResolutionI) {
				String[] parts = s.split("# ");
				String p0 = parts[0];

				String p = parts[1];
				if (p.contains("B- Preferable")) {
					nbPrefB++;
				} else if (p.contains("C- Optional")) {
					nbPrefC++;
				} else if (p.contains("A- Mandatory")) {
					Man_VRI = Man_VRI + prop_uri + p0 + "> ,";

				}
				// System.out.println("the requested Input Video Resolution is "+ p0 +" the
				// preference is :"+p);

			}
			if (trVideoResolutionI.length != 0 & !Man_VRI.isEmpty()) {
				Man_VRI = "?vnf viking:requires_VideoResolution " + Man_VRI.substring(0, Man_VRI.length() - 1) + " .";

			}
			for (String s : trVideoResolutionO) {
				String[] parts = s.split("# ");
				String p0 = parts[0];

				String p = parts[1];
				if (p.contains("B- Preferable")) {
					nbPrefB++;
				} else if (p.contains("C- Optional")) {
					nbPrefC++;
				} else if (p.contains("A- Mandatory")) {
					Man_VRO = Man_VRO + prop_uri + p0 + "> ,";

				}
				// System.out.println("the requested Output Video Resolution is "+ p0 +" the
				// preference is :"+p);

			}
			if (trVideoResolutionO.length != 0 & !Man_VRO.isEmpty()) {
				Man_VRO = "?vnf viking:supplies_VideoResolution " + Man_VRO.substring(0, Man_VRO.length() - 1) + " .";

			}

		}
		if (a == true) {

			for (String s : trAudioFormatI) {
				String[] parts = s.split("# ");
				String p0 = parts[0];

				String p = parts[1];
				if (p.contains("B- Preferable")) {
					nbPrefB++;
				} else if (p.contains("C- Optional")) {
					nbPrefC++;
				} else if (p.contains("A- Mandatory")) {
					Man_AFI = Man_AFI + prop_uri + p0 + "> ,";

				}
				// System.out.println("the requested Input Audio Format is "+ p0 +" the
				// preference is :"+p);

			}
			if (trAudioFormatI.length != 0 & !Man_AFI.isEmpty()) {
				Man_AFI = "?vnf viking:requires_AudioFormat " + Man_AFI.substring(0, Man_AFI.length() - 1) + " .";

			}
			for (String s : trAudioFormatO) {
				String[] parts = s.split("# ");
				String p0 = parts[0];

				String p = parts[1];
				if (p.contains("B- Preferable")) {
					nbPrefB++;
				} else if (p.contains("C- Optional")) {
					nbPrefC++;
				} else if (p.contains("A- Mandatory")) {
					Man_AFO = Man_AFO + prop_uri + p0 + "> ,";

				}
				// System.out.println("the requested Output Audio Format is "+ p0 +" the
				// preference is :"+p);

			}
			if (trAudioFormatO.length != 0 & !Man_AFO.isEmpty()) {
				Man_AFO = "?vnf viking:supplies_AudioFormat " + Man_AFO.substring(0, Man_AFO.length() - 1) + " .";

			}
			for (String s : trAudioCodecI) {
				String[] parts = s.split("# ");
				String p0 = parts[0];

				String p = parts[1];
				if (p.contains("B- Preferable")) {
					nbPrefB++;
				} else if (p.contains("C- Optional")) {
					nbPrefC++;
				} else if (p.contains("A- Mandatory")) {
					Man_ACI = Man_ACI + prop_uri + p0 + "> ,";

				}
				// System.out.println("the requested Input Audio Codec is "+ p0 +" the
				// preference is :"+p);

			}
			if (trAudioCodecI.length != 0 & !Man_ACI.isEmpty()) {
				Man_ACI = "?vnf viking:requires_AudioCodec " + Man_ACI.substring(0, Man_ACI.length() - 1) + " .";

			}
			for (String s : trAudioCodecO) {
				String[] parts = s.split("# ");
				String p0 = parts[0];

				String p = parts[1];
				if (p.contains("B- Preferable")) {
					nbPrefB++;
				} else if (p.contains("C- Optional")) {
					nbPrefC++;
				} else if (p.contains("A- Mandatory")) {
					Man_ACO = Man_ACO + prop_uri + p0 + "> ,";

				}
				// System.out.println("the requested Output Audio Codec is "+ p0 +" the
				// preference is :"+p);

			}
			if (trAudioCodecO.length != 0 & !Man_ACO.isEmpty()) {
				Man_ACO = "?vnf viking:supplies_AudioCodec " + Man_ACO.substring(0, Man_ACO.length() - 1) + " .";

			}
			for (String s : trAudioResolutionI) {
				String[] parts = s.split("# ");
				String p0 = parts[0];

				String p = parts[1];
				if (p.contains("B- Preferable")) {
					nbPrefB++;
				} else if (p.contains("C- Optional")) {
					nbPrefC++;
				} else if (p.contains("A- Mandatory")) {
					Man_ARI = Man_ARI + prop_uri + p0 + "> ,";

				}
				// System.out.println("the requested Input Audio Resolution is "+ p0 +" the
				// preference is :"+p);

			}
			if (trAudioResolutionI.length != 0 & !Man_ARI.isEmpty()) {
				Man_ARI = "?vnf viking:requires_AudioResolution " + Man_ARI.substring(0, Man_ARI.length() - 1) + " .";

			}
			for (String s : trAudioResolutionO) {
				String[] parts = s.split("# ");
				String p0 = parts[0];

				String p = parts[1];
				if (p.contains("B- Preferable")) {
					nbPrefB++;
				} else if (p.contains("C- Optional")) {
					nbPrefC++;
				} else if (p.contains("A- Mandatory")) {
					Man_ARO = Man_ARO + prop_uri + p0 + "> ,";

				}
				// System.out.println("the requested Output Audio Resolution is "+ p0 +" the
				// preference is :"+p);

			}
			if (trAudioResolutionO.length != 0 & !Man_ARO.isEmpty()) {
				Man_ARO = "?vnf viking:supplies_AudioResolution " + Man_ARO.substring(0, Man_ARO.length() - 1) + " .";

			}

		}
		
		query = prefix + Man_op + Man_ct + Man_tech + Man_std + Man_IFI + Man_ARO + Man_ARI + Man_ACO + Man_ACI
				+ Man_AFO + Man_AFI + Man_VRO + Man_VRI + Man_VCO + Man_VCI + Man_VFO + Man_VFI + Man_IRO + Man_IRI
				+ Man_IFO + Man_price + Man_cpu + Man_network + Man_memory+ Man_storage+Man_device+ Man_feature+"}";
		System.out.println("the query is " + query);

		System.out.println("/////////////////////////////////////////// ");

		System.out.println("the number of Prefrence B is: " + nbPrefB);
		System.out.println("the number of Prefrence C is: " + nbPrefC);
		WPref = gwpref / ((nbPrefB * 2) + nbPrefC);
		WPrefC = WPref;
		WPrefB = WPref * 2;
		System.out.println("***************************************");
		System.out.println("the weight of Prefrence B is: " + WPrefB);
		System.out.println("the weight of Prefrence C is: " + WPrefC);
		System.out.println("/////////////////////////////////////////// ");
		getVNFCondidates(query);
	}

	ArrayList<String> VNFConadidates = new ArrayList<>();

	public void getVNFCondidates(String finalquery) {

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
		ScoreVNFCondidate(VNFConadidates);

	}

	public void ScoreVNFCondidate(ArrayList<String> VNFConadidates) {

		Model model = FileManager.get().loadModel("C:\\Users\\adminnennouar\\Downloads\\Viking_new_version.rdf");

		for (int j = 0; j < VNFConadidates.size(); j++) {
			boolean res;
			double vnf_score = 0;
			if (!price.contains("Choose Preference")) {
				String[] ps = price.split("# ");
				String p0 = ps[0];
				String p = ps[1];
				String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK WHERE { <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"+ VNFConadidates.get(j) +"> viking:has_price ?price. FILTER (?price< "+p0+").}";
				//System.out.println("the ask query is " + testqe);
				Query query = QueryFactory.create(testqe);
				QueryExecution qe = QueryExecutionFactory.create(query, model);
				res = qe.execAsk();
				if (res == true) {
				if (p.contains("B- Preferable")) {

					vnf_score = vnf_score + WNFP + WPrefB;
				} else if (p.contains("C- Optional")) {
					vnf_score = vnf_score + WNFP + WPrefC;
				} 

				}
				// System.out.println("the requested Price is " + p0 + " the preference is :" +
				// p);
			}
			if (!cpu.contains("Choose Preference")) {
				String[] ps = cpu.split("# ");
				String p0 = ps[0];
				String p = ps[1];
				String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK WHERE { <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"+ VNFConadidates.get(j) +"> viking:has_CPU_Resource ?cpu. FILTER (?cpu< "+p0+").}";
				//System.out.println("the ask query is " + testqe);
				Query query = QueryFactory.create(testqe);
				QueryExecution qe = QueryExecutionFactory.create(query, model);
				res = qe.execAsk();
				if (res == true) {
				if (p.contains("B- Preferable")) {
					vnf_score = vnf_score + WNFP + WPrefB;
				} else if (p.contains("C- Optional")) {
					vnf_score = vnf_score + WNFP + WPrefC;
				}
				
			}}
			if (!memory.contains("Choose Preference")) {
				String[] ps = memory.split("# ");
				String p0 = ps[0];

				String p = ps[1];
				String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK WHERE { <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"+ VNFConadidates.get(j) +"> viking:has_memory_resource ?memory. FILTER (?memory< "+p0+").}";
				//System.out.println("the ask query is " + testqe);
				Query query = QueryFactory.create(testqe);
				QueryExecution qe = QueryExecutionFactory.create(query, model);
				res = qe.execAsk();
				if (res == true) {
				if (p.contains("B- Preferable")) {
					vnf_score = vnf_score + WNFP + WPrefB;
				} else if (p.contains("C- Optional")) {
					vnf_score = vnf_score + WNFP + WPrefC;
				}
				// System.out.println("the requested Memory is " + p0 + " the preference is :" +
				// p);
			}}
			if (!network.contains("Choose Preference")) {
				String[] ps = network.split("# ");
				String p0 = ps[0];

				String p = ps[1];
				String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK WHERE { <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"+ VNFConadidates.get(j) +"> viking:has_network_resource ?network. FILTER (?network< "+p0+").}";
				//System.out.println("the ask query is " + testqe);
				Query query = QueryFactory.create(testqe);
				QueryExecution qe = QueryExecutionFactory.create(query, model);
				res = qe.execAsk();
				if (res == true) {
				if (p.contains("B- Preferable")) {
					vnf_score = vnf_score + WNFP + WPrefB;
				} else if (p.contains("C- Optional")) {
					vnf_score = vnf_score + WNFP + WPrefC;
				}
				// System.out.println("the requested Network is " + p0 + " the preference is :"
				// + p);
			}}
			if (!storage.contains("Choose Preference")) {
				String[] ps = storage.split("# ");
				String p0 = ps[0];

				String p = ps[1];
				String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK WHERE { <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"+ VNFConadidates.get(j) +"> viking:has_storage_resource ?storage. FILTER (?storage< "+p0+").}";
				//System.out.println("the ask query is " + testqe);
				Query query = QueryFactory.create(testqe);
				QueryExecution qe = QueryExecutionFactory.create(query, model);
				res = qe.execAsk();
				if (res == true) {
				if (p.contains("B- Preferable")) {
					vnf_score = vnf_score + WNFP + WPrefB;
				} else if (p.contains("C- Optional")) {
					vnf_score = vnf_score + WNFP + WPrefC;
				}}
				// System.out.println("the requested Storage is " + p0 + " the preference is :"
				// + p);
			}

			for (int i = 0; i < devices.size(); i++) {
				Pair p = devices.get(i);
				String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
						+ VNFConadidates.get(j) + ">"
						+ " viking:covers <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#" + p.prop
						+ ">.}";
				//System.out.println("the ask query is " + testqe);
				Query query = QueryFactory.create(testqe);
				QueryExecution qe = QueryExecutionFactory.create(query, model);
				res = qe.execAsk();
				if (res == true) {
				if (p.pref.contains("B- Preferable")) {
					vnf_score = vnf_score + WNFP + WPrefB;

				} else if (p.pref.contains("C- Optional")) {
					vnf_score = vnf_score + WNFP + WPrefC;

				}}
				// System.out.println("the requested Device is " + p.prop + " the preference is
				// :" + p.pref);
			}
			for (int i = 0; i < features.size(); i++) {
				Pair p = features.get(i);
				String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
						+ VNFConadidates.get(j) + ">"
						+ " viking:offers <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#" + p.prop
						+ ">.}";
				//System.out.println("the ask query is " + testqe);
				Query query = QueryFactory.create(testqe);
				QueryExecution qe = QueryExecutionFactory.create(query, model);
				res = qe.execAsk();
				if (res == true) {
				if (p.pref.contains("B- Preferable")) {
					vnf_score = vnf_score + WNFP + WPrefB;
				} else if (p.pref.contains("C- Optional")) {
					vnf_score = vnf_score + WNFP + WPrefC;
				}}
				// System.out.println("the requested Feature is " + p.prop + " the preference is
				// :" + p.pref);
			}
			for (int i = 0; i < trOplist.size(); i++) {
				Pair p = trOplist.get(i);

				String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
						+ VNFConadidates.get(j) + ">"
						+ " viking:implements <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#" + p.prop
						+ ">.}";
				//System.out.println("the ask query is " + testqe);
				Query query = QueryFactory.create(testqe);
				QueryExecution qe = QueryExecutionFactory.create(query, model);
				res = qe.execAsk();
				if (res == true) {
					if (p.pref.contains("B- Preferable")) {
						vnf_score = vnf_score + WFP + WPrefB;

					} else if (p.pref.contains("C- Optional")) {
						vnf_score = vnf_score + WFP + WPrefC;
					}
				}

				// testqueryy tsqe=new testqueryy(finalquery);

				// System.out.println("the requested Transcoding operation is " + p.prop + " the
				// preference is :" + p.pref);
			}

			for (int i = 0; i < trTechlist.size(); i++) {
				Pair p = trTechlist.get(i);
				String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
						+ VNFConadidates.get(j) + ">"
						+ " viking:applies <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#" + p.prop + ">.}";
				//System.out.println("the ask query is " + testqe);
				Query query = QueryFactory.create(testqe);
				QueryExecution qe = QueryExecutionFactory.create(query, model);
				res = qe.execAsk();
				if (res == true) {
					if (p.pref.contains("B- Preferable")) {

						vnf_score = vnf_score + WFP + WPrefB;

					} else if (p.pref.contains("C- Optional")) {

						vnf_score = vnf_score + WFP + WPrefC;

					}
				}
				// System.out.println("the requested Transcoding technique is "+ p.prop +" the
				// preference is :"+p.pref);
			}

			for (int i = 0; i < trStdlist.size(); i++) {
				Pair p = trStdlist.get(i);
				String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
						+ VNFConadidates.get(j) + ">"
						+ " viking:supports <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#" + p.prop + ">.}";
				//System.out.println("the ask query is " + testqe);
				Query query = QueryFactory.create(testqe);
				QueryExecution qe = QueryExecutionFactory.create(query, model);
				res = qe.execAsk();
				if (res == true) {
					if (p.pref.contains("B- Preferable")) {

						vnf_score = vnf_score + WFP + WPrefB;

					} else if (p.pref.contains("C- Optional")) {

						vnf_score = vnf_score + WFP + WPrefC;

					}
				}
				// System.out.println("the requested Transcoding Standard is "+ p.prop +" the
				// preference is :"+p.pref);
			}

			for (int i = 0; i < trCtlist.size(); i++) {
				Pair p = trCtlist.get(i);
				String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
						+ VNFConadidates.get(j) + ">"
						+ " viking:delivers <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#" + p.prop + ">.}";
				//System.out.println("the ask query is " + testqe);
				Query query = QueryFactory.create(testqe);
				QueryExecution qe = QueryExecutionFactory.create(query, model);
				res = qe.execAsk();

				if (res == true) {
					if (p.pref.contains("B- Preferable")) {

						vnf_score = vnf_score + WFP + WPrefB;

					} else if (p.pref.contains("C- Optional")) {

						vnf_score = vnf_score + WFP + WPrefC;

					}
				}
			}
			// System.out.println("the requested Content is "+ p.prop +" the preference is
			// :"+p.pref);

			/*
			 * for (int i = 0; i < trCtAttlist.size(); i++) { Pair p = trCtAttlist.get(i);
			 * if (p.pref.contains("B- Preferable")) { nbPrefB++; } else if
			 * (p.pref.contains("C- Optional")) { nbPrefC++; } else if
			 * (p.pref.contains("A- Mandatory")) { Man_ctatt = Man_ctatt + prop_uri + p.prop
			 * + "> ,"; } // System.out.println("the requested Content Attributs is "+
			 * p.prop +" the // preference is :"+p.pref); } if (!trCtAttlist.isEmpty()) {
			 * Man_ctatt = "?vnf viking:supplies " + Man_ctatt.substring(0,
			 * Man_ctatt.length() - 1) + " .";
			 * 
			 * }
			 */
			if (i == true) {

				for (String s : trImageFormatI) {
					String[] parts = s.split("# ");
					String p0 = parts[0];
					String p = parts[1];
					String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ VNFConadidates.get(j) + ">"
							+ " viking:requires_ImageFormat <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ p0 + ">.}";
					//System.out.println("the ask query is " + testqe);
					Query query = QueryFactory.create(testqe);
					QueryExecution qe = QueryExecutionFactory.create(query, model);
					res = qe.execAsk();

					if (res == true) {
						if (p.contains("B- Preferable")) {

							vnf_score = vnf_score + WFP + WPrefB;

						} else if (p.contains("C- Optional")) {

							vnf_score = vnf_score + WFP + WPrefC;

						}
					}
					// System.out.println("the requested Input image format is "+ p0 +" the
					// preference is :"+p);
				}

				for (String s : trImageFormatO) {
					String[] parts = s.split("# ");
					String p0 = parts[0];

					String p = parts[1];
					String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ VNFConadidates.get(j) + ">"
							+ " viking:supplies_ImageFormat <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ p0 + ">.}";
					//System.out.println("the ask query is " + testqe);
					Query query = QueryFactory.create(testqe);
					QueryExecution qe = QueryExecutionFactory.create(query, model);
					res = qe.execAsk();
					if (res == true) {

						if (p.contains("B- Preferable")) {

							vnf_score = vnf_score + WFP + WPrefB;

						} else if (p.contains("C- Optional")) {
							vnf_score = vnf_score + WFP + WPrefC;
						}
					}
					// System.out.println("the requested Output image format is "+ p0 +" the
					// preference is :"+p);

				}

				for (String s : trImageResolutionI) {
					String[] parts = s.split("# ");
					String p0 = parts[0];
					String p = parts[1];
					String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ VNFConadidates.get(j) + ">"
							+ " viking:requires_ImageResolution <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ p0 + ">.}";
					//System.out.println("the ask query is " + testqe);
					Query query = QueryFactory.create(testqe);
					QueryExecution qe = QueryExecutionFactory.create(query, model);
					res = qe.execAsk();
					if (res == true) {
						if (p.contains("B- Preferable")) {
							vnf_score = vnf_score + WFP + WPrefB;

						} else if (p.contains("C- Optional")) {
							vnf_score = vnf_score + WFP + WPrefC;
						}

					}
					// System.out.println("the requested Input image Resolution is "+ p0 +" the
					// preference is :"+p);

				}

				for (String s : trImageResolutionO) {
					String[] parts = s.split("# ");
					String p0 = parts[0];
					String p = parts[1];
					String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ VNFConadidates.get(j) + ">"
							+ " viking:supplies_ImageResolution <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ p0 + ">.}";
					//System.out.println("the ask query is " + testqe);
					Query query = QueryFactory.create(testqe);
					QueryExecution qe = QueryExecutionFactory.create(query, model);
					res = qe.execAsk();
					if (res == true) {
						if (p.contains("B- Preferable")) {
							vnf_score = vnf_score + WFP + WPrefB;
						} else if (p.contains("C- Optional")) {
							vnf_score = vnf_score + WFP + WPrefC;
						}

					}

					// System.out.println("the requested Output image Resolution is "+ p0 +" the
					// preference is :"+p);

				}

			}
			if (v == true) {

				for (String s : trVideoFormatI) {
					String[] parts = s.split("# ");
					String p0 = parts[0];
					String p = parts[1];
					String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ VNFConadidates.get(j) + ">"
							+ " viking:requires_VideoFormat <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ p0 + ">.}";
					//System.out.println("the ask query is " + testqe);
					Query query = QueryFactory.create(testqe);
					QueryExecution qe = QueryExecutionFactory.create(query, model);
					res = qe.execAsk();
					if (res == true) {
						if (p.contains("B- Preferable")) {
							vnf_score = vnf_score + WFP + WPrefB;
						} else if (p.contains("C- Optional")) {
							vnf_score = vnf_score + WFP + WPrefC;
						}

					}
					// System.out.println("the requested Input Video Format is "+ p0 +" the
					// preference is :"+p);

				}

				for (String s : trVideoFormatO) {
					String[] parts = s.split("# ");
					String p0 = parts[0];

					String p = parts[1];
					String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ VNFConadidates.get(j) + ">"
							+ " viking:supplies_VideoFormat <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ p0 + ">.}";
					//System.out.println("the ask query is " + testqe);
					Query query = QueryFactory.create(testqe);
					QueryExecution qe = QueryExecutionFactory.create(query, model);
					res = qe.execAsk();
					if (res == true) {
						if (p.contains("B- Preferable")) {
							vnf_score = vnf_score + WFP + WPrefB;
						} else if (p.contains("C- Optional")) {
							vnf_score = vnf_score + WFP + WPrefC;
						}

					}
					// System.out.println("the requested Output Video Format is "+ p0 +" the
					// preference is :"+p);

				}

				for (String s : trVideoCodecI) {
					String[] parts = s.split("# ");
					String p0 = parts[0];

					String p = parts[1];
					String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ VNFConadidates.get(j) + ">"
							+ " viking:requires_VideoCodec <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ p0 + ">.}";
					//System.out.println("the ask query is " + testqe);
					Query query = QueryFactory.create(testqe);
					QueryExecution qe = QueryExecutionFactory.create(query, model);
					res = qe.execAsk();
					if (res == true) {
						if (p.contains("B- Preferable")) {
							vnf_score = vnf_score + WFP + WPrefB;
						} else if (p.contains("C- Optional")) {
							vnf_score = vnf_score + WFP + WPrefC;
						}
					}
					// System.out.println("the requested Input Video Codec is "+ p0 +" the
					// preference is :"+p);

				}

				for (String s : trVideoCodecO) {
					String[] parts = s.split("# ");
					String p0 = parts[0];

					String p = parts[1];
					String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ VNFConadidates.get(j) + ">"
							+ " viking:supplies_VideoCodec <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ p0 + ">.}";
				//	System.out.println("the ask query is " + testqe);
					Query query = QueryFactory.create(testqe);
					QueryExecution qe = QueryExecutionFactory.create(query, model);
					res = qe.execAsk();
					if (res == true) {
						if (p.contains("B- Preferable")) {
							vnf_score = vnf_score + WFP + WPrefB;
						} else if (p.contains("C- Optional")) {
							vnf_score = vnf_score + WFP + WPrefC;
						}
					}
					// System.out.println("the requested Output Video Codec is "+ p0 +" the
					// preference is :"+p);

				}
				for (String s : trVideoResolutionI) {
					String[] parts = s.split("# ");
					String p0 = parts[0];

					String p = parts[1];
					String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ VNFConadidates.get(j) + ">"
							+ " viking:requires_VideoResolution <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ p0 + ">.}";
					//System.out.println("the ask query is " + testqe);
					Query query = QueryFactory.create(testqe);
					QueryExecution qe = QueryExecutionFactory.create(query, model);
					res = qe.execAsk();
					if (res == true) {
						if (p.contains("B- Preferable")) {
							vnf_score = vnf_score + WFP + WPrefB;
						} else if (p.contains("C- Optional")) {
							vnf_score = vnf_score + WFP + WPrefC;
						}

					}
					// System.out.println("the requested Input Video Resolution is "+ p0 +" the
					// preference is :"+p);

				}

				for (String s : trVideoResolutionO) {
					String[] parts = s.split("# ");
					String p0 = parts[0];

					String p = parts[1];
					String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ VNFConadidates.get(j) + ">"
							+ " viking:supplies_VideoResolution <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ p0 + ">.}";
					//System.out.println("the ask query is " + testqe);
					Query query = QueryFactory.create(testqe);
					QueryExecution qe = QueryExecutionFactory.create(query, model);
					res = qe.execAsk();
					if (res == true) {
						if (p.contains("B- Preferable")) {
							vnf_score = vnf_score + WFP + WPrefB;
						} else if (p.contains("C- Optional")) {
							vnf_score = vnf_score + WFP + WPrefC;
						}
					}
					// System.out.println("the requested Output Video Resolution is "+ p0 +" the
					// preference is :"+p);
				}

			}
			if (a == true) {

				for (String s : trAudioFormatI) {
					String[] parts = s.split("# ");
					String p0 = parts[0];

					String p = parts[1];
					String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ VNFConadidates.get(j) + ">"
							+ " viking:requires_AudioFormat <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ p0 + ">.}";
					//System.out.println("the ask query is " + testqe);
					Query query = QueryFactory.create(testqe);
					QueryExecution qe = QueryExecutionFactory.create(query, model);
					res = qe.execAsk();
					if (res == true) {
						if (p.contains("B- Preferable")) {
							vnf_score = vnf_score + WFP + WPrefB;
						} else if (p.contains("C- Optional")) {
							vnf_score = vnf_score + WFP + WPrefC;
						}

					}
					// System.out.println("the requested Input Audio Format is "+ p0 +" the
					// preference is :"+p);

				}
				if (trAudioFormatI.length != 0) {
					Man_AFI = "?vnf viking:requires_AudioFormat " + Man_AFI.substring(0, Man_AFI.length() - 1) + " .";

				}
				for (String s : trAudioFormatO) {
					String[] parts = s.split("# ");
					String p0 = parts[0];

					String p = parts[1];
					String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ VNFConadidates.get(j) + ">"
							+ " viking:supplies_AudioFormat <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ p0 + ">.}";
					//System.out.println("the ask query is " + testqe);
					Query query = QueryFactory.create(testqe);
					QueryExecution qe = QueryExecutionFactory.create(query, model);
					res = qe.execAsk();
					if (res == true) {
						if (p.contains("B- Preferable")) {
							vnf_score = vnf_score + WFP + WPrefB;
						} else if (p.contains("C- Optional")) {
							vnf_score = vnf_score + WFP + WPrefC;
						}
					}
					// System.out.println("the requested Output Audio Format is "+ p0 +" the
					// preference is :"+p);

				}

				for (String s : trAudioCodecI) {
					String[] parts = s.split("# ");
					String p0 = parts[0];

					String p = parts[1];
					String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ VNFConadidates.get(j) + ">"
							+ " viking:requires_AudioCodec <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ p0 + ">.}";
					//System.out.println("the ask query is " + testqe);
					Query query = QueryFactory.create(testqe);
					QueryExecution qe = QueryExecutionFactory.create(query, model);
					res = qe.execAsk();
					if (res == true) {
						if (p.contains("B- Preferable")) {
							vnf_score = vnf_score + WFP + WPrefB;
						} else if (p.contains("C- Optional")) {
							vnf_score = vnf_score + WFP + WPrefC;
						}

					}
					// System.out.println("the requested Input Audio Codec is "+ p0 +" the
					// preference is :"+p);

				}

				for (String s : trAudioCodecO) {
					String[] parts = s.split("# ");
					String p0 = parts[0];

					String p = parts[1];
					String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ VNFConadidates.get(j) + ">"
							+ " viking:supplies_AudioCodec <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ p0 + ">.}";
					//System.out.println("the ask query is " + testqe);
					Query query = QueryFactory.create(testqe);
					QueryExecution qe = QueryExecutionFactory.create(query, model);
					res = qe.execAsk();
					if (res == true) {
						if (p.contains("B- Preferable")) {
							vnf_score = vnf_score + WFP + WPrefB;
						} else if (p.contains("C- Optional")) {
							vnf_score = vnf_score + WFP + WPrefC;
						}
					}
					// System.out.println("the requested Output Audio Codec is "+ p0 +" the
					// preference is :"+p);

				}

				for (String s : trAudioResolutionI) {
					String[] parts = s.split("# ");
					String p0 = parts[0];

					String p = parts[1];
					String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ VNFConadidates.get(j) + ">"
							+ " viking:requires_AudioResolution <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ p0 + ">.}";
					//System.out.println("the ask query is " + testqe);
					Query query = QueryFactory.create(testqe);
					QueryExecution qe = QueryExecutionFactory.create(query, model);
					res = qe.execAsk();
					if (res == true) {
						if (p.contains("B- Preferable")) {
							vnf_score = vnf_score + WFP + WPrefB;
						} else if (p.contains("C- Optional")) {
							vnf_score = vnf_score + WFP + WPrefC;
						}

					}
					// System.out.println("the requested Input Audio Resolution is "+ p0 +" the
					// preference is :"+p);

				}

				for (String s : trAudioResolutionO) {
					String[] parts = s.split("# ");
					String p0 = parts[0];

					String p = parts[1];
					String testqe = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> ASK  WHERE {<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ VNFConadidates.get(j) + ">"
							+ " viking:supplies_AudioResolution <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#"
							+ p0 + ">.}";
					//System.out.println("the ask query is " + testqe);
					Query query = QueryFactory.create(testqe);
					QueryExecution qe = QueryExecutionFactory.create(query, model);
					res = qe.execAsk();
					if (res == true) {
						if (p.contains("B- Preferable")) {
							vnf_score = vnf_score + WFP + WPrefB;
						} else if (p.contains("C- Optional")) {
							vnf_score = vnf_score + WFP + WPrefC;
						}

					}
					// System.out.println("the requested Output Audio Resolution is "+ p0 +" the
					// preference is :"+p);

				}

			}

			vnf_sc = new VNFandScore(VNFConadidates.get(j), vnf_score);

		}

	}

}
