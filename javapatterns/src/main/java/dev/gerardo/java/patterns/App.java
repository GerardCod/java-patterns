package dev.gerardo.java.patterns;


import java.util.List;
import java.util.stream.Collectors;

import dev.gerardo.java.patterns.solid.ocp.BetterFilter;
import dev.gerardo.java.patterns.solid.ocp.Color;
import dev.gerardo.java.patterns.solid.ocp.ColorSpecification;
import dev.gerardo.java.patterns.solid.ocp.Product;
import dev.gerardo.java.patterns.solid.ocp.ProductFilter;
import dev.gerardo.java.patterns.solid.ocp.Size;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {
        /* Journal journal = new Journal();
        journal.addEntry("I fell in depression");
        journal.addEntry("I cried today");

        Persistance persistance = new Persistance();
        String filename = "backup.txt";
        persistance.saveToFile(journal, filename, true);
        Runtime.getRuntime().exec("notepad.exe " + filename);
        System.out.println(journal); */

        Product apple = new Product("Apple", Color.GREEN, Size.MEDIUM);
        Product house = new Product("House", Color.RED, Size.HUGE);
        Product car = new Product("Car", Color.BLUE, Size.LARGE);
        List<Product> products = List.of(apple, house, car);

        System.out.println("Green objects (old)");
        ProductFilter pFilter = new ProductFilter();
        System.out.println(pFilter.filterByColor(products, Color.GREEN).collect(Collectors.toList()));
        
        
        System.out.println("Green objects (new)");
        BetterFilter filter = new BetterFilter();
        System.out.println(filter.filter(products, new ColorSpecification(Color.GREEN)).collect(Collectors.toList()));
    }
}
