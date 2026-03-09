package composite;

import duck.Quackable;
import observer.Observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flock implements Quackable {

    private List<Quackable> quackers = new ArrayList<>();

    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        Iterator<Quackable> iterator = quackers.iterator();

        while (iterator.hasNext()) {
            Quackable quacker = iterator.next();
            System.out.println(quacker);   // ⭐ print duck name

            quacker.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        Iterator<Quackable> iterator = quackers.iterator();

        while (iterator.hasNext()) {
            Quackable quacker = iterator.next();
            quacker.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {
        // Flock itself does not notify directly.
    }

    @Override
    public String toString() {
        return "Flock of Ducks";
    }
}