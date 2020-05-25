package com.sample.consume.rest.template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

@Component
public class JsonFileWriter {
	
	private static final Logger log = LoggerFactory.getLogger(JsonFileWriter.class);
	
	/*
	 * https://www.baeldung.com/gson-save-file
	 */
	public void writeJsonFile(Object data, String filePath) throws JsonIOException, IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//Gson gson = new Gson();
		// create writer
		Writer writer = new FileWriter(filePath);
		// Writer writer = Files.newBufferedWriter(Paths.get(filePath));
		// convert Object to JSON File
		gson.toJson(data, writer);
	    // close the writer
	    writer.close();
	    
		//store a object as a JSON:
		//gson.toJson(data, new FileWriter(filePath));// not working..!!	    
	    log.info(gson.toJson(data));
	    
	    /*
	     //convert json string to Object.
	     Product product = gson.fromJson(json, Product.class);
  		 System.out.println(product);
  		 return product;
	     */
	  	  
	}
	
	
	private void writeToFile(String data, String filePath) {
		//private static String filePath = "/Users/Documents/MyData.txt";
		
		File newJsonFile = new File(filePath);
		if (!newJsonFile.exists()) {
			try {
				File directory = new File(newJsonFile.getParent());
				if (!directory.exists()) {
					directory.mkdirs();
				}
				newJsonFile.createNewFile();
			} catch (IOException e) {
				System.out.println("Excepton Occured: " + e.toString());
				e.printStackTrace();
			}
		}
		
		try {
			// Convenience class for writing character files
			FileWriter fileWriter = new FileWriter(newJsonFile.getAbsoluteFile(), true);
 
			// Writes text to a character-output stream
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			bufferWriter.write(data.toString());
			bufferWriter.close();
			
			/*
			 // Constructs a FileWriter given a file name, using the platform's default charset
	            file = new FileWriter("/Users/Shared/crunchify.txt");
	            // JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
		        JSONObject obj = new JSONObject();
		        obj.put("Name", "Crunchify.com");
		        obj.put("Author", "App Shah");
		 
		        JSONArray company = new JSONArray();
		        company.add("Company: Facebook");
		        company.add("Company: PayPal");
		        company.add("Company: Google");
		        obj.put("Company List", company);
		        
	            file.write(obj.toJSONString());
			 */
 
			System.out.println("Data saved at file location: " + filePath + " Data: " + data + "\n");
		} catch (IOException e) {
			System.out.println("Got an error while saving data to a file " + e.toString());
			e.printStackTrace();
		}
	}
		
		
}
