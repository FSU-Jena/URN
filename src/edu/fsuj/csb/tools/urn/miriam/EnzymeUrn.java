package edu.fsuj.csb.tools.urn.miriam;

import java.util.zip.DataFormatException;


/**
 * provides a urn class for enzymes
 * @author Stephan Richter
 *
 */
public class EnzymeUrn extends KeggUrn {

	/**
	 * create a new urn instance
	 * @param ecCode the ec code of the enzyme
	 * @throws DataFormatException
	 */
	public EnzymeUrn(String ecCode) throws DataFormatException {
	  super("ec-code",ecCode);
  }
}
