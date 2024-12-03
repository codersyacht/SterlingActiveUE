package com.cdy.others;

import com.cdy.utility.Converter;
import com.cdy.utility.UtilityFileProcess;
import com.yantra.interop.japi.YIFApi;
import com.yantra.interop.japi.YIFClientFactory;
import com.yantra.yfc.dom.YFCDocument;
import com.yantra.yfs.japi.YFSEnvironment;
import org.w3c.dom.Document;

public class CustomAPI2 {
  public Document invokeGetCompleteShipmentDetails(YFSEnvironment env, Document doc) {
    UtilityFileProcess file = new UtilityFileProcess();
    Converter cvnt = new Converter();
    try {
      String shipListForOrderTemplate = "<Order TotalNumberOfRecords=''> <OrderLines> <OrderLine OrderLineKey=''> <ShipmentLines/> </OrderLine> </OrderLines> <Shipments> <Shipment DocumentType='' DeliveryMethod='' EnterpriseCode='' SellerOrganizationCode='' ShipNode='' ShipmentNo=''  ReceivingNode='' HoldLocation='' Status='' OrderNo=''> <Extn CarrierName='' TrackingURL='' /> <Instructions> <Instruction InstructionText='' InstructionType='' InstructionUsage='' SequenceNo='' /> </Instructions> <Containers> <Container ContainerNo='' TrackingNo=''> <ContainerDetails> <ContainerDetail ItemID='' UnitOfMeasure='' Quantity=''> <ShipmentLine  DocumentType='' OrderNo='' PrimeLineNo='' SubLineNo='' ReleaseNo='' ShipmentLineNo='' ShipmentSubLineNo=''  /> <ShipmentTagSerials> <ShipmentTagSerial Quantity='' SerialNo='' /> </ShipmentTagSerials> </ContainerDetail> </ContainerDetails> </Container> </Containers> <Status Description='' Status='' StatusName='' /> <ShipmentLines> <ShipmentLine DocumentType='' ItemID='' OrderNo='' PrimeLineNo='' Quantity='' ReleaseNo=''  ReceivedQuantity='' ShipmentLineNo='' CancelReason='' CustomerPickedQuantity='' ShipmentSubLineNo='' SubLineNo='' UnitOfMeasure=''> <OrderLine LineType=''> <OrderLineOptions> <OrderLineOption OptionDescription='' OptionItemID='' OptionUOM='' UnitPrice='' /> </OrderLineOptions> </OrderLine> <ShipmentTagSerials> <ShipmentTagSerial Quantity='' SerialNo='' /> </ShipmentTagSerials> </ShipmentLine> </ShipmentLines> </Shipment> </Shipments> </Order>";
      Document getShipListTemplate = YFCDocument.getDocumentFor(shipListForOrderTemplate).getDocument();
      String outputString = file.getInputFile("/root/apps/customXML/getCompleteShipmentDetails.xml");
      System.out.println("file Read complete");
      System.out.println("Data is " + outputString);
      YIFApi api = YIFClientFactory.getInstance().getLocalApi();
      System.out.println("API initialised");
      env.setApiTemplate("getCompleteShipmentDetails", getShipListTemplate);
      System.out.println("Template loaded");
      Document outputDoc = cvnt.StringtoDocConverter(outputString);
      System.out.println("Input is:" + cvnt.DoctoStringConverter(doc));
      Document outDoc = api.invoke(env, "getCompleteShipmentDetails", outputDoc);
      System.out.println("execution completed");
      System.out.println("Output Data is " + cvnt.DoctoStringConverter(outDoc));
      env.clearApiTemplate("getCompleteShipmentDetails");
      return outDoc;
    } catch (Exception e) {
      System.out.println(e.toString());
      return null;
    } 
  }
}