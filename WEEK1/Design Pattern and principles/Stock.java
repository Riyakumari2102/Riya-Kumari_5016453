// Stock.java

public interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

// StockMarket.java

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Observer> observers;
    private double stockPrice;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}

// Observer.java

public interface Observer {
    void update(double stockPrice);
}

// MobileApp.java

public class MobileApp implements Observer {
    public void update(double stockPrice) {
        System.out.println("Mobile app: Stock price updated to " + stockPrice);
    }
}

// WebApp.java

public class WebApp implements Observer {
    public void update(double stockPrice) {
        System.out.println("Web app: Stock price updated to " + stockPrice);
    }
}

// ObserverPatternExample.java

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(100.0);
        stockMarket.setStockPrice(120.0);

        stockMarket.deregisterObserver(webApp);

        stockMarket.setStockPrice(150.0);
    }
}