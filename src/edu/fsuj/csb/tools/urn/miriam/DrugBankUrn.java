package edu.fsuj.csb.tools.urn.miriam;

import java.util.zip.DataFormatException;


public class DrugBankUrn extends MiriamUrn {

	public DrugBankUrn(String code) throws DataFormatException {
	  super("drugbank",code);
  }

}
