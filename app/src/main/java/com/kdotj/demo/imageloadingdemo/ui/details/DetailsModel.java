package com.kdotj.demo.imageloadingdemo.ui.details;

import java.util.Locale;

/**
 * Created by kyle.jablonski on 10/20/17.
 */

public class DetailsModel {

  private static final String BASE_URL = "https://github.com";
  private static final String NEW_LINE_AND_TABS = "\n\t";
  private static final String[] DOCS_URL_ARRAY = new String[]{
      BASE_URL + "/bumptech/glide",
      BASE_URL + "/square/picasso",
      BASE_URL + "/koush/ion",
      BASE_URL + "/facebook/fresco"
  };
  private String codeSnippet;
  private String libraryTitle;
  private int libraryId;
  private String imageUrl;

  DetailsModel(String libraryTitle, int libraryId, String imageUrl) {
    this.libraryTitle = libraryTitle;
    this.imageUrl = imageUrl;
    this.libraryId = libraryId;
    generateCodeSnippet(libraryId, imageUrl);
  }

  private void generateCodeSnippet(int libraryId, String imageUrl) {
    switch (libraryId) {
      case 0:
        codeSnippet = getGlideCodeSnippet(imageUrl);
        break;
      case 1:
        codeSnippet = getPicassoCodeSnippet(imageUrl);
        break;
      case 2:
        codeSnippet = getIonCodeSnippet(imageUrl);
        break;
      case 3:
        codeSnippet = getFrescoCodeSnippet(imageUrl);
        break;
      default:
        throw new IllegalArgumentException("Invalid library id!");
    }

  }

  String getDocsUrl() {
    return DOCS_URL_ARRAY[libraryId];
  }

  String getCodeSnippet() {
    return codeSnippet;
  }

  String getLibraryTitle() {
    return libraryTitle;
  }

  String getImageUrl() {
    return imageUrl;
  }

  int getLibraryId() {
    return libraryId;
  }

  private String getGlideCodeSnippet(String url) {
    return "Glide.with(context)\n\t\t"
        + String.format(Locale.getDefault(), ".load(\"%s\")", url)
        + NEW_LINE_AND_TABS
        + ".into(imageView)";
  }

  private String getPicassoCodeSnippet(String url) {
    return "Picasso.with(context)\n\t\t" + String
        .format(Locale.getDefault(), ".load(\"%s\")", url)
        + NEW_LINE_AND_TABS
        + ".placeholder(R.drawable.placeholder)"
        + NEW_LINE_AND_TABS
        + ".error(R.drawable.error)"
        + NEW_LINE_AND_TABS
        + ".into(imageView);";
  }

  private String getIonCodeSnippet(String url) {
    return
        "Ion.with(imageView)"
            + NEW_LINE_AND_TABS
            + ".placeholder(R.drawable.placeholder)"
            + NEW_LINE_AND_TABS
            + ".error(R.drawable.error)"
            + NEW_LINE_AND_TABS
            + String.format(Locale.getDefault(), ".load(\"%s\")", url);
  }

  private String getFrescoCodeSnippet(String url) {
    return String.format(Locale.getDefault(), "Uri uri = Uri.parse(\"%s\");", url)
        + "\nSimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);"
        + "\ndraweeView.setImageURI(uri);";
  }

}
