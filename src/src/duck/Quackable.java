package duck;

import observer.QuackObservable;

public interface Quackable extends QuackObservable {
    void quack();
}