package edu.fsuj.csb.tools.urn.miriam;

import java.util.zip.DataFormatException;


public class PubChemCompoundUrn extends MiriamUrn {

	public PubChemCompoundUrn(int code) throws DataFormatException {
	  super("pubchem.compound",""+code);
  }

	public PubChemCompoundUrn(String code) throws NumberFormatException, DataFormatException {
		this(Integer.parseInt(code));
  }

}
