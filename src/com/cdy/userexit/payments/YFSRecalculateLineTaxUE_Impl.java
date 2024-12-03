package com.cdy.userexit.payments;

import com.cdy.userexit.Generic;
import com.yantra.yfs.japi.YFSEnvironment;
import com.yantra.yfs.japi.YFSExtnLineTaxCalculationInputStruct;
import com.yantra.yfs.japi.YFSExtnTaxCalculationOutStruct;
import com.yantra.yfs.japi.YFSUserExitException;
import com.yantra.yfs.japi.ue.YFSRecalculateLineTaxUE;

public class YFSRecalculateLineTaxUE_Impl implements YFSRecalculateLineTaxUE {
   @SuppressWarnings({ "rawtypes", "unchecked" })
public YFSExtnTaxCalculationOutStruct recalculateLineTax(YFSEnvironment arg0, YFSExtnLineTaxCalculationInputStruct arg1) throws YFSUserExitException {
      try {
         YFSExtnTaxCalculationOutStruct output = (YFSExtnTaxCalculationOutStruct)(new Generic()).GenericUserExitTrigger("YFSRecalculateLineTaxUE", arg1, new YFSExtnTaxCalculationOutStruct());
         System.out.println("After parsing " + output.colTax.get(0).toString());
         return output;
      } catch (Exception var4) {
         System.out.println(var4.toString());
         return null;
      }
   }
}