package com.cdy.userexit.payments;

import com.cdy.userexit.Generic;
import com.yantra.yfs.japi.YFSEnvironment;
import com.yantra.yfs.japi.YFSExtnHeaderTaxCalculationInputStruct;
import com.yantra.yfs.japi.YFSExtnTaxCalculationOutStruct;
import com.yantra.yfs.japi.YFSUserExitException;
import com.yantra.yfs.japi.ue.YFSRecalculateHeaderTaxUE;

public class YFSRecalculateHeaderTaxUE_Impl implements YFSRecalculateHeaderTaxUE {
   @SuppressWarnings({ "rawtypes", "unchecked" })
public YFSExtnTaxCalculationOutStruct recalculateHeaderTax(YFSEnvironment arg0, YFSExtnHeaderTaxCalculationInputStruct arg1) throws YFSUserExitException {
      try {
         YFSExtnTaxCalculationOutStruct output = (YFSExtnTaxCalculationOutStruct)(new Generic()).GenericUserExitTrigger("YFSRecalculateHeaderTaxUE", arg1, new YFSExtnTaxCalculationOutStruct());
         System.out.println("After parsing " + output.colTax.get(0).toString());
         return output;
      } catch (Exception var4) {
         System.out.println(var4.toString());
         return null;
      }
   }
}