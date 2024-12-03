package com.cdy.others;

import com.cdy.utility.Converter;
import com.yantra.yfs.core.YFSSystem;
import com.yantra.yfs.japi.YFSEnvironment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.w3c.dom.Document;

public class CustomAPI4 {
  public String externalURL = null;
  
 public Document invokeExternalWebsite(YFSEnvironment env, Document doc) {
    try {
      this.externalURL = YFSSystem.getProperty("ue.externalURL");
      String retVal = "<Result> " + sendGET() + " </Result>";
      Converter cvt = new Converter();
      return cvt.StringtoDocConverter(retVal);
    } catch (Exception e) {
      System.out.println(e.toString());
      return null;
    } 
  }
  
  private String sendGET() throws IOException {
    URL obj = new URL(this.externalURL);
    StringBuffer response = null;
    HttpURLConnection con = (HttpURLConnection)obj.openConnection();
    con.setRequestMethod("GET");
    con.setRequestProperty("User-Agent", "Mozilla/5.0");
    int responseCode = con.getResponseCode();
    System.out.println("GET Response Code :: " + responseCode);
    if (responseCode == 200) {
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      response = new StringBuffer();
      String inputLine;
      while ((inputLine = in.readLine()) != null)
        response.append(inputLine); 
      in.close();
    } else {
      System.out.println("GET request did not work.");
    } 
    return response.toString();
  }
}