package com.kdotj.demo.imageloadingdemo.ui.details;

import com.kdotj.demo.imageloadingdemo.ui.details.DetailsActivityContracts.Presenter;
import com.kdotj.demo.imageloadingdemo.ui.details.DetailsActivityContracts.View;

class DetailPresenter implements Presenter {

  private final View view;
  private final DetailsModel detailsModel;

  DetailPresenter(View view, DetailsModel detailsModel) {
    this.view = view;
    this.detailsModel = detailsModel;
  }

  void start() {
    view.loadImage(detailsModel.getImageUrl(), detailsModel.getLibraryId());
    view.showCodeSnippet(detailsModel.getCodeSnippet());
    view.showDetailsTitle(detailsModel.getLibraryTitle());
  }

  public void viewOnGithubClicked() {
    view.navigateToGithub(detailsModel.getDocsUrl());
  }

  public void copyCodeClicked() {
    view.copyCodeSnippet(detailsModel.getCodeSnippet());
  }

  public void shareClicked() {
    view.showShareIntent(detailsModel.getLibraryTitle(), detailsModel.getCodeSnippet());
  }

}
