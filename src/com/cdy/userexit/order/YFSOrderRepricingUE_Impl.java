package com.cdy.userexit.order;

import com.yantra.yfc.log.YFCLogCategory;
import com.yantra.yfs.japi.YFSEnvironment;
import com.yantra.yfs.japi.YFSUserExitException;
import com.yantra.yfs.japi.ue.YFSOrderRepricingUE;
import org.w3c.dom.Document;

public class YFSOrderRepricingUE_Impl extends BaseOrderUserExit implements YFSOrderRepricingUE {
   public Document orderReprice(YFSEnvironment env, Document inDoc) throws YFSUserExitException {
      YFCLogCategory cat = YFCLogCategory.instance(YFSOrderRepricingUE_Impl.class);
      cat.verbose("Verbose recorded for UE trigger");
      return super.SinglePointUserExitCall(env, "YFSOrderRepricingUE", inDoc);
   }
}