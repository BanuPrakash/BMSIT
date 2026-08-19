import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(152, "Laptop", 55000, "Electronics"));
        products.add(new Product(22, "Mobile", 25000, "Electronics"));
        products.add(new Product(93, "Television", 45000, "Electronics"));
        products.add(new Product(435, "Refrigerator", 38000, "Home"));
        products.add(new Product(511, "Washing Machine", 32000, "Home"));
        products.add(new Product(60, "Microwave Oven", 12000, "Kitchen"));
        products.add(new Product(888, "iPhone 17", 98000.00, "mobile"));
        products.add(new Product(12, "Samsung Fold", 2_00_000, "mobile"));

        products.add(new Product(511, "Washing Machine", 32000, "Home")); // supports duplicate

        // instead of Arrays.sort
        Collections.sort(products); // uses Comparable

        for(Product p : products) {
            System.out.println(p);
        }

        System.out.println("By Price:");

        Collections.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        for(Product p : products) {
            System.out.println(p);
        }
    }
}
