package com.cdy.utility;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class Converter {
   public Document StringtoDocConverter(String XML) {
      Document doc = this.convertStringToDocument(XML);
      return doc;
   }

   public String DoctoStringConverter(Document doc) {
      String xml = this.convertDocumenttoString(doc);
      return xml;
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

   public String convertDocumenttoString(Document doc) {
      try {
         DOMSource domSource = new DOMSource(doc);
         StringWriter writer = new StringWriter();
         StreamResult result = new StreamResult(writer);
         TransformerFactory tf = TransformerFactory.newInstance();
         Transformer transformer = tf.newTransformer();
         transformer.transform(domSource, result);
         return writer.toString();
      } catch (Exception var7) {
         System.out.println(var7.toString());
         return null;
      }
   }
}