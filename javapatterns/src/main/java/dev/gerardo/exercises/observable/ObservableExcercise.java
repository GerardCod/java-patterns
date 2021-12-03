package dev.gerardo.exercises.observable;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Game
{
    private List<Rat> ratsInPlay = new ArrayList<>();

    public void addRat(Rat rat) {
        ratsInPlay.add(rat);
        ratsInPlay.forEach(r -> r.attack = ratsInPlay.size());
    }

    public void removeRat(Rat rat) {
        if (ratsInPlay.contains(rat)) {
            ratsInPlay.remove(rat);
            ratsInPlay.forEach(r -> r.attack = ratsInPlay.size());
        }
    }
}

class Rat implements Closeable
{
    private Game game;
    public int attack = 1;

    public Rat(Game game)
    {
        this.game = game;
        this.game.addRat(this);
    }

    @Override
    public void close() throws IOException
    {
        this.game.removeRat(this);
    }

    @Override
    public String toString() {
        return String.format("Rat[attack=%d]", attack);
    }
}

public class ObservableExcercise {
    public static void main(String[] args) {
        try {
            Game game = new Game();
            Rat rat1 = new Rat(game);
            Rat rat2 = new Rat(game);
            Rat rat3 = new Rat(game);

            System.out.println(rat1);

            rat1.close();

            System.out.println(rat2);

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
