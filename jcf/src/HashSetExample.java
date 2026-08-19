import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>(399);
        products.add(new Product(152, "Laptop", 55000, "Electronics"));
        products.add(new Product(22, "Mobile", 25000, "Electronics"));
        products.add(new Product(93, "Television", 45000, "Electronics"));
        products.add(new Product(435, "Refrigerator", 38000, "Home"));
        products.add(new Product(511, "Washing Machine", 32000, "Home"));
        products.add(new Product(60, "Microwave Oven", 12000, "Kitchen"));
        products.add(new Product(888, "iPhone 17", 98000.00, "mobile"));
        products.add(new Product(12, "Samsung Fold", 2_00_000, "mobile"));


        products.add(new Product(511, "Washing Machine", 32000, "Home")); // duplicate

        for(Product p : products) {
            System.out.println(p);
        }

    }
}
