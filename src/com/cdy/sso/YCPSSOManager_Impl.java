package com.cdy.sso;

import com.yantra.ycp.japi.util.YCPSSOManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class YCPSSOManager_Impl implements YCPSSOManager {
  public String getUserData(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String userid = null;
    if (request.getParameter("userid") != null) {
      userid = request.getParameter("userid");
      System.out.println("User is : " + userid);
      return userid;
    } 
    String URI = request.getRequestURI();
    URI = "http://9.30.223.187:9080" + URI;
    System.out.println("Requested URI" + URI);
    String SSOServer = "http://9.30.223.187:9081/SSOServer/SSOAdmin";
    response.sendRedirect(String.valueOf(SSOServer) + "?RETURN_URL=" + URI);
    return null;
  }
}