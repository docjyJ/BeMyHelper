package fr.insat.bemyhelper.DataBase;

import fr.insat.bemyhelper.Model.User;

public interface Users {
    int addNew(User user, String pass);
    boolean exist(String user);
    User correctPassword(String user, String pass);

}