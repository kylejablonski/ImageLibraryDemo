package com.kdotj.demo.imageloadingdemo.ui.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import com.kdotj.demo.imageloadingdemo.ImageLoadingApp;
import com.kdotj.demo.imageloadingdemo.R;
import com.kdotj.demo.imageloadingdemo.data.ImageRepo;
import com.kdotj.demo.imageloadingdemo.ui.details.DetailActivity;
import com.kdotj.demo.imageloadingdemo.ui.options.OptionsFragment;

public class MainActivity extends AppCompatActivity implements MainActivityContracts.View,
    ImageAdapter.Callback, SharedPreferences.OnSharedPreferenceChangeListener, OptionsFragment.Callback {

  private RecyclerView mRecyclerView;
  private DrawerLayout mDrawerLayout;
  private SharedPreferences mSharedPreferences;
  private MainActivityPresenter mActivityPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mSharedPreferences = getSharedPreferences(ImageLoadingApp.PREFERENCES, 0);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
    setSupportActionBar(toolbar);
    mDrawerLayout = (DrawerLayout) findViewById(R.id.options_drawer);
    mRecyclerView = (RecyclerView) findViewById(R.id.recycler_images);

    LinearLayoutManager llManager = new LinearLayoutManager(this, 1, false);
    mRecyclerView.setLayoutManager(llManager);
    mRecyclerView.addItemDecoration(new DividerItemDecoration(this, 1));

    MainActivityModel mainActivityModel = new MainActivityModel(mSharedPreferences);
    mActivityPresenter = new MainActivityPresenter(mainActivityModel, this);
    mActivityPresenter.start();
  }

  @Override
  protected void onPause() {
    super.onPause();
    mSharedPreferences.registerOnSharedPreferenceChangeListener(this);
  }

  @Override
  protected void onResume() {
    super.onResume();
    mSharedPreferences.registerOnSharedPreferenceChangeListener(this);
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_options:
        onHandleDrawerState();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  @Override
  public void updateAdapterData(int libraryId, ImageRepo imageRepo) {
    ImageAdapter newAdapter = new ImageAdapter(this, libraryId, imageRepo);
    mRecyclerView.setAdapter(newAdapter);
  }

  @Override
  public void onItemClickedTransition(ImageView imageView, String url, int libraryId) {
    ActivityOptionsCompat activityOptions =
        ActivityOptionsCompat.makeSceneTransitionAnimation(this,
            new Pair[]{new Pair(imageView, getString(R.string.transition_image_view))});
    if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
      DetailActivity.createActivity(this, url, libraryId, activityOptions.toBundle());
    } else {
      loadActivity(url, libraryId);
    }

  }

  @Override
  public void onItemClicked(String url, int libraryId) {
    loadActivity(url, libraryId);
  }

  @Override
  public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
    onHandleDrawerState();
    mActivityPresenter.onSharedPreferencesUpdated();
  }

  @Override
  public void onHandleDrawerState() {
    if (mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
      mDrawerLayout.closeDrawer(GravityCompat.END);
    } else {
      mDrawerLayout.openDrawer(GravityCompat.END);
    }
  }

  private void loadActivity(String url, int libraryId) {
    Intent intent = new Intent(this, DetailActivity.class);
    intent.putExtra(DetailActivity.KEY_IMAGE_URL, url);
    intent.putExtra(DetailActivity.KEY_IMAGE_LIB_ID, libraryId);
    startActivity(intent);
  }

}
