package com.cdy.userexit.order;

import com.yantra.yfs.japi.YFSEnvironment;
import com.yantra.yfs.japi.YFSUserExitException;
import com.yantra.yfs.japi.ue.YFSGetDeliveryLeadTimeUE;
import org.w3c.dom.Document;

public class YFSGetDeliveryLeadTimeUE_Impl extends BaseOrderUserExit implements YFSGetDeliveryLeadTimeUE {
   public Document getDeliveryLeadTime(YFSEnvironment yfs, Document inDoc) throws YFSUserExitException {
      return super.SinglePointUserExitCall(yfs, "YFSGetDeliveryLeadTimeUE", inDoc);
   }
}