package fr.insat.bemyhelper.DataBase;

import fr.insat.bemyhelper.Model.User;

public interface Requests {
    int addNew(User user, String description);

}