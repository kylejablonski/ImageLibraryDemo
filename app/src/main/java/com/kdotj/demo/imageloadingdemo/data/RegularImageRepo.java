package com.kdotj.demo.imageloadingdemo.data;

import java.util.Arrays;
import java.util.List;

class RegularImageRepo implements ImageRepo {

  private static final String[] imageUrlsRegular = new String[]{
      "https://images.unsplash.com/photo-1506371712237-a03dca697e2e?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=b93545a0a8552ff9bdf733a9d57e860d",
      "https://images.unsplash.com/photo-1506408117482-b60ae52a2480?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=e144c44093e22de55877c659bffe03ad",
      "https://images.unsplash.com/photo-1506372243740-26eb4f00cd11?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=8b1f51c55ae3835de1c317c7892ea2d8",
      "https://images.unsplash.com/photo-1506377637707-ba59e50e9304?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=15874ebb5e78e791c757afa2b70ded65",
      "https://images.unsplash.com/photo-1506404523803-9f9fa45e066e?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=c9f4c45aef81605bfb6e0f387182e324",
      "https://images.unsplash.com/photo-1506361797048-46a149213205?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=bf761b1f7e67183f2870d1261ea44ced",
      "https://images.unsplash.com/photo-1506377711776-dbdc2f3c20d9?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=7cb2083f4483764e78967efc5d773735",
      "https://images.unsplash.com/photo-1506356719850-7079b0a3ce75?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=cc37a6b655c16cc3b16aa01bead945d5",
      "https://images.unsplash.com/photo-1506372023823-741c83b836fe?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=3b11b348fd48c756d9fc10fb4d77bce4",
      "https://images.unsplash.com/photo-1506395308321-904a71783d60?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=c5ef6c2cd94e1aa61db8e37609ef2ab0"};

  RegularImageRepo(){}

  public List<String> getImageUrls() {
    return Arrays.asList(imageUrlsRegular);
  }
}
