// SingletonPatternExample.java

/**
 * A singleton class representing a logging utility.
 */
class Logger {

    // Private static instance of the Logger class
    private static volatile Logger instance;

    // Private constructor to prevent instantiation from outside
    private Logger() {
    }

    // Public static method to get the instance of the Logger class
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    // Create a new instance if it doesn't exist
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Example logging method
    public void log(String message) {
        System.out.println("Logged: " + message);
    }
}

/**
 * A test class to verify the Singleton implementation of the Logger class.
 */
public class SingletonPatternExample {

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Check if both instances are the same
        System.out.println("Is logger1 the same as logger2? " + (logger1 == logger2));

        // Test logging
        logger1.log("Hello, World!");
        logger2.log("This is another log message.");
    }
}