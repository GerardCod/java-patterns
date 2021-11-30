package dev.gerardo.java.patterns.solid.ocp;

public class SizeSpecialisation implements Specification<Product> {
  private Size size;

  public SizeSpecialisation(Size size) {
    this.size = size;
  }

  @Override
  public boolean isSatified(Product item) {
    return item.size == size;
  }
  
}
