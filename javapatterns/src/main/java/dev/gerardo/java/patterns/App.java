package dev.gerardo.java.patterns;

import dev.gerardo.java.patterns.solid.Journal;
import dev.gerardo.java.patterns.solid.Persistance;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Journal journal = new Journal();
        journal.addEntry("I fell in depression");
        journal.addEntry("I cried today");

        Persistance persistance = new Persistance();
        String filename = "backup.txt";
        persistance.saveToFile(journal, filename, true);
        Runtime.getRuntime().exec("notepad.exe " + filename);
        System.out.println(journal);
    }
}
