import java.util.ArrayList;

public class MxPropCalWeights {
	ArrayList<Pair> mxtechnique, mxoperation, MxCtlist, devices, features;
	String price, cpu, memory, network, storage;
	double WFP, WNFP, WPrefB, WPrefC, WPref, gwfp, gwnfp, gwpref;
	int nbFP, nbPrefB, nbPrefC, nbNFP;
	String[] querylist;

	public MxPropCalWeights(ArrayList<Pair> mxtechnique, ArrayList<Pair> mxoperation, ArrayList<Pair> MxCtlist,
			ArrayList<Pair> devices, ArrayList<Pair> features, String price, String cpu, String memory, String network,
			String storage, int gwfp, int gwnfp, int gwpref) {
		this.mxtechnique=mxtechnique;
		this.mxoperation=mxoperation;
		this.MxCtlist=MxCtlist;
		this.devices=devices;
		this.features=features;
		this.price=price;
		this.cpu=cpu;
		this.memory=memory;
		this.network=network;
		this.storage=storage;
		this.gwfp=gwfp;
		this.gwnfp=gwnfp;
		this.gwpref=gwpref;

	}

	public void calculateWFP() {
		String opqe= " viking:implements ";
		String opqe1 = null;
		String query="PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX viking: <http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#> SELECT DISTINCT ?s  WHERE{ ?s ";
		
		String elementuri="<http://www.semanticweb.org/pc/ontologies/2018/3/VIKING#";
		ArrayList<String> ar = new ArrayList<String>();
		ar.add(query);
		for (int i = 0; i < mxtechnique.size(); i++) {
			Pair p = mxtechnique.get(i);
			System.out.println(" the Mixer techniques requested are : " + p.prop);
			elementuri=elementuri+p.prop+">";
			ar.add(elementuri);
			System.out.println(" the Mixer query is : " + query + elementuri);
		}
		for (int i = 0; i < mxoperation.size(); i++) {
			Pair p = mxoperation.get(i);
			System.out.println(" the Mixer operations requested are : " + p.prop);
			if (i==mxoperation.size()-1) {
				opqe1=opqe1+ elementuri+p.prop+"> ,";
			}else {opqe1=opqe1+ elementuri+p.prop+"> .";}
				
			
		}
		
		System.out.println(query + opqe +opqe1);
		
		for (int i = 0; i < MxCtlist.size(); i++) {
			Pair p = MxCtlist.get(i);
			System.out.println(" the Mixer Contents requested are : " + p.prop);
		}
		
		
		nbFP=mxtechnique.size()+mxoperation.size()+MxCtlist.size();
		System.out.println("the number of FP is: " + nbFP);
		WFP = gwfp / nbFP;
		System.out.println("the weight of FP is: " + WFP);
	}

	public void calculateWNFP() {
		if (!price.isEmpty()) {
			nbNFP++;
		}
		if (!cpu.isEmpty()) {
			nbNFP++;
		}
		if (!memory.isEmpty()) {
			nbNFP++;
		}
		if (!network.isEmpty()) {
			nbNFP++;
		}
		if (!storage.isEmpty()) {
			nbNFP++;
		}
		
		nbNFP =nbNFP+devices.size()+features.size() ;
		System.out.println("the number of NFP is: " + nbNFP);
		WNFP = gwnfp / nbNFP;
		System.out.println("the weight of NFP is: " + WNFP);
	}

	public void calculateWPref() {
		if (!price.isEmpty()) {
			String[] ps = price.split("# ");
			String p = ps[1];
			if (p.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.contains("C- Optional")) {
				nbPrefC++;
			}
			
		}
		if (!cpu.isEmpty()) {
			String[] ps = price.split("# ");
			String p = ps[1];
			if (p.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.contains("C- Optional")) {
				nbPrefC++;
			}
		}
		if (!memory.isEmpty()) {
			String[] ps = memory.split("# ");
			String p = ps[1];
			if (p.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.contains("C- Optional")) {
				nbPrefC++;
			}
		}
		if (!network.isEmpty()) {
			String[] ps = network.split("# ");
			String p = ps[1];
			if (p.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.contains("C- Optional")) {
				nbPrefC++;
			}
		}
		if (!storage.isEmpty()) {
			String[] ps = storage.split("# ");
			String p = ps[1];
			if (p.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.contains("C- Optional")) {
				nbPrefC++;
			}
		}
		
		for (int i = 0; i < devices.size(); i++) {
			Pair p = devices.get(i);
			if (p.pref.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.pref.contains("C- Optional")) {
				nbPrefC++;
			}
		}
		for (int i = 0; i < features.size(); i++) {
			Pair p = features.get(i);
			if (p.pref.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.pref.contains("C- Optional")) {
				nbPrefC++;
			}
		}
		
		for (int i = 0; i < mxtechnique.size(); i++) {
			Pair p = mxtechnique.get(i);
			if (p.pref.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.pref.contains("C- Optional")) {
				nbPrefC++;
			}
		}
		for (int i = 0; i < mxoperation.size(); i++) {
			Pair p = mxoperation.get(i);
			if (p.pref.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.pref.contains("C- Optional")) {
				nbPrefC++;
			}
		}
		for (int i = 0; i < MxCtlist.size(); i++) {
			Pair p = MxCtlist.get(i);
			if (p.pref.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.pref.contains("C- Optional")) {
				nbPrefC++;
			}
		}
	}

}
