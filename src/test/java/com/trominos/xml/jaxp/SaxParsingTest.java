package com.trominos.xml.jaxp;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import junit.framework.TestCase;

public class SaxParsingTest extends TestCase {
	
	private static final String XML_DOC = "src/test/java/com/trominos/xml/jaxp/sample.xml";

	
	SAXParserFactory spf  = null;
	SAXParser saxParser   = null;
	XMLReader xmlReader   = null; 
	
	protected void setUp(){
		spf = SAXParserFactory.newInstance();
		spf.setNamespaceAware(true);
		spf.setValidating(false);
		try {
			saxParser = spf.newSAXParser();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
        try {
			xmlReader = saxParser.getXMLReader();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        xmlReader.setContentHandler(new SaxParsing());
	}
	
	
	public void testStartElement(){
		try {
			xmlReader.parse(XML_DOC);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	protected void tearDown(){
		spf  = null;
		saxParser   = null;
		xmlReader   = null; 
	}
	

}
