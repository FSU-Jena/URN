package edu.fsuj.csb.tools.urn.miriam;

import java.util.zip.DataFormatException;


public class JcsdUrn extends MiriamUrn {

	public JcsdUrn(String code) throws DataFormatException {
	  super("jcsd",code);
  }

}
