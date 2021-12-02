package dev.gerardo.exercises.bridge;


interface Renderer {
  String whatToRenderAs();
}

class VectorRenderer implements Renderer {

  @Override
  public String whatToRenderAs() {
    return "lines";
  }

}

class RasterRenderer implements Renderer {

  @Override
  public String whatToRenderAs() {
    return "pixels";
  }

}

abstract class Shape {

  protected Renderer renderer;

  public Shape() {

  }

  public Shape(Renderer renderer) {
    this.renderer = renderer;
  }

  public abstract String getName();

}

class Triangle extends Shape {

  public Triangle(Renderer renderer) {
    super(renderer);
  }

  @Override
  public String getName() {
    return "Triangle";
  }

  @Override
  public String toString() {
    return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
  }
}

class Square extends Shape {

  public Square(Renderer renderer) {
    super(renderer);
  }

  @Override
  public String getName() {
    return "Square";
  }

  @Override
  public String toString() {
    return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
  }
}

class VectorSquare extends Square {
  public VectorSquare(Renderer renderer) {
    super(renderer);
  }

  @Override
  public String toString() {
    return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
  }
}

class RasterSquare extends Square {
  public RasterSquare(Renderer renderer) {
    super(renderer);
  }

  @Override
  public String toString() {
    return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
  }
}

public class BridgeShapeDemo {
  public static void main(String[] args) {
    Renderer render = new VectorRenderer();
    System.out.println(new Square(render).toString());
    System.out.println(new Triangle(render).toString());
  }
}
