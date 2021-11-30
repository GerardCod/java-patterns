package dev.gerardo.exercises;

import java.io.File;
import java.io.IOException;
import java.util.function.Supplier;

public class CheckSingleton {
  public static boolean isSingleton(Supplier<Object> func) {
    return func.get() == func.get();
  }
}

class StaticBlockSingleton {
  private StaticBlockSingleton() throws IOException {
    System.out.println("Singleton is initializing");
    File.createTempFile(".", ".");
  }

  private static StaticBlockSingleton instance;

  static {
    try {
      instance = new StaticBlockSingleton(); 
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

  public static StaticBlockSingleton getInstance() {
    return instance;
  }
}

class SingletonDemo {
  public static void main(String[] args) {
    
  }
}
