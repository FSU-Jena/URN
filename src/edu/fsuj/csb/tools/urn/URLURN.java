package edu.fsuj.csb.tools.urn;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.TreeSet;
import java.util.zip.DataFormatException;

import edu.fsuj.csb.tools.xml.Tools;

/**
 * provides a class for storing urls in urns
 * @author Stephan Richter
 *
 */
public class URLURN extends URN {

	/**
	 * creates a new url urn containing the given url
	 * @param url the url to be stored
	 * @throws DataFormatException
	 */
	public URLURN(URL url) throws DataFormatException {
	  super("url",url.toString());
  }

	/* (non-Javadoc)
	 * @see edu.fsuj.csb.tools.urn.URN#urls()
	 */
	@Override
	public Set<URL> urls() throws MalformedURLException {
		TreeSet<URL> result=Tools.URLSet();
		result.add(url());
		return result;
	}

	/**
	 * @return the url stored in the urn
	 * @throws MalformedURLException
	 */
	public URL url() throws MalformedURLException {
	  return new URL(namespace());
  }
	
	
}
