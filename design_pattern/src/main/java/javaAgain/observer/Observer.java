package javaAgain.observer;

import java.util.ArrayList;
import java.util.List;

abstract class Subject {
    protected List<Observer> observers = new ArrayList<>();

    public void add(Observer obs) {
        observers.add(obs);
    }

    public void remove(Observer obs) {
        observers.remove(obs);
    }

    public abstract void notifyObserver();
}

class ConcertSubject extends Subject{

    @Override
    public void notifyObserver() {
        //Do some thing
        for(Observer o :observers){
            o.response();
        }
    }
}

interface Observer {
    void response();
}

class DetailObserver implements Observer{

    @Override
    public void response() {
        System.out.println("response");
    }
}
