package com.kdotj.demo.imageloadingdemo.ui.options;

import android.content.SharedPreferences;
import com.kdotj.demo.imageloadingdemo.ImageLoadingApp;

class OptionsModel {

  private final SharedPreferences mSharedPreferences;

  OptionsModel(SharedPreferences sharedPreferences){
    this.mSharedPreferences = sharedPreferences;
  }

  int getInitialLibrarySetting(){
    return mSharedPreferences.getInt(ImageLoadingApp.KEY_IMAGE_LIB_ID, 0);
  }

  int getInitialRepoSetting(){
    return mSharedPreferences.getInt(ImageLoadingApp.KEY_REPO_ID, 0);
  }

  void applyNewSetting(int imageLibraryId, int repoId){
    SharedPreferences.Editor editor = mSharedPreferences.edit();
    editor.putInt(ImageLoadingApp.KEY_IMAGE_LIB_ID, imageLibraryId).apply();
    editor.putInt(ImageLoadingApp.KEY_REPO_ID, repoId).apply();
  }

}
