package com.cdy.userexit.payments.parsers;

import com.yantra.yfs.japi.YFSExtnTaxBreakup;
import com.yantra.yfs.japi.YFSExtnTaxCalculationOutStruct;
import java.io.Serializable;
import java.util.List;

public class YFSExtnTaxCalculationOutStruct_Parser implements Serializable {
   public List<YFSExtnTaxBreakup> colTax;
   public double tax;
   public double taxPercentage;

   public YFSExtnTaxCalculationOutStruct convertToYFSExtnTaxCalculationOutStruct() {
      YFSExtnTaxCalculationOutStruct output = new YFSExtnTaxCalculationOutStruct();
      output.tax = this.tax;
      output.taxPercentage = this.taxPercentage;
      output.colTax = this.colTax;
      return output;
   }
}