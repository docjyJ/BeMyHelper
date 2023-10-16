package fr.insat.bemyhelper.DataBase.MySql;

import fr.insat.bemyhelper.DataBase.Requests;
import fr.insat.bemyhelper.DataBase.Users;
import fr.insat.bemyhelper.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestsImpl implements Requests {
    private final Factory daoFactory;

    RequestsImpl(Factory daoFactory) {
        this.daoFactory = daoFactory;
    }


    @Override
    public int addNew(User user, String description) {
        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Demandes (User, Request, State) VALUE (?, ?, 'Waiting')");
            statement.setString(1, user.getUser());
            statement.setString(2, description);
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
