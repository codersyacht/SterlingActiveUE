package com.cdy.userexit.order;

import org.w3c.dom.Document;
import com.yantra.yfs.japi.YFSEnvironment;
import com.yantra.yfs.japi.YFSUserExitException;
import com.yantra.yfs.japi.ue.OMPGetExternalCostForOptionsUE;

public class OMPGetExternalCostForOptionsUE_Impl extends BaseOrderUserExit implements OMPGetExternalCostForOptionsUE
{

    @Override
    public Document getExternalCostForOptions(YFSEnvironment env, Document inDoc) throws YFSUserExitException
     {
     return super.SinglePointUserExitCall(env, "OMPGetExternalCostForOptionsUE",  inDoc);
    }
    
}
