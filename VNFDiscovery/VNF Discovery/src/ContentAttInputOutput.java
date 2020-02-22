import java.util.ArrayList;

public class ContentAttInputOutput {

	elementIO Format;
	elementIO Codec;
	elementIO Resolution;
	elementIO Bitrate;
	public ContentAttInputOutput(elementIO trVFIO,elementIO trACIO,elementIO trVRIO,elementIO trVBIO) {
		this.Format=trVFIO;
		this.Codec=trACIO;
		this.Resolution=trVRIO;
		this.Bitrate=trVBIO;
	}
}
