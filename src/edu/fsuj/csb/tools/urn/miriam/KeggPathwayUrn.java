package edu.fsuj.csb.tools.urn.miriam;

import java.util.zip.DataFormatException;


/**
 * provides a class for kegg pathways
 * @author Stephan Richter
 *
 */
public class KeggPathwayUrn extends KeggUrn {

	/**
	 * creates a new urn instance
	 * @param code the kegg pathway code
	 * @throws DataFormatException
	 */
	public KeggPathwayUrn(String code) throws DataFormatException {
		super("kegg.pathway",code);		
  }
}
