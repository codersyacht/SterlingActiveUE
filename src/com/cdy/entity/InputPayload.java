package com.cdy.entity;

import java.io.Serializable;

public class InputPayload implements Serializable 
{
  public String requestId;  
  public String methodIdentifier;
  public String inputPayload;
  public String userToken;
}