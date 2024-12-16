package com.cdy.userexit.payments;

import com.cdy.userexit.Generic;
import com.yantra.yfs.japi.YFSEnvironment;
import com.yantra.yfs.japi.YFSExtnPaymentCollectionInputStruct;
import com.yantra.yfs.japi.YFSExtnPaymentCollectionOutputStruct;
import com.yantra.yfs.japi.YFSUserExitException;
import com.yantra.yfs.japi.ue.YFSCollectionCreditCardUE;

public class YFSCollectionCreditCardUE_Impl implements YFSCollectionCreditCardUE {
@SuppressWarnings({ "rawtypes", "unchecked" })
public YFSExtnPaymentCollectionOutputStruct collectionCreditCard(YFSEnvironment arg0, YFSExtnPaymentCollectionInputStruct arg1) throws YFSUserExitException 
{
      try {
         YFSExtnPaymentCollectionOutputStruct output = (YFSExtnPaymentCollectionOutputStruct)(new Generic()).GenericUserExitTrigger("YFSCollectionCreditCardUE", arg1, new YFSExtnPaymentCollectionOutputStruct());
         return output;
      } catch (Exception var4) {
         System.out.println(var4.toString());
         return null;
      }
   }
}