package edu.fsuj.csb.tools.urn.miriam;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.DataFormatException;


/**
 * provides a urn class for enzymes
 * @author Stephan Richter
 *
 */
public class EnzymeUrn extends MiriamUrn {

	/**
	 * create a new urn instance
	 * @param ecCode the ec code of the enzyme
	 * @throws DataFormatException
	 */
	public EnzymeUrn(String ecCode) throws DataFormatException {
	  super("ec-code",ecCode);
  }
	
	/**
	 * @return the kegg url of the given enzyme
	 * @throws MalformedURLException
	 */
	public URL keggUrl() throws MalformedURLException{ // this method is kept, as it allows direct url acces without searching through the urls() set
		return new URL("http://www.genome.jp/dbget-bin/www_bget?"+code()); 
	}
}
