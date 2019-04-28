package main.chapter2.observer;

import java.util.Observable;
import java.util.Observer;

public class JingDongObserver implements Observer {
    public void update(Observable o, Object product){
    String newProduct = (String)product;
    System.err.println("ADD" + newProduct + "to JINGDONG");
    }
}
