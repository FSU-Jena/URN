package edu.fsuj.csb.tools.urn.miriam;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.TreeSet;
import java.util.zip.DataFormatException;

import edu.fsuj.csb.tools.urn.URN;
import edu.fsuj.csb.tools.xml.CachedXMLReader;
import edu.fsuj.csb.tools.xml.NoTokenException;
import edu.fsuj.csb.tools.xml.Tools;
import edu.fsuj.csb.tools.xml.XMLReader;
import edu.fsuj.csb.tools.xml.XmlToken;

/**
 * provides a basic class for urns described by the miriam registry
 * @author Stephan Richter
 *
 */
public class MiriamUrn extends URN {
	
	private String ns=null;
	private TreeSet<URL> urls;

	/**
	 * create a new url instance within the miriam top level namespace
	 * @param namespace the namespace below the top level
	 * @param code the rest of the urn code
	 * @throws DataFormatException
	 */
	public MiriamUrn(String namespace,String code) throws DataFormatException {
	  super("miriam",namespace+":"+code);
	  ns=namespace;
  }
	
	/**
	 * create a new miriam urn with fully specified namespace
	 * @param urnString the fully qualified namespace
	 * @throws DataFormatException
	 */
	public MiriamUrn(String urnString) throws DataFormatException {
		super(convert(urnString));
  }

	private static String convert(String urnString) {
		if (urnString.startsWith("http://identifiers.org"))return urnString.replace("http://identifiers.org", "urn:miriam").replace('/', ':').trim();
	  return urnString;
  }

	/**
	 * @return the code part of the namespace
	 */
	public String code(){
		return namespace().substring(ns.length()+1);
	}

  /* (non-Javadoc)
   * @see edu.fsuj.csb.tools.urn.URN#urls()
   */
  public TreeSet<URL> urls() throws MalformedURLException {
  	if (urls!=null) return urls;
		urls=Tools.URLSet();
  	if (nid().equals("file")) return null;
  	String urn = get();
/*  	if (urn.contains("knapsack")){
  		int i=urn.lastIndexOf(':');
  		URL url = new URL("http://kanaya.naist.jp/knapsack_jsp/information.jsp?sname=C_ID&word="+urn.substring(i+1));
  		urls.add(url);
  		Tools.warnOnce("MiriamUrn.urls() overriding Miriam Registry Resolve script for "+urn+"!!!\nResult: "+urls);
			return urls;
  	}*/
		URL url=new URL("http://www.ebi.ac.uk/miriamws/main/rest/resolve/"+urn);
		XMLReader xmlr;
		XmlToken token;
    try {
	    xmlr = new CachedXMLReader(url);
	    token = xmlr.readToken();
			if (token.instanceOf("uris")) {
				urls=urlsOf(token);
				return urls;
			}
    } catch (IOException e) {
	    Tools.warn("Input output error on "+url);
	    return null;
    } catch (NoTokenException e) {
	    e.printStackTrace();
    }
		return null;
  }

	/**
	 * tries to find urls within a given xml token
	 * @param token the token to be inspected
	 * @return the set of urls found
	 * @throws MalformedURLException
	 */
	private TreeSet<URL> urlsOf(XmlToken token) throws MalformedURLException {
	  TreeSet<URL> result=null;		
		for (XmlToken subtoken: token.subtokens()){
			if (subtoken.instanceOf("uri")){
				if (subtoken.getValue("type").equals("URL")){
					if (result==null) result=Tools.URLSet();
					String dummy=Tools.removeHtml(subtoken.content());
					result.add(new URL(dummy));
					
					/* the following code adds the url to the rest page */
					if (dummy.contains("http://www.genome.jp/dbget-bin/www_bget")){
						dummy=dummy.replace("http://www.genome.jp/dbget-bin/www_bget", "");
						int pos=dummy.indexOf(':');
						if (pos>-1) dummy=dummy.substring(pos+1);
						dummy="http://rest.kegg.jp/get/"+dummy;
					}
					result.add(new URL(dummy));
					/*  end rest */
					
				} else System.err.println("found uri token, with type ≠ URL!");
			} else System.err.println("found "+subtoken.tokenClass()+" token!");
		}
		return result;
  }
	
	public static void main(String[] args) throws DataFormatException {
	  System.out.println(new MiriamUrn("http://identifiers.org/biomodels.db/BIOMD0000000091"));
  }
}
