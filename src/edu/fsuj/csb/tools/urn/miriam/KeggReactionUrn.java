package edu.fsuj.csb.tools.urn.miriam;

import java.util.zip.DataFormatException;


/**
 * provides an urn class for kegg reactions
 * @author Stephan Richter
 *
 */
public class KeggReactionUrn extends KeggUrn {

	/**
	 * create a new instance
	 * @param code the kegg reaction code
	 * @throws DataFormatException
	 */
	public KeggReactionUrn(String code) throws DataFormatException {
	  super("kegg.reaction",code);
	}
}
