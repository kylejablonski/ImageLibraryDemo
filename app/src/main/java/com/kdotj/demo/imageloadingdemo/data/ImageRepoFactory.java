package com.kdotj.demo.imageloadingdemo.data;

/**
 * Factory for Creating an {@link ImageRepo}.
 * <p>
 * The Default repo is {@link RepoType#THUMB}.
 * Created by kyle.jablonski on 10/20/17.
 */

public class ImageRepoFactory {

  /**
   * private constructor to avoid initializing this class
   */
  private ImageRepoFactory(){}

  public static ImageRepo getRepo(ImageRepoFactory.RepoType repoType) {
    switch(repoType) {
      case SMALL:
        return new SmallImageRepo();
      case REGULAR:
        return new RegularImageRepo();
      case FULL:
        return new FullImageRepo();
      case THUMB:
      default:
        return new ThumbImageRepo();
    }
  }

  public enum RepoType {
    THUMB(0),
    SMALL(1),
    REGULAR(2),
    FULL(3);

    private int type;

    RepoType(int type) {
      this.type = type;
    }

    public static ImageRepoFactory.RepoType from(int type) {
      ImageRepoFactory.RepoType[] repoTypes = values();
      for(RepoType repoType: repoTypes) {
        if(repoType.type == type) {
          return repoType;
        }
      }
      return THUMB;
    }
  }

}
