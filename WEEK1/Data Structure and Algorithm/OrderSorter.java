import java.util.Arrays;

class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

public class OrderSorter {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1); // Index of smaller element
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap orders[i + 1] and orders[high] (or pivot)
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
                new Order("1", "Alice", 250.0),
                new Order("2", "Bob", 150.0),
                new Order("3", "Charlie", 300.0)
        };

        System.out.println("Before Sorting:");
        for (Order order : orders) {
            System.out.println(order);
        }

        bubbleSort(orders);
        System.out.println("\nAfter Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Resetting the array for quick sort
        orders = new Order[] {
                new Order("1", "Alice", 250.0),
                new Order("2", "Bob", 150.0),
                new Order("3", "Charlie", 300.0)
        };

        quickSort(orders, 0, orders.length - 1);
        System.out.println("\nAfter Quick Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

// Analysis:
// Compare the performance (time complexity) of Bubble Sort and Quick Sort.
// Discuss why Quick Sort is generally preferred over Bubble Sort.

// Bubble Sort:

// Time Complexity: 𝑂(𝑛2)O(n2) because it involves nested loops.
// Space Complexity: 𝑂(1)O(1) since it's an in-place sorting algorithm.
// Use Case: Suitable for small or nearly sorted lists but inefficient for
// larger lists.

// Quick Sort:

// Time Complexity: 𝑂(𝑛log𝑛) O(nlogn) on average, but 𝑂(𝑛2)O(n2) in the
// worst case (when the pivot choice is poor).
// Space Complexity: 𝑂(log 𝑛) O(logn) due to recursion stack.
// Use Case: More efficient for larger lists compared to Bubble Sort. It’s
// preferred for its average-case efficiency and practical performance.

// Why Quick Sort is Generally Preferred Over Bubble Sort:

// Efficiency: Quick Sort has a better average-case time complexity of 𝑂(𝑛
// log𝑛)O(nlogn) compared to Bubble Sort’s 𝑂(𝑛2)O(n2 ). This makes Quick Sort
// more suitable for larger datasets.
// Practical Performance: Even though Quick Sort has a worst-case complexity of
// 𝑂(𝑛2)O(n2 ), in practice, its average-case performance and optimizations
// (like choosing a good pivot) make it more efficient than Bubble Sort.
// Usage in Libraries: Quick Sort is often used in standard libraries and
// real-world applications due to its efficient performance and versatility.