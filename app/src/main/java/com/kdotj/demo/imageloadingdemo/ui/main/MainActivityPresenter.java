package com.kdotj.demo.imageloadingdemo.ui.main;

import com.kdotj.demo.imageloadingdemo.ui.main.MainActivityContracts.View;

class MainActivityPresenter implements MainActivityContracts.Presenter {
  private final MainActivityModel mainActivityModel;
  private final View view;

  MainActivityPresenter(MainActivityModel mainActivityModel, View view) {
    this.mainActivityModel = mainActivityModel;
    this.view = view;
  }

  @Override
  public void start(){
    view.updateAdapterData(mainActivityModel.getLibraryId(), mainActivityModel.getImageRepo());
  }

  @Override
  public void onSharedPreferencesUpdated() {
    view.updateAdapterData(mainActivityModel.getLibraryId(), mainActivityModel.getImageRepo());
  }

}
