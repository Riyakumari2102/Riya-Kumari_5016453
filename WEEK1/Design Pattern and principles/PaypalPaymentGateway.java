public interface PaymentProcessor {
    void processPayment(String paymentDetails);
}

public class PaypalPaymentGateway {
    public void makePayment(String email, String amount) {
        System.out.println("Processing PayPal payment for " + amount + " to " + email);
    }
}

public class StripePaymentGateway {
    public void chargeCard(String cardNumber, double amount) {
        System.out.println("Processing Stripe payment for " + amount + " using card " + cardNumber);
    }
}

public class PaypalAdapter implements PaymentProcessor {
    private PaypalPaymentGateway paypalPaymentGateway;

    public PaypalAdapter(PaypalPaymentGateway paypalPaymentGateway) {
        this.paypalPaymentGateway = paypalPaymentGateway;
    }

    @Override
    public void processPayment(String paymentDetails) {
        // Extract email and amount from paymentDetails
        String[] parts = paymentDetails.split(",");
        String email = parts[0];
        String amount = parts[1];
        paypalPaymentGateway.makePayment(email, amount);
    }
}

// Similar implementation for StripeAdapter

public class PaymentClient {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PaypalAdapter(new PaypalPaymentGateway());
        paypalProcessor.processPayment("user@example.com,100");

        // ... similar usage for StripeAdapter
    }
}
