package dev.gerardo.behaviourals.chain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

class Event<Args> {
  private int index = 0;
  private Map<Integer, Consumer<Args>> handlers = new HashMap<>();

  public int subscribe(Consumer<Args> handler) {
    int i = index;
    handlers.put(index++, handler);
    return i;
  }

  public void unsubscribe(int key) {
    handlers.remove(key);
  }

  public void fire(Args args) {
    for (Consumer<Args> consumer : handlers.values()) {
      consumer.accept(args);
    }
  }

}

class Query {
  public String creatureName;

  enum Argument {
    ATTACK,
    DEFENSE;
  }

  public Argument argument;
  public int result;

  public Query(String creatureName, Argument argument, int result) {
    this.creatureName = creatureName;
    this.argument = argument;
    this.result = result;
  }

}

class Game {
  public Event<Query> queries = new Event<>();
}

class CreatureBroker {
  private Game game;
  public String name;
  public int baseAttack, baseDefense;

  public CreatureBroker(Game game, String name, int baseAttack, int baseDefense) {
    this.game = game;
    this.name = name;
    this.baseAttack = baseAttack;
    this.baseDefense = baseDefense;
  }

  public int getAttack() {
    Query query = new Query(name, Query.Argument.ATTACK, baseAttack);
    game.queries.fire(query);
    return query.result;
  }

  public int getDefense() {
    Query query = new Query(name, Query.Argument.DEFENSE, baseDefense);
    game.queries.fire(query);
    return query.result;
  }

  @Override
  public String toString() {
    return "CreatureBroker [attack=" + baseAttack + ", defense=" + baseDefense + ", game=" + game + ", name="
        + name + "]";
  }

}

class CreatureModifierBroker {
  protected Game game;
  protected CreatureBroker creature;

  public CreatureModifierBroker(Game game, CreatureBroker creature) {
    this.game = game;
    this.creature = creature;
  }

}

class DoubleAttackModifierBroker extends CreatureModifierBroker implements AutoCloseable {

  private final int token;

  public DoubleAttackModifierBroker(Game game, CreatureBroker creature) {
    super(game, creature);

    token = game.queries.subscribe(q -> {
      if (q.creatureName.equals(creature.name) && q.argument == Query.Argument.ATTACK) {
        q.result *= 2;
      }
    });

  }

  @Override
  public void close() throws Exception {
    game.queries.unsubscribe(token);
  }

}

class IncreaseDefenseModifierBroker extends CreatureModifierBroker implements AutoCloseable {
  private final int token;

  public IncreaseDefenseModifierBroker(Game game, CreatureBroker creature) {
    super(game, creature);

    token = game.queries.subscribe(q -> {
      if (q.creatureName.equals(creature.name) && q.argument == Query.Argument.DEFENSE) {
        q.result *= 2;
      }
    });
  }

  @Override
  public void close() throws Exception {
    // TODO Auto-generated method stub
    game.queries.unsubscribe(token);
  }

}

public class BrokerChainDemo {
  public static void main(String[] args) {
    Game game = new Game();
    CreatureBroker creatureBroker = new CreatureBroker(game, "Pikachu", 200, 180);

    System.out.println(creatureBroker);

    
    try (
      IncreaseDefenseModifierBroker mDefenseModifier = new IncreaseDefenseModifierBroker(game, creatureBroker);
      DoubleAttackModifierBroker attack = new DoubleAttackModifierBroker(game, creatureBroker);
    ) {
      System.out.println(creatureBroker);
    } catch (Exception e) {
      System.err.println(e);
    }

  }
}
