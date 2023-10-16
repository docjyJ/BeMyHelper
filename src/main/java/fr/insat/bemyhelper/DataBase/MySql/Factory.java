package fr.insat.bemyhelper.DataBase.MySql;

import fr.insat.bemyhelper.DataBase.Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {
    public static Factory getInstance() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new Factory();
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_030", "projet_gei_030", "quoh0The");
    }

    // Récupération du Dao
    public Users getUsers() {
        return new UsersImpl(this);
    }
}
