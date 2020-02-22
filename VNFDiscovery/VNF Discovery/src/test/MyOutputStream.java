package test;

import java.io.OutputStream;

public class MyOutputStream extends OutputStream {
StringBuffer buf;

public MyOutputStream() {
	buf=new StringBuffer();
}

public void write(int character) {
	buf.append((char)character);
}
public String getstring() {
	return buf.toString();
	
}

}
