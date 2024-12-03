package com.cdy.userexit.order;

import com.yantra.yfs.japi.YFSEnvironment;
import com.yantra.yfs.japi.YFSUserExitException;
import com.yantra.yfs.japi.ue.YFSGetExternalAvailabilityUE;
import org.w3c.dom.Document;

public class YFSGetExternalAvailabilityUE_Impl extends BaseOrderUserExit implements YFSGetExternalAvailabilityUE {
   public Document getExternalAvailability(YFSEnvironment yfs, Document inDoc) throws YFSUserExitException {
      return super.SinglePointUserExitCall(yfs, "YFSGetExternalAvailabilityUE", inDoc);
   }
}