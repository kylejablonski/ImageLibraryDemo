package com.kdotj.demo.imageloadingdemo.ui.details;

/**
 * Created by kyle.jablonski on 10/20/17.
 */

public class DetailsActivityContracts {

  public interface Presenter {
    void viewOnGithubClicked();

    void copyCodeClicked();

    void shareClicked();
  }

  public interface View {
    void showDetailsTitle(String var1);

    void showCodeSnippet(String var1);

    void navigateToGithub(String var1);

    void copyCodeSnippet(String var1);

    void loadImage(String var1, int var2);

    void showShareIntent(String var1, String var2);
  }

}
