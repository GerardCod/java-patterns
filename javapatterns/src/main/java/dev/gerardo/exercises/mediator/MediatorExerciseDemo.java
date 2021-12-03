package dev.gerardo.exercises.mediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Participant
{
    private Mediator mediator;
    private int value;

    public Participant(Mediator mediator)
    {
        this.mediator = mediator;
        this.value = 0;
        this.mediator.join(this);
    }

    public void say(int n)
    {
        mediator.broadcast(this, n);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String toString() {
        return String.format("Participant[value=%d]", value);
    }
}

class Mediator
{
    private List<Participant> partipants;

    public Mediator() {
        this.partipants = new ArrayList<>();
    }

    public void broadcast(Participant p, int value)
    {
        partipants.stream().filter(participant -> !participant.equals(p))
                .forEach(participant -> {
                    participant.setValue(value);
                });
    }

    public void join(Participant p)
    {
        partipants.add(p);
    }

    @Override
    public String toString() {
        return Arrays.toString(partipants.toArray());
    }
}

public class MediatorExerciseDemo {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Participant p1 = new Participant(mediator);
        Participant p2 = new Participant(mediator);

        System.out.println(mediator);
        p1.say(3);
        System.out.println(mediator);
    }
}
