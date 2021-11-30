package dev.gerardo.java.patterns.solid.ocp;

public class AndSpecification<T> implements Specification<T> {
  private Specification<T> first;
  private Specification<T> second;

  public AndSpecification(Specification<T> first, Specification<T> second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public boolean isSatified(T item) {
    return first.isSatified(item) && second.isSatified(item);
  }
  
}
