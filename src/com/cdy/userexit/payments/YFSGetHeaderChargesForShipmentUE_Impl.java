package com.cdy.userexit.payments;

import com.cdy.userexit.Generic;
import com.yantra.yfs.japi.YFSEnvironment;
import com.yantra.yfs.japi.YFSExtnInputHeaderChargesShipment;
import com.yantra.yfs.japi.YFSExtnOutputHeaderChargesShipment;
import com.yantra.yfs.japi.YFSUserExitException;
import com.yantra.yfs.japi.ue.YFSGetHeaderChargesForShipmentUE;

public class YFSGetHeaderChargesForShipmentUE_Impl implements YFSGetHeaderChargesForShipmentUE {
   @SuppressWarnings({ "rawtypes", "unchecked" })
public YFSExtnOutputHeaderChargesShipment getHeaderChargesForShipment(YFSEnvironment arg0, YFSExtnInputHeaderChargesShipment arg1) throws YFSUserExitException {
      try {
         YFSExtnOutputHeaderChargesShipment output = (YFSExtnOutputHeaderChargesShipment)(new Generic()).GenericUserExitTrigger("YFSGetHeaderChargesForShipmentUE", arg1, new YFSExtnOutputHeaderChargesShipment());
         return output;
      } catch (Exception var4) {
         System.out.println(var4.toString());
         return null;
      }
   }
}