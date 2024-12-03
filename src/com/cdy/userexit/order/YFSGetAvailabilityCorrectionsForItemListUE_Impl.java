package com.cdy.userexit.order;

import com.yantra.yfs.japi.YFSEnvironment;
import com.yantra.yfs.japi.YFSUserExitException;
import com.yantra.yfs.japi.ue.YFSGetAvailabilityCorrectionsForItemListUE;
import org.w3c.dom.Document;

public class YFSGetAvailabilityCorrectionsForItemListUE_Impl extends BaseOrderUserExit implements YFSGetAvailabilityCorrectionsForItemListUE 
{
@Override
public Document getAvailabilityCorrectionsForItemList(YFSEnvironment yfs, Document inDoc) throws YFSUserExitException 
{
    return super.SinglePointUserExitCall(yfs, "YFSGetAvailabilityCorrectionsForItemListUE", inDoc);
}
}