package edu.bmsit.prj.dao;

import edu.bmsit.prj.entity.Product;

import java.util.List;

public interface ProductDao {
    void addProduct(Product product) throws PersistenceException;
    List<Product> getProducts() throws FetchException;
}