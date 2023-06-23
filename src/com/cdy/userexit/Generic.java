package com.cdy.userexit;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import java.io.StringReader;

import com.cdy.entity.InputPayload;
import com.google.gson.Gson;
import com.ibm.icu.text.SimpleDateFormat;

import org.w3c.dom.Document;

import com.cdy.utility.Converter;
import com.cdy.utility.HttpWebCall;
import com.cdy.utility.PropertiesParser;

public class Generic <InputDataType, OutputDataType>
{   
  InputPayload inputPayload;
    Gson gson;
    Converter converter;

  public Generic()
  {
    gson = new Gson();
    converter = new Converter();
    inputPayload = new InputPayload();
   
  }

    Properties properties = new Properties();

    @SuppressWarnings("unchecked")
    public OutputDataType GenericUserExitTrigger(String UserExitName, InputDataType inputDataType, OutputDataType outputDataType) throws IllegalArgumentException, IllegalAccessException, IOException, NoSuchFieldException, SecurityException 
    {
        String structtype;
        System.out.println("Debugger 1");
        structtype = inputDataType.getClass().getName();
        System.out.println(structtype);
        switch(structtype)
        {
            case "org.apache.xerces.dom.DeferredDocumentImpl":
            {
             
               Converter converter = new Converter();
               System.out.println(new Date()+": User exit input data: " +converter.DoctoStringConverter((Document)inputDataType));
               Document retDoc = converter.StringtoDocConverter(this.UserExitInvoke(UserExitName, converter.DoctoStringConverter((Document)inputDataType)));        
               return (OutputDataType)retDoc;
            }

            case "com.yantra.yfs.japi.YFSExtnPaymentCollectionInputStruct":
            {
              PropertiesParser <InputDataType, OutputDataType> propertyParser = new PropertiesParser<InputDataType, OutputDataType>();
              Properties prop = propertyParser.AutomateProperties(inputDataType);
              System.out.println(new Date()+": User exit input data: " +prop);
              Properties retprop = this.UserExitInvoke(UserExitName, prop); 
              OutputDataType retval =  propertyParser.AutomateOutputResult(outputDataType, retprop);
              return retval;

            }
        }

        return null;
    }

    public String UserExitInvoke(String UserExitName, String inputData)
    {
      
      SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");  
      Date date = new Date(); 
        inputPayload.requestId=formatter.format(date);
        inputPayload.methodIdentifier=UserExitName;
        inputPayload.inputPayload=inputData;
        System.out.println(new Date()+ ": Remote User Exit Triggered for "+ UserExitName);
        String retval = new HttpWebCall().httpWebRequest(gson.toJson(inputPayload));
        System.out.println("Received user exit response: \n"+ retval);
        return retval;   
    }

    public Properties UserExitInvoke(String UserExitName, Properties props) throws IOException
    {
    

      SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");  
      Date date = new Date(); 
        inputPayload.requestId=formatter.format(date);
        inputPayload.methodIdentifier=UserExitName;
        inputPayload.inputPayload=props.toString();
        System.out.println(new Date()+ ": Remote User Exit Triggered for "+ UserExitName);
        String retval = new HttpWebCall().httpWebRequest(gson.toJson(inputPayload));
        retval = retval.replaceAll(" ", "\n");
        System.out.println(retval.toString());
        Properties properties = new Properties() ;
        properties.load(new StringReader(retval));
        return properties;
       
    }
    
    
}
