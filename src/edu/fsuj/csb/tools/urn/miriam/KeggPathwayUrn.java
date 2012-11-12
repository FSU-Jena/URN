package edu.fsuj.csb.tools.urn.miriam;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.DataFormatException;


/**
 * provides a class for kegg pathways
 * @author Stephan Richter
 *
 */
public class KeggPathwayUrn extends MiriamUrn {

	/**
	 * creates a new urn instance
	 * @param code the kegg pathway code
	 * @throws DataFormatException
	 */
	public KeggPathwayUrn(String code) throws DataFormatException {
		super("kegg.pathway",code);		
  }
	
	/**
	 * @return the special kegg pathway url
	 * @throws MalformedURLException
	 */
	public URL url() throws MalformedURLException {
	  return new URL("http://www.genome.ad.jp/dbget-bin/www_bget?pathway+"+code());
	}

}
