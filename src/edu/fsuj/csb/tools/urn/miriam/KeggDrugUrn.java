package edu.fsuj.csb.tools.urn.miriam;

import java.util.zip.DataFormatException;


/**
 * provide a urn class for kegg drugs
 * @author Stephan Richter
 *
 */
public class KeggDrugUrn extends KeggUrn {

	/**
	 * create a new urn instance
	 * @param code the kegg drug code
	 * @throws DataFormatException
	 */
	public KeggDrugUrn(String code) throws DataFormatException {
	  super("kegg.drug",code);

	  
  }

}
