package com.kdotj.demo.imageloadingdemo.ui.details;



import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by kyle.jablonski on 10/25/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class DetailsModelTest {

  private static final String HTTPS_GITHUB_COM = "https://github.com";

  // SUT
  private DetailsModel detailsModel;

  @Test(expected = IllegalArgumentException.class)
  public void invalidLibraryId_ShouldThrow_IllegalArgumentException(){
    // given
    String libraryTitle = "Anything";
    int libraryId = -1;
    String sampleImageUrl = "https://images.unsplash.com/photo-1506371712237-a03dca697e2e?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=3d8ff0ccd05f40b47c62792e8847e79e";

    // when
    detailsModel = new DetailsModel(libraryTitle, libraryId, sampleImageUrl);

  }

  @Test
  public void glideLibrary_ShouldReturn_CorrectData(){

    // given
    String expectedRepoUrl = HTTPS_GITHUB_COM + "/bumptech/glide";
    String libraryTitle = "Glide";
    int libraryId = 0;
    String sampleImageUrl = "https://images.unsplash.com/photo-1506371712237-a03dca697e2e?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=3d8ff0ccd05f40b47c62792e8847e79e";

    // when
    detailsModel = new DetailsModel(libraryTitle, libraryId, sampleImageUrl);

    // then
    assertThat(detailsModel.getLibraryId()).isEqualTo(libraryId);
    assertThat(detailsModel.getLibraryTitle()).isEqualTo(libraryTitle);
    assertThat(detailsModel.getDocsUrl()).isEqualTo(expectedRepoUrl);
    assertThat(detailsModel.getCodeSnippet()).isNotEmpty();
    assertThat(detailsModel.getImageUrl()).isEqualTo(sampleImageUrl);
  }

  @Test
  public void picassoLibrary_ShouldReturn_CorrectData(){

    // given
    String expectedRepoUrl = HTTPS_GITHUB_COM + "/square/picasso";
    String libraryTitle = "Picasso";
    int libraryId = 1;
    String sampleImageUrl = "https://images.unsplash.com/photo-1506371712237-a03dca697e2e?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=3d8ff0ccd05f40b47c62792e8847e79e";

    // when
    detailsModel = new DetailsModel(libraryTitle, libraryId, sampleImageUrl);

    // then
    assertThat(detailsModel.getLibraryId()).isEqualTo(libraryId);
    assertThat(detailsModel.getLibraryTitle()).isEqualTo(libraryTitle);
    assertThat(detailsModel.getDocsUrl()).isEqualTo(expectedRepoUrl);
    assertThat(detailsModel.getCodeSnippet()).isNotEmpty();
    assertThat(detailsModel.getImageUrl()).isEqualTo(sampleImageUrl);
  }

  @Test
  public void ionLibrary_ShouldReturn_CorrectData(){

    // given
    String expectedRepoUrl = HTTPS_GITHUB_COM + "/koush/ion";
    String libraryTitle = "Ion";
    int libraryId = 2;
    String sampleImageUrl = "https://images.unsplash.com/photo-1506371712237-a03dca697e2e?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=3d8ff0ccd05f40b47c62792e8847e79e";

    // when
    detailsModel = new DetailsModel(libraryTitle, libraryId, sampleImageUrl);

    // then
    assertThat(detailsModel.getLibraryId()).isEqualTo(libraryId);
    assertThat(detailsModel.getLibraryTitle()).isEqualTo(libraryTitle);
    assertThat(detailsModel.getDocsUrl()).isEqualTo(expectedRepoUrl);
    assertThat(detailsModel.getCodeSnippet()).isNotEmpty();
    assertThat(detailsModel.getImageUrl()).isEqualTo(sampleImageUrl);
  }

  @Test
  public void frescoLibrary_ShouldReturn_CorrectData(){

    // given
    String expectedRepoUrl = HTTPS_GITHUB_COM + "/facebook/fresco";
    String libraryTitle = "Fresco";
    int libraryId = 3;
    String sampleImageUrl = "https://images.unsplash.com/photo-1506371712237-a03dca697e2e?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=3d8ff0ccd05f40b47c62792e8847e79e";

    // when
    detailsModel = new DetailsModel(libraryTitle, libraryId, sampleImageUrl);

    // then
    assertThat(detailsModel.getLibraryId()).isEqualTo(libraryId);
    assertThat(detailsModel.getLibraryTitle()).isEqualTo(libraryTitle);
    assertThat(detailsModel.getDocsUrl()).isEqualTo(expectedRepoUrl);
    assertThat(detailsModel.getCodeSnippet()).isNotEmpty();
    assertThat(detailsModel.getImageUrl()).isEqualTo(sampleImageUrl);

  }




}
