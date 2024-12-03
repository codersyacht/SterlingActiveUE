package com.cdy.userexit.order;

import com.yantra.pca.ycd.japi.ue.YCDGetAppeasementOffersUE;
import com.yantra.yfs.japi.YFSEnvironment;
import com.yantra.yfs.japi.YFSUserExitException;
import org.w3c.dom.Document;

public class YCDGetAppeasementOffersUE_Impl extends BaseOrderUserExit implements YCDGetAppeasementOffersUE {
   public Document getAppeasementOffers(YFSEnvironment yfs, Document inDoc) throws YFSUserExitException {
      return super.SinglePointUserExitCall(yfs, "YCDGetAppeasementOffersUE", inDoc);
   }
}