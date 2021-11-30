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
    
  }

  @Override
  public void fax(Document d) {
    
  }

  @Override
  public void scan(Document d) {
    
  }

}

class OldFashionPrinter implements Printer {

  @Override
  public void print(Document d) {
    // TODO Auto-generated method stub
    
  }

}

class PhotoCopier implements Printer, Scanner {

  @Override
  public void scan(Document d) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void print(Document d) {
    // TODO Auto-generated method stub
    
  }

}


interface MultiFunctionDevide extends Printer, Scanner {}