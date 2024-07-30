// Image.java

/**
 * An interface representing an image.
 */
public interface Image {
    void display();
}

// RealImage.java

/**
 * A concrete class representing a real image that loads an image from a remote
 * server.
 */
public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }

    private void loadFromDisk() {
        System.out.println("Loading " + filename);
    }
}

// ProxyImage.java

/**
 * A proxy class representing a proxy image that implements lazy initialization
 * and caching.
 */
public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;
    private boolean hasBeenLoaded = false;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (!hasBeenLoaded) {
            realImage = new RealImage(filename);
            hasBeenLoaded = true;
        }
        realImage.display();
    }
}

// ProxyPatternExample.java

/**
 * A test class to demonstrate the use of ProxyImage to load and display images.
 */
public class ProxyPatternExample {

    public static void main(String[] args) {
        // Create proxy images
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Display images (loads from disk on first display)
        image1.display();
        image1.display();
        image2.display();
        image2.display();
    }
}