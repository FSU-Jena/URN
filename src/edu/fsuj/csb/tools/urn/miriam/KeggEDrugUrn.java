package edu.fsuj.csb.tools.urn.miriam;

import java.util.zip.DataFormatException;


/**
 * provide a urn class for kegg environmental drugs
 * @author Stephan Richter
 *
 */
public class KeggEDrugUrn extends KeggUrn {

	/**
	 * create a new urn instance
	 * @param code the kegg environ code
	 * @throws DataFormatException
	 */
	public KeggEDrugUrn(String code) throws DataFormatException {
	  super("kegg.environ",code);	  
  }
}
