package com.cdy.others;

import com.yantra.yfc.statistics.interfaces.IStatisticObject;
import com.yantra.yfc.statistics.interfaces.PLTStatisticsConsumer;
import java.util.Collection;

public class PLTStatisticsConsumer_Impl implements PLTStatisticsConsumer 
{
  public void consumeStatistics(Collection<IStatisticObject> arg0) {
    System.out.println("Inside customer Statistics class");
    System.out.println("Data" + arg0.toString());
  }
}