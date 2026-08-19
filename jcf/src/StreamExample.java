import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(152, "Laptop", 55000, "Electronics"));
         products.add(new Product(435, "Refrigerator", 38000, "Home"));
        products.add(new Product(60, "Microwave Oven", 12000, "Kitchen"));
        products.add(new Product(888, "iPhone 17", 98000.00, "mobile"));
        products.add(new Product(22, "Mobile", 25000, "Electronics"));
        products.add(new Product(93, "Television", 45000, "Electronics"));

        products.add(new Product(12, "Samsung Fold", 2_00_000, "mobile"));
        products.add(new Product(511, "Washing Machine", 32000, "Home"));


        // filter takes Predicate as argument
        // Predicate is a FunctionalInterfare
        //boolean test(T t) --> p -> p.getCategory().equals("mobile")

        // forEach takes action
        products.stream().filter(p -> p.getCategory().equals("mobile")).forEach(p -> System.out.println(p));

        // can be easily converted to Multi-threaded
        products.parallelStream().filter(p -> p.getCategory().equals("mobile")).forEach(p -> System.out.println(p));

        System.out.println("Need to get Names of Mobiles");
        List<String> names =
                products.stream()
                        .filter(p-> p.getCategory().equals("mobile"))
                        .map(p -> p.getName()).collect(Collectors.toList());

        names.forEach(name -> System.out.println(name));

        System.out.println("Get Sum of cost of electronics items");
        double total = products.stream()
                .filter(p -> p.getCategory().equals("Electronics"))
                .map(p -> p.getPrice())
                .reduce(0.0, (v1, v2) -> v1 + v2);

        System.out.println("total : " + total);

        System.out.println("*********");

       DoubleSummaryStatistics stats = products.stream().collect(Collectors.summarizingDouble(p -> p.getPrice()));

        System.out.println("Max : "  + stats.getMax());
        System.out.println("Min : "  + stats.getMin());
        System.out.println("Avg : "  + stats.getAverage());
        System.out.println("Sum : "  + stats.getSum());

        System.out.println("Grouping!!!");

        Map<String, List<Product>> category  =
                products.stream().collect(Collectors.groupingBy(p-> p.getCategory()));

        System.out.println(category.get("Electronics"));
    }
}
