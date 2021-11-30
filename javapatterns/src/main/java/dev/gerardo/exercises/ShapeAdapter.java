package dev.gerardo.exercises;

class Square {
  public int side;

  public Square(int side) {
    this.side = side;
  }
}

interface Rectangle {
  int getWidth();

  int getHeight();

  default int getArea() {
    return getWidth() * getHeight();
  }
}

class SquareToRectangleAdapter implements Rectangle {
  private Square square;
  
  public SquareToRectangleAdapter(Square square) {
    this.square = square;
  }

  @Override
  public int getWidth() {
    return square.side;
  }

  @Override
  public int getHeight() {
    return square.side;
  }
}

public class ShapeAdapter {

  public static void main(String[] args) {
    Square qSquare = new Square(20);
    SquareToRectangleAdapter adapter = new SquareToRectangleAdapter(qSquare);
    System.out.println(adapter.getArea());
  }

}
