package edu.fsuj.csb.tools.urn;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.zip.DataFormatException;



public class FileUrn extends URN {

	public FileUrn(String namespace) throws DataFormatException {
	  super("file",namespace);
  }

	@Override
	public Set<URL> urls() throws MalformedURLException {
		return null;
	}

}
