package com.kdotj.demo.imageloadingdemo.ui.main;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.facebook.drawee.view.SimpleDraweeView;
import com.kdotj.demo.imageloadingdemo.R;

class ImageViewHolder extends RecyclerView.ViewHolder {

  AppCompatImageView imageView;
  SimpleDraweeView draweeView;
  AppCompatTextView title;

  ImageViewHolder(View itemView) {
    super(itemView);
    imageView = itemView.findViewById(R.id.image_view);
    draweeView = itemView.findViewById(R.id.fresco_image_view);
    title = itemView.findViewById(R.id.image_title);
  }
}
