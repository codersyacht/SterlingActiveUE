package com.cdy.userexit.payments;

import com.cdy.userexit.Generic;
import com.yantra.yfs.japi.YFSEnvironment;
import com.yantra.yfs.japi.YFSExtnPaymentCollectionInputStruct;
import com.yantra.yfs.japi.YFSExtnPaymentCollectionOutputStruct;
import com.yantra.yfs.japi.YFSUserExitException;
import com.yantra.yfs.japi.ue.YFSCollectionCreditCardUE;

public class YFSCollectionCreditCardUE_Impl implements YFSCollectionCreditCardUE
{

    @Override
    public YFSExtnPaymentCollectionOutputStruct collectionCreditCard(YFSEnvironment arg0, YFSExtnPaymentCollectionInputStruct arg1) throws YFSUserExitException 
    {
       
        try {
           YFSExtnPaymentCollectionOutputStruct output = (YFSExtnPaymentCollectionOutputStruct) new Generic<YFSExtnPaymentCollectionInputStruct, YFSExtnPaymentCollectionOutputStruct>().GenericUserExitTrigger("YFSCollectionCreditCardUE", arg1, new YFSExtnPaymentCollectionOutputStruct());
           System.out.println(output.authorizationId);
           System.out.println(output.authorizationAmount);
           System.out.println(output.authorizationExpirationDate);
           System.out.println(output.tranAmount);
           System.out.println(output.tranType);
           return output;
           
        } catch (Exception e) 
        {
          
            System.out.println(e.toString());
        }

        return null;
    }

       

}
