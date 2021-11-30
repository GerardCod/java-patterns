package dev.gerardo.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Attribute {
  public String name;
  public String type;

  public Attribute(String name, String type) {
    this.name = name;
    this.type = type;
  }

  @Override
  public String toString() {
    return String.format("public %s %s;", type, name);
  }
  
}

public class CodeBuilder {
  private String className;
  private List<Attribute> attributes = new ArrayList<>();
  private final int indentSize = 2;
  private final String newLine = System.lineSeparator();

  public CodeBuilder(String className) {
    this.className = className;
  }

  public CodeBuilder addField(String name, String type) {
    attributes.add(new Attribute(name, type));
    return this;
  }

  @Override
  public String toString() {
    return toStringHelper();
  }

  private String toStringHelper() {
    StringBuilder sb = new StringBuilder();
    String indentation = String.join("", Collections.nCopies(1 * indentSize, " "));
    sb.append(String.format("public class %s%s", className, newLine));
    sb.append(String.format("{%s", newLine));

    if (attributes.size() > 0) {
      for (Attribute pair : attributes) {
        sb.append(String.format("%s%s%s", indentation, pair.toString(), newLine));
      }
    }
    sb.append("}");
    return sb.toString();
  }
}

class Demo {
  public static void main(String[] args) {
    CodeBuilder builder = new CodeBuilder("Pokemon");
    String classFormat = builder.addField("name", "String")
    .addField("types", "List<String>").toString();

    System.out.println(classFormat);
  }
}