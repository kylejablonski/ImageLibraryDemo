package com.kdotj.demo.imageloadingdemo.ui.details;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.kdotj.demo.imageloadingdemo.R;
import com.kdotj.demo.imageloadingdemo.ui.main.MainActivity;
import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;

import java.util.Locale;

/**
 * Created by kyle.jablonski on 10/20/17.
 */

public class DetailActivity extends AppCompatActivity implements DetailsActivityContracts.View,
    LibraryTextView.Callback {

  public static final String KEY_IMAGE_URL = "key_image_url";
  public static final String KEY_IMAGE_LIB_ID = "key_image_lib_id";

  private AppCompatImageView imageView;
  private SimpleDraweeView draweeView;
  private LibraryTextView libraryTextView;
  private Toolbar mToolbar;
  private CoordinatorLayout rootView;
  private DetailPresenter mDetailPresenter;
  private BottomSheetBehavior mBottomSheetBehavior;

  public static void createActivity(MainActivity mainActivity, String url, int libraryId,
      Bundle options) {
    Intent intent = new Intent(mainActivity, DetailActivity.class);
    intent.putExtra(DetailActivity.KEY_IMAGE_URL, url);
    intent.putExtra(DetailActivity.KEY_IMAGE_LIB_ID, libraryId);

    if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
      ActivityCompat.startActivity(mainActivity, intent, options);
    } else {
      mainActivity.startActivity(intent);
    }
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);
    mToolbar = findViewById(R.id.toolbar_details);
    setSupportActionBar(mToolbar);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);

    rootView = findViewById(R.id.root_view);
    libraryTextView = findViewById(R.id.library_text_view);
    libraryTextView.addCallback(this);
    imageView = findViewById(R.id.image_large);
    draweeView = findViewById(R.id.image_large_fresco);

    FrameLayout frameLayout = findViewById(R.id.bottom_sheet_frame);
    mBottomSheetBehavior = BottomSheetBehavior.from(frameLayout);

    Intent intent = getIntent();
    String url = intent.getStringExtra(KEY_IMAGE_URL);
    int imageLibraryId = intent.getIntExtra(KEY_IMAGE_LIB_ID, 0);

    String[] libraries = getResources().getStringArray(R.array.libraries);
    DetailsModel detailsModel = new DetailsModel(libraries[imageLibraryId], imageLibraryId, url);
    mDetailPresenter = new DetailPresenter(this, detailsModel);
    mDetailPresenter.start();
  }


  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  @Override
  public void showDetailsTitle(String title) {
    mToolbar.setTitle(title);
    libraryTextView.setTitle(String.format(Locale.getDefault(), getString(R.string.snippet_title), title));
  }

  @Override
  public void showCodeSnippet(String snippet) {
    libraryTextView.setCodeSnippetText(snippet);
  }

  @Override
  public void navigateToGithub(String url) {
    Intent intent = new Intent(Intent.ACTION_VIEW);
    intent.setData(Uri.parse(url));
    startActivity(intent);
  }

  @Override
  public void copyCodeSnippet(String snippet) {

    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    ClipData clip = ClipData.newPlainText(getString(R.string.app_name), snippet);
    clipboard.setPrimaryClip(clip);

    Snackbar.make(rootView, getString(R.string.clipboard_message), Snackbar.LENGTH_LONG)
        .setAction(getString(R.string.share), new OnClickListener() {
          @Override
          public void onClick(View view) {
            mDetailPresenter.shareClicked();
          }
        }).show();
  }

  @Override
  public void loadImage(String url, int libraryId) {
    switch (libraryId) {
      case 0:
        imageView.setVisibility(View.VISIBLE);
        draweeView.setVisibility(View.GONE);
        Glide.with(imageView.getContext())
            .load(url)
            .into(imageView);
        break;
      case 1:
        imageView.setVisibility(View.VISIBLE);
        draweeView.setVisibility(View.GONE);
        Picasso.with(imageView.getContext())
            .load(url)
            .placeholder(R.drawable.placeholder_gradient)
            .error(R.drawable.error_gradient)
            .into(imageView);
        break;
      case 2:
        imageView.setVisibility(View.VISIBLE);
        draweeView.setVisibility(View.GONE);
        Ion.with(imageView)
            .placeholder(R.drawable.placeholder_gradient)
            .error(R.drawable.error_gradient)
            .load(url);
        break;
      case 3:
        imageView.setVisibility(View.GONE);
        draweeView.setVisibility(View.VISIBLE);
        Uri uri = Uri.parse(url);
        draweeView.setImageURI(uri);
        break;
      default:
        throw new IllegalStateException("Invalid image library id! -> " + libraryId);
    }
  }

  @Override
  public void showShareIntent(String title, String content) {
    Intent intent = new Intent();
    intent.setAction(Intent.ACTION_SEND);
    intent.putExtra(Intent.EXTRA_TEXT, content);
    intent.setType("text/plain");

    Intent.createChooser(intent, title);

    startActivity(intent);
  }

  @Override
  public void copyCodeClicked() {
    mDetailPresenter.copyCodeClicked();

  }

  @Override
  public void visitGithubPage() {
    mDetailPresenter.viewOnGithubClicked();
  }

  @Override
  public void onToolbarClicked() {
    handleBottomSheetState();
  }

  private void handleBottomSheetState(){
    if(mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED){
      mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }else{
      mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }
  }


}
