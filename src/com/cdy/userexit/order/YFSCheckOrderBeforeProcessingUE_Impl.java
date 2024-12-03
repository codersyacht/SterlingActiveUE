package com.cdy.userexit.order;

import com.yantra.interop.japi.YIFApi;
import com.yantra.interop.japi.YIFClientFactory;
import com.yantra.yfs.japi.YFSEnvironment;
import com.yantra.yfs.japi.YFSUserExitException;
import com.yantra.yfs.japi.ue.YFSCheckOrderBeforeProcessingUE;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class YFSCheckOrderBeforeProcessingUE_Impl implements YFSCheckOrderBeforeProcessingUE {
   public boolean checkOrderBeforeProcessing(YFSEnvironment env, Document arg1) throws YFSUserExitException {
      try {
         String reservationInputXML = this.getInputFile("/root/apps/tmp/reservation.xml");
         String splitLineInputXML = this.getInputFile("/root/apps/tmp/splitline.xml");
         YIFApi api = YIFClientFactory.getInstance().getLocalApi();
         Document reservationDoc = this.convertStringToDocument(reservationInputXML);
         Document splitLineDoc = this.convertStringToDocument(splitLineInputXML);
         api.invoke(env, "reserveAvailableInventory", reservationDoc);
         api.invoke(env, "splitLine", splitLineDoc);
      } catch (Exception var8) {
         var8.printStackTrace();
         System.out.println(var8.toString());
      }

      return true;
   }

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

   public Document convertStringToDocument(String xmlStr) {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

      try {
         DocumentBuilder builder = factory.newDocumentBuilder();
         Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));
         return doc;
      } catch (Exception var5) {
         var5.printStackTrace();
         return null;
      }
   }
}