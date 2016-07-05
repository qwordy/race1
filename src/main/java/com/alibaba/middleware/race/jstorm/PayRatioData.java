package com.alibaba.middleware.race.jstorm;

import java.math.BigDecimal;

/**
 * Created by yfy on 7/4/16.
 * PayRatioData for one minute
 */
public class PayRatioData {

  public PayRatioData() {
    w = 0;
    p = 0;
  }

  public PayRatioData(double wireless, double pc) {
    w = wireless;
    p = pc;
  }

  public PayRatioData(PayRatioData data) {
    w = data.getWireless();
    p = data.getPc();
  }

  public void addWireless(double amount) {
    w += amount;
  }

  public void addPc(double amount) {
    p += amount;
  }

  public double getWireless() {
    return w;
  }

  public double getPc() {
    return p;
  }

  public Double ratio() {
    return p == 0 ? Double.MAX_VALUE : w / p;
  }

  public Double ratio2() {
    if (p == 0)
      return 1.79e+308;
    else
      return Math.round(w / p * 100) / 100.0;
  }

  @Override
  public String toString() {
    return String.format("wireless:%f pc:%f ratio:%f", w, p, ratio());
  }

  // wireless, pc
  private double w, p;

}
