package dev.gerardo.java.patterns.solid.dip;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.javatuples.Triplet;

enum Relationship {
  PARENT,
  CHILD,
  SIBLING
}

class Person {
  public String name;

  public Person(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Person [name=" + name + "]";
  }

}

interface RelationshipBrowser {
  List<Person> findAllChildrenOf(String name);
}

class Relationships implements RelationshipBrowser {
  private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

  public void addParentAndChild(Person parent, Person child) {
    relations.add(new Triplet<Person,Relationship,Person>(parent, Relationship.PARENT, child));
    relations.add(new Triplet<Person,Relationship,Person>(parent, Relationship.CHILD, child));
  }

  public List<Triplet<Person, Relationship, Person>> getRelations() {
    return relations;
  }

  @Override
  public List<Person> findAllChildrenOf(String name) {
    return relations.stream().filter(x -> x.getValue0().name.equals(name) 
    && x.getValue1().equals(Relationship.PARENT))
    .map(Triplet::getValue2).collect(Collectors.toList());
  }

}

class Research {
  /* public Research(Relationships relationships) {
    List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
    relations.stream().filter(x -> x.getValue0().name.equals("Gerardo") && x.getValue1().equals(Relationship.PARENT))
    .forEach(x -> {
      System.out.println(x.getValue0().name + " has a child called " + x.getValue2().name);
    });;
  } */

  public Research(RelationshipBrowser browser) {
    List<Person> children = browser.findAllChildrenOf("Gerardo");
    for (Person p : children) {
      System.out.println(p);
    }
  }
}

public class Demo {
  public static void main(String[] args) {
    Person parent = new Person("Gerardo");
    Person child1 = new Person("Carlota");
    Person child2 = new Person("Samael");

    Relationships relations = new Relationships();
    relations.addParentAndChild(parent, child1);
    relations.addParentAndChild(parent, child2);

    new Research(relations);
  }
}
