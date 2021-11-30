package dev.gerardo.java.patterns.solid.isp;

public class Document {
  
}

interface Machine {
  void print(Document d);
  void fax(Document d);
  void scan(Document d);
}

interface Printer {
  void print(Document d);
}

interface Scanner {
  void scan(Document d);
}

class MultiFunctionPrinter implements Machine {

  @Override
  public void print(Document d) {
    System.out.println("Doing something");
    
  }

  @Override
  public void fax(Document d) {
    
    System.out.println("Doing something");
  }

  @Override
  public void scan(Document d) {
    System.out.println("Doing something");
    
  }

}

class OldFashionPrinter implements Printer {

  @Override
  public void print(Document d) {
    System.out.println("Doing something");
    
  }

}

class PhotoCopier implements Printer, Scanner {

  @Override
  public void scan(Document d) {
    System.out.println("Doing something");
  }
  
  @Override
  public void print(Document d) {
    System.out.println("Doing something");
  }

}


interface MultiFunctionDevide extends Printer, Scanner {}