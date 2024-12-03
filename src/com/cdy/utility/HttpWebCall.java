package com.cdy.utility;

import com.yantra.yfs.core.YFSSystem;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class HttpWebCall {
   String url = YFSSystem.getProperty("ue.UEServerHost");
   DataOutputStream dataOutputStream;

   public HttpURLConnection initConnection() {
      HttpURLConnection httpURLConnection = null;

      try {
         URL obj = new URL(this.url);
         httpURLConnection = (HttpURLConnection)obj.openConnection();
         httpURLConnection.setRequestMethod("POST");
         httpURLConnection.setRequestProperty("Content-Type", "application/json");
         httpURLConnection.setRequestProperty("Accept", "application/json");
         httpURLConnection.setDoOutput(true);
         httpURLConnection.setReadTimeout(3600000);
      } catch (Exception var3) {
         System.out.println(var3.toString());
      }

      return httpURLConnection;
   }

   public void httpRequest(HttpURLConnection httpURLConnection, String data) {
      try {
         this.dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
         System.out.println(new Date() + "DataOutputStream initialized");
         this.dataOutputStream.writeBytes(data);
         System.out.println(new Date() + "DataOutputStream writebytes completed");
         this.dataOutputStream.flush();
         System.out.println(new Date() + "DataOutputStream flused");
         this.dataOutputStream.close();
         System.out.println(new Date() + "DataOutputStream closed");
      } catch (Exception var4) {
         System.out.println(var4.toString());
      }

   }

   public String generateHttpOutput(HttpURLConnection httpUrlConnection) {
      try {
         System.out.println(new Date() + "Awaiting http response code");
         int responseCode = httpUrlConnection.getResponseCode();
         System.out.println(new Date() + "Received http response code");
         System.out.println("Response Code : " + responseCode);
         BufferedReader in = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream()));
         StringBuffer response = new StringBuffer();

         String inputLine;
         while((inputLine = in.readLine()) != null) {
            response.append(inputLine);
         }

         String line = response.toString();
         return line;
      } catch (Exception var7) {
         System.out.println(new Date() + var7.toString());
         return null;
      }
   }

   public String httpWebRequest(String data) {
      if (this.url != null && !this.url.equals((Object)null) && this.url != "") {
         String httpresponse = null;
         System.out.println(new Date() + "http request initiated");

         while(httpresponse == null) {
            HttpURLConnection httpURLConnection = this.initConnection();
            System.out.println(new Date() + "http request completed");
            this.httpRequest(httpURLConnection, data);
            System.out.println(new Date() + "http output generate initialized");
            httpresponse = this.generateHttpOutput(httpURLConnection);
            System.out.println(new Date() + "http output generate completed");
         }

         return httpresponse;
      } else {
         System.out.println("URL is not present");
         return null;
      }
   }
}