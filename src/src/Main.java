import adapter.Goose;
import adapter.GooseAdapter;
import composite.Flock;
import decorator.QuackCounter;
import duck.Quackable;
import factory.AbstractDuckFactory;
import factory.CountingDuckFactory;
import observer.Quackologist;

public class Main {

    public static void main(String[] args) {

        AbstractDuckFactory duckFactory = new CountingDuckFactory();

        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());

        Flock mallardFlock = new Flock();
        mallardFlock.add(duckFactory.createMallardDuck());
        mallardFlock.add(duckFactory.createMallardDuck());
        mallardFlock.add(duckFactory.createMallardDuck());

        Flock mainFlock = new Flock();
        mainFlock.add(redheadDuck);
        mainFlock.add(duckCall);
        mainFlock.add(rubberDuck);
        mainFlock.add(gooseDuck);
        mainFlock.add(mallardFlock);

        Quackologist quackologist = new Quackologist();
        mainFlock.registerObserver(quackologist);

        System.out.println("Duck Simulator");
        System.out.println("--------------------");

        mainFlock.quack();

        System.out.println("--------------------");
        System.out.println("Total duck quacks counted: " + QuackCounter.getQuacks());
    }
}