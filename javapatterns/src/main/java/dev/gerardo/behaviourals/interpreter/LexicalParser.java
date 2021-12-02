package dev.gerardo.behaviourals.interpreter;

interface Element {
  int eval();
}

class Integer implements Element {
  private int value;

  public Integer(int value) {
    this.value = value;
  }

  @Override
  public int eval() {
    return value;
  }

}

class BinaryOperation implements Element {

  public enum Type {
    SUBSTRACTION,
    ADDITION
  }

  public Type type;
  public Element left, right;

  @Override
  public int eval() {
    switch (type) {
      case ADDITION:
        return left.eval() + right.eval();
      case SUBSTRACTION:
        return left.eval() - right.eval();
      default:
        return 0;
    }
  }

}

public class LexicalParser {
  
}
