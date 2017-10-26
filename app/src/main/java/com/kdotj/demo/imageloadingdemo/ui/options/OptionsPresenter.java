package com.kdotj.demo.imageloadingdemo.ui.options;

/**
 * Created by kyle.jablonski on 10/26/17.
 */

public class OptionsPresenter implements OptionsFragmentContracts.Presenter {

  private final OptionsFragmentContracts.View view;
  private final OptionsModel optionsModel;

  OptionsPresenter(OptionsFragmentContracts.View view, OptionsModel optionsModel){
    this.view = view;
    this.optionsModel = optionsModel;
  }

  @Override
  public void setInitialState() {
    view.updateLibrarySelection(optionsModel.getInitialLibrarySetting());
    view.updateRepoSelection(optionsModel.getInitialRepoSetting());
  }

  @Override
  public void applySelected(int imageLibraryId, int repoId){
    optionsModel.applyNewSetting(imageLibraryId, repoId);
  }
}
