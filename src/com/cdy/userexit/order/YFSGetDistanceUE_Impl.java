package com.cdy.userexit.order;

import org.w3c.dom.Document;
import com.yantra.yfs.japi.YFSEnvironment;
import com.yantra.yfs.japi.YFSUserExitException;
import com.yantra.yfs.japi.ue.YFSGetDistanceUE;

public class YFSGetDistanceUE_Impl extends BaseOrderUserExit implements YFSGetDistanceUE
{

    @Override
    public Document getDistance(YFSEnvironment yfs, Document inDoc) throws YFSUserExitException 
    {
      return super.SinglePointUserExitCall(yfs, "YFSGetDistanceUE",  inDoc);
    }
    
}
