package com.kdotj.demo.imageloadingdemo.ui.main;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.kdotj.demo.imageloadingdemo.R;
import com.kdotj.demo.imageloadingdemo.data.ImageRepo;
import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;

import java.util.Locale;

class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {

  private ImageRepo imageRepo;
  private int imageLibraryId;
  private final ImageAdapter.Callback callback;

  interface Callback {

    void onItemClickedTransition(ImageView view, String url, int libraryId);

    void onItemClicked(String url, int libraryId);
  }

  ImageAdapter(ImageAdapter.Callback callback, int imageLibraryId, ImageRepo imageRepo) {
    this.imageRepo = imageRepo;
    this.imageLibraryId = imageLibraryId;
    this.callback = callback;
  }

  @Override
  public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ImageViewHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_row, parent, false));
  }

  @Override
  public void onBindViewHolder(final ImageViewHolder holder, int position) {
    holder.title.setText(String.format(Locale.getDefault(),
        holder.itemView.getResources().getString(R.string.image_item_title),
        Integer.toString(position + 1)));
    loadImage(holder, position);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
      public void onClick(View view) {
        if (imageLibraryId != 3) {
          callback.onItemClickedTransition(holder.imageView,
              imageRepo.getImageUrls().get(holder.getAdapterPosition()), imageLibraryId);
        } else {
          callback.onItemClicked(
              imageRepo.getImageUrls().get(holder.getAdapterPosition()), imageLibraryId);
        }

      }
    });
  }

  @Override
  public int getItemCount() {
    return this.imageRepo != null && imageRepo.getImageUrls() != null && !imageRepo
        .getImageUrls().isEmpty() ? imageRepo.getImageUrls().size() : 0;
  }

  private void loadImage(ImageViewHolder holder, int position) {
    String url = imageRepo.getImageUrls().get(position);
    switch (imageLibraryId) {
      case 0:
        holder.imageView.setVisibility(View.VISIBLE);
        holder.draweeView.setVisibility(View.GONE);
        Glide.with(holder.imageView.getContext())
            .load(url)
            .into(holder.imageView);
        break;
      case 1:
        holder.imageView.setVisibility(View.VISIBLE);
        holder.draweeView.setVisibility(View.GONE);
        Picasso.with(holder.imageView.getContext())
            .load(url)
            .placeholder(R.drawable.placeholder_gradient)
            .error(R.drawable.error_gradient)
            .into(holder.imageView);
        break;
      case 2:
        holder.imageView.setVisibility(View.VISIBLE);
        holder.draweeView.setVisibility(View.GONE);
        Ion.with(holder.imageView)
            .placeholder(R.drawable.placeholder_gradient)
            .error(R.drawable.error_gradient)
            .load(url);
        break;
      case 3:
        holder.imageView.setVisibility(View.GONE);
        holder.draweeView.setVisibility(View.VISIBLE);
        Uri uri = Uri.parse(url);
        holder.draweeView.setImageURI(uri);
        break;
      default:
        throw new IllegalStateException("Invalid image library id! -> " + imageLibraryId);
    }
  }
}
