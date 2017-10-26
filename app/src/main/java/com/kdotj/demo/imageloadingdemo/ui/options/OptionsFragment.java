package com.kdotj.demo.imageloadingdemo.ui.options;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.kdotj.demo.imageloadingdemo.ImageLoadingApp;
import com.kdotj.demo.imageloadingdemo.R;

public class OptionsFragment extends Fragment implements OptionsFragmentContracts.View,
    OnMenuItemClickListener {

  private RadioGroup mRadioGroupLibrary;
  private RadioGroup mRadioGroupRepo;
  private OptionsPresenter mOptionsPresenter;
  private OptionsFragment.Callback mCallback;

  public interface Callback {

    void onHandleDrawerState();
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    final SharedPreferences sharedPreferences = getContext()
        .getSharedPreferences(ImageLoadingApp.PREFERENCES, Context.MODE_PRIVATE);

    final OptionsModel optionsModel = new OptionsModel(sharedPreferences);
    mOptionsPresenter = new OptionsPresenter(this, optionsModel);

  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    try{
      mCallback = (OptionsFragment.Callback) context;
    } catch(ClassCastException ex){
      throw new IllegalStateException("Rethrowing ClassCastException! Parent must implement OptionsFragment.Callback!");
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mCallback = null; // null the callback to avoid any leaks
  }

  @Nullable
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_options, container);
    Toolbar toolbar = view.findViewById(R.id.toolbar_options);
    toolbar.inflateMenu(R.menu.menu_options);
    toolbar.setOnMenuItemClickListener(this);
    mRadioGroupLibrary = view.findViewById(R.id.radio_group_library);
    mRadioGroupRepo = view.findViewById(R.id.radio_group_repo);
    return view;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mOptionsPresenter.setInitialState();
  }

  @Override
  public boolean onMenuItemClick(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_apply:

        int libraryViewId = mRadioGroupLibrary.getCheckedRadioButtonId();
        View libraryButton = mRadioGroupLibrary.findViewById(libraryViewId);
        int libraryId = mRadioGroupLibrary.indexOfChild(libraryButton);

        int repoViewId = mRadioGroupRepo.getCheckedRadioButtonId();
        View repoButton = mRadioGroupRepo.findViewById(repoViewId);
        int repoId = mRadioGroupRepo.indexOfChild(repoButton);

        mOptionsPresenter.applySelected(libraryId, repoId);
        mCallback.onHandleDrawerState();
        return true;
      default:
        return false;
    }
  }

  @Override
  public void updateLibrarySelection(int imageLibraryId) {
    RadioButton libraryButton = (RadioButton) mRadioGroupLibrary.getChildAt(imageLibraryId);
    libraryButton.setChecked(true);
  }

  @Override
  public void updateRepoSelection(int repoId) {
    RadioButton repoButton = (RadioButton) mRadioGroupRepo.getChildAt(repoId);
    repoButton.setChecked(true);
  }

}