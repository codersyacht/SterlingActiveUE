package com.cdy.userexit;

import com.cdy.entity.InputPayload;
import com.cdy.userexit.payments.parsers.YFSExtnOutputHeaderChargesShipment_Parser;
import com.cdy.userexit.payments.parsers.YFSExtnTaxCalculationOutStruct_Parser;
import com.cdy.utility.Converter;
import com.cdy.utility.HttpWebCall;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.ibm.icu.text.SimpleDateFormat;
import com.yantra.yfs.core.YFSSystem;
import com.yantra.yfs.japi.YFSExtnPaymentCollectionOutputStruct;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import org.jose4j.json.internal.json_simple.parser.ParseException;
import org.json.Property;
import org.w3c.dom.Document;

public class Generic<InputDataType, OutputDataType> {
    InputPayload inputPayload;
    Gson gson;
    Converter converter;
    Property jsontoPropertyConverter;
    String userToken = YFSSystem.getProperty((String)"ue.UserToken");
    Properties properties = new Properties();

    public Generic() {
        this.gson = new Gson();
        this.converter = new Converter();
        this.inputPayload = new InputPayload();
    }

    @SuppressWarnings("unchecked")
    public OutputDataType GenericUserExitTrigger(String UserExitName, InputDataType inputDataType, OutputDataType outputDataType) throws IllegalArgumentException, IllegalAccessException, IOException, NoSuchFieldException, SecurityException, ParseException {
        String structtype = inputDataType.getClass().getName();
        System.out.println(structtype);
        switch (structtype) {
            case "org.apache.xerces.dom.DeferredDocumentImpl": {
                Converter converter = new Converter();
                System.out.println(new Date() + ": User exit input data: " + converter.DoctoStringConverter((Document)inputDataType));
                Document retDoc = converter.StringtoDocConverter(this.UserExitInvoke(UserExitName, converter.DoctoStringConverter((Document)inputDataType)));
                return (OutputDataType)retDoc;
            }
            case "org.apache.xerces.dom.DocumentImpl": {
                Converter converter = new Converter();
                System.out.println(new Date() + ": User exit input data: " + converter.DoctoStringConverter((Document)inputDataType));
                Document retDoc = converter.StringtoDocConverter(this.UserExitInvoke(UserExitName, converter.DoctoStringConverter((Document)inputDataType)));
                return (OutputDataType)retDoc;
            }
            case "com.yantra.yfs.japi.YFSExtnPaymentCollectionInputStruct": {
                ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
                String json = writer.writeValueAsString(inputDataType);
                System.out.println("User Exit Input Data: " + json);
                String ueReturnValue = this.UserExitInvoke(UserExitName, json);
                System.out.println("User Exit Output Data: " + ueReturnValue);
                ObjectMapper mapper = new ObjectMapper();
                return (OutputDataType)mapper.readValue(ueReturnValue, YFSExtnPaymentCollectionOutputStruct.class);
            }
            case "com.yantra.yfs.japi.YFSExtnHeaderTaxCalculationInputStruct": {
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                String json = ow.writeValueAsString(inputDataType);
                System.out.println("User Exit Input Data: " + json);
                String ueReturnValue = this.UserExitInvoke(UserExitName, json);
                System.out.println("User Exit Output Data: " + ueReturnValue);
                ObjectMapper mapper = new ObjectMapper();
                YFSExtnTaxCalculationOutStruct_Parser retval = (YFSExtnTaxCalculationOutStruct_Parser)mapper.readValue(ueReturnValue, YFSExtnTaxCalculationOutStruct_Parser.class);
                return (OutputDataType)retval.convertToYFSExtnTaxCalculationOutStruct();
            }
            case "com.yantra.yfs.japi.YFSExtnLineTaxCalculationInputStruct": {
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                String json = ow.writeValueAsString(inputDataType);
                System.out.println("User Exit Input Data: " + json);
                String ueReturnValue = this.UserExitInvoke(UserExitName, json);
                System.out.println("User Exit Output Data: " + ueReturnValue);
                ObjectMapper mapper = new ObjectMapper();
                YFSExtnTaxCalculationOutStruct_Parser retval = (YFSExtnTaxCalculationOutStruct_Parser)mapper.readValue(ueReturnValue, YFSExtnTaxCalculationOutStruct_Parser.class);
                return (OutputDataType)retval.convertToYFSExtnTaxCalculationOutStruct();
            }
            case "com.yantra.yfs.japi.YFSExtnInputHeaderChargesShipment": {
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                String json = ow.writeValueAsString(inputDataType);
                System.out.println("User Exit Input Data: " + json);
                String ueReturnValue = this.UserExitInvoke(UserExitName, json);
                System.out.println("User Exit Output Data: " + ueReturnValue);
                ObjectMapper mapper = new ObjectMapper();
                YFSExtnOutputHeaderChargesShipment_Parser retval = (YFSExtnOutputHeaderChargesShipment_Parser)mapper.readValue(ueReturnValue, YFSExtnOutputHeaderChargesShipment_Parser.class);
                return (OutputDataType)retval.convertToYFSExtnOutputHeaderChargesShipment();
            }
        }
        return null;
    }

    public String UserExitInvoke(String UserExitName, String inputData) {
        if (this.userToken == null || this.userToken.equals(null) || this.userToken == "") {
            System.out.println("User token is not configured");
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        this.inputPayload.requestId = String.valueOf(this.userToken) + formatter.format(date);
        this.inputPayload.methodIdentifier = UserExitName;
        this.inputPayload.inputPayload = inputData;
        this.inputPayload.userToken = this.userToken;
        System.out.println(new Date() + ": Remote User Exit Triggered for " + UserExitName);
        String retval = new HttpWebCall().httpWebRequest(this.gson.toJson((Object)this.inputPayload));
        System.out.println("Received user exit response: \n" + retval);
        return retval;
    }
}