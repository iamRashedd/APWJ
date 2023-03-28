package ricemill.repository;

import ricemill.model.Product;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductRepository {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ProductRepository() throws NamingException, SQLException {
        Context context = new InitialContext();
        DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/ricemill");
        this.connection = dataSource.getConnection();
        this.preparedStatement = null;
        this.resultSet = null;
    }

    public boolean insertProduct(Product product) throws SQLException{
        String sql ="insert into products set id = ?, name = ? , category = ? , subcategory = ? , price = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1,product.getId());
        this.preparedStatement.setString(2,product.getName());
        this.preparedStatement.setString(3, product.getCategory());
        this.preparedStatement.setString(4, product.getSubcategory());
        this.preparedStatement.setInt(5,product.getPrice());
        boolean res = this.preparedStatement.execute();
        this.close();
        return res;
    }

    public ArrayList<Product> show() throws SQLException{
        String sql = "select * from products";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.resultSet = this.preparedStatement.executeQuery(sql);

        ArrayList<Product> products = new ArrayList<>();
        while(resultSet.next()){
            Product p = new Product();
            p.setId(resultSet.getInt("id"));
            p.setCategory(resultSet.getString("category"));
            p.setSubcategory(resultSet.getString("subcategory"));
            p.setName(resultSet.getString("name"));
            p.setPrice(resultSet.getInt("price"));
            products.add(p);
        }
        this.close();
        return products;
    }
    public Product searchProduct(int id) throws SQLException{
        String sql = "select * from products where id = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1,id);
        this.resultSet = this.preparedStatement.executeQuery();
        Product p = new Product();
        while(resultSet.next()){
            p.setId(resultSet.getInt("id"));
            p.setCategory(resultSet.getString("category"));
            p.setSubcategory(resultSet.getString("subcategory"));
            p.setName(resultSet.getString("name"));
            p.setPrice(resultSet.getInt("price"));
        }
        this.close();
        return p;

    }

    public boolean updateProduct(Product product) throws SQLException {
        String sql = "update products set name = ? , category = ? , subcategory = ? , price = ? where id = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1,product.getName());
        this.preparedStatement.setString(2, product.getCategory());
        this.preparedStatement.setString(3, product.getSubcategory());
        this.preparedStatement.setInt(4,product.getPrice());
        this.preparedStatement.setInt(5,product.getId());
        boolean res = this.preparedStatement.execute();
        this.close();
        return res;
    }

    public boolean deleteProduct(int id) throws SQLException{
        String sql = "delete from products where id = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1,id);
        boolean res = this.preparedStatement.execute();

        this.close();
        return res;

    }
    private void close() throws SQLException{
        this.preparedStatement.close();
        this.connection.close();
    }
}
