package com.cdy.userexit.order;

import com.yantra.yfs.japi.YFSEnvironment;
import com.yantra.yfs.japi.YFSUserExitException;
import com.yantra.yfs.japi.ue.INVGetSupplyCorrectionsUE;
import org.w3c.dom.Document;

public class INVGetSupplyCorrectionsUE_Impl extends BaseOrderUserExit implements INVGetSupplyCorrectionsUE {
   public Document getSupplyCorrections(YFSEnvironment env, Document inDoc) throws YFSUserExitException {
      return super.SinglePointUserExitCall(env, "INVGetSupplyCorrectionsUE", inDoc);
   }
}