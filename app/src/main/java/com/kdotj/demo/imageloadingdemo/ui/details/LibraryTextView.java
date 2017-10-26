package com.kdotj.demo.imageloadingdemo.ui.details;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.kdotj.demo.imageloadingdemo.R;


public class LibraryTextView extends RelativeLayout implements View.OnClickListener {

  private Toolbar mToolbar;
  private AppCompatTextView textViewCodeSnippet;
  private LibraryTextView.Callback callback;

  interface Callback {

    void copyCodeClicked();

    void visitGithubPage();

    void onToolbarClicked();
  }


  public LibraryTextView(Context context) {
    this(context, null);
  }

  public LibraryTextView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public LibraryTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    inflate(getContext(), R.layout.library_text_view, this);

    mToolbar = findViewById(R.id.toolbar_library_details);
    mToolbar.setOnClickListener(this);
    textViewCodeSnippet = findViewById(R.id.text_view_snippet);

    AppCompatButton buttonViewGithub = findViewById(R.id.button_github);
    AppCompatButton buttonCopyCode = findViewById(R.id.button_copy_code);
    buttonViewGithub.setOnClickListener(this);
    buttonCopyCode.setOnClickListener(this);
  }

  void setTitle(String libraryName) {
    mToolbar.setTitle(libraryName);
  }

  void setCodeSnippetText(String codeSnippet) {
    this.textViewCodeSnippet.setText(codeSnippet);
  }

  void addCallback(LibraryTextView.Callback callback) {
    this.callback = callback;
  }

  @Override
  public void onClick(View view) {
    switch(view.getId()) {
      case R.id.toolbar_library_details:
        callback.onToolbarClicked();
        break;
      case R.id.button_github:
        callback.visitGithubPage();
        break;
      case R.id.button_copy_code:
        callback.copyCodeClicked();
        break;
    }

  }
}
