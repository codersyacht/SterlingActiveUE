package com.cdy.userexit.order;

import com.yantra.yfs.japi.YFSEnvironment;
import com.yantra.yfs.japi.YFSUserExitException;
import com.yantra.yfs.japi.ue.OMPGetExternalCostForOptionsUE;
import org.w3c.dom.Document;

public class OMPGetExternalCostForOptionsUE_Impl extends BaseOrderUserExit implements OMPGetExternalCostForOptionsUE {
   public Document getExternalCostForOptions(YFSEnvironment env, Document inDoc) throws YFSUserExitException {
      return super.SinglePointUserExitCall(env, "OMPGetExternalCostForOptionsUE", inDoc);
   }
}