package com.example.modernjavainaction.ch16;

import java.util.List;
import java.util.function.Supplier;

public class BestPriceFinderMain {

  private static final BestPriceFinder bestPriceFinder = new BestPriceFinder();

  public static void main(String[] args) {
    execute("sequential", () -> bestPriceFinder.findPricesSequential("myPhone27S"));
  }

  private static void execute(String msg, Supplier<List<String>> s) {
    long start = System.nanoTime();
    System.out.println(s.get());
    long duration = (System.nanoTime() - start) / 1_000_000;
    System.out.println(msg + " done in " + duration + " msecs");
  }

}
