package dev.gerardo.creationals.singleton.mono;

class ChiefExecutiveOfficer {
  private String name;
  private static int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    ChiefExecutiveOfficer.age = age;
  }

  @Override
  public String toString() {
    return "ChiefExecutiveOfficer [name=" + name + ", age=" + age + "]";
  }

}

public class MonoStateSingleton {
  public static void main(String[] args) {
    ChiefExecutiveOfficer ceo = new ChiefExecutiveOfficer();
    ceo.setName("Gerardo");
    ceo.setAge(22);

    ChiefExecutiveOfficer ceo2 = new ChiefExecutiveOfficer();
    System.out.println(ceo);
    System.out.println(ceo2);
  }
}
