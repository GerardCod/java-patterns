package dev.gerardo.java.patterns.solid.lsp;

public class Rectangle {
  private int height;
  private int width;

  public Rectangle() {}
  
  public Rectangle(int width, int height) {
    this.setWidth(width);
    this.setHeight(height);
  }
  
  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int area() {
    return width * height;
  }

  @Override
  public String toString() {
    return "Rectangle [height=" + height + ", width=" + width + "]";
  }

}
