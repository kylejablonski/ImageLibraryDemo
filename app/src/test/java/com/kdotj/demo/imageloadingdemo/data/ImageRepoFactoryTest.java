package com.kdotj.demo.imageloadingdemo.data;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.kdotj.demo.imageloadingdemo.data.ImageRepoFactory.RepoType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Test the ImageRepoFactory to make sure we get some data and its for the right {@link RepoType}
 * Created by kyle.jablonski on 10/25/17.
 */

@RunWith(JUnit4.class)
public class ImageRepoFactoryTest {

  private RepoType repoType;

  // SUT
  private ImageRepo imageRepo;

  @Test
  public void imageRepoFrom_InvalidId_ShouldReturnThumbImageRepo(){
    // given
    RepoType repoType = RepoType.from(-1);

    // when
    imageRepo = ImageRepoFactory.getRepo(repoType);

    // then
    assertThat(imageRepo).isInstanceOf(ThumbImageRepo.class);
  }

  @Test
  public void repoTypeThumb_ShouldReturn_ThumbImageRepo(){
    // given
    repoType = RepoType.THUMB;

    // when
    imageRepo = ImageRepoFactory.getRepo(repoType);

    // then
    assertThat(imageRepo).isInstanceOf(ThumbImageRepo.class);
  }

  @Test
  public void repoTypeThumb_ShouldReturn_AtLeastOneItem(){
    // given
    repoType = RepoType.THUMB;

    // when
    imageRepo = ImageRepoFactory.getRepo(repoType);

    // then
    assertThat(imageRepo.getImageUrls().size()).isGreaterThanOrEqualTo(1);
  }

  @Test
  public void repoTypeSmall_ShouldReturn_SmallImageRepo(){
    // given
    repoType = RepoType.SMALL;

    // when
    imageRepo = ImageRepoFactory.getRepo(repoType);

    // then
    assertThat(imageRepo).isInstanceOf(SmallImageRepo.class);
  }

  @Test
  public void repoTypeSmall_ShouldReturn_AtLeastOneItem(){
    // given
    repoType = RepoType.SMALL;

    // when
    imageRepo = ImageRepoFactory.getRepo(repoType);

    // then
    assertThat(imageRepo.getImageUrls().size()).isGreaterThanOrEqualTo(1);
  }

  @Test
  public void repoTypeRegular_ShouldReturn_RegularImageRepo(){
    // given
    repoType = RepoType.REGULAR;

    // when
    imageRepo = ImageRepoFactory.getRepo(repoType);

    // then
    assertThat(imageRepo).isInstanceOf(RegularImageRepo.class);
  }

  @Test
  public void repoTypeRegular_ShouldReturn_AtLeastOneItem(){
    // given
    repoType = RepoType.REGULAR;

    // when
    imageRepo = ImageRepoFactory.getRepo(repoType);

    // then
    assertThat(imageRepo.getImageUrls().size()).isGreaterThanOrEqualTo(1);
  }

  @Test
  public void repoTypeFull_ShouldReturn_FullImageRepo(){
    // given
    repoType = RepoType.FULL;

    // when
    imageRepo = ImageRepoFactory.getRepo(repoType);

    // then
    assertThat(imageRepo).isInstanceOf(FullImageRepo.class);
  }

  @Test
  public void repoTypeFull_ShouldReturn_AtLeastOneItem(){
    // given
    repoType = RepoType.FULL;

    // when
    imageRepo = ImageRepoFactory.getRepo(repoType);

    // then
    assertThat(imageRepo.getImageUrls().size()).isGreaterThanOrEqualTo(1);
  }

  @Test
  public void repoTypeFrom_ShouldReturn_MatchedRepo(){
    // given
    RepoType repoType = RepoType.from(0);

    // when
    imageRepo = ImageRepoFactory.getRepo(repoType);

    // then
    assertThat(imageRepo.getImageUrls().size()).isGreaterThanOrEqualTo(1);
  }

}
