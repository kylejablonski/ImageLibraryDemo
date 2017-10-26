package com.kdotj.demo.imageloadingdemo.data;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kyle.jablonski on 10/20/17.
 */

public class ThumbImageRepo implements ImageRepo {

  private static final String[] imageUrlsThumb = new String[]{
      "https://images.unsplash.com/photo-1506371712237-a03dca697e2e?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=3d8ff0ccd05f40b47c62792e8847e79e",
      "https://images.unsplash.com/photo-1506408117482-b60ae52a2480?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=076b175bfff5f39db39659c9cc32076e",
      "https://images.unsplash.com/photo-1506372243740-26eb4f00cd11?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=a786690ef185e28fd4027a5e5344ecfe",
      "https://images.unsplash.com/photo-1506377637707-ba59e50e9304?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=faa4d4a6282e72b8d7131673d466fbe5",
      "https://images.unsplash.com/photo-1506404523803-9f9fa45e066e?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=9054e576162b57c408b8a199c3f79cd1",
      "https://images.unsplash.com/photo-1506361797048-46a149213205?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=400ac58e9231968e6fa07404de6d12d0",
      "https://images.unsplash.com/photo-1506377711776-dbdc2f3c20d9?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=4c90cd0725aafcbf1b31ca4875bf0cd7",
      "https://images.unsplash.com/photo-1506356719850-7079b0a3ce75?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=288aeee5a6901868f2598cc32730cd80",
      "https://images.unsplash.com/photo-1506372023823-741c83b836fe?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=b2a9128203f88df75b3707bdf43a13cd",
      "https://images.unsplash.com/photo-1506395308321-904a71783d60?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=d972a038feb9ec372e71abdbe7a83055"};

  ThumbImageRepo(){}

  public List<String> getImageUrls() {
    return Arrays.asList(imageUrlsThumb);
  }

}
