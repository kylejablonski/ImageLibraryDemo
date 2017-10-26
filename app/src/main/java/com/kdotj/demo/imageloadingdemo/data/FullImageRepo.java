package com.kdotj.demo.imageloadingdemo.data;

import java.util.Arrays;
import java.util.List;

class FullImageRepo implements ImageRepo {

  private static final String[] imageUrlsFull = new String[]{
      "https://images.unsplash.com/photo-1506371712237-a03dca697e2e?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=cbd2e87ac779a0be21e46bce73907256",
      "https://images.unsplash.com/photo-1506408117482-b60ae52a2480?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=c6e8d25c0366435ee4aa256e66a4b92b",
      "https://images.unsplash.com/photo-1506372243740-26eb4f00cd11?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=9c8b540e2f5e33b7b9f90ed01c0a00fc",
      "https://images.unsplash.com/photo-1506377637707-ba59e50e9304?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=ce5599ab1ae66633a9f3d72ad1d1061a",
      "https://images.unsplash.com/photo-1506404523803-9f9fa45e066e?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=d6e304d87d29f5346289ba19f92dc84f",
      "https://images.unsplash.com/photo-1506361797048-46a149213205?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=7ef8df4395255bec27ac3fd4756d3dcf",
      "https://images.unsplash.com/photo-1506377711776-dbdc2f3c20d9?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=3aeb1fed159a14def7c4d0aaf8396f92",
      "https://images.unsplash.com/photo-1506356719850-7079b0a3ce75?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=acb7d1d9834ab6992c3127936241597a",
      "https://images.unsplash.com/photo-1506372023823-741c83b836fe?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=fcc8d86e492fa65fade277789e689ad0",
      "https://images.unsplash.com/photo-1506395308321-904a71783d60?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=71868a99872a2427096674949ec1b4a1"};

  FullImageRepo(){}

  public List<String> getImageUrls() {
    return Arrays.asList(imageUrlsFull);
  }

}
