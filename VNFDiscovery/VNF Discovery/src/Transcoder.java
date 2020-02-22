import java.util.ArrayList;

public class Transcoder {
	ArrayList<Pair> TrOplist, TrTechlist, TrSdlist, TrCtlist, TrCtAttlist;
	ContentInputOutput CtIO;
	public Transcoder(ArrayList<Pair> TrOplist, ArrayList<Pair>TrTechlist,ArrayList<Pair> TrSdlist, ArrayList<Pair>TrCtlist, ArrayList<Pair>TrCtAttlist,ContentInputOutput ctIO2) {
		this.TrOplist=TrOplist;
		
		this.TrTechlist=TrTechlist;
		this.TrSdlist=TrSdlist;
		this.TrCtlist=TrCtlist;
		this.TrCtAttlist=TrCtAttlist;
		this.CtIO=ctIO2;
	}
}
