package edu.fsuj.csb.tools.urn.miriam;

import java.util.zip.DataFormatException;


public class PubChemSubstanceUrn extends MiriamUrn {

	public PubChemSubstanceUrn(int code) throws DataFormatException {
	  super("pubchem.substance",""+code);
  }

	public PubChemSubstanceUrn(String code) throws NumberFormatException, DataFormatException {
		this(Integer.parseInt(code));
  }

}
