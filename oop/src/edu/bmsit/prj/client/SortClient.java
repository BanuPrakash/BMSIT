package edu.bmsit.prj.client;

import edu.bmsit.prj.entity.Mobile;
import edu.bmsit.prj.entity.Product;
import edu.bmsit.prj.entity.Tv;
import edu.bmsit.prj.util.Utility;

public class SortClient {
    public static void main(String[] args) {
        String[] names = {"Roger", "Brad", "Angelina", "Penelope", "Charlie"};

        Utility.sort(names);

        for(String name : names) {
            System.out.println(name);
        }

        System.out.println("******");
        Product[] products = new Product[5]; // Array of pointers, not created 5 products
        products[0] = new Mobile(1, "iPhone 16", 79999, "5G");
        products[1] = new Mobile(2, "Samsung S25", 24999, "5G");
        products[2] = new Mobile(3, "OnePlus 13", 69999, "4G");

        // 2 TVs
        products[3] = new Tv(4, "Sony Bravia", 89999, "OLED");
        products[4] = new Tv(5, "Onida TV", 5999, "CRT");

        Utility.sort(products);

        for(Product p : products) {
            System.out.println(p); //toString() : Object
        }
    }

}
