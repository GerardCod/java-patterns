package dev.gerardo.exercises;

class Point {
  public int x;
  public int y;

  public Point(int x , int y) {
    this.x = x;
    this.y = y;
  }

  public Point(Point otherPoint) {
    this(otherPoint.x, otherPoint.y);
  }

  @Override
  public String toString() {
    return "Point [x=" + x + ", y=" + y + "]";
  }
}

class Line {
  public Point start;
  public Point end;

  public Line (Point start, Point end) {
    this.start = start;
    this.end = end;
  }

  public Line deepCopy() {
    Line newLine = new Line(new Point(this.start), new Point(this.end));
    return newLine;
  }

  @Override
  public String toString() {
    return "Line [end=" + end + ", start=" + start + "]";
  }

}

public class LinePrototype {
  public static void main(String[] args) {
    Point start = new Point(0, 0);
    Point end = new Point(10, 7);

    Line lineOne = new Line(start, end);
    Line lineTwo = lineOne.deepCopy();

    lineTwo.start.x = 1;

    System.out.println(lineOne);
    System.out.println(lineTwo);
  }
}
