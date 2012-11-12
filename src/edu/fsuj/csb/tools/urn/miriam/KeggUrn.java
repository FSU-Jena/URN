package edu.fsuj.csb.tools.urn.miriam;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.TreeSet;
import java.util.zip.DataFormatException;

import edu.fsuj.csb.tools.newtork.pagefetcher.PageFetcher;

/**
 * a subclass of miriam registry urns for kegg entities
 * @author Stephan Richter
 *
 */
public abstract class KeggUrn extends MiriamUrn {

	/**
	 * create a new instance by providing a qualifier
	 * @param string the qualifier, like "kegg.reaction:R00001" or "kegg.compound:C00001"
	 * @throws DataFormatException
	 */
	public KeggUrn(String string) throws DataFormatException {
	  super(string);
  }
	
	/**
	 * @param nid the kegg qualifier
	 * @param namespace the kegg code of the compound
	 * @throws DataFormatException
	 */
	public KeggUrn(String nid, String namespace) throws DataFormatException {
		super(nid,namespace);
  }

	/**
	 * @return the url related to the kegg compound
	 * @throws MalformedURLException
	 */
	public URL url() throws MalformedURLException{
	  return new URL("http://www.genome.jp/dbget-bin/www_bget?"+code());
	}
	
	/* (non-Javadoc)
	 * @see edu.fsuj.csb.tools.urn.MiriamUrn#urls()
	 */
	@Override
	public TreeSet<URL> urls() throws MalformedURLException {
		TreeSet<URL> result = super.urls();
		result.add(url());	 
	  return result;
	}

	/**
	 * @return the page code for the given compound
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public String fetch() throws MalformedURLException, IOException {
	  return PageFetcher.fetch(url()).toString();
  }
}
