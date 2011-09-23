package com.synergyj.demo.camel;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by IntelliJ IDEA.
 * User: domix
 * Date: 22/09/11
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 */
public class Routes extends RouteBuilder {
  public final static String routerAddress = "http://www.webservicex.net/stockquote.asmx";
  public final static String wsdlUrl = "src/main/resources/ws.wsdl";
  public final static String serviceName = "{http://www.webserviceX.NET/}StockQuote";
  public final static String portName = "{http://www.webserviceX.NET/}StockQuoteSoap";
  public final static String queueRequestSymbol = "seda:requestSymbol";
  public static final String velocityTemplate = "velocity:request/request.xml";

  public void configure() {
    errorHandler(noErrorHandler());

    StringBuilder sb = new StringBuilder();
    sb.append("cxf://");
    sb.append(routerAddress);
    sb.append("?wsdlURL=");
    sb.append(wsdlUrl);
    sb.append("&serviceName=");
    sb.append(serviceName);
    sb.append("&portName=");
    sb.append(portName);
    sb.append("&dataFormat=MESSAGE");

    String webService = sb.toString();

    from(queueRequestSymbol).to(velocityTemplate).to(webService).to("stream:err");
  }
}
