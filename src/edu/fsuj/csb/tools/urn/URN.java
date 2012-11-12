package edu.fsuj.csb.tools.urn;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.TreeSet;
import java.util.zip.DataFormatException;

import edu.fsuj.csb.tools.xml.ObjectComparator;

/**
 * this class ist the base class for the Miriam Registry URNS
 * @author Stephan Richter
 *
 */
public abstract class URN {
	private String nid; // holds the NID
	private String namespace; // holds the particular namespace
	
	/**
	 * creates a new URN object from the complete urn string
	 * @param urn the complete urn string
	 * @throws DataFormatException if urn string is not properly formatted
	 */
	public URN(String urn) throws DataFormatException {
		urn=urn.replace("%3A", ":");
		int firstColon=urn.indexOf(':');
		if (firstColon<0) throw new DataFormatException(urn+" is not a valid urn: colon missing!");
		String dummy=urn.substring(0,firstColon);
		if (!dummy.equals("urn"))throw new DataFormatException(urn+" is not a valid urn: has to begin with \"urn:\"!");
		dummy=urn.substring(firstColon+1);
		firstColon=dummy.indexOf(':');
		if (firstColon<0) throw new DataFormatException(urn+" is not a valid urn: second colon missing!");
		nid=dummy.substring(0,firstColon);
		namespace=dummy.substring(firstColon+1);
  }
	
	/**
	 * creates a urn with the given NID and NAMESPACE
	 * @param nid
	 * @param namespace
	 */
	public URN(String nid,String namespace) {
		this.nid=nid;
		this.namespace=namespace;
  }
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return get();
	}
	
	/**
	 * returns the complete urn
	 * @return
	 */
	public String get(){
		return "urn:"+nid+":"+namespace;
	}
	
	/**
	 * @return the NID of this URN object
	 */
	public String nid(){
		return nid;
	}
	
	/**
	 * @return the NAMESPACE of this URN object
	 */
	public String namespace(){
		return namespace;
	}
	
	public static void main(String[] args) throws DataFormatException, MalformedURLException {
		FileUrn urn=new FileUrn("hashvalue");
		System.out.println("urn: "+urn);	  
	  System.out.println(urn.urls()+" <= urls");
  }

	/**
	 * @return the urls related to this urn
	 * @throws MalformedURLException
	 */
	public abstract Set<URL> urls() throws MalformedURLException;

	public static TreeSet<URN> set() {
	  return new TreeSet<URN>(ObjectComparator.get());
  }
	
	public String suffix(){
		String suffix=toString();
		return suffix.substring(suffix.lastIndexOf(':')+1);
	}
}
