package com.kdotj.demo.imageloadingdemo.ui.main;

import com.kdotj.demo.imageloadingdemo.data.ImageRepo;

/**
 * Created by kyle.jablonski on 10/20/17.
 */

public interface MainActivityContracts {

  interface View {

    void updateAdapterData(int libraryId, ImageRepo imageRepo);
  }

  interface Presenter {

    void start();

    void onSharedPreferencesUpdated();
  }

}
