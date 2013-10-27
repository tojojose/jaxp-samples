package com.trominos.xml.jaxp;

import java.io.IOException;
import java.io.PrintStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
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
        xmlReader.setErrorHandler(new MyErrorHandler(System.out));
   
        
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
	

	
	private  static class MyErrorHandler implements 	ErrorHandler{

		private PrintStream out;

	    MyErrorHandler(PrintStream out) {
	        this.out = out;
	    }

	    private String getParseExceptionInfo(SAXParseException spe) {
	        String systemId = spe.getSystemId();

	        if (systemId == null) {
	            systemId = "null";
	        }

	        String info = "URI=" + systemId + " Line=" 
	            + spe.getLineNumber() + ": " + spe.getMessage();

	        return info;
	    }

	    public void warning(SAXParseException spe) throws SAXException {
	        out.println("Warning: " + getParseExceptionInfo(spe));
	    }
	        
	    public void error(SAXParseException spe) throws SAXException {
	        String message = "Error: " + getParseExceptionInfo(spe);
	        throw new SAXException(message);
	    }

	    public void fatalError(SAXParseException spe) throws SAXException {
	        String message = "Fatal Error: " + getParseExceptionInfo(spe);
	        throw new SAXException(message);
	    }
		
		
		
	}

	
}
