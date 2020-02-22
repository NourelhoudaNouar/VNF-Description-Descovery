import java.util.ArrayList;

public class CpPropCalWeights {
	ArrayList<Pair> cpstand, cptechnique, cpoperation, cpCtlist;
	String cpmaxsize;
	ArrayList<Pair> devices, features;
	String price, cpu, memory, network, storage;
	
	int nbFP, nbPrefB, nbPrefC, nbNFP;
	double WFP, WNFP, WPrefB, WPrefC, WPref, gwfp, gwnfp, gwpref;

	public CpPropCalWeights(ArrayList<Pair> cpstand, ArrayList<Pair> cptechnique, ArrayList<Pair> cpoperation,
			ArrayList<Pair> cpCtlist, String cpmaxsize, ArrayList<Pair> devices, ArrayList<Pair> features, String price,
			String cpu, String memory, String network, String storage, int gwfp, int gwnfp, int gwpref) {
		this.cpstand = cpstand;
		this.cpoperation = cpoperation;
		this.cptechnique = cptechnique;
		this.cpCtlist = cpCtlist;
		this.cpmaxsize=cpmaxsize;
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
		
		for (int i = 0; i < cptechnique.size(); i++) {
			Pair p = cptechnique.get(i);
			System.out.println(" the compressor techniques requested are : " + p.prop);
		}
		for (int i = 0; i < cpoperation.size(); i++) {
			Pair p = cpoperation.get(i);
			System.out.println(" the compressor operations requested are : " + p.prop);
		}
		for (int i = 0; i < cpstand.size(); i++) {
			Pair p = cpstand.get(i);
			System.out.println(" the compressor standards requested are : " + p.prop);
		}
		for (int i = 0; i < cpCtlist.size(); i++) {
			Pair p = cpCtlist.get(i);
			System.out.println(" the compressor Contents requested are : " + p.prop);
		}
		
		if (!cpmaxsize.isEmpty()) {
			nbFP++;
		}
		
		nbFP=nbFP+cptechnique.size()+cpoperation.size()+cpstand.size()+cpCtlist.size();
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
		if (!cpmaxsize.isEmpty()) {
			String[] ps = cpmaxsize.split("# ");
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
		
		for (int i = 0; i < cptechnique.size(); i++) {
			Pair p = cptechnique.get(i);
			if (p.pref.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.pref.contains("C- Optional")) {
				nbPrefC++;
			}
		}
		for (int i = 0; i < cpoperation.size(); i++) {
			Pair p = cpoperation.get(i);
			if (p.pref.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.pref.contains("C- Optional")) {
				nbPrefC++;
			}
		}
		for (int i = 0; i < cpstand.size(); i++) {
			Pair p = cpstand.get(i);
			if (p.pref.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.pref.contains("C- Optional")) {
				nbPrefC++;
			}
		}
		for (int i = 0; i <cpCtlist.size(); i++) {
			Pair p = cpCtlist.get(i);
			if (p.pref.contains("B- Preferable")) {
				nbPrefB++;
			} else if (p.pref.contains("C- Optional")) {
				nbPrefC++;
			}
		}
	}

}
