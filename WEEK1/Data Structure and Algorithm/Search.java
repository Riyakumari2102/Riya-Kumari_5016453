import java.util.Arrays;

class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

public class Search {
    // Linear search
    public static int linearSearch(Product[] products, String searchTerm) {
        if (searchTerm == null)
            return -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equals(searchTerm)) {
                return i; // Found
            }
        }
        return -1; // Not found
    }

    // Binary search
    public static int binarySearch(Product[] products, String searchTerm) {
        if (searchTerm == null)
            return -1;

        // Create a copy of the array to sort
        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, (p1, p2) -> p1.getProductName().compareTo(p2.getProductName()));

        int left = 0;
        int right = sortedProducts.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = sortedProducts[mid].getProductName().compareTo(searchTerm);
            if (comparison == 0) {
                return mid; // Found
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Not found
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product("1", "Apple", "Fruit"),
                new Product("2", "Banana", "Fruit"),
                new Product("3", "Carrot", "Vegetable")
        };

        // Test Linear Search
        System.out.println("Linear Search Result: " + linearSearch(products, "Banana"));

        // Sort the array once before binary search
        Arrays.sort(products, (p1, p2) -> p1.getProductName().compareTo(p2.getProductName()));

        // Test Binary Search
        System.out.println("Binary Search Result: " + binarySearch(products, "Banana"));
    }
}

// Analysis:
// Compare the time complexity of linear and binary search algorithms.
// Discuss which algorithm is more suitable for your platform and why.

// Linear Search:
// Best-case: O(1) (if the item is the first element)
// Average-case: O(n)
// Worst-case: O(n) (if the item is the last or not present)

// Binary Search:
// Best-case: O(1) (if the item is the middle element)
// Average-case: O(log n)
// Worst-case: O(log n)
// For an e-commerce platform, binary search is generally more suitable due to
// its average and worst-case time complexity of O(log n). This means that as
// the number of products increases, the search time will grow
// logarithmically,making it significantly faster than linear search for large
// datasets.

// However, it's important to note that binary search requires the data to be
// sorted, which introduces an initial sorting overhead. If the products are
// frequently added or removed, maintaining the sorted order might be costly. In
// such cases, a hybrid approach or other data structures like a search tree
// could be considered.