package fr.insat.bemyhelper.controller.entityManager;

import fr.insat.bemyhelper.model.UserEntity;

public interface UserManager {
    int addNew(UserEntity user);

    boolean exist(String username);
    UserEntity correctPassword(String username, String password) throws UserNotFoundException, BadPasswordException;

}