package com.cdy.userexit.order;

import com.cdy.userexit.Generic;
import com.cdy.utility.Converter;
import com.yantra.yfs.japi.YFSEnvironment;
import org.w3c.dom.Document;

public class BaseOrderUserExit {
   @SuppressWarnings({ "rawtypes", "unchecked" })
  public Document SinglePointUserExitCall(YFSEnvironment yfs, String UserExitName, Document inDoc) {
      Converter converter = new Converter();

      try {
         System.out.println(UserExitName + " User Exit Triggered.");
         Document outDoc = (Document)(new Generic()).GenericUserExitTrigger(UserExitName, inDoc, inDoc);
         System.out.println(UserExitName + "output " + converter.DoctoStringConverter(outDoc));
         return outDoc;
      } catch (Exception var6) {
         System.out.println(var6.toString());
         return null;
      }
   }
}