package com.synergyj.demo.camel;

import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: domix
 * Date: 22/09/11
 * Time: 22:40
 * To change this template use File | Settings | File Templates.
 */
public class MainTest {
  @Test
  public void testSend() throws Exception {
    Sender sender = new Sender();
    sender.send("AAPL", Routes.queueRequestSymbol);
    Thread.sleep(5000);
  }
}
