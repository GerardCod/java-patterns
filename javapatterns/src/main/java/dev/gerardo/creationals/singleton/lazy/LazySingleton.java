package dev.gerardo.creationals.singleton.lazy;

public class LazySingleton {
  private static LazySingleton instance;

  private LazySingleton() {
    System.out.println("Initializing the singleton");
  }

  public static synchronized LazySingleton getInstance() {
    if (instance == null) {
      instance = new LazySingleton();
    }

    return instance;
  }
}
