package fr.insat.bemyhelper.controller.implementation;

import fr.insat.bemyhelper.controller.entityManager.ManagerFactory;
import fr.insat.bemyhelper.controller.entityManager.RequestManager;
import fr.insat.bemyhelper.controller.entityManager.UserManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Factory implements ManagerFactory {
    private final EntityManagerFactory emf;

    Factory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public static ManagerFactory createFactory(){
        return new Factory(Persistence.createEntityManagerFactory("default"));
    }

    @Override
    public UserManager getUserManager() {
            return new UsersImpl(emf.createEntityManager());
        }

    @Override
    public RequestManager getRequestManager() {
        return new RequestImp(emf.createEntityManager());
    }
}
