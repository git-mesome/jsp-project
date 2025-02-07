package io.wisoft.seminar.vo;

public class ActionForward {

  private String path;
  private boolean redirect;

  public ActionForward() {

  }

  public String getPath() {
    return path;
  }

  public void setPath(final String path) {
    this.path = path;
  }

  public boolean isRedirect() {
    return redirect;
  }

  public void setRedirect(final boolean redirect) {
    this.redirect = redirect;
  }

}
