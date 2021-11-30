package dev.gerardo.java.patterns.solid.lsp;

public class Demo {
  public static void main(String[] args) {
    Rectangle rc = new Rectangle();
    rc.setHeight(10);
    rc.setWidth(5);

    Rectangle sq = new Square(8);
    
    System.out.println(rc);
    System.out.println(sq);
  }
}
