package com.moussawi7.controlledgif;

public enum Events {
  READY("onReady"),
  ERROR("onError");

  private final String mName;

  Events(final String name) {
    mName = name;
  }

  @Override
  public String toString() {
    return mName;
  }
}
