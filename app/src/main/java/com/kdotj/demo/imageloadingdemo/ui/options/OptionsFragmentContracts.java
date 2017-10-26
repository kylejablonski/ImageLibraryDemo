package com.kdotj.demo.imageloadingdemo.ui.options;

/**
 * Created by kyle.jablonski on 10/26/17.
 */

public interface OptionsFragmentContracts {

  interface View {

    void updateLibrarySelection(int imageLibraryId);

    void updateRepoSelection(int repoId);

  }

  interface Presenter {

    void setInitialState();

    void applySelected(int imageLibraryId, int repoId);
  }

}
