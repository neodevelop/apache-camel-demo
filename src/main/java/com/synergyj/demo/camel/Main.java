package com.synergyj.demo.camel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String args[]) throws Exception {
    Sender sender = new Sender();
    String symbol = "_";
    while (symbol.length() > 0) {
      symbol = input("Please introduce the Symbol: ");
      sender.send(symbol, Routes.queueRequestSymbol);
    }


    Thread.sleep(5000);
  }

  public static String input(String message) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    System.out.print(message);
    return br.readLine();
  }
}
