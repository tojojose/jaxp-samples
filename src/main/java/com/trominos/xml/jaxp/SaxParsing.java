package com.trominos.xml.jaxp;

import java.util.Hashtable;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class SaxParsing  implements ContentHandler {

	
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		
		StringBuilder sb = new StringBuilder(length);
		for(int i = start; i < start + length ; i++){
			sb.append(ch[i]);		
		}
		
		System.out.println(sb.toString());
		
	}

	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		System.out.println("qName " + qName);
		System.out.println("localName " + localName);
		System.out.println("uri " + uri);
		System.out.println("************************************");
	}

	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void processingInstruction(String target, String data)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub
		
	}

	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void startDocument() throws SAXException {
		
		
	}

	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		System.out.println("uri :" + uri);
		System.out.println("qName :" + qName);
		
		

		for(int i = 0 ; i < atts.getLength(); i++ ){
			System.out.println(atts.getLocalName(i) + ":" +  atts.getValue(i));
		}
		System.out.println("---------------------------------");
	}

	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

}
