package com.kdotj.demo.imageloadingdemo.ui.main;

import android.content.SharedPreferences;
import com.kdotj.demo.imageloadingdemo.ImageLoadingApp;
import com.kdotj.demo.imageloadingdemo.data.ImageRepo;
import com.kdotj.demo.imageloadingdemo.data.ImageRepoFactory;
import com.kdotj.demo.imageloadingdemo.data.ImageRepoFactory.RepoType;

class MainActivityModel {

  private SharedPreferences mSharedPreferences;

  MainActivityModel(SharedPreferences sharedPreferences) {
    this.mSharedPreferences = sharedPreferences;
  }

  ImageRepo getImageRepo() {
    int repoType = this.mSharedPreferences.getInt(ImageLoadingApp.KEY_REPO_ID, 0);
    return ImageRepoFactory.getRepo(RepoType.from(repoType));
  }

  int getLibraryId() {
    return this.mSharedPreferences.getInt(ImageLoadingApp.KEY_IMAGE_LIB_ID, 0);
  }

}
