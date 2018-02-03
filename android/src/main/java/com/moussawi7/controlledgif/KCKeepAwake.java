package com.moussawi7.controlledgif;

import android.app.Activity;
import android.view.WindowManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.Callback;
import java.util.Map;
import java.util.HashMap;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import javax.annotation.Nullable;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import com.felipecsl.gifimageview.library.GifImageView;

public class KCKeepAwake extends ReactContextBaseJavaModule {

  private static final String MAX_NUMBER = "MAX_NUMBER";
  private static final String MIN_NUMBER = "MIN_NUMBER";
  private ReactContext reactContext=null;

  public KCKeepAwake(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "KCKeepAwake";
  }

  private void sendEvent(ReactContext reactContext,String eventName, @Nullable WritableMap params) {
    reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, params);
  }

  public Map<String, Object> getConstants() {
    final Map<String, Object> constants = new HashMap<>();
    constants.put(MAX_NUMBER,100);
    constants.put(MIN_NUMBER,0);
    return constants;
  }

  @ReactMethod
  public void activate(Integer a,Integer b,Promise promise) {
    Integer s=a+b;
    promise.resolve(s);
  }

  @ReactMethod
  public void deactivate(Promise promise) {
    promise.reject("$$","erorr to get value");
  }

  @ReactMethod
  public void tryCallback(Integer a,Integer b,Callback errorCallback,Callback successCallback) {
    Integer s=a+b;
    Integer m=a*b;
    errorCallback.invoke(m);
    //  successCallback.invoke(s);
  }

  @ReactMethod
  public void tryEvents(Integer a,Integer b) {
    Integer s=a+b;
    Integer m=a*b;
    WritableMap params = Arguments.createMap();
    params.putInt("resultSum",s);
    sendEvent(this.reactContext, "showResult", params);
  }


}
