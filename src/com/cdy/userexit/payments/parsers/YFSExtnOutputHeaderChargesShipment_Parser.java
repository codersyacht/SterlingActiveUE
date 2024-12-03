package com.cdy.userexit.payments.parsers;

import com.yantra.yfs.japi.YFSExtnHeaderChargeStruct;
import com.yantra.yfs.japi.YFSExtnOutputHeaderChargesShipment;
import java.io.Serializable;
import java.util.List;

public class YFSExtnOutputHeaderChargesShipment_Parser implements Serializable {
   public List<YFSExtnHeaderChargeStruct> newHeaderCharges;
   public boolean adjustHeaderDiscount = false;
   public double newShippingCharges;
   public double newPersonalizeCharges;
   public double newHandlingCharges;
   public double newDiscount;

   public YFSExtnOutputHeaderChargesShipment convertToYFSExtnOutputHeaderChargesShipment() {
      YFSExtnOutputHeaderChargesShipment output = new YFSExtnOutputHeaderChargesShipment();
      output.newHeaderCharges = this.newHeaderCharges;
      output.adjustHeaderDiscount = this.adjustHeaderDiscount;
      output.newShippingCharges = this.newShippingCharges;
      output.newPersonalizeCharges = this.newPersonalizeCharges;
      output.newHandlingCharges = this.newHandlingCharges;
      output.newDiscount = this.newDiscount;
      return output;
   }
}