package ricemill.repository;


import ricemill.model.Client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientRepository {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ClientRepository() throws NamingException, SQLException {
        Context context = new InitialContext();
        DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/ricemill");
        this.connection = dataSource.getConnection();
        this.preparedStatement = null;
        this.resultSet = null;
    }

    public boolean insertClient(Client client) throws SQLException{
        String sql ="insert into clients set id = ?, name = ? , mobile = ? , email = ? , balance = ? , address = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1,client.getId());
        this.preparedStatement.setString(2,client.getName());
        this.preparedStatement.setString(3, client.getMobile());
        this.preparedStatement.setString(4, client.getEmail());
        this.preparedStatement.setString(5,client.getAddress());
        boolean res = this.preparedStatement.execute();
        this.close();
        return res;
    }

    public ArrayList<Client> show() throws SQLException{
        String sql = "select * from clients";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.resultSet = this.preparedStatement.executeQuery(sql);

        ArrayList<Client> clients = new ArrayList<>();
        while(resultSet.next()){
            Client c = new Client();
            c.setId(resultSet.getInt("id"));
            c.setName(resultSet.getString("name"));
            c.setMobile(resultSet.getString("mobile"));
            c.setEmail(resultSet.getString("email"));
            c.setBalance(resultSet.getInt("balance"));
            c.setAddress(resultSet.getString("address"));
            clients.add(c);
        }
        this.close();
        return clients;
    }
    public Client searchClient(int id) throws SQLException{
        String sql = "select * from clients where id = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1,id);
        this.resultSet = this.preparedStatement.executeQuery();
        Client c = new Client();
        while(resultSet.next()){
            c.setId(resultSet.getInt("id"));
            c.setName(resultSet.getString("name"));
            c.setMobile(resultSet.getString("mobile"));
            c.setEmail(resultSet.getString("email"));
            c.setBalance(resultSet.getInt("balance"));
            c.setAddress(resultSet.getString("address"));
        }
        this.close();
        return c;

    }

    public boolean updateClient(Client client) throws SQLException {
        String sql = "update clients set name = ? , mobile = ? , email = ? , balance = ? , address = ? where id = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1,client.getName());
        this.preparedStatement.setString(2, client.getMobile());
        this.preparedStatement.setString(3, client.getEmail());
        this.preparedStatement.setString(4,client.getAddress());
        this.preparedStatement.setInt(5,client.getId());
        boolean res = this.preparedStatement.execute();
        this.close();
        return res;
    }
    private void close() throws SQLException{
        this.preparedStatement.close();
        this.connection.close();
    }
}
