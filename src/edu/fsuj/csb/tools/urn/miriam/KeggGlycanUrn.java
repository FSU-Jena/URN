package edu.fsuj.csb.tools.urn.miriam;

import java.util.zip.DataFormatException;



/**
 * provides a urn class for kegg glycans
 * @author Stephan Richter
 *
 */
public class KeggGlycanUrn extends KeggUrn {


	/**
	 * create a new urn instance
	 * @param code the kegg glycan code
	 * @throws DataFormatException
	 */
	public KeggGlycanUrn(String code) throws DataFormatException {
	  super("kegg.glycan",code);
  }
}
