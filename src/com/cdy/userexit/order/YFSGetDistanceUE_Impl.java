package com.cdy.userexit.order;

import com.yantra.yfs.japi.YFSEnvironment;
import com.yantra.yfs.japi.YFSUserExitException;
import com.yantra.yfs.japi.ue.YFSGetDistanceUE;
import org.w3c.dom.Document;

public class YFSGetDistanceUE_Impl extends BaseOrderUserExit implements YFSGetDistanceUE {
   public Document getDistance(YFSEnvironment yfs, Document inDoc) throws YFSUserExitException {
      return super.SinglePointUserExitCall(yfs, "YFSGetDistanceUE", inDoc);
   }
}