package com.trominos.xml.jaxp;

import java.io.File;

import junit.framework.TestCase;

public class XSLTTransFormTest extends TestCase{
	
	public void testapplyStleSheet(){
		
		XSLTTransForm  xsltTransForm = new XSLTTransForm();
		
		File dateFile  = new File("src/test/java/com/trominos/xml/jaxp/one.xml");
		File xsltFile = new File("src/test/java/com/trominos/xml/jaxp/one.xsl");
		
		xsltTransForm.applyStleSheet(dateFile, xsltFile);
		
		
		
	}
	
	

}
