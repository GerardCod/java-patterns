package dev.gerardo.java.patterns.solid.lsp;

public class Square extends Rectangle {
  
  public Square() {
    super();
  }

  public Square(int size) {
    super(size, size);
  }

  @Override
  public void setHeight(int height) {
    super.setWidth(height);
    super.setHeight(height);
  }

  @Override
  public void setWidth(int width) {
    super.setWidth(width);
    super.setHeight(width);
  }

  
}
