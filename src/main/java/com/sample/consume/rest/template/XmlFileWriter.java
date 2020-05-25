package com.sample.consume.rest.template;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.stereotype.Component;

@Component
public class XmlFileWriter {


	public void convertObjectToXML(Object data, String filePath) throws JAXBException, FileNotFoundException {
        // create JAXB context and instantiate marshaller
		// System.out.println("Child class "+data.getClass().getName());
       // JAXBContext context = JAXBContext.newInstance(VaultAuth.class);
		JAXBContext context = JAXBContext.newInstance(data.getClass());
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
      //  m.marshal(data, System.out);

        // Write to File
        m.marshal(data, new File(filePath));
        
        /*
		  JSONObject json = new JSONObject(jsonObj.toString());
		  String xml = XML.toString(json);
		  System.out.println("JSON converted to XML: ");
		  System.out.println(xml);
		 */
    }
}
