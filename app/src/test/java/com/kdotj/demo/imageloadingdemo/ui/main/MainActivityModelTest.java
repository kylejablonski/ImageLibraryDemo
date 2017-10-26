package com.kdotj.demo.imageloadingdemo.ui.main;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

import android.content.SharedPreferences;
import com.kdotj.demo.imageloadingdemo.ImageLoadingApp;
import com.kdotj.demo.imageloadingdemo.data.ImageRepo;
import com.kdotj.demo.imageloadingdemo.data.ThumbImageRepo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by kyle.jablonski on 10/25/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class MainActivityModelTest {

  @Mock
  private SharedPreferences mSharedPreferences;

  @Mock
  private SharedPreferences.Editor mEditor;

  // SUT
  private MainActivityModel mMainActivityModel;


  @Before
  public void setup(){
    MockitoAnnotations.initMocks(this);
    mMainActivityModel = new MainActivityModel(mSharedPreferences);
  }

  @Test
  public void getImageRepo_ShouldReturn_ThumbImageRepo(){
    // given
    given(mSharedPreferences.getInt(eq(ImageLoadingApp.KEY_REPO_ID), anyInt())).willReturn(0);

    // when
    ImageRepo imageRepo = mMainActivityModel.getImageRepo();

    // then
    assertThat(imageRepo).isInstanceOf(ThumbImageRepo.class);
  }

  @Test
  public void getLibraryId_ShouldReturn_Zero (){
    int expected = 0;

    // given
    given(mSharedPreferences.getInt(eq(ImageLoadingApp.KEY_IMAGE_LIB_ID), anyInt())).willReturn(0);

    // when
    int libraryId = mMainActivityModel.getLibraryId();

    // then
    assertThat(libraryId).isEqualTo(expected);
  }

}
