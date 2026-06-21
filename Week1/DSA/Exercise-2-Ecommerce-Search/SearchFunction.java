public class SearchFunction {

    // Linear Search
    public static Product linearSearch(Product[] products, String targetName) {

        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }

        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String targetName) {

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            int comparison =
                    products[mid].productName.compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return products[mid];
            }

            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
            new Product(101, "Camera", "Electronics"),
            new Product(102, "Headphones", "Electronics"),
            new Product(103, "Laptop", "Electronics"),
            new Product(104, "Mobile", "Electronics"),
            new Product(105, "Mouse", "Accessories")
        };

        String searchItem = "Laptop";

        System.out.println("Linear Search Result:");
        Product linearResult = linearSearch(products, searchItem);

        if (linearResult != null) {
            System.out.println(linearResult);
        } else {
            System.out.println("Product not found.");
        }

        System.out.println("\nBinary Search Result:");
        Product binaryResult = binarySearch(products, searchItem);

        if (binaryResult != null) {
            System.out.println(binaryResult);
        } else {
            System.out.println("Product not found.");
        }
    }
}