package visundGUI;

import org.semanticweb.owlapi.model.OWLOntologyStorageException;

public class TemporarySaveInfo {
	String[] trAudioFI, trAudioFO, trAudioCI, trAudioCO, trAudioRI, trAudioRO, trVideoFI, trVideoFO, trVideoCI,
	trVideoCO, trVideoRI, trVideoRO, trImageFI, trImageFO, trImageCI, trImageCO, trImageRI, trImageRO;
String trVideoBMnI, trVideoBMnO, trVideoBMxI, trVideoBMxO, trImageBMnI, trImageBMnO, trImageBMxI, trImageBMxO,
	trAudioBMnI, trAudioBMnO, trAudioBMxI, trAudioBMxO;
	VikingManip VM=new VikingManip();
	public TemporarySaveInfo() {
		
	}
	public TemporarySaveInfo(String[] trAudioFI,String[] trAudioFO, String[] trAudioCI,String[] trAudioCO,String[] trAudioRI, String[]trAudioRO, String trAudioBMnI, String trAudioBMnO, String trAudioBMxI, String trAudioBMxO,
			String[] trVideoFI, String[] trVideoFO,String[] trVideoCI,String[] trVideoCO,String[] trVideoRI,String[] trVideoRO,String trVideoBMnI,String trVideoBMnO,String trVideoBMxI,String trVideoBMxO,
			String[] trImageFI,String[] trImageFO,String[] trImageCI,String[] trImageCO,String[] trImageRI,String[] trImageRO,String trImageBMnI,String trImageBMnO,String trImageBMxI,String trImageBMxO) {
		super();
		this.trVideoFI = trVideoFI;
		this.trVideoCI = trVideoCI;
		this.trVideoRI = trVideoRI;
		this.trVideoBMnI = trVideoBMnI;
		this.trVideoBMxI = trVideoBMxI;

		this.trVideoFO = trVideoFO;
		this.trVideoFO = trVideoFO;
		this.trVideoRO = trVideoRO;
		this.trVideoBMnO = trVideoBMnO;
		this.trVideoBMxO = trVideoBMxO;

		this.trImageFI = trImageFI;
		this.trImageCI = trImageCI;
		this.trImageRI = trImageRI;
		this.trImageBMnI = trImageBMnI;
		this.trImageBMxI = trImageBMxI;

		this.trImageFO = trImageFO;
		this.trImageCO = trImageCO;
		this.trImageRO = trImageRO;
		this.trImageBMnO = trImageBMnO;
		this.trImageBMxO = trImageBMxO;

		this.trAudioFI = trAudioFI;
		this.trAudioCI = trAudioCI;
		this.trAudioRI = trAudioRI;
		this.trAudioBMnI = trAudioBMnI;
		this.trAudioBMxI = trAudioBMxI;

		this.trAudioFO = trAudioFO;
		this.trAudioCO = trAudioCO ;
		this.trAudioRO = trAudioRO;
		this.trAudioBMnO = trAudioBMnO;
		this.trAudioBMxO = trAudioBMxO ;
		System.out.println("c bn");
	
	}
	
	public void settrVideoIOinfo(String vnfnm) throws OWLOntologyStorageException {
		for (int i= 0; i < trVideoFI.length; i++) {
			System.out.println(trVideoFI[i]);
			//VM.setTrVideoFormatI(vnfnm, trVideoFI[i]);	
		}
		
		for (int i= 0; i < trVideoFO.length; i++) {
			VM.setTrVideoFormatO(vnfnm, trVideoFO[i]);	
		}
		for (int i= 0; i < trVideoCI.length; i++) {
			VM.setTrVideoCodecI(vnfnm, trVideoCI[i]);	
		}
		
		for (int i= 0; i < trVideoCO.length; i++) {
			VM.setTrVideoCodecO(vnfnm, trVideoCO[i]);	
		}
		for (int i= 0; i < trVideoRI.length; i++) {
			VM.setTrVideoResolutionI(vnfnm, trVideoRI[i]);	
		}
		
		for (int i= 0; i < trVideoRO.length; i++) {
			VM.setTrVideoResolutionO(vnfnm, trVideoRO[i]);	
		}
		VM.setTrVideoBitrateI(vnfnm, "["+trVideoBMnI+","+trVideoBMxI+"]");
		VM.setTrVideoBitrateO(vnfnm, "["+trVideoBMnO+","+trVideoBMxO+"]");
	}

}
