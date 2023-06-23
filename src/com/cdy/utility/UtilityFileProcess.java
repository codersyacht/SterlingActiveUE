package com.cdy.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Properties;


public class UtilityFileProcess
{
	public String getInputFile (String fileName) throws IOException 
	{
		
		 BufferedReader br = new BufferedReader(new FileReader(fileName));
		    try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();

		        while (line != null) 
		        {
		            sb.append(line);
		            
		            line = br.readLine();
		        }
		        return sb.toString();
		    } finally 
		    {
		        br.close();
		    }		  
	}
	
	 public Properties readPropertiesFile(String fileName) throws IOException {
	      FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream(fileName);
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }
	      return prop;
	   }
	
	public String getInputFilefromEAR (String fileName) throws IOException
	{
		InputStream is= UtilityFileProcess.class.getClassLoader().getResourceAsStream(fileName);
		
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();
		
		  
	}
	
	public void writeOutputFile (String fileName, String data) throws IOException 
	{
		File file = new File(fileName);
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter out = new PrintWriter(bw);
		out.println(data);
		out.println();
		out.close();
	}
	
	public void deleteFile(String fileName)
	{
		File file = new File(fileName);
		file.delete();
	}
	
	
	public boolean CreateNewFileIfDoesNotExist (String fileName)
	{
		try
		{
		 File file = new File(fileName);
		 if (!file.exists())
		 {
			 file.createNewFile();
			 return true;
		 
		 }
		
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		 }
		
		 return false;
	}
	
	public boolean CreateNewFolderIfDoesNotExist (String fileName)
	{
		try
		{
		 File file = new File(fileName);
		 if (!file.exists())
		 {
			 file.mkdir();
			 return true;
		 
		 }
		 return false;
		
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		 }
		
		 return false;
	}
	

}
