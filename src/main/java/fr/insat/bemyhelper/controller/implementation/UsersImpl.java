package fr.insat.bemyhelper.controller.implementation;

import fr.insat.bemyhelper.controller.entityManager.BadPasswordException;
import fr.insat.bemyhelper.controller.entityManager.UserManager;
import fr.insat.bemyhelper.controller.entityManager.UserNotFoundException;
import fr.insat.bemyhelper.model.UserEntity;
import jakarta.persistence.EntityManager;

class UsersImpl implements UserManager {
    private final EntityManager em;
    UsersImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public int addNew(UserEntity user) {
        em.getTransaction().begin();
        em.merge(user);
        em.flush();
        em.getTransaction().commit();
        return 1;
    }

    @Override
    public boolean exist(String username) {
        return em.find(UserEntity.class, username) != null;
    }

    @Override
    public UserEntity correctPassword(String username, String password) throws UserNotFoundException, BadPasswordException {
        UserEntity user = em.find(UserEntity.class, username);
        if(user == null) throw new UserNotFoundException();
        if(!user.getPassword().equals(password)) throw new BadPasswordException();
        return user;
    }
}
