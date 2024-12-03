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

public class UtilityFileProcess {
   public String getInputFile(String fileName) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader(fileName));

      try {
         StringBuilder sb = new StringBuilder();

         for(String line = br.readLine(); line != null; line = br.readLine()) {
            sb.append(line);
         }

         String var6 = sb.toString();
         return var6;
      } finally {
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
      } catch (FileNotFoundException var9) {
         var9.printStackTrace();
      } catch (IOException var10) {
         var10.printStackTrace();
      } finally {
         fis.close();
      }

      return prop;
   }

   public String getInputFilefromEAR(String fileName) throws IOException {
      InputStream is = UtilityFileProcess.class.getClassLoader().getResourceAsStream(fileName);
      BufferedReader br = null;
      StringBuilder sb = new StringBuilder();

      try {
         br = new BufferedReader(new InputStreamReader(is));

         String line;
         while((line = br.readLine()) != null) {
            sb.append(line);
         }
      } catch (IOException var15) {
         var15.printStackTrace();
      } finally {
         if (br != null) {
            try {
               br.close();
            } catch (IOException var14) {
               var14.printStackTrace();
            }
         }

      }

      return sb.toString();
   }

   public void writeOutputFile(String fileName, String data) throws IOException {
      File file = new File(fileName);
      if (!file.exists()) {
         file.createNewFile();
      }

      FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter out = new PrintWriter(bw);
      out.println(data);
      out.println();
      out.close();
   }

   public void deleteFile(String fileName) {
      File file = new File(fileName);
      file.delete();
   }

   public boolean CreateNewFileIfDoesNotExist(String fileName) {
      try {
         File file = new File(fileName);
         if (!file.exists()) {
            file.createNewFile();
            return true;
         }
      } catch (Exception var3) {
         System.out.println(var3.toString());
      }

      return false;
   }

   public boolean CreateNewFolderIfDoesNotExist(String fileName) {
      try {
         File file = new File(fileName);
         if (!file.exists()) {
            file.mkdir();
            return true;
         } else {
            return false;
         }
      } catch (Exception var3) {
         System.out.println(var3.toString());
         return false;
      }
   }
}