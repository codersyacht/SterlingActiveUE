package com.cdy.others;

import com.cdy.utility.Converter;
import com.cdy.utility.UtilityFileProcess;
import com.yantra.interop.japi.YIFApi;
import com.yantra.interop.japi.YIFClientFactory;
import com.yantra.yfs.japi.YFSEnvironment;
import org.w3c.dom.Document;

public class CustomAPI1 {
  public Document invokeConfirmShipment(YFSEnvironment env, Document doc) {
    UtilityFileProcess file = new UtilityFileProcess();
    Converter cvnt = new Converter();
    try {
      String outputString = file.getInputFile("/root/apps/customXML/confirmShipment.xml");
      System.out.println("file Read complete");
      System.out.println("Data is " + outputString);
      YIFApi api = YIFClientFactory.getInstance().getLocalApi();
      Document outputDoc = cvnt.StringtoDocConverter(outputString);
      System.out.println("Input is:" + cvnt.DoctoStringConverter(doc));
      Document outDoc = api.invoke(env, "confirmShipment", outputDoc);
      System.out.println("Output Data is " + cvnt.DoctoStringConverter(outDoc));
      return outDoc;
    } catch (Exception e) {
      System.out.println(e.toString());
      return null;
    } 
  }
}