// Notifier.java

public interface Notifier {
    void send(String message);
}

// EmailNotifier.java

public class EmailNotifier implements Notifier {

    @Override
    public void send(String message) {
        System.out.println("Sending email notification: " + message);
    }
}

// NotifierDecorator.java

public abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

// SMSNotifierDecorator.java

public class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS notification: " + message);
    }
}

// SlackNotifierDecorator.java

public class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack notification: " + message);
    }
}

// DecoratorPatternExample.java

public class DecoratorPatternExample {

    public static void main(String[] args) {
        // Create an email notifier
        Notifier emailNotifier = new EmailNotifier();

        // Create an SMS notifier decorator
        Notifier smsNotifierDecorator = new SMSNotifierDecorator(emailNotifier);

        // Create a Slack notifier decorator
        Notifier slackNotifierDecorator = new SlackNotifierDecorator(smsNotifierDecorator);

        // Send a notification via multiple channels
        slackNotifierDecorator.send("Hello, world!");
    }
}