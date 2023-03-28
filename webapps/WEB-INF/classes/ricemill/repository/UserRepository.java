package ricemill.repository;

import ricemill.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserRepository {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public UserRepository() throws NamingException, SQLException {
        Context context = new InitialContext();
        DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/ricemill");
        this.connection = dataSource.getConnection();
        this.preparedStatement = null;
        this.resultSet = null;
    }

    public boolean login(String email, String password) throws SQLException {
        String sql = "select email, password from users where email = ? and password = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, email);
        this.preparedStatement.setString(2, password);
        this.resultSet = this.preparedStatement.executeQuery();
        boolean res = this.resultSet.next();
        this.close();
        return res;
    }

    public boolean register(User user) throws SQLException {
        String sql = "insert into users set email = ?, password = ?, name = ? , address = ? , type = ? , is_enabled = 1";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, user.getEmail());
        this.preparedStatement.setString(2, user.getPassword());
        this.preparedStatement.setString(3, user.getName());
        this.preparedStatement.setString(4, user.getAddress());
        this.preparedStatement.setString(5, user.getType());
        boolean res = this.preparedStatement.execute();
        this.close();
        return res;
    }

    public boolean updateUser(User user) throws SQLException{
        String sql = "update users set  password = ?, name = ? , address = ? , type = ? where email = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, user.getPassword());
        this.preparedStatement.setString(2, user.getName());
        this.preparedStatement.setString(3, user.getAddress());
        this.preparedStatement.setString(4, user.getType());
        this.preparedStatement.setString(5, user.getEmail());
        boolean res = this.preparedStatement.execute();
        this.close();
        return res;
    }

    public boolean changePassword(String email, String currentPassword, String newPassword) throws SQLException {
        String sql = "update users set password = ? where email = ? and password = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, newPassword);
        this.preparedStatement.setString(2, email);
        this.preparedStatement.setString(3, currentPassword);
        boolean res = this.preparedStatement.execute();
        this.close();
        return res;
    }

    public User searchUser(String email) throws SQLException {
        String sql = "select * from users where email = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, email);
        resultSet = this.preparedStatement.executeQuery();
        User user = new User();
        while(resultSet.next()){
            user.setEmail( resultSet.getString("email"));
            user.setPassword( resultSet.getString("password"));
            user.setName( resultSet.getString("name"));
            user.setAddress( resultSet.getString("address"));
            user.setType( resultSet.getString("type"));
        }
        this.close();
        return user;
    }


    private void close() throws SQLException {
        this.preparedStatement.close();
        this.connection.close();
    }
}

