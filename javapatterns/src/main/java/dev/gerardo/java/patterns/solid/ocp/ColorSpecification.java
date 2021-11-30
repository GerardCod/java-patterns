package dev.gerardo.java.patterns.solid.ocp;

public class ColorSpecification implements Specification<Product> {
  private Color color;

  public ColorSpecification(Color color) {
    this.color = color;
  }

  @Override
  public boolean isSatified(Product item) {
    return item.color == this.color;
  }
  
}
