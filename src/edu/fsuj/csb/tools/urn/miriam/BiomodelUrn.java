package edu.fsuj.csb.tools.urn.miriam;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.DataFormatException;


/**
 * provides an urn class for biomodel urns
 * @author Stephan Richter
 *
 */
public class BiomodelUrn extends MiriamUrn {

	/**
	 * creates a new instance
	 * @param number the biomodel number, e.g. 48
	 * @throws DataFormatException
	 */
	public BiomodelUrn(int number) throws DataFormatException{
		super("biomodels.db","BIOMD"+(new java.text.DecimalFormat("0000000000")).format(number));
	}
	/**
	 * creates a new urn instance
	 * @param code the biomodel code, e.g. BIOMD0000000048
	 * @throws DataFormatException
	 */
	public BiomodelUrn(String code) throws DataFormatException {
	  super("biomodels.db",code);
  }

	/**
	 * @return the url, from which the biomodel can be downloaded
	 * @throws MalformedURLException
	 */
	public URL downloadUrl() throws MalformedURLException{
		return new URL("http://www.ebi.ac.uk/biomodels-main/download?mid="+code());
	}
}
