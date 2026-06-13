import java.util.Arrays;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }
}

class SearchAlgorithms {

    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equals(targetName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareTo(targetName);

            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }
}

public class EcommerceSearch {
    public static void main(String[] args) {

        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Phone", "Electronics"),
            new Product(3, "Shoes", "Fashion"),
            new Product(4, "Watch", "Accessories")
        };

        Product result1 = SearchAlgorithms.linearSearch(products, "Shoes");
        System.out.println(result1 != null ? "Found (Linear)" : "Not Found");

        Arrays.sort(products, (a, b) -> a.productName.compareTo(b.productName));

        Product result2 = SearchAlgorithms.binarySearch(products, "Shoes");
        System.out.println(result2 != null ? "Found (Binary)" : "Not Found");
    }
}