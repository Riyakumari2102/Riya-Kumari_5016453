import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Objects;

public class InventoryManagementSystem {

    private final Map<String, Product> inventory = new ConcurrentHashMap<>();

    public void addProduct(Product product) {
        if (product != null && product.getProductId() != null) {
            inventory.put(product.getProductId(), product);
        }
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public void updateProduct(Product product) {
        if (product != null && product.getProductId() != null) {
            inventory.put(product.getProductId(), product);
        }
    }

    public void deleteProduct(String productId) {
        inventory.remove(productId);
    }

    // Main method to run the application
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        // Create some products
        Product product1 = new Product("P001", "Product 1", 10, 99.99);
        Product product2 = new Product("P002", "Product 2", 20, 19.99);

        // Add products to inventory
        ims.addProduct(product1);
        ims.addProduct(product2);

        // Retrieve and print products
        System.out.println("Retrieved Product 1: " + ims.getProduct("P001"));
        System.out.println("Retrieved Product 2: " + ims.getProduct("P002"));

        // Update product
        product1.setPrice(89.99);
        ims.updateProduct(product1);
        System.out.println("Updated Product 1: " + ims.getProduct("P001"));

        // Delete a product
        ims.deleteProduct("P002");
        System.out.println("Product 2 after deletion: " + ims.getProduct("P002"));
    }
}

class Product {
    private final String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = Objects.requireNonNull(productId, "Product ID cannot be null");
        this.productName = Objects.requireNonNull(productName, "Product name cannot be null");
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return productId.equals(product.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
