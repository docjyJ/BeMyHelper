package fr.insat.bemyhelper.DataBase.MySql;

import fr.insat.bemyhelper.DataBase.Users;
import fr.insat.bemyhelper.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersImpl implements Users {
    private final Factory daoFactory;

    UsersImpl(Factory daoFactory) {
        this.daoFactory = daoFactory;
    }
    @Override
    public int addNew(User user, String pass) {
        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Users (First, Last, Username, Password, Type) VALUE (?, ?, ?, ?, ?)");
            statement.setString(1, user.getFirst());
            statement.setString(2, user.getLast());
            statement.setString(3, user.getUser());
            statement.setString(4, pass);
            statement.setString(5, user.getType().toString());
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }

    @Override
    public boolean exist(String user) {
        boolean exist = false;
        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) from Users WHERE Username = ?;");
            statement.setString(1, user);
            ResultSet result = statement.executeQuery();
            exist = result.next() && result.getInt("COUNT(*)") == 1;
        } catch (SQLException e) { e.printStackTrace(); }
        return exist;
    }

    @Override
    public User correctPassword(String user, String pass) {
        User userObj = null;
        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT First, Last, Username, Type from Users WHERE Username = ? AND Password = ?;");
            statement.setString(1, user);
            statement.setString(2, pass);
            ResultSet result = statement.executeQuery();
            if (result.next())
                try {
                    userObj = new User(
                            result.getString("First"),
                            result.getString("Last"),
                            result.getString("Username"),
                            result.getString("Type"));
                } catch (IllegalArgumentException e) { e.printStackTrace(); }
        } catch (SQLException e) { e.printStackTrace(); }
        return userObj;
    }
}
