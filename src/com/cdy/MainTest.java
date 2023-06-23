package com.cdy;

import java.io.IOException;

import org.w3c.dom.Document;

import com.cdy.userexit.Generic;
import com.cdy.utility.Converter;
import com.cdy.utility.UtilityFileProcess;
import com.yantra.yfs.japi.YFSUserExitException;

public class MainTest 
{
    public static void main(String args[]) throws YFSUserExitException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, IOException
    {
        Document inDoc = null;
        Converter converter = new Converter();
        UtilityFileProcess utilityfileprocess = new UtilityFileProcess();
        try {
            inDoc=converter.StringtoDocConverter(utilityfileprocess.getInputFile("/Users/hussamoa/Techhub/createOrder.xml"));
            
         } catch (Exception e) 
         {
             System.out.println(e.toString());
         }
         System.out.println("Trial "+ inDoc.getClass().getTypeName());
         System.out.println(converter.DoctoStringConverter(inDoc));

    Generic<Document, Document> generic = new Generic<Document, Document>();
    Document outDoc = generic.GenericUserExitTrigger("YFSBeforeCreateOrderUE", inDoc, inDoc);
    System.out.println(converter.DoctoStringConverter(outDoc));
    }
    
}
