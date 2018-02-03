package com.moussawi7.controlledgif;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import java.util.*;
import javax.annotation.Nullable;

import com.felipecsl.gifimageview.library.GifImageView;
import android.graphics.Bitmap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ReactControlledGifManager extends SimpleViewManager<GifImageView> implements LifecycleEventListener{

  public static final String REACT_CLASS = "RCTControlledGifView";
  private static ThemedReactContext reactContext = null;
  private GifImageView mView;
  private Boolean isPlaying=false;

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @Override
  public void onHostDestroy() {
  //  Log.e("#","onHostDestroy");
  }

  @Override
  public void onHostResume() {
  //  Log.e("#","onHostResume");
  }

  @Override
  public void onHostPause() {
  //  Log.e("#","onHostPause");
  }

  @Override
  @Nullable
  public Map getExportedCustomDirectEventTypeConstants() {
    MapBuilder.Builder builder = MapBuilder.builder();
    builder.put(Events.READY.toString(), MapBuilder.of("registrationName", Events.READY.toString()));
    builder.put(Events.ERROR.toString(), MapBuilder.of("registrationName", Events.ERROR.toString()));
    return builder.build();
  }

  @Override
  protected GifImageView createViewInstance(ThemedReactContext context) {
    reactContext = context;
    return new GifImageView(context);
  }

  @ReactProp(name = "isPlaying")
  public void setPlaying(final GifImageView view, @Nullable Boolean isPlaying) {
    isPlaying=isPlaying;
    if(isPlaying){
      view.startAnimation();
    }else{
      view.stopAnimation();
    }
  }

  @ReactProp(name = "url")
  public void setUrl(final GifImageView view, @Nullable String url) {
    mView=view;
    view.setOnFrameAvailable(new GifImageView.OnFrameAvailable() {
      @Override
      public Bitmap onFrameAvailable(Bitmap bitmap) {
        return bitmap;
      }
    });

    new GifDataDownloader() {
      @Override protected void onPostExecute(final byte[] bytes) {
        if(bytes==null){
          WritableMap event = Arguments.createMap();
          event.putString("code","UNABLE_TO_LOAD");
          event.putString("message","Unable to load file");
          reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(view.getId(),Events.ERROR.toString(),event);
          return;
        }

        view.setBytes(bytes);
        if(isPlaying){
          view.startAnimation();
        }
        WritableMap event = Arguments.createMap();
        event.putString("width",""+view.getGifWidth());
        event.putString("height",""+view.getGifHeight());
        reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(view.getId(),Events.READY.toString(),event);
      }}.execute(url);
    }

  }
