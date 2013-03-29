package edu.fsuj.csb.tools.urn.miriam;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.DataFormatException;

import edu.fsuj.csb.tools.newtork.pagefetcher.PageFetcher;

/**
 * provides a urn class for kegg organisms/genomes
 * @author Stephan Richter
 *
 */
public class KeggGenomeUrn extends MiriamUrn {
	
	/**
	 * create a new urn instance
	 * @param orgCode the kegg organism code
	 * @throws DataFormatException
	 */
	public KeggGenomeUrn(String orgCode) throws DataFormatException {
		super("kegg.genome",orgCode);		
  }
	
	/**
	 * @return the special kegg organism data page url
	 * @throws MalformedURLException
	 */
	public URL url() throws MalformedURLException{		
		return new URL("http://www.genome.jp/kegg-bin/show_organism?menu_type=pathway_maps&org=" + code());
	}
	
	/**
	 * @return the special kegg organism api data page url
	 * @throws MalformedURLException
	 */
	public URL apiUrl() throws MalformedURLException{		
		return new URL("http://rest.kegg.jp/list/pathway/" + code());
	}

	/**
	 * @return the set of code lines of the kegg organism data page
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public String[] fetchLines() throws MalformedURLException, IOException {
		return PageFetcher.fetchLines(url());
  }

	public String[] getFromApi() throws MalformedURLException, IOException {
		return PageFetcher.fetchLines(apiUrl());
	}
}
