package dev.gerardo.exercises;

import java.util.*;

interface ValueContainer extends Iterable<Integer> {
}

class SingleValue implements ValueContainer {
  public int value;

  // please leave this constructor as-is
  public SingleValue(int value) {
    this.value = value;
  }

  @Override
  public Iterator<Integer> iterator() {
    return Collections.singleton(value).iterator();
  }
}

class ManyValues extends ArrayList<Integer> implements ValueContainer {
}

class MyList extends ArrayList<ValueContainer> {
  // please leave this constructor as-is
  public MyList(Collection<? extends ValueContainer> c) {
    super(c);
  }

  public int sum() {
    int sum = 0;
    Iterator<ValueContainer> iterator = this.iterator();
    Iterator<Integer> intIterator = null;

    while (iterator.hasNext()) {
      intIterator = iterator.next().iterator();
      
      while (intIterator.hasNext()) {
        sum += intIterator.next();
      }

    }

    return sum;
  }
}

public class SumComposite {
  public static void main(String[] args) {
    SingleValue single = new SingleValue(8);
    ManyValues many = new ManyValues();
    many.add(8);
    many.add(8);
    many.add(8);

    MyList list = new MyList(List.of(single, many));
    System.out.println("Sum of the elements: " + list.sum());
  }
}
