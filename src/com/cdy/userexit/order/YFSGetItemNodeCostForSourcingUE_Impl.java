package com.cdy.userexit.order;

import com.yantra.yfs.japi.YFSEnvironment;
import com.yantra.yfs.japi.YFSUserExitException;
import com.yantra.yfs.japi.ue.YFSGetItemNodeCostForSourcingUE;
import org.w3c.dom.Document;

public class YFSGetItemNodeCostForSourcingUE_Impl extends BaseOrderUserExit implements YFSGetItemNodeCostForSourcingUE {
   public Document getItemNodeCostForSourcing(YFSEnvironment yfs, Document inDoc) throws YFSUserExitException {
      return super.SinglePointUserExitCall(yfs, "YFSGetItemNodeCostForSourcingUE", inDoc);
   }
}