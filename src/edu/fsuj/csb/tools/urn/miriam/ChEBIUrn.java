package edu.fsuj.csb.tools.urn.miriam;

import java.util.zip.DataFormatException;


public class ChEBIUrn extends MiriamUrn {

	public ChEBIUrn(String code) throws DataFormatException {
	  super("obo.chebi","CHEBI:"+code);
  }

}
