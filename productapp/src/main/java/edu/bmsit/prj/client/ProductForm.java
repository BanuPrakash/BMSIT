package edu.bmsit.prj.client;

import edu.bmsit.prj.dao.PersistenceException;
import edu.bmsit.prj.dao.ProductDao;
import edu.bmsit.prj.dao.ProductDaoJdbcImpl;
import edu.bmsit.prj.entity.Product;

public class ProductForm {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoJdbcImpl(); // better use factory

        Product product = Product.builder().name("Samsung Fold").price(1_25_000.00).build();

        try {
            productDao.addProduct(product);
            System.out.println("Product added Successfully!!!");
        } catch (PersistenceException e) {
            System.out.println(e.getMessage()); // for END USER
            e.printStackTrace(); // DEVELOPER , MAINTENANCE TEAM
        }
    }
}
