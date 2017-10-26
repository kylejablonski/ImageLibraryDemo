package com.kdotj.demo.imageloadingdemo;

import android.app.Application;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by kyle.jablonski on 10/20/17.
 */

public class ImageLoadingApp extends Application {

  public static String PREFERENCES = "image_loading_prefs";
  public static String KEY_REPO_ID = "repo_id";
  public static String KEY_IMAGE_LIB_ID = "image_library_id";

  public ImageLoadingApp() {
  }

  public void onCreate() {
    super.onCreate();
    Fresco.initialize(this);
  }
}
