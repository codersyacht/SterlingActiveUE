package com.cdy.utility;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Properties;
import org.w3c.dom.Document;

public class PropertiesParser<InputDataType, OutputDataType> {
    @SuppressWarnings("deprecation")
   public OutputDataType AutomateOutputResult(OutputDataType outputDataType, Properties retprops) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Converter converter = new Converter();
        for (Object key : retprops.keySet()) {
            String datatype = outputDataType.getClass().getDeclaredField(key.toString()).getType().getName();
            System.out.println(datatype);
            switch (datatype) {
                case "java.lang.String": {
                    outputDataType.getClass().getDeclaredField(key.toString()).set(outputDataType, retprops.getProperty(key.toString()));
                    break;
                }
                case "double": {
                    System.out.println("in Double");
                    outputDataType.getClass().getDeclaredField(key.toString()).setDouble(outputDataType, Double.parseDouble(retprops.getProperty(key.toString())));
                    break;
                }
                case "boolean": {
                    outputDataType.getClass().getDeclaredField(key.toString()).setBoolean(outputDataType, Boolean.parseBoolean(retprops.getProperty(key.toString())));
                    break;
                }
                case "org.w3c.dom.Document": {
                    outputDataType.getClass().getDeclaredField(key.toString()).set(outputDataType, converter.StringtoDocConverter(retprops.getProperty(key.toString())));
                    break;
                }
                case "java.util.Date": {
                    outputDataType.getClass().getDeclaredField(key.toString()).set(outputDataType, new Date(retprops.getProperty(key.toString())));
                }
            }
        }
        return outputDataType;
    }

    public String AutomateProperties(InputDataType inputDataType) throws IllegalArgumentException, IllegalAccessException {
        String properties = "";
        Field[] fields = inputDataType.getClass().getFields();
        int i = 0;
        while (i < fields.length) {
            Object fieldvalue = fields[i].get(inputDataType);
            switch (fields[i].getType().getName()) {
                case "java.lang.String": {
                    if (fieldvalue == null) break;
                    properties = String.valueOf(properties) + fields[i].getName() + "=" + (String)fieldvalue + " ";
                    break;
                }
                case "double": {
                    if (fieldvalue == null) break;
                    properties = String.valueOf(properties) + fields[i].getName() + "=" + (Double)fieldvalue + " ";
                    break;
                }
                case "boolean": {
                    if (fieldvalue == null) break;
                    properties = String.valueOf(properties) + fields[i].getName() + "=" + (Boolean)fieldvalue + " ";
                    break;
                }
                case "org.w3c.dom.Document": {
                    Converter converter = new Converter();
                    String doc = null;
                    if ((Document)fieldvalue != null) {
                        doc = converter.DoctoStringConverter((Document)fieldvalue);
                    }
                    if (doc == null) break;
                    properties = String.valueOf(properties) + fields[i].getName() + "=" + doc + " ";
                    break;
                }
                case "java.util.Date": {
                    if (fieldvalue == null) break;
                    properties = String.valueOf(properties) + fields[i].getName() + "=" + (Date)fieldvalue + " ";
                }
            }
            ++i;
        }
        return properties;
    }
}