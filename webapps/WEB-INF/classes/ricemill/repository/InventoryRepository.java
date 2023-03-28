package ricemill.repository;

import ricemill.model.Inventory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class InventoryRepository {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public InventoryRepository() throws NamingException, SQLException {
        Context context = new InitialContext();
        DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/ricemill");
        this.connection = dataSource.getConnection();
        this.preparedStatement = null;
        this.resultSet = null;
    }

    public boolean insertInventory(Inventory inventory) throws SQLException{
        String sql = "insert into inventory set id = ? , product_id = ? , status = ? , min_stock = ? , max_stock = ? , available_stock = ? , last_update = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1,inventory.getId());
        this.preparedStatement.setInt(2,inventory.getProduct_id());
        this.preparedStatement.setString(3, inventory.getStatus());
        this.preparedStatement.setInt(4, inventory.getMin_stock());
        this.preparedStatement.setInt(5,inventory.getMax_stock());
        this.preparedStatement.setInt(6,inventory.getAvailable_stock());
        Date d = new Date(inventory.getLast_update().getTime());
        this.preparedStatement.setDate(7, d);

        boolean res = this.preparedStatement.execute();
        this.close();
        return res;
    }

    public ArrayList<Inventory> show() throws SQLException{
        String sql = "select * from inventory";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.resultSet = this.preparedStatement.executeQuery(sql);

        ArrayList<Inventory> inventories = new ArrayList<>();
        while(resultSet.next()){
            Inventory i = new Inventory();
            i.setId(resultSet.getInt("id"));
            i.setProduct_id(resultSet.getInt("product_id"));
            i.setStatus(resultSet.getString("status"));
            i.setMin_stock(resultSet.getInt("min_stock"));
            i.setMax_stock(resultSet.getInt("max_stock"));
            i.setAvailable_stock(resultSet.getInt("available_stock"));
            i.setLast_update(resultSet.getDate("last_update"));
            inventories.add(i);
        }
        this.close();
        return inventories;
    }

    public Inventory searchInventory(int id) throws SQLException{
        String sql = "select * from inventory where id = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1,id);
        this.resultSet = this.preparedStatement.executeQuery();
        Inventory i = new Inventory();
        while(resultSet.next()){
            i.setId(resultSet.getInt("id"));
            i.setProduct_id(resultSet.getInt("product_id"));
            i.setStatus(resultSet.getString("status"));
            i.setMin_stock(resultSet.getInt("min_stock"));
            i.setMax_stock(resultSet.getInt("max_stock"));
            i.setAvailable_stock(resultSet.getInt("available_stock"));
            i.setLast_update(resultSet.getDate("last_update"));
        }
        this.close();
        return i;

    }

    public boolean updateInventory(Inventory inventory) throws SQLException {
        String sql = "update inventory set product_id = ? , status = ? , min_stock = ? , max_stock = ? , available_stock = ? , last_update = ? where id = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1,inventory.getProduct_id());
        this.preparedStatement.setString(2, inventory.getStatus());
        this.preparedStatement.setInt(3, inventory.getMin_stock());
        this.preparedStatement.setInt(4,inventory.getMax_stock());
        this.preparedStatement.setInt(5,inventory.getAvailable_stock());
        Date d = new Date(System.currentTimeMillis());
        this.preparedStatement.setDate(6, d);
        this.preparedStatement.setInt(7,inventory.getId());
        boolean res = this.preparedStatement.execute();
        this.close();
        return res;
    }
    public boolean deleteInventory(int id) throws SQLException{
        String sql = "delete from inventory where id = ?";
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
