package com.cdy.utility;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import com.yantra.yfs.core.YFSSystem;

public class HttpWebCall 
{
    String url;
    
    DataOutputStream dataOutputStream;

  public HttpWebCall()
    {
      // url = "http://9.202.178.34:8080/InvokeUserExit";
      // url = "http://host.docker.internal:8080/InvokeUserExit";
      url = YFSSystem.getProperty("UE.UEServerHost");
       
    }

   public HttpURLConnection initConnection()
    {
        HttpURLConnection httpURLConnection=null;
        try
            {
                URL obj = new URL(url);
                httpURLConnection = (HttpURLConnection) obj.openConnection();
		        httpURLConnection.setRequestMethod("POST");
		        httpURLConnection.setRequestProperty("Content-Type", "application/json");
		        httpURLConnection.setRequestProperty("Accept", "application/json");
                httpURLConnection.setDoOutput(true);    
                httpURLConnection.setReadTimeout(3600000);
                
                
            }
            catch(Exception e)
            {
                System.out.println(e.toString());
            }
            return httpURLConnection;

    }

    public void httpRequest(HttpURLConnection httpURLConnection, String data)
    {
        try
        {
         
            
            dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            System.out.println(new Date() + "DataOutputStream initialized");
            dataOutputStream.writeBytes(data);
            System.out.println(new Date() + "DataOutputStream writebytes completed");
            dataOutputStream.flush();
            System.out.println(new Date() + "DataOutputStream flused");
            dataOutputStream.close();
            System.out.println(new Date() + "DataOutputStream closed");
        }
        catch(Exception e)
            {
                System.out.println(e.toString());
            }

    }

    public String generateHttpOutput(HttpURLConnection httpUrlConnection)
	{
		try
		{
        System.out.println(new Date() + "Awaiting http response code");
		int responseCode = httpUrlConnection.getResponseCode();
        System.out.println(new Date() + "Received http response code");
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) 
        {
			response.append(inputLine);
		}
		String line = response.toString();
		return line;
		}
		catch (Exception e)
		{
            System.out.println(new Date() + e.toString());
			
		}
		return null;

		
	}

    public String httpWebRequest(String data)
    {
        String httpresponse = null;
       System.out.println(new Date() + "http request initiated");
       while (httpresponse ==null)
       {
       HttpURLConnection httpURLConnection =  initConnection();
       System.out.println(new Date() + "http request completed");
       httpRequest(httpURLConnection, data);      
       System.out.println(new Date() + "http output generate initialized");
       httpresponse = generateHttpOutput(httpURLConnection);
       System.out.println(new Date() + "http output generate completed");
       }
       return httpresponse;

    }
    
}
