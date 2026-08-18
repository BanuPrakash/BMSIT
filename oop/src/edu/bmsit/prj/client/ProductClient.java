package edu.bmsit.prj.client;

import edu.bmsit.prj.entity.Mobile;
import edu.bmsit.prj.entity.Product;
import edu.bmsit.prj.entity.Tv;

public class ProductClient {
    public static void main(String[] args) {
        Product[] products = new Product[5]; // Array of pointers, not created 5 products
        products[0] = new Mobile(1, "iPhone 16", 79999, "5G");
        products[1] = new Mobile(2, "Samsung S25", 24999, "5G");
        products[2] = new Mobile(3, "OnePlus 13", 69999, "4G");

        // 2 TVs
        products[3] = new Tv(4, "Sony Bravia", 89999, "OLED");
        products[4] = new Tv(5, "Onida TV", 5999, "CRT");

        printExpensiveOnes(products);
        printDetails(products);
    }

    // IS this OCP? NO
    private static void printDetails(Product[] products) {
        for(Product p : products) {
            System.out.println(p.getName() + ", " + p.getPrice());
            if(p instanceof  Mobile) { // type checking
                Mobile m = (Mobile) p;  // downcasting
                System.out.println(m.getConnectivity());
            }
            if(p.getClass() == Tv.class) { // type checking
                Tv t = (Tv) p;
                System.out.println(t.getScreenType());
            }

        }
    }

    // Is this OCP? YES
    private static void printExpensiveOnes(Product[] products) {
        for(Product p : products) {
            // Dynamic Binding
            if(p.isExpensive()) {
                System.out.println("Product " + p.getName() + " is Expensive!!");
            } else {
                System.out.println("Product " + p.getName() + " is not expensive!!!");
            }
        }
    }
}
