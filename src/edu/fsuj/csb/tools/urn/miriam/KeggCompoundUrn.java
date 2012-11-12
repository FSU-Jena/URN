package edu.fsuj.csb.tools.urn.miriam;

import java.util.zip.DataFormatException;



/**
 * provide a urn class for kegg compounds
 * @author Stephan Richter
 *
 */
public class KeggCompoundUrn extends KeggUrn {


	/**
	 * create a new kegg urn for a compound
	 * @param code the kegg compound code
	 * @throws DataFormatException
	 */
	public KeggCompoundUrn(String code) throws DataFormatException {
	  super("kegg.compound",code);
  }
}
