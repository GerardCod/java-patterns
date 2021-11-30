package dev.gerardo.exercises;

class Person {
  public int id;
  public String name;

  public Person(int id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public String toString() {
    return "Person [id=" + id + ", name=" + name + "]";
  }
  
}

public class PersonFactory {
  private int idSequence = 0;

  public Person createPerson(String name) {
    Person person = new Person(idSequence, name);
    idSequence++;
    return person;
  }

}

class DemoFactory {
  public static void main(String[] args) {
    PersonFactory factory = new PersonFactory();
    Person gerardo = factory.createPerson("Gerardo");
    Person fausto = factory.createPerson("Fausto");

    System.out.println(gerardo);
    System.out.println(fausto);
  }
}
