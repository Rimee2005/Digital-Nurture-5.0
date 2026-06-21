public class SortingOrders {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {

        int n = orders.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (orders[j].totalPrice > orders[j + 1].totalPrice) {

                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(orders, low, high);

            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    public static int partition(Order[] orders, int low, int high) {

        double pivot = orders[high].totalPrice;

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (orders[j].totalPrice < pivot) {

                i++;

                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    // Display Orders
    public static void displayOrders(Order[] orders) {

        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public static void main(String[] args) {

        Order[] bubbleOrders = {
            new Order(101, "Rimjhim", 4500),
            new Order(102, "Aman", 2200),
            new Order(103, "Priya", 7800),
            new Order(104, "Rahul", 3500)
        };

        System.out.println("Orders Before Bubble Sort:");
        displayOrders(bubbleOrders);

        bubbleSort(bubbleOrders);

        System.out.println("\nOrders After Bubble Sort:");
        displayOrders(bubbleOrders);

        Order[] quickOrders = {
            new Order(101, "Rimjhim", 4500),
            new Order(102, "Aman", 2200),
            new Order(103, "Priya", 7800),
            new Order(104, "Rahul", 3500)
        };

        quickSort(quickOrders, 0, quickOrders.length - 1);

        System.out.println("\nOrders After Quick Sort:");
        displayOrders(quickOrders);
    }
}