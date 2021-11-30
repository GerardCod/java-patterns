package dev.gerardo.java.patterns.solid.ocp;

public interface Specification<T> {
  boolean isSatified(T item);
}
