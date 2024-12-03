package com.cdy.userexit.order;

import com.cdy.utility.Converter;
import com.yantra.yfs.japi.YFSEnvironment;
import com.yantra.yfs.japi.YFSUserExitException;
import com.yantra.yfs.japi.ue.YFSBeforeCreateOrderUE;
import org.w3c.dom.Document;

public class YFSBeforeCreateOrderUE_Impl extends BaseOrderUserExit implements YFSBeforeCreateOrderUE {
   public String beforeCreateOrder(YFSEnvironment env, String inDoc) throws YFSUserExitException {
      return null;
   }

   public Document beforeCreateOrder(YFSEnvironment env, Document inDoc) throws YFSUserExitException {
      return super.SinglePointUserExitCall(env, "YFSBeforeCreateOrderUE", inDoc);
   }

   public static void main(String[] args) throws YFSUserExitException {
      YFSBeforeCreateOrderUE_Impl temp = new YFSBeforeCreateOrderUE_Impl();
      String data = "<order></order>";
      Document doc = (new Converter()).StringtoDocConverter(data);
      temp.beforeCreateOrder((YFSEnvironment)null, (Document)doc);
   }
}