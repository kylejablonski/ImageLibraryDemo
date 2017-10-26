package com.kdotj.demo.imageloadingdemo.ui.options;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.content.SharedPreferences;
import com.kdotj.demo.imageloadingdemo.ImageLoadingApp;

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
public class OptionsModelTest {

  @Mock
  private SharedPreferences mSharedPreferences;

  @Mock
  private SharedPreferences.Editor mEditor;

  // SUT
  private OptionsModel mOptionsModel;


  @Before
  public void setup(){
    MockitoAnnotations.initMocks(this);
    mOptionsModel = new OptionsModel(mSharedPreferences);
  }

  @Test
  public void updateSelection_ShouldEditPreferences(){
    // given
    int libraryId = 0;
    int repoId = 0;

    // when
    when(mSharedPreferences.edit()).thenReturn(mEditor);
    when(mEditor.putInt(anyString(), anyInt())).thenReturn(mEditor);

    mOptionsModel.applyNewSetting(libraryId, repoId);

    // then
    verify(mEditor, times(2)).apply();
  }

  @Test
  public void getImageRepo_ShouldReturn_ThumbImageRepo(){
    // given
    int expected = 0;
    given(mSharedPreferences.getInt(eq(ImageLoadingApp.KEY_REPO_ID), anyInt())).willReturn(0);

    // when
    int repoId = mOptionsModel.getInitialRepoSetting();

    // then
    assertThat(repoId).isEqualTo(expected);
  }

  @Test
  public void getLibraryId_ShouldReturn_Zero (){
    // given
    int expected = 0;
    given(mSharedPreferences.getInt(eq(ImageLoadingApp.KEY_IMAGE_LIB_ID), anyInt())).willReturn(0);

    // when
    int libraryId = mOptionsModel.getInitialLibrarySetting();

    // then
    assertThat(libraryId).isEqualTo(expected);
  }

}
