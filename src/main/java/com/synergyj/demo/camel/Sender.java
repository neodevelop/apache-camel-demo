package com.synergyj.demo.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by IntelliJ IDEA.
 * User: domix
 * Date: 22/09/11
 * Time: 22:09
 * To change this template use File | Settings | File Templates.
 */
public class Sender {
  CamelContext context = buildContext();
  ProducerTemplate template = context.createProducerTemplate();

  public void send(final String symbol, final String destination) {
    if(symbol.length() > 0 && destination.length() > 0) {
      template.sendBody(destination, symbol);
    }
  }

  public CamelContext buildContext() {
    CamelContext context = new DefaultCamelContext();
    try {
      context.addRoutes(new Routes());
      context.start();
    } catch (Exception e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }

    return context;
  }
}
