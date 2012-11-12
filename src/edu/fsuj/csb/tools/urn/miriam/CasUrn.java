package edu.fsuj.csb.tools.urn.miriam;

import java.util.zip.DataFormatException;


public class CasUrn extends MiriamUrn {

	public CasUrn(String code) throws DataFormatException {
	  super("cas",code);
  }

}
