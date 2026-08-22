package edu.bmsit.prj.dao;

import edu.bmsit.prj.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoJdbcImpl implements ProductDao{

    @Override
    public void addProduct(Product product) throws PersistenceException {
        String SQL = "INSERT INTO products (id, name, price) VALUES (0, ?, ?)";
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL); // pre compiled
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenceException("unable to add Product!!!", e);
        } finally {
            DBUtil.closeConnection(con);
        }

    }

    @Override
    public List<Product> getProducts() throws FetchException {
        String SQL = "SELECT id, name, price FROM products";
        List<Product> products = new ArrayList<>();
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                products.add(Product.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .price(rs.getDouble("price")).build());
            }
        } catch (SQLException e) {
            throw new FetchException("unable to get Products!!!");
        } finally {
            DBUtil.closeConnection(con);
        }

        return products;
    }
}
