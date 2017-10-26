package com.kdotj.demo.imageloadingdemo.data;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kyle.jablonski on 10/20/17.
 */

public class SmallImageRepo implements ImageRepo {

  private static final String[] imageUrlsSmall = new String[]{
      "https://images.unsplash.com/photo-1506371712237-a03dca697e2e?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=734f0c501c45888ffcd965e58c8c8563",
      "https://images.unsplash.com/photo-1506408117482-b60ae52a2480?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=9688826980f5a886b9b48f929086399e",
      "https://images.unsplash.com/photo-1506372243740-26eb4f00cd11?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=7c789f3b48a20a4991c1b3eca91fe6af",
      "https://images.unsplash.com/photo-1506377637707-ba59e50e9304?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=35d015c0abcdd7de49a653779c17709f",
      "https://images.unsplash.com/photo-1506404523803-9f9fa45e066e?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=90c0f6d4a7b210ddf3f69fbc0c713a6b",
      "https://images.unsplash.com/photo-1506361797048-46a149213205?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=ba9a9260e15e9aafc5e7f924e9bf3145",
      "https://images.unsplash.com/photo-1506377711776-dbdc2f3c20d9?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=259028246bb75ff5d0eddb109e2e8513",
      "https://images.unsplash.com/photo-1506356719850-7079b0a3ce75?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=072c90c025c75f1ac798b11985ae44a4",
      "https://images.unsplash.com/photo-1506372023823-741c83b836fe?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=80008fe9ef2c6bb1c88ba3c549fc1211",
      "https://images.unsplash.com/photo-1506395308321-904a71783d60?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=556ab223eb53e2e8969c54da353e75c6"};

  SmallImageRepo(){}

  public List<String> getImageUrls() {
    return Arrays.asList(imageUrlsSmall);
  }
}
