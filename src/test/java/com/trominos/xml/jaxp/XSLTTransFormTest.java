package com.trominos.xml.jaxp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import junit.framework.TestCase;

public class XSLTTransFormTest extends TestCase{
	
	public void testapplyStleSheet(){
		
		XSLTTransForm xsltTransForm;
		try {
			xsltTransForm = new XSLTTransForm(new FileOutputStream(new File("src/test/java/com/trominos/xml/jaxp/output.xml")));
			File dateFile  = new File("src/test/java/com/trominos/xml/jaxp/one.xml");
			File xsltFile = new File("src/test/java/com/trominos/xml/jaxp/one.xsl");
			
			xsltTransForm.applyStleSheet(dateFile, xsltFile);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	

}
