import java.util.Arrays;

public class ProductArraysExample {
    public static void main(String[] args) {
                Product[] products = new Product[8];
                products[0] = new Product(152, "Laptop", 55000, "Electronics");
                products[1] = new Product(22, "Mobile", 25000, "Electronics");
                 products[2] = new Product(93, "Television", 45000, "Electronics");
                products[3] = new Product(435, "Refrigerator", 38000, "Home");
                 products[4] = new Product(511, "Washing Machine", 32000, "Home");
                products[5] = new Product(60, "Microwave Oven", 12000, "Kitchen");
                products[6] = new Product(888, "iPhone 17", 98000.00, "mobile");
                products[7] = new Product(12, "Samsung Fold", 2_00_000, "mobile");

        Arrays.sort(products);
        for(Product p : products) {
            System.out.println(p);
        }

        System.out.println("Sort by Price: use Lambda");

//        Arrays.sort(products, (p1,p2) -> (int)(p1.getPrice() - p2.getPrice()));

        Arrays.sort(products, (p1,p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        for(Product p : products) {
            System.out.println(p);
        }

    }
}
