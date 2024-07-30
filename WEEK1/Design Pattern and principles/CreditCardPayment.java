// PaymentStrategy.java

/**
 * An interface representing a payment strategy.
 */
public interface PaymentStrategy {
    void pay(double amount);
}

// CreditCardPayment.java

/**
 * A concrete class representing a credit card payment strategy that implements
 * PaymentStrategy.
 */
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using credit card");
    }
}

// PayPalPayment.java

/**
 * A concrete class representing a PayPal payment strategy that implements
 * PaymentStrategy.
 */
public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using PayPal");
    }
}

// PaymentContext.java

/**
 * A class representing a payment context that holds a reference to
 * PaymentStrategy and a method to execute the strategy.
 */
public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

// StrategyPatternExample.java

/**
 * A test class to demonstrate selecting and using different payment strategies.
 */
public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext(new CreditCardPayment());
        paymentContext.executePayment(100.0);

        paymentContext.setPaymentStrategy(new PayPalPayment());
        paymentContext.executePayment(200.0);
    }
}