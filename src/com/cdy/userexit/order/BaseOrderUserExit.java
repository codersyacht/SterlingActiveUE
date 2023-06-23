package com.cdy.userexit.order;

import org.w3c.dom.Document;

import com.cdy.userexit.Generic;
import com.cdy.utility.Converter;
import com.yantra.yfs.japi.YFSEnvironment;

public class BaseOrderUserExit 
{
   public Document SinglePointUserExitCall(YFSEnvironment yfs, String UserExitName, Document inDoc)
   {
    Converter converter = new Converter();
    try 
    {
      System.out.println(UserExitName+ " User Exit Triggered.");
      Document outDoc = new Generic<Document, Document>().GenericUserExitTrigger("YFSBeforeCreateOrderUE", inDoc,inDoc);
      System.out.println(UserExitName+ "output "+  converter.DoctoStringConverter(outDoc));
      return outDoc;
    } 

    catch (Exception e) 
    {
      System.out.println(e.toString());
    }
    return null;
   }
}
