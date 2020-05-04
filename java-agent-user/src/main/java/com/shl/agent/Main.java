package com.shl.agent;

/**
 * @author songhengliang
 * @date 2020/5/4
 */
public class Main {
  public static void main(String[] args) {
    System.out.println("main方法执行");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}