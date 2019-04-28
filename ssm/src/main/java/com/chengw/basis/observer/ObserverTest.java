package main.chapter2.observer;

import java.util.Observable;

public class ObserverTest extends Observable {

    public static void main(String[] args) {
        ProductList observable = ProductList.getInstance();

        JingDongObserver jingDongObserver = new JingDongObserver();

        observable.addObserver(jingDongObserver);

        observable.addProduct("this is a product");
    }
}
