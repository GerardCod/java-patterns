package dev.gerardo.java.patterns.solid;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Persistance {
  public void saveToFile(Journal journal, String filename, boolean overwrite) throws FileNotFoundException {
    if (overwrite || new File(filename).exists()) {
      try (PrintStream stream = new PrintStream(filename)) {
        stream.print(journal);
      }
    }

  }

  public Journal load(String filename) {
    // TODO
    
    return null;
  }

}
