import java.util.HashMap;

public class InventoryManagement {

    private HashMap<Integer, Product> inventory;

    public InventoryManagement() {
        inventory = new HashMap<>();
    }

    // Add Product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Product added successfully.");
    }

    // Update Product
    public void updateProduct(int productId, String name, int quantity, double price) {
        Product product = inventory.get(productId);

        if (product != null) {
            product.setProductName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete Product
    public void deleteProduct(int productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display Products
    public void displayProducts() {
        System.out.println("\nInventory Details:");

        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {

        InventoryManagement ims = new InventoryManagement();

        // Adding Products
        ims.addProduct(new Product(101, "Laptop", 10, 55000));
        ims.addProduct(new Product(102, "Mouse", 50, 500));
        ims.addProduct(new Product(103, "Keyboard", 30, 1200));

        ims.displayProducts();

        // Updating Product
        ims.updateProduct(102, "Wireless Mouse", 45, 800);

        ims.displayProducts();

        // Deleting Product
        ims.deleteProduct(103);

        ims.displayProducts();
    }
}