package com.cdy.sequence;

import com.yantra.ycp.core.YCPContext;
import com.yantra.yfs.japi.YFSEnvironment;
import org.w3c.dom.Document;

public class SequenceGenerator {
  public Document generateSequence(YFSEnvironment env, Document indoc) throws Exception {
    Long sequenceNumber = Long.valueOf(0L);
    YCPContext context = new YCPContext("admin", "API");
    for (int i = 0; i <= 50; i++) {
      sequenceNumber = Long.valueOf(context.getNextDBSeqNo("SEQ_EXTN_TO_NO"));
      System.out.println("Sequence Number" + sequenceNumber);
    } 
    context.close();
    return indoc;
  }
}