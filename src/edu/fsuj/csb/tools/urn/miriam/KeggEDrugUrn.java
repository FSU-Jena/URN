package edu.fsuj.csb.tools.urn.miriam;

import java.util.zip.DataFormatException;


/**
 * provide a urn class for kegg drugs
 * @author Stephan Richter
 *
 */
public class KeggEDrugUrn extends KeggUrn {

	/**
	 * create a new urn instance
	 * @param code the kegg drug code
	 * @throws DataFormatException
	 */
	public KeggEDrugUrn(String code) throws DataFormatException {
	  super("kegg.edrug",code);	  
  }
}
