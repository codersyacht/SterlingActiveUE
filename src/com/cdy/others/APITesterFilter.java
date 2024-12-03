package com.cdy.others;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class APITesterFilter implements Filter 
{
  public void init(FilterConfig arg0) throws ServletException {}
  
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
    System.out.println("filter is invoked before");
    HttpServletRequest request = (HttpServletRequest)req;
    HttpServletResponse response = (HttpServletResponse)resp;
    String referrer = request.getHeader("referer");
    System.out.println("Referrer : " + referrer);
    String user = null;
    user = request.getParameter("YFSEnvironment.userId");
    System.out.println("User : " + user);
    if (user.equals("admin"))
      response.sendRedirect("http://localhost:9080/smcfs/yfshttpapi/yantrahttpapitester.jsp"); 
    chain.doFilter(req, resp);
    System.out.println("filter is invoked after");
  }
  
  public void destroy() {}
}