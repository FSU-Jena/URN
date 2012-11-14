package edu.fsuj.csb.tools.urn.miriam;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.TreeSet;
import java.util.zip.DataFormatException;

import edu.fsuj.csb.tools.newtork.pagefetcher.PageFetcher;
import edu.fsuj.csb.tools.xml.Tools;

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
		Tools.startMethod("url()");
		URL result=new URL("http://www.genome.jp/dbget-bin/www_bget?"+code());
		Tools.endMethod(result);
	  return result;
	}
	
	/* (non-Javadoc)
	 * @see edu.fsuj.csb.tools.urn.MiriamUrn#urls()
	 */
	@Override
	public TreeSet<URL> urls() throws MalformedURLException {
		Tools.startMethod("KeggUrn.urls()");
		TreeSet<URL> result = super.urls();
		result.add(url());
		Tools.endMethod(result);
	  return result;
	}

	/**
	 * @return the page code for the given compound
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public String fetch() throws MalformedURLException, IOException {
		Tools.startMethod("KeggUrn.fetch()");
		String result = PageFetcher.fetch(url()).toString();
		Tools.endMethod();
	  return result; 
  }
}
